import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


/**
 * Name> Yahor Siarheyeu
 * M.Nr.> 11930943
 */
public class Controller implements ActionListener {
    private DefaultTableModel model;
    private JTextField textField;
    private JButton button;
    private JTable table;

    public Controller(JTextField enterField , DefaultTableModel model, JTable table,JButton button){

        textField = enterField;
        this.model = model;
        this.button = button;
        this.table = table;
    }




    @Override
    public void actionPerformed(ActionEvent e) throws IllegalArgumentException{

        String textValue = textField.getText();
        switch (button.getText()){
            case "Create a new contact":
                Object[] tempCreate = textValue.split(",");
                model.addRow(tempCreate);
                textField.setText("");
                break;
            case "Delete contact":
                //selection delete
                if(table.getSelectedRow()!=-1){
                    model.removeRow(table.getSelectedRow());
                    break;
                }

                //hand-writing delete
                Object[] tempDelete = textValue.split(",");
                String tempStr = (String) tempDelete[0];
                int counterDelete = 0;
                for(int i = model.getRowCount()-1; i>= 0; i--){
                    if(tempStr.equals(model.getValueAt(i,0))) {
                        model.removeRow(i);
                        counterDelete = 1;
                        textField.setText("");
                        break;
                    }
                }
                if (counterDelete == 0){
                    JOptionPane.showMessageDialog(null, "Contact " + tempStr + " wasn't found");
                    throw new IllegalArgumentException("There are no such people in address book");
                }

                break;
            case "Edit":
                int idRow = table.getSelectedRow();
                if(idRow == -1){
                    JOptionPane.showMessageDialog(null, "Not valid operation. Please choose the contact from address book and then press 'Edit' button");
                    throw new IllegalArgumentException("Contact wasn't selected");
                }
                for(int i = model.getRowCount()-1; i>=0; i--){
                    Object[] tempEdit = textValue.split(",");
                    if(i == idRow) {
                        model.insertRow(i, tempEdit);
                        model.removeRow(i+1);
                        textField.setText("");
                    }
                }
                break;
            case "Search contact":
                Object [] tempSearch = textValue.split(",");
                List<String> rowData = new ArrayList<>();                       //build a row in a one collection for output
                int exceptionCounter = 0;
                for (int i = model.getRowCount()-1; i >= 0 ; i--) {
                    if(tempSearch[0].equals(model.getValueAt(i,0))){
                        for (int count = 0; count < model.getColumnCount(); count++) {
                            rowData.add((String) table.getValueAt(i,count));
                        }
                        exceptionCounter = 1;
                        JOptionPane.showMessageDialog(null, rowData);
                        textField.setText("");
                    }
                }
                if(exceptionCounter == 0){
                    JOptionPane.showMessageDialog(null, "Contact " + textValue + " wasn't found");
                    throw new IllegalArgumentException("There are no such people in address book");
                }
            default:
                break;

        }
    }
}


