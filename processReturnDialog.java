import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class processReturnDialog extends JDialog implements ActionListener{

    private JTextField returnid;
    private JTextField status;
    private JTextField amount;
    private JButton processButton;
    private JButton cancelButton;

    public processReturnDialog(JFrame frame, boolean modal){
        super(frame, true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(290, 150);
        setTitle("process return");
        setLayout(new GridLayout(5,2));
        add(new JLabel("return id:"));
        returnid = new JTextField();
        add(returnid);
        add(new JLabel("new status (optional):"));
        status = new JTextField();
        add(status);
        processButton = new JButton("process");
        add(processButton);
        processButton.addActionListener(this);
        cancelButton = new JButton("cancel");
        add(cancelButton);
        cancelButton.addActionListener(this);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == processButton){
            if (status.getText().equals("")) {
                status.setText("processed");
            }
            database.process_return(Integer.parseInt(returnid.getText()), status.getText());
            System.out.println("remove");
            dispose();
        } else if(e.getSource() == cancelButton){
            System.out.println("cancel");
            dispose();
        }
    }
}
