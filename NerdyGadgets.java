import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

public class NerdyGadgets extends JFrame implements ActionListener {
    static DefaultTableModel model = new DefaultTableModel(new String[]{"Location", "ProuctID", "Amount"}, 0);
    static DefaultTableModel model2 = new DefaultTableModel(new String[]{"returnid", "returnstatus", "ordernumber", "name", "reason", "amount", "returnlocation", "notes", "returntype"}, 0);
    private static boolean darkmode = false;
    private JFrame frame;
    private JTabbedPane tabs;
    private JPanel routesTab;
    public static JPanel packagesTab;
    public static JPanel InventoryTab;
    public JButton routeview_button;
    public JButton notifiction_button;
    public JButton routedetails_button;
    public JButton deliverydetails_button;
    public JButton addbutton;
    public JButton removebutton;
    public JCheckBox darkMode;
    public JTable warehousetable;
    public JButton returnbutton;
    public JButton processreturnbutton;
    public static ArrayList<warehouse> warehouse = new ArrayList<warehouse>();
    public NerdyGadgets() {
        GUI();
    }

    private void GUI() {
        frame = new JFrame("DeliveryPro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        try {
        if (darkmode == true) {
            frame.getContentPane().setBackground(Color.BLACK);
            frame.setBackground(Color.BLACK);
                UIManager.setLookAndFeel(new NimbusLookAndFeel());
                UIManager.put("control", new Color(12, 12, 12));
                UIManager.put("info", new Color(128, 128, 128));
                UIManager.put("nimbusBase", new Color(18, 30, 49));
                UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
                UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
                UIManager.put("nimbusFocus", new Color(115, 164, 209));
                UIManager.put("nimbusGreen", new Color(176, 179, 50));
                UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
                UIManager.put("nimbusLightBackground", new Color(18, 30, 49));
                UIManager.put("nimbusOrange", new Color(191, 98, 4));
                UIManager.put("nimbusRed", new Color(169, 46, 34));
                UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
                UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
                UIManager.put("text", new Color(230, 230, 230));
                SwingUtilities.updateComponentTreeUI(this);
        } else {
            frame.getContentPane().setBackground(Color.white);
            frame.setBackground(Color.white);
                UIManager.setLookAndFeel(new NimbusLookAndFeel());
                UIManager.put("control", new Color(243, 243, 243));
                UIManager.put("info", new Color(127, 127, 127));
                UIManager.put("nimbusBase", new Color(237, 225, 206));
                UIManager.put("nimbusAlertYellow", new Color(7, 68, 255));
                UIManager.put("nimbusDisabledText", new Color(127, 127, 127));
                UIManager.put("nimbusFocus", new Color(115, 164, 209));
                UIManager.put("nimbusGreen", new Color(79, 76, 205));
                UIManager.put("nimbusInfoBlue", new Color(189, 116, 34));
                UIManager.put("nimbusLightBackground", new Color(237, 225, 206));
                UIManager.put("nimbusOrange", new Color(64, 157, 251));
                UIManager.put("nimbusRed", new Color(86, 209, 221));
                UIManager.put("nimbusSelectedText", new Color(0, 0, 0));
                UIManager.put("nimbusSelectionBackground", new Color(151, 162, 99));
                UIManager.put("text", new Color(25, 25, 25));
                SwingUtilities.updateComponentTreeUI(this);
            }
        } catch (UnsupportedLookAndFeelException exc) {
            System.err.println("Nimbus: Unsupported Look and feel!");
        }
        Border border = BorderFactory.createLineBorder(Color.gray,3);

        // Makes the tabs
        tabs = new JTabbedPane();

        // Home tab

        //Home JPanels
        JPanel homeTab = new JPanel();
        JPanel dashboardPanel = new JPanel();
        JPanel currentroutePanel = new JPanel();
        JPanel small_notifictionPanel = new JPanel();
        JPanel notifictionPanel = new JPanel();
        JPanel dayRoutesPanel = new JPanel();
        JPanel overviewPanel = new JPanel();
            JPanel overviewNamePanel = new JPanel();
            JPanel overviewDeliveriesPanel = new JPanel();
            JPanel overviewEstimatedPanel = new JPanel();
        JPanel routedetailsPanel = new JPanel();
        JPanel deliverydetailsPanel = new JPanel();
        JPanel inventoryPanel = new JPanel();
            JPanel itemPanel = new JPanel();
            JPanel quantityPanel = new JPanel();
            JPanel locationPanel = new JPanel();
        JPanel settingsPanel = new JPanel();
        JPanel chartsPanel = new JPanel();

        //Home JLabels
        JLabel currentrouteText = new JLabel();
        JLabel dashboardText = new JLabel();
        JLabel small_notificationText = new JLabel();
        JLabel notificationText = new JLabel();
        JLabel dayRoutes = new JLabel();
        JLabel overviewText = new JLabel();
            JLabel overviewNameText = new JLabel();
            JLabel overviewDeliveriesText = new JLabel();
            JLabel overviewEstimatedText = new JLabel();
        JLabel routedetailsText = new JLabel();
        JLabel deliverydetailsText = new JLabel();
        JLabel inventoryText = new JLabel();
            JLabel itemText = new JLabel();
            JLabel quantityText = new JLabel();
            JLabel locationText = new JLabel();
        JLabel settingsText = new JLabel();
        JLabel chartsText = new JLabel();

        routeview_button = new JButton("View Routes");
            routeview_button.addActionListener(this);
        notifiction_button = new JButton("View Notifictions");
            notifiction_button.addActionListener(this);
        routedetails_button = new JButton("View Details");
            routedetails_button.addActionListener(this);
        deliverydetails_button = new JButton("View Details");
            deliverydetails_button.addActionListener(this);

        homeTab.setLayout(new BoxLayout(homeTab, BoxLayout.PAGE_AXIS));
        dashboardPanel.setLayout(new BoxLayout(dashboardPanel, BoxLayout.LINE_AXIS));
        dayRoutesPanel.setLayout(new BoxLayout(dayRoutesPanel, BoxLayout.PAGE_AXIS));
        small_notifictionPanel.setLayout(new BoxLayout(small_notifictionPanel, BoxLayout.PAGE_AXIS));
        tabs.addTab("Home", homeTab);


        dashboardText.setText("Delivery Dashboard");
        currentrouteText.setText("Current Route:");
        dayRoutes.setText("Today's Routes");
        small_notificationText.setText("Notifications");
        overviewText.setText("Route Overview");
            overviewNameText.setText("Route Name");
            overviewDeliveriesText.setText("Deliveries");
            overviewEstimatedText.setText("Estimated Time of Arrival");
        routedetailsText.setText("Route Details");
        deliverydetailsText.setText("Delivery Details");
        inventoryText.setText("Inventory");
            itemText.setText("Item");
            quantityText.setText("Quantity");
            locationText.setText("Location");
        notificationText.setText("Notifications");
        chartsText.setText("Charts");
        settingsText.setText("Settings");
//        dashboardPanel.setBorder(border);

        currentroutePanel.setBorder(border);
        dayRoutesPanel.setBorder(border);
        notifictionPanel.setBorder(border);
        overviewPanel.setBorder(border);
        routedetailsPanel.setBorder(border);
        settingsPanel.setBorder(border);
        chartsPanel.setBorder(border);
        notifictionPanel.setBorder(border);
        deliverydetailsPanel.setBorder(border);
        inventoryPanel.setBorder(border);
        small_notifictionPanel.setBorder(border);

        homeTab.add(dashboardText);
        homeTab.add(dashboardPanel);
        homeTab.add(currentrouteText);
        homeTab.add(currentroutePanel);
//            currentroutePanel.add(Map);

        homeTab.add(overviewText);
        homeTab.add(overviewPanel);
            overviewPanel.add(overviewNamePanel);
            overviewPanel.add(overviewNameText);
            overviewPanel.add(overviewDeliveriesPanel);
            overviewPanel.add(overviewDeliveriesText);
            overviewPanel.add(overviewEstimatedPanel);
            overviewPanel.add(overviewEstimatedText);

        homeTab.add(routedetailsText);
        homeTab.add(routedetailsPanel);
            routedetailsPanel.add(routedetails_button);
        homeTab.add(deliverydetailsText);
        homeTab.add(deliverydetailsPanel);
            deliverydetailsPanel.add(deliverydetails_button);
        homeTab.add(inventoryText);
        homeTab.add(inventoryPanel);
            inventoryPanel.add(itemText);
            inventoryPanel.add(itemPanel);
            inventoryPanel.add(quantityText);
            inventoryPanel.add(quantityPanel);
            inventoryPanel.add(locationText);
            inventoryPanel.add(locationPanel);
        homeTab.add(settingsText);
        homeTab.add(settingsPanel);
        homeTab.add(chartsText);
        homeTab.add(chartsPanel);
        homeTab.add(notificationText);
        homeTab.add(notifictionPanel);

        dashboardPanel.add(dayRoutesPanel);
        dayRoutesPanel.add(dayRoutes);
        dayRoutesPanel.add(routeview_button);
        dashboardPanel.add(small_notifictionPanel);
        small_notifictionPanel.add(small_notificationText);
        small_notifictionPanel.add(notifiction_button);




        // Create routes panel
        routesTab = new JPanel();
        routesTab.setLayout(new GridLayout(0, 1));

        //Route 1
        // Add route 1 text
        JPanel route1Text = new JPanel();
        route1Text.setLayout(new GridLayout(0, 1));
        route1Text.add(new JLabel("Route 1"));
        route1Text.add(new JLabel("Start Location: ABC"));
        route1Text.add(new JLabel("End Location: XYZ"));
        route1Text.add(new JLabel("Distance: 10 miles"));
        route1Text.add(new JLabel("Estimated Time of Arrival: 10:00 AM"));
        route1Text.add(new JLabel("Work Alerts: None"));
        route1Text.add(new JLabel("Traffic Alerts: None"));

        // Add route 1 buttons
        JPanel route1Buttons = new JPanel();
        route1Buttons.setLayout(new FlowLayout(FlowLayout.LEFT));
        route1Buttons.add(new JButton("Add Stop"));
        route1Buttons.add(new JButton("Remove Stop"));

        //route 1 add
        routesTab.add(route1Text);
        routesTab.add(route1Buttons);

        //Route 2
        // Add route 2 text
        JPanel route2Text = new JPanel();
        route2Text.setLayout(new GridLayout(0, 1));
        route2Text.add(new JLabel("Route 2"));
        route2Text.add(new JLabel("Start Location: DEF"));
        route2Text.add(new JLabel("End Location: UVW"));
        route2Text.add(new JLabel("Distance: 15 miles"));
        route2Text.add(new JLabel("Estimated Time of Arrival: 11:00 AM"));
        route2Text.add(new JLabel("Work Alerts: Construction"));
        route2Text.add(new JLabel("Traffic Alerts: Heavy Traffic"));

        //route 2 buttons
        JPanel route2Buttons = new JPanel();
        route2Buttons.setLayout(new FlowLayout(FlowLayout.LEFT));
        route2Buttons.add(new JButton("Add Stop"));
        route2Buttons.add(new JButton("Remove Stop"));

        //route 2 add
        routesTab.add(route2Text);
        routesTab.add(route2Buttons);

        tabs.addTab("Routes", routesTab);

        //packages tab
        packagesTab = new JPanel();
        packagesTab.setLayout(new GridLayout(0, 4));

        //identifier packages
        packagesTab.add(new JLabel("Package ID:"));
        packagesTab.add(new JLabel("Destination:"));
        packagesTab.add(new JLabel("Status:"));
        packagesTab.add(new JLabel("Location:"));

        // Call the print_packages method from the Database class
       database.print_packages();
        //tab packages
        tabs.addTab("Packages", packagesTab);

        // Create Inventory panel
        InventoryTab = new JPanel();
        InventoryTab.setLayout(new GridLayout(3, 1));
        tabs.addTab("Inventory", InventoryTab);

        // Create the buttons
        JPanel InventoryButtons = new JPanel();
        InventoryButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
        addbutton = new JButton("Add product");
        addbutton.addActionListener(this);
        InventoryButtons.add(addbutton);
        removebutton = new JButton("Delete product");
        removebutton.addActionListener(this);
        InventoryButtons.add(removebutton);
    

        // Add the buttons
        InventoryTab.add(InventoryButtons);

        //identifier inventory
        JPanel Inventorytext = new JPanel();
        Inventorytext.setLayout(new GridLayout(5, 1));
        JTable table = new JTable(model);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{"location", "product", "amount"});
        database.print_warehouse();
        table.setModel(model);
        InventoryTab.add(table);


