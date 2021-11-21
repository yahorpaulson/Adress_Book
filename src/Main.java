import javax.swing.*;


/**
 * Name> Yahor Siarheyeu
 * M.Nr.> 11930943
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Model model = new Model();

            View view = new View(model);

            view.setVisible(true);
        });
    }

}
