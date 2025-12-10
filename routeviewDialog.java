import javax.swing.*;

public class routeviewDialog extends JDialog {
   public routeviewDialog(JFrame frame, boolean modal){
       super(frame, true);
       setSize(200,200);
       setTitle("Route overview");
       setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}