        InventoryTab.add(Inventorytext);

                //Retours
                // Create retours panel
                JPanel retoursTab = new JPanel();
                retoursTab.setLayout(new GridLayout(3, 1));
                tabs.addTab("Retours", retoursTab);
        
                // Create the buttons
                JPanel retoursButtons = new JPanel();
                retoursButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
                returnbutton = new JButton("Start return");
                returnbutton.addActionListener(this);
                retoursButtons.add(returnbutton);
                
                processreturnbutton = new JButton("Process return");
                processreturnbutton.addActionListener(this);
                retoursButtons.add(processreturnbutton);
        
                // Add the buttons
                retoursTab.add(retoursButtons);
                JTable table2 = new JTable(model2);
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
        model2.setRowCount(0);
        model2.addRow(new Object[]{"return id", "status", "order number", "product", "reason", "quantity", "return address", "note", "return type"});
        database.print_returns();
        table2.setModel(model2);
        retoursTab.add(table2);
                //identifier inventory
                JPanel retourstext = new JPanel();

               
        
                retoursTab.add(retourstext);

        // Create Settings panel
        JPanel SettingsTab = new JPanel();
        SettingsTab = new JPanel();
        SettingsTab.setLayout(new GridLayout(0, 2));
        SettingsTab.add(new JLabel("Dark Mode"));
        darkMode = new JCheckBox();
        darkMode.setSelected(darkmode);
        darkMode.addActionListener(this);
        SettingsTab.add(darkMode);

