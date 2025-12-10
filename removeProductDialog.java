import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class removeProductDialog extends JDialog implements ActionListener{
    private JTextField name;
    private JTextField location;
    private JTextField amount;
    private JButton removeButton;
    private JButton cancelButton;

    public removeProductDialog(JFrame frame, boolean modal){
        super(frame, true);
        setSize(290, 150);
        setTitle("remove product");
        setLayout(new GridLayout(5,2));
        add(new JLabel("name: "));
        name = new JTextField();
        add(name);
        add(new JLabel("location: "));
        location = new JTextField();
        add(location);
        add(new JLabel("amount: "));
        amount = new JTextField();
        add(amount);
        removeButton = new JButton("remove");
        add(removeButton);
        removeButton.addActionListener(this);
        cancelButton = new JButton("cancel");
        add(cancelButton);
        cancelButton.addActionListener(this);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == removeButton){
            database.remove_product(Integer.parseInt(amount.getText()), name.getText(), Integer.parseInt(location.getText()));
            System.out.println("remove");
            dispose();
        } else if(e.getSource() == cancelButton){
            System.out.println("cancel");
            dispose();
        }
    }
}
