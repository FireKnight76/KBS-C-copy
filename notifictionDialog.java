import javax.swing.*;

public class notifictionDialog extends JDialog {
    public notifictionDialog(JFrame frame, boolean modal){
        super(frame, true);
        setSize(200,200);
        setTitle("Notifiction");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
