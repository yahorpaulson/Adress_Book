import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Name> Yahor Siarheyeu
 * M.Nr.> 11930943
 */
public class Model extends DefaultTableModel {

    private List <Object> listOfContacts = new ArrayList<>();
    public Object[][] arrayOfContacts = new Object[][]{};
    private int counter = 0;

    public Model() {
        super(Constants.TABLE_HEADER,0);
    }





}
