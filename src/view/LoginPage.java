package view;

import model.command.OperationCommand;
import model.command.applicationCommands.LoginCommand;
import view.context.ContextModel;
import view.context.ContextView;
import view.viewComponents.form.Form;
import view.viewComponents.form.GridLayoutStrategy;
import view.viewComponents.form.SubmitButton;
import view.viewComponents.form.inputs.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import view.viewComponents.Toaster.Toaster;
import view.viewComponents.Utils.*;



public class LoginPage extends Window {

	private static final long serialVersionUID = 1L;
	private final Toaster toaster;



	@SuppressWarnings("deprecation")
	public LoginPage(ContextModel contextModel, View view) {
		super(contextModel);
		addViewComponent(new Form());

		JPanel mainJPanel = getMainJPanel();
		addLogo(mainJPanel);
		addSeparator(mainJPanel);
		addUsernameTextField(mainJPanel);
		addPasswordTextField(mainJPanel, contextModel, view);
		addLoginButton(mainJPanel, contextModel, view);




		this.add(mainJPanel);
		this.pack();
		this.setVisible(true);
		this.toFront();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);

		toaster = new Toaster(mainJPanel);


	}

	private JPanel getMainJPanel() {
		this.setUndecorated(true);

		Dimension size = new Dimension(800, 400);

		JPanel panel1 = new JPanel();
		panel1.setSize(size);
		panel1.setPreferredSize(size);
		panel1.setBackground(UIUtils.COLOR_BACKGROUND);
		panel1.setLayout(null);

		MouseAdapter ma = new MouseAdapter() {
			int lastX, lastY;

			@Override
			public void mousePressed(MouseEvent e) {
				lastX = e.getXOnScreen();
				lastY = e.getYOnScreen();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(getLocationOnScreen().x + x - lastX, getLocationOnScreen().y + y - lastY);
				lastX = x;
				lastY = y;
			}
		};

		panel1.addMouseListener(ma);
		panel1.addMouseMotionListener(ma);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		return panel1;
	}

	private void addSeparator(JPanel panel1) {
		JSeparator separator1 = new JSeparator();
		separator1.setOrientation(SwingConstants.VERTICAL);
		separator1.setForeground(UIUtils.COLOR_OUTLINE);
		panel1.add(separator1);
		separator1.setBounds(310, 80, 1, 240);
	}

	private void addLogo(JPanel panel1) {
		JLabel label1 = new JLabel();
		label1.setFocusable(false);
		try {
			label1.setIcon(new ImageIcon(ImageIO.read(new File("icons/logo.png"))));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		panel1.add(label1);
		label1.setBounds(55, 146, 200, 110);
	}

	private void addUsernameTextField(JPanel panel1) {
		TextFieldUsername usernameField = new TextFieldUsername();

		usernameField.setBounds(423, 109, 250, 44);
		usernameField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (usernameField.getText().equals(UIUtils.PLACEHOLDER_TEXT_USERNAME)) {
					usernameField.setText("");
				}
				usernameField.setForeground(Color.white);
				usernameField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (usernameField.getText().isEmpty()) {
					usernameField.setText(UIUtils.PLACEHOLDER_TEXT_USERNAME);
				}
				usernameField.setForeground(UIUtils.COLOR_OUTLINE);
				usernameField.setBorderColor(UIUtils.COLOR_OUTLINE);
			}
		});

		panel1.add(usernameField);
	}

	private void addPasswordTextField(JPanel panel1, ContextModel contextModel, View view) {
		TextFieldPassword passwordField = new TextFieldPassword();

		passwordField.setBounds(423, 168, 250, 44);
		passwordField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setForeground(Color.white);
				passwordField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
			}

			@Override
			public void focusLost(FocusEvent e) {
				passwordField.setForeground(UIUtils.COLOR_OUTLINE);
				passwordField.setBorderColor(UIUtils.COLOR_OUTLINE);
			}
		});

		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER)
					loginEventHandler(contextModel, view, panel1);
			}
		});

		panel1.add(passwordField);
	}
	private void addLoginButton(JPanel panel1, ContextModel contextModel, View view) {
		final Color[] loginButtonColors = {UIUtils.COLOR_INTERACTIVE, Color.white};

		JLabel loginButton = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = UIUtils.get2dGraphics(g);
				super.paintComponent(g2);

				Insets insets = getInsets();
				int w = getWidth() - insets.left - insets.right;
				int h = getHeight() - insets.top - insets.bottom;
				g2.setColor(loginButtonColors[0]);
				g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

				FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
				int x2 = (getWidth() - metrics.stringWidth(UIUtils.BUTTON_TEXT_LOGIN)) / 2;
				int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				g2.setFont(UIUtils.FONT_GENERAL_UI);
				g2.setColor(loginButtonColors[1]);
				g2.drawString(UIUtils.BUTTON_TEXT_LOGIN, x2, y2);
			}
		};

		loginButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				loginEventHandler(contextModel, view, panel1);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER;
				loginButtonColors[1] = UIUtils.OFFWHITE;
				loginButton.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE;
				loginButtonColors[1] = Color.white;
				loginButton.repaint();
			}
		});

		loginButton.setBackground(UIUtils.COLOR_BACKGROUND);
		loginButton.setBounds(423, 247, 250, 44);
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel1.add(loginButton);
	}



	private void loginEventHandler( ContextModel contextModel, View view, JPanel jPanel) {

		String password = new String (((JPasswordField)jPanel.getComponent(3)).getPassword());
		String username = ((JTextField)jPanel.getComponent(2)).getText();

		OperationCommand command = new LoginCommand(view.getApplicationModel(),
				username,
				password);
		command.execute();

		if (view.getApplicationModel().getUserModel() != null) {
			setVisible(false);
			view.removeContextView(view.getContextViews().get(0));
			view.addContextView(new ContextView(new ContextModel(view.getApplicationModel().getDataModel(),
					view.getApplicationModel().getUserModel()), view));
		} else {

			toaster.warn("Neispravna sifra ili korisnicko ime");
			((JPasswordField)jPanel.getComponent(3)).setText("");
			((JTextField)jPanel.getComponent(2)).setText("");

		}
	}



}
