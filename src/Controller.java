import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Name> Yahor Siarheyeu
 * M.Nr.> 11930943
 */
public class Controller implements ActionListener{
    private DefaultTableModel model;
    private JTextField textField;
    private JButton button;
    private int idRow = 0;

    public Controller(JTextField enterField , DefaultTableModel model, JButton button){

        textField = enterField;
        this.model = model;
        this.button = button;
    }


    @Override
    public void actionPerformed(ActionEvent e) throws IllegalArgumentException{

        String textValue = textField.getText();
        switch (button.getText()){
            case "Create a new contact":
                Object[] tempCreate = textValue.split(",");
                model.addRow(tempCreate);
                idRow++;
                break;
            case "Delete contact":
                Object[] tempDelete = textValue.split(",");
                String tempStr = (String) tempDelete[0];
                for(int i = model.getRowCount()-1; i>= 0; i--){
                    if(tempStr.equals(model.getValueAt(i,0))) {
                        model.removeRow(i);
                    }
                    else
                        throw new IllegalArgumentException("There is no such people in adress book");
                }
                break;
            default:
                break;

        }
    }
}


