import javax.swing.*;


public class routedetailsDialog extends JDialog {
    public routedetailsDialog(JFrame frame, boolean modal){
        super(frame, true);
        setSize(200,200);
        setTitle("Route Details");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
