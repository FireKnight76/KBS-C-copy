import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class addProductDialog extends JDialog implements ActionListener{
    private JTextField name;
    private JTextField location;
    private JTextField amount;
    private JButton addButton;
    private JButton cancelButton;

    public addProductDialog(JFrame frame, boolean modal){
        super(frame, true);
        setSize(290, 150);
        setTitle("new product");
        setLayout(new GridLayout(5,2));
        add(new JLabel("name: "));
        name = new JTextField(); 
        add(name);  
        add(new JLabel("location (optional): "));
        location = new JTextField();
        add(location);
        add(new JLabel("amount: "));
        amount = new JTextField();
        add(amount);
        addButton = new JButton("add");
        add(addButton);
        addButton.addActionListener(this);
        cancelButton = new JButton("cancel");
        add(cancelButton);
        cancelButton.addActionListener(this); 
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addButton){
            if (location.getText().equals("")) { 
                location.setText("0");
            }
            database.add_product(Integer.parseInt(amount.getText()), name.getText(), Integer.parseInt(location.getText()));
            System.out.println("add");
            dispose();
        } else if(e.getSource() == cancelButton){
            System.out.println("cancel");
            dispose();
        }
    }
}
