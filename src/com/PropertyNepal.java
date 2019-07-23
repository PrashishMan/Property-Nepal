/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import PropertyNepal.Property;
import PropertyNepal.PropertyToBuy;
import PropertyNepal.PropertyToRent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author prashish
 */
public class PropertyNepal implements ActionListener {

    private JFrame frame;
    private JLabel label;
    private JPanel menuPanel, propertyPanel;
    private LocatePropertyLayoutPanel locatePropertyLayoutPanel;
    private AddPropertyLayoutPanel addPropertyLayoutPanel;
    private Container contentPane;
    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;
    private JMenuItem addProperty, locateProperty, viewProperty, save, exit, about, help;
    private CardLayout transactionMode;
    private SearchAndSort searchAndSort;
    private File propertyFile;

    private ArrayList<Property> properties;

    private static final int WIDTH = 820;
    private static final int HEIGHT = 590;
    private static final int RENT_TYPE = 1;
    private static final int BUY_TYPE = 2;

    public PropertyNepal() {

        //Assigning instances to their respective constructor
        frame = new JFrame("Property Nepal");
        label = new JLabel("Rent Property");

        frame.setIconImage(new ImageIcon(getClass().getResource("/Images/flag.png")).getImage());

        propertyFile = new File("Property_File.txt");
        contentPane = frame.getContentPane();
        properties = new ArrayList<Property>();

        searchAndSort = new SearchAndSort(properties);

        
        addPropertyLayoutPanel = new AddPropertyLayoutPanel(label, WIDTH, HEIGHT, properties);
        locatePropertyLayoutPanel = new LocatePropertyLayoutPanel(label, WIDTH, HEIGHT, properties);
        
        try {
            if(propertyFile.length() == 0){
                saveFile();
            }
                loadFile();
            
        } catch (IOException ex) {
            Logger.getLogger(PropertyNepal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PropertyNepal.class.getName()).log(Level.SEVERE, null, ex);
        }

        transactionMode = new CardLayout();

        contentPane.setBackground(Color.RED);
        menuPanel = new JPanel();
        propertyPanel = new JPanel(transactionMode);

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");

        addProperty = new JMenuItem("Add Property");
        addProperty.addActionListener(this);

        locateProperty = new JMenuItem("Locate Property");
        locateProperty.addActionListener(this);

        viewProperty = new JMenuItem("View");
        viewProperty.addActionListener(this);

        save = new JMenuItem("save");
        save.addActionListener(this);

        exit = new JMenuItem("Exit");
        exit.addActionListener(this);

        about = new JMenuItem("About");
        about.addActionListener(this);

        help = new JMenuItem("Help");
        help.addActionListener(this);

        //setting frame attributes
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);

        addProperty.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        locateProperty.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        viewProperty.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        //contaner to hold objects        
//        contentPane.setLayout(null);
        contentPane.setBackground(Color.GRAY);

        //Defining menuBar attributes
        menuBar.setSize(WIDTH, 60);

        //Defining menuBar attributes
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        //Adding menu item in file menu
        fileMenu.add(addProperty);
        fileMenu.add(locateProperty);
        fileMenu.add(viewProperty);
        fileMenu.add(save);
        fileMenu.add(exit);

        //Adding menu item in help menu
        helpMenu.add(about);
        helpMenu.add(help);

        //adding panel view for the cardLayout
        propertyPanel.add(locatePropertyLayoutPanel, "locateProperty");
        propertyPanel.add(addPropertyLayoutPanel, "addProperty");

        //adding menu panel to the content pane
        contentPane.add(menuBar, BorderLayout.PAGE_START);
        contentPane.add(propertyPanel, BorderLayout.CENTER);
        contentPane.add(label, BorderLayout.PAGE_END);

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(frame, "Do you want to save the file before closing \n this window? ", "Save File", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    try {
                        saveFile();
                    } catch (IOException ex) {
                        Logger.getLogger(PropertyNepal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else if (confirmed == JOptionPane.NO_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new PropertyNepal();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addProperty) {
            transactionMode.show(propertyPanel, "addProperty");
            label.setText("Add Property");
        } else if (e.getSource() == locateProperty) {
            transactionMode.show(propertyPanel, "locateProperty");
            label.setText("Locate Property");
        } else if (e.getSource() == save) {
            try {
                saveFile();
            } catch (IOException ex) {
                Logger.getLogger(PropertyNepal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == viewProperty) {

            JFrame viewTableFrame = new JFrame();
            CardLayout layout = new CardLayout();
            JPanel listPanel = new JPanel(layout);
            Container contentPane = viewTableFrame.getContentPane();
            viewTableFrame.setSize(1000, 400);
            viewTableFrame.setLocation(40, 40);

            //always appears at the front of the main frame
            viewTableFrame.setAlwaysOnTop(true);

            //disables user from interacting with the main frame
            frame.setEnabled(false);

            JLabel propertiesListLabel = new JLabel("Rent Property List");
            propertiesListLabel.setHorizontalAlignment(SwingConstants.CENTER);

            DefaultTableModel rentTableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Owners Name", "Contact", "Type", "Location", "Price (M)", "Rooms", "Payment", "Parking", "Security", "Hot Water", "Power Backup", "Internet "});
            JTable rentViewTable = new JTable(rentTableModel);
            rentViewTable.setRowHeight(20);
            TableColumnModel cModel = rentViewTable.getColumnModel();
            cModel.getColumn(0).setPreferredWidth(80);
            cModel.getColumn(1).setPreferredWidth(160);
            cModel.getColumn(2).setPreferredWidth(170);
            cModel.getColumn(3).setPreferredWidth(120);
            cModel.getColumn(4).setPreferredWidth(120);
            cModel.getColumn(5).setPreferredWidth(120);
            cModel.getColumn(6).setPreferredWidth(50);
            cModel.getColumn(7).setPreferredWidth(90);
            cModel.getColumn(8).setPreferredWidth(100);
            cModel.getColumn(9).setPreferredWidth(100);
            cModel.getColumn(10).setPreferredWidth(100);
            cModel.getColumn(11).setPreferredWidth(100);

            JScrollPane rentSp = new JScrollPane(rentViewTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            DefaultTableModel buyTableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Owners Name", "Contact", "Type", "Location", "Price", "Area", "Community", "Furnishing", "Insurance", "Near by", "Distance"});
            JTable viewBuyTable = new JTable(buyTableModel);
            viewBuyTable.setRowHeight(20);
            TableColumnModel bCModel = viewBuyTable.getColumnModel();
            bCModel.getColumn(0).setPreferredWidth(80);
            bCModel.getColumn(1).setPreferredWidth(140);
            bCModel.getColumn(2).setPreferredWidth(170);
            bCModel.getColumn(3).setPreferredWidth(100);
            bCModel.getColumn(4).setPreferredWidth(120);
            bCModel.getColumn(5).setPreferredWidth(100);
            bCModel.getColumn(6).setPreferredWidth(60);
            bCModel.getColumn(7).setPreferredWidth(110);
            bCModel.getColumn(8).setPreferredWidth(70);
            bCModel.getColumn(9).setPreferredWidth(90);
            bCModel.getColumn(10).setPreferredWidth(190);

            JScrollPane buySp = new JScrollPane(viewBuyTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            ImageIcon previousIcon = new ImageIcon(getClass().getResource("/Images/previousImg.png"));
            Image previousImg = previousIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            previousIcon = new ImageIcon(previousImg);

            ImageIcon nextIcon = new ImageIcon(getClass().getResource("/Images/nextImg.png"));
            Image nextImg = nextIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            nextIcon = new ImageIcon(nextImg);

            ImageIcon delIcon = new ImageIcon(getClass().getResource("/Images/delImg.png"));
            Image delImg = delIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            delIcon = new ImageIcon(delImg);

            JButton previousBtn = new JButton(previousIcon);
            JButton nextBtn = new JButton(nextIcon);
            JButton deleteBtn = new JButton(delIcon);

            JPanel topPanel = new JPanel();
            topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            topPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            topPanel.add(previousBtn);
            topPanel.add(propertiesListLabel);
            topPanel.add(nextBtn);

            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 450, 10));
            bottomPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            bottomPanel.add(deleteBtn);

            propertiesListLabel.setPreferredSize(new Dimension(853, 40));
            previousBtn.setPreferredSize(new Dimension(50, 50));
            nextBtn.setPreferredSize(new Dimension(50, 50));
            deleteBtn.setPreferredSize(new Dimension(50, 50));

            listPanel.add(rentSp, "rentSp");
            listPanel.add(buySp, "buySp");

            contentPane.add(topPanel, BorderLayout.NORTH);
            contentPane.add(listPanel, BorderLayout.CENTER);
            contentPane.add(bottomPanel, BorderLayout.SOUTH);

            topPanel.setBackground(Color.DARK_GRAY);
            bottomPanel.setBackground(Color.DARK_GRAY);

            propertiesListLabel.setForeground(Color.LIGHT_GRAY);
            propertiesListLabel.setFont(new Font("Arial", Font.BOLD, 26));

            if (properties != null) {
                for (int i = 0; i < properties.size(); i++) {
                    if (properties.get(i) instanceof PropertyToRent) {
                        rentTableModel.addRow(properties.get(i).getContent());
                    } else {
                        buyTableModel.addRow(properties.get(i).getContent());
                    }
                }
            }
            viewTableFrame.setVisible(true);

            previousBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    propertiesListLabel.setText("Rent Property List");
                    layout.show(listPanel, "rentSp");
                }
            });

            nextBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    propertiesListLabel.setText("Buy Property List");
                    layout.show(listPanel, "buySp");
                }
            });

            deleteBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int type = 0;
                    int selectedRow = -1;

                    if (viewBuyTable.getSelectedRow() > -1) {
                        type = BUY_TYPE;
                        selectedRow = viewBuyTable.getSelectedRow();

                    } else if (rentViewTable.getSelectedRow() > -1) {
                        type = RENT_TYPE;
                        selectedRow = rentViewTable.getSelectedRow();

                    } else {
                        JOptionPane.showMessageDialog(viewTableFrame, "Row not selected", "Please select the row for deletion!!", JOptionPane.ERROR_MESSAGE);
                    }

                    if (type != 0) {
                        int delValue = JOptionPane.showConfirmDialog(viewTableFrame, "Do you really want to delete this property", "Confirm Property Delete", JOptionPane.YES_NO_OPTION);

                        Property deleteProperty = null;
                        if (type == BUY_TYPE) {
                            deleteProperty = (PropertyToBuy) searchAndSort.selectProperty(buyTableModel.getValueAt(selectedRow, 0).toString());
                        } else if (type == RENT_TYPE) {
                            deleteProperty = (PropertyToRent) searchAndSort.selectProperty(rentTableModel.getValueAt(selectedRow, 0).toString());
                        }

                        if (delValue == JOptionPane.YES_OPTION) {

                            properties.remove(properties.indexOf(deleteProperty));

                            if (type == BUY_TYPE) {
                                buyTableModel.removeRow(selectedRow);
                            } else {
                                rentTableModel.removeRow(selectedRow);
                            }
                        }
                    }
                }

            }
            );

            viewTableFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    viewTableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setEnabled(true);
                }
            });

        }

    }

    public void saveFile() throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(propertyFile);
        ObjectOutputStream objOutputStream = new ObjectOutputStream(fileOutputStream);
        

        for (Property p : properties) {
            objOutputStream.writeObject(p);
        }

        fileOutputStream.close();
        objOutputStream.close();

    }

    public void loadFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(propertyFile);
        ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);

        
        try {
            while (true) {
                Property fileProperty = (Property) objInputStream.readObject();
                properties.add(fileProperty);
            }
        } catch (EOFException e) {

        }
        if(properties.size() == 0){
                    System.out.println("Under");
                    properties.add(new PropertyToRent("BP-101", "Apple Singh", "01-4289847","Room",  "Indrachowk", 54000, 1, "Monthly"));
                    properties.add(new PropertyToRent("BP-102", "Mango Maharjan", "01-4242347","Room",  "Kalimati", 44000, 2, "Monthly"));
                    properties.add(new PropertyToRent("BP-103", "Orange Shakya", "01-5239847","Room",  "Thamel", 154000, 1, "Monthly"));
                    properties.add(new PropertyToRent("BP-104", "Banana Bogati", "01-4289834","Appartment",  "Sanobharang", 24000, 5, "Monthly"));
                    properties.add(new PropertyToRent("BP-105", "Papaya Suwal", "01-4255234","Appartment",  "Pyukha", 114000, 1, "Monthly"));
                    properties.add(new PropertyToRent("BP-106", "Guava Limbhu", "01-4623345","Room",  "Putalisadak", 84000, 2, "Monthly"));
                    properties.add(new PropertyToRent("BP-107", "Peach Pradhan", "01-4443247","Appartment",  "Lainchour", 64000, 4, "Monthly"));
                    properties.add(new PropertyToRent("BP-108", "Honey Shrestha", "01-4663452","Building",  "Teku", 254000, 10, "Monthly"));
                    properties.add(new PropertyToRent("BP-109", "Tomato Dhakal", "01-4234255","Appartment",  "Jamal", 180000, 8, "Monthly"));
                    properties.add(new PropertyToRent("BP-110", "Parrot Lal", "01-4341223","Building",  "Teku", 300000, 12, "Monthly"));
                    
                    
                    properties.add(new PropertyToBuy("SP-401", "Apple Singh", "977-9841998343", "Building", "Kalimati", 32000000, 140, "Residential Area", "unFurnished", "Level 1" ));
                    properties.add(new PropertyToBuy("SP-402", "Mango Maharjan", "977-9840093242", "Land", "Teku", 57000000, 140, "Commercial Area", "Partially furnished", "Level 3" ));
                    properties.add(new PropertyToBuy("SP-403", "Orange Shakya", "977-9855312321", "Building", "Indrachowk", 63000000, 140, "Commercial Area", "Partially furnished", "Level 4" ));
                    properties.add(new PropertyToBuy("SP-404", "Banana Bogati", "977-9848796773", "Appartment", "Chagal", 43000000, 140, "Residential Area", "unFurnished", "Level 1" ));
                    properties.add(new PropertyToBuy("SP-405", "Papaya Suwal", "977-9848392343", "Building", "Thamel", 90000000, 140, "Commercial Area", "unFurnished", "Level 1" ));
                    properties.add(new PropertyToBuy("SP-406", "Guava Limbhu", "977-9841909093", "Building", "Teku", 132000000, 440, "Commercial Area", "Partially furnished", "Level 3" ));
                    properties.add(new PropertyToBuy("SP-407", "Honey Shrestha", "977-9865234234", "Appartment", "Sanobharang", 8000000, 80, "Residential Area", "unFurnished", "Level 1" ));
                    properties.add(new PropertyToBuy("SP-408", "Tomato Dhakal", "977-9849048325", "Building", "Naxal", 256000000, 430, "Residential Area", "unFurnished", "Level 2" ));
                    properties.add(new PropertyToBuy("SP-409", "Parrot Lal", "977-9849093423", "Building", "Maharajgunj", 182000000, 390, "Residential Area", "fully furnished", "Level 1" ));
                    properties.add(new PropertyToBuy("SP-410", "Turtle Adhikari", "977-9841123123", "Building", "Kamalpokhari", 132000000, 230, "Commercial Area", "unFurnished", "Level 4" ));
                    properties.add(new PropertyToBuy("SP-411", "Soup Rai", "977-9841954332", "Building", "Sitapaila", 25000000, 186, "Residential Area", "Fully furnished", "Level 1" ));
                    
                    saveFile();
                    
                    
                    
                    
                    
                    
                    
                    
                }
    }

}
