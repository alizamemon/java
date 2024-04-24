package myform;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class MyForm extends javax.swing.JFrame {

    private DefaultListModel<String> listModel;
    private DefaultComboBoxModel<String> comboBoxModel;
    private int listBoxCount;
    private int comboBoxCount;

    public MyForm() {
        initComponents();
        listModel = new DefaultListModel<>();
        listBox.setModel(listModel);
        listBoxCount = 0;

        comboBoxModel = new DefaultComboBoxModel<>();
        comboBox.setModel(comboBoxModel);
        comboBoxCount = 0;
    }

    // Method to update the count label
    private void updateCountLabel() {
        listBoxCountLabel.setText("Count (ListBox): " + listBoxCount);
        comboBoxCountLabel.setText("Count (ComboBox): " + comboBoxCount);
    }

    private void addButtonToListBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // Get the entered value from a text field or input source
        String value = valueTextField.getText();

        // Add the value to the ListBox
        listModel.addElement(value);

        // Update the count and count label
        listBoxCount++;
        updateCountLabel();
    }

    private void addButtonToComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // Get the entered value from a text field or input source
        String value = valueTextField.getText();

        // Add the value to the ComboBox
        comboBoxModel.addElement(value);

        // Update the count and count label
        comboBoxCount++;
        updateCountLabel();
    }

    // Generated code for GUI components and event handlers

    // ...

    // Main method to launch the application
    public static void main(String args[]) {
        // Set the look and feel for the application (optional)
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyForm().setVisible(true);
            }
        });
    }
}