        tabs.addTab("Settings", SettingsTab);

        //Important
        frame.add(tabs, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //magazijn en database tests
        // database.print_packages();
        //SwingUtilities.invokeLater(NerdyGadgets::new);
        NerdyGadgets nd = new NerdyGadgets();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == routeview_button){
           JDialog D = new routeviewDialog(frame, true);
        }
        if(e.getSource() == notifiction_button){
            JDialog D = new notifictionDialog(frame, true);
        }
        if(e.getSource() == routedetails_button){
            JDialog D = new routedetailsDialog(frame, true);
        }
        if(e.getSource()==deliverydetails_button){
            JDialog D = new deliverydetailsDialog(frame, true);
        }
        if(e.getSource() == addbutton){
            JDialog D = new addProductDialog(frame, true);
            frame.dispose();
            GUI();
        }
        if(e.getSource() == removebutton){
            JDialog D = new removeProductDialog(frame, true);
            frame.dispose();
            GUI();
        }
        if(e.getSource() == darkMode){
            if (darkmode == false) {
                darkmode = true;
            }
            else{
                darkmode = false;
            }
            frame.dispose();
            GUI();
            // System.out.println("mode switched");        
        }
        if (e.getSource() == returnbutton) {
            // show the return form
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(RetourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(RetourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(RetourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(RetourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
    
            /* Create and display the form */
                    new RetourForm(frame, true);
            frame.dispose();
            GUI();
        }
        if (e.getSource() == processreturnbutton) {
            JDialog D = new processReturnDialog(frame, true);
            frame.dispose();
            GUI();
        }
    }
}