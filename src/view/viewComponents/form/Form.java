/***********************************************************************
 * Module:  Form.java
 * Author:  Korisnik
 * Purpose: Defines the Class Form
 ***********************************************************************/

package view.viewComponents.form;

import observer.Subject;
import view.Button;
import view.CheckBox;
import view.DropDownList;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;
import view.viewComponents.form.LayoutStrategy;
import view.viewComponents.form.SubmitButton;
import view.viewComponents.form.inputs.*;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/** @pdOid e26bc48c-dbb9-40e4-bea4-cea621964701 */
public class Form extends JPanel implements ViewComponent {
   /** @pdRoleInfo migr=no name=Button assc=association7 mult=0..* type=Aggregation */
   public Button[] button;
   /** @pdRoleInfo migr=no name=Input assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<Input> input;
   /** @pdRoleInfo migr=no name=CheckBox assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<CheckBox> checkBox;
   /** @pdRoleInfo migr=no name=DropDownList assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<DropDownList> dropDownList;

   private LayoutStrategy layout;

   private SubmitButton submitButton;
   private java.util.Collection<Input> inputs;
   private static final long serialVersionUID = 1L;


   public Form() {
      this.inputs = new Vector<Input>();
      this.layout = new FlowLayoutStrategy();
      setBackground(UIUtils.COLOR_BACKGROUND);
   }

   public LayoutManager getLayout() {
      return layout.getLayoutManager();
   }


   public void setLayout(LayoutStrategy layout) {
      this.layout = layout;
   }

   public SubmitButton getSubmitButton() {
      return submitButton;
   }

   public void setSubmitButton(SubmitButton submitButton) {
      this.submitButton = submitButton;
   }







   /** @pdGenerated default getter */
   public java.util.Collection<Input> getInput() {
      if (input == null)
         input = new java.util.HashSet<Input>();
      return input;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorInput() {
      if (input == null)
         input = new java.util.HashSet<Input>();
      return input.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newInput */
   public void setInput(java.util.Collection<Input> newInput) {
      removeAllInput();
      for (java.util.Iterator iter = newInput.iterator(); iter.hasNext();)
         addInput((Input)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newInput */
   public void addInput(Input newInput) {
      if (newInput == null)
         return;
      if (this.input == null)
         this.input = new java.util.HashSet<Input>();
      if (!this.input.contains(newInput))
         this.input.add(newInput);
   }
   
   /** @pdGenerated default remove
     * @param oldInput */
   public void removeInput(Input oldInput) {
      if (oldInput == null)
         return;
      if (this.input != null)
         if (this.input.contains(oldInput))
            this.input.remove(oldInput);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllInput() {
      if (input != null)
         input.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<CheckBox> getCheckBox() {
      if (checkBox == null)
         checkBox = new java.util.HashSet<CheckBox>();
      return checkBox;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCheckBox() {
      if (checkBox == null)
         checkBox = new java.util.HashSet<CheckBox>();
      return checkBox.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCheckBox */
   public void setCheckBox(java.util.Collection<CheckBox> newCheckBox) {
      removeAllCheckBox();
      for (java.util.Iterator iter = newCheckBox.iterator(); iter.hasNext();)
         addCheckBox((CheckBox)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCheckBox */
   public void addCheckBox(CheckBox newCheckBox) {
      if (newCheckBox == null)
         return;
      if (this.checkBox == null)
         this.checkBox = new java.util.HashSet<CheckBox>();
      if (!this.checkBox.contains(newCheckBox))
         this.checkBox.add(newCheckBox);
   }
   
   /** @pdGenerated default remove
     * @param oldCheckBox */
   public void removeCheckBox(CheckBox oldCheckBox) {
      if (oldCheckBox == null)
         return;
      if (this.checkBox != null)
         if (this.checkBox.contains(oldCheckBox))
            this.checkBox.remove(oldCheckBox);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCheckBox() {
      if (checkBox != null)
         checkBox.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<DropDownList> getDropDownList() {
      if (dropDownList == null)
         dropDownList = new java.util.HashSet<DropDownList>();
      return dropDownList;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDropDownList() {
      if (dropDownList == null)
         dropDownList = new java.util.HashSet<DropDownList>();
      return dropDownList.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDropDownList */
   public void setDropDownList(java.util.Collection<DropDownList> newDropDownList) {
      removeAllDropDownList();
      for (java.util.Iterator iter = newDropDownList.iterator(); iter.hasNext();)
         addDropDownList((DropDownList)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDropDownList */
   public void addDropDownList(DropDownList newDropDownList) {
      if (newDropDownList == null)
         return;
      if (this.dropDownList == null)
         this.dropDownList = new java.util.HashSet<DropDownList>();
      if (!this.dropDownList.contains(newDropDownList))
         this.dropDownList.add(newDropDownList);
   }
   
   /** @pdGenerated default remove
     * @param oldDropDownList */
   public void removeDropDownList(DropDownList oldDropDownList) {
      if (oldDropDownList == null)
         return;
      if (this.dropDownList != null)
         if (this.dropDownList.contains(oldDropDownList))
            this.dropDownList.remove(oldDropDownList);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDropDownList() {
      if (dropDownList != null)
         dropDownList.clear();
   }



   @Override
   public void update(Subject subject) {

   }
}