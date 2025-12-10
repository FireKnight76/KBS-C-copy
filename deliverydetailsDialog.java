import javax.swing.*;

public class deliverydetailsDialog extends JDialog {
    public deliverydetailsDialog(JFrame frame, boolean modal){
        super(frame, true);
        setSize(200,200);
        setTitle("Delivery Details");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
