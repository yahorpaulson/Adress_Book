import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


/**
 * Name> Yahor Siarheyeu
 * M.Nr.> 11930943
 */
public class View extends JFrame {
    private DefaultTableModel model;

    private JPanel contentPanel;
    private JTable addressBookTable;
    private JButton createButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton searchButton;


    public View(DefaultTableModel addressBookModel){
        model = addressBookModel;


        setTitle("Address Book 1.0.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 250, 600, 600);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        setContentPane(contentPanel);

        addressBookTable = new JTable();
        addressBookTable.setModel(model);
        addressBookTable.setSize(400,200);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(addressBookTable);
        contentPanel.add(scrollPane);


        createButton = new JButton("Create a new contact");
        contentPanel.add(createButton);

        editButton = new JButton("Edit");
        contentPanel.add(editButton);

        deleteButton = new JButton("Delete contact");
        contentPanel.add(deleteButton);

        searchButton = new JButton("Search contact");
        contentPanel.add(searchButton);

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 20));
        contentPanel.add(textField);





        Controller controllerCreate = new Controller(textField,model,createButton);
        createButton.addActionListener(controllerCreate);
        Controller controllerEdit = new Controller(textField,model,editButton);
        editButton.addActionListener(controllerEdit);
        Controller controllerDelete = new Controller(textField,model,deleteButton);
        deleteButton.addActionListener(controllerDelete);
        Controller controllerSearch = new Controller(textField,model,searchButton);
        searchButton.addActionListener(controllerSearch);

    }

}
