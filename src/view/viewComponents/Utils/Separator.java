package view.viewComponents.Utils;

import observer.Subject;
import view.viewComponents.ViewComponent;

import javax.swing.*;

public class Separator extends JSeparator implements ViewComponent {


    public Separator() {
        setOrientation(SwingConstants.HORIZONTAL);
        setForeground(UIUtils.COLOR_OUTLINE);
    }

    @Override
    public void update(Subject subject) {

    }
}
