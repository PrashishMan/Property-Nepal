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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author prashish
 */
public class BuyPanel extends JPanel implements ActionListener {
    
    private JPanel propertyViewPanel, propertyViewInnerPanel, innerButtonPanel, searchSelectionPanel, searchSelectionInnerPanel, searchByPricePanel,
            searchPanel, searchInnerPanel, searchByPriceInnerPanel, searchByLocationPanel, searchByLocationInnerPanel, buttonsPanel, outerPropertyViewPanel, innerPropertyViewPanel,
            viewPropertyDetailsPanel, viewDetailsPanel, logoViewPanel, viewAdditionalPropertiesPanel;
    
    private JLabel propertyViewLabel, searchSelectionLabel, searchByPriceLabel, searchByLocationLabel, searchLabel,
            imageLabel, propertyNepalLabel, flagImageLabel, viewAdditionalPropertiesLabel, viewFurnishingLabel, viewInsuranceLabel, viewNearbyLabel, viewDistanceLabel, viewFurnishingValueLabel,
            viewInsuranceValueLabel, viewNearbyValueLabel, viewDistanceValueLabel;
    private JTextField searchByPriceTextField;
    private JComboBox searchByLocationCombobox;
    private ArrayList<Property> properties;
    private Color itemsPanelColor, itemSelectionPanelColor, panelHeadingColor;
    private ButtonGroup searchSelectionGroup;
    private JRadioButton priceRadioButton, locationRadioButton;
    private CardLayout searchCardLayout, viewCardLayout;
    private JButton searchByPriceButton, searchByLocationButton, rentBtn, cancelBtn;
    private int WIDTH;
    private Font headingLabelFont;
    private PropertyToBuy propertyToBuy;
    private SearchAndSort searchAndSort;
    private JScrollPane viewPropertyDetailSp, viewRecentlyAddedSp;
    private ImageIcon img1, img2, img3, flagImg, searchBtnImg;
    private ArrayList<String> locations;
    private JTable viewPropertyDetailTable, viewRecentlyAddedTable;
    private DefaultTableModel model, recentlyTableModel;
    
    private final int BUY_TYPE = 2;
    
    public BuyPanel(int WIDTH, ArrayList<Property> properties) {
        //reference to the arraylist that is accessed by all the other class
        this.properties = properties;
        this.WIDTH = WIDTH;
        setLayout(null);
        setBackground(new Color(92, 194, 232));
        //font for the heading at the panel where user provides input
        headingLabelFont = new Font("Arial", Font.BOLD, 14);
        
        //this object creates the image icon from the path specified by the get resource
        //image for the search button
        searchBtnImg = new ImageIcon(getClass().getResource("/Images/searchBtn.png"));
        //resizing the image to the appropriate size accoding to the button size
        Image buttonImage = searchBtnImg.getImage().getScaledInstance(21, 20, Image.SCALE_SMOOTH);
        searchBtnImg = new ImageIcon(buttonImage);
        
        //image of the logo for property to buy
        flagImg = new ImageIcon(getClass().getResource("/Images/flag.png"));
        Image flagImage = flagImg.getImage().getScaledInstance(240, 160, Image.SCALE_SMOOTH);
        flagImg = new ImageIcon(flagImage);
        
        //color for panel that holds the components
        itemsPanelColor = new Color(64, 64, 64);
        itemSelectionPanelColor = new Color(255, 255, 255);
        panelHeadingColor = new Color(160, 160, 160);
        
        //switch between different options while performing the search
        searchCardLayout = new CardLayout();
        //switches the display from the simple property nepal logo to display information abou the property
        viewCardLayout = new CardLayout();
        
        propertyViewPanel = new JPanel();
        propertyViewInnerPanel = new JPanel();
        innerButtonPanel = new JPanel();
        searchSelectionPanel = new JPanel();
        searchSelectionInnerPanel = new JPanel();
        searchPanel = new JPanel();
        buttonsPanel = new JPanel();
        //assigning these panel their cardlayout
        searchInnerPanel = new JPanel(searchCardLayout);
        outerPropertyViewPanel = new JPanel(viewCardLayout);
        viewAdditionalPropertiesPanel = new JPanel();
        
        searchByPricePanel = new JPanel();
        searchByPriceInnerPanel = new JPanel();
        searchByLocationPanel = new JPanel();
        searchByLocationInnerPanel = new JPanel();
        viewDetailsPanel = new JPanel();
        
        innerPropertyViewPanel = new JPanel();
        viewPropertyDetailsPanel = new JPanel();
        
        buttonsPanel = new JPanel();
        logoViewPanel = new JPanel();
        
        //instance of SearchAndSort class that performs sorting and searching as well as inspection of user input
        searchAndSort = new SearchAndSort(this, properties);
        
        searchSelectionLabel = new JLabel("Search By: ");
        propertyViewLabel = new JLabel("View Property");
        searchByPriceLabel = new JLabel("Price : ");
        searchByLocationLabel = new JLabel("Location : ");
        searchLabel = new JLabel("Search");
        imageLabel = new JLabel();
        flagImageLabel = new JLabel(flagImg);
        viewAdditionalPropertiesLabel = new JLabel("Additional Properties");
        
        viewFurnishingLabel = new JLabel("Furnishing: ");
        viewInsuranceLabel = new JLabel("Insurance: ");
        viewNearbyLabel = new JLabel("Near By: ");
        viewDistanceLabel = new JLabel("Distance(KM): ");
        
        viewFurnishingValueLabel = new JLabel("");
        viewInsuranceValueLabel = new JLabel("");
        viewNearbyValueLabel = new JLabel("----");
        viewDistanceValueLabel = new JLabel("----");
        
        propertyNepalLabel = new JLabel("Property Nepal");
        
        searchByPriceTextField = new JTextField();
        
        searchByLocationCombobox = new JComboBox();
        
        searchSelectionGroup = new ButtonGroup();
        priceRadioButton = new JRadioButton("Price");
        locationRadioButton = new JRadioButton("Location");
        
        searchByPriceButton = new JButton(searchBtnImg);
        searchByLocationButton = new JButton(searchBtnImg);
        rentBtn = new JButton("Rent");
        cancelBtn = new JButton("Cancel");
        
        //this instance of DefaultTable model defines the columns and value of the column
        //it contains two columns for displaying the user input for confirmation
        model = new DefaultTableModel(new Object[][]{{"Owner: ", ""}, {"Contact: ", ""}, {"Location: ", ""}, {"Price : ", ""},
        {"Area:", ""}, {"Locality:", ""}}, new String[]{"Attributes", "Value"});
        //implementing the model in the table
        viewPropertyDetailTable = new JTable(model);
        
        //gets the column model for arranging the with of the column
        TableColumnModel columnModel = viewPropertyDetailTable.getColumnModel();
        
        //sets the width of the column at 0th index
        columnModel.getColumn(0).setPreferredWidth(20);
        viewPropertyDetailTable.setRowHeight(20);
        
        //allows table to be scrolled when the data exceeds the table size
        viewPropertyDetailSp = new JScrollPane(viewPropertyDetailTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        
        //this instance of DefaultTableModel defines vatious columns for displaying the attributes of a property recently added
        recentlyTableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name", "Location", "Type", "Price", "Area"});
        viewRecentlyAddedTable = new JTable(recentlyTableModel);
        viewRecentlyAddedSp = new JScrollPane(viewRecentlyAddedTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //this instance of TableColumnModel helps to adjust the column size of the table
        TableColumnModel columnRecentModel = viewRecentlyAddedTable.getColumnModel();
        //getColumn retrives the reference to the column
        //setPreffered size adjusts the size as given in its parameters
        columnRecentModel.getColumn(0).setPreferredWidth(30);
        columnRecentModel.getColumn(1).setPreferredWidth(60);
        columnRecentModel.getColumn(2).setPreferredWidth(70);
        columnRecentModel.getColumn(3).setPreferredWidth(55);
        columnRecentModel.getColumn(4).setPreferredWidth(40);
        columnRecentModel.getColumn(5).setPreferredWidth(35);
        
        //set the row height of the table
        viewRecentlyAddedTable.setRowHeight(30);
        
        //this radiogroup help user determine the method for searching the property 
        searchSelectionGroup.add(priceRadioButton);
        searchSelectionGroup.add(locationRadioButton);
        
        propertyViewPanel.add(propertyViewInnerPanel);
        propertyViewPanel.add(innerButtonPanel);
        
        searchPanel.setLayout(null);
        searchPanel.add(searchLabel);
        searchPanel.add(searchInnerPanel);
        searchPanel.add(viewRecentlyAddedSp);
        searchPanel.add(outerPropertyViewPanel);
        searchPanel.add(buttonsPanel);
        
        logoViewPanel.setLayout(null);
        logoViewPanel.add(flagImageLabel);
        logoViewPanel.add(propertyNepalLabel);
        
        //this is the panel that has implemetnted cardLayout
        //@param1: the name of the panel to be displayed 
        //@param2: key for the panel future reference
        //switches between displaying company logo and property information
        outerPropertyViewPanel.add(logoViewPanel, "logoViewPanel");
        outerPropertyViewPanel.add(innerPropertyViewPanel, "propertyViewPanel");
        
        //switched between panel that receives price input and location input
        searchInnerPanel.add(searchByPricePanel, "searchByPrice");
        searchInnerPanel.add(searchByLocationPanel, "searchByLocation");
        
        //this panel has implemented flowlayout with 2 horizontal and 2 vertical gap between the view inside it
        //@param1: orientation of the layout content
        //@param2: horizintal gap between the views inside the panel
        //@param3: vertical gap between the views if layed vertically
        searchByPricePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
        searchByPricePanel.add(searchByPriceLabel);
        searchByPricePanel.add(searchByPriceTextField);
        searchByPricePanel.add(searchByPriceButton);
        
        searchByLocationPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
        searchByLocationPanel.add(searchByLocationLabel);
        searchByLocationPanel.add(searchByLocationCombobox);
        searchByLocationPanel.add(searchByLocationButton);

        //displays property for view
        innerPropertyViewPanel.setLayout(null);
        innerPropertyViewPanel.add(viewPropertyDetailsPanel);
        innerPropertyViewPanel.add(viewAdditionalPropertiesLabel);
        innerPropertyViewPanel.add(viewAdditionalPropertiesPanel);
        
        viewPropertyDetailsPanel.setLayout(null);
        viewPropertyDetailsPanel.add(imageLabel);
        viewPropertyDetailsPanel.add(viewPropertyDetailSp);
        
        buttonsPanel.setLayout(null);
        buttonsPanel.add(rentBtn);
        buttonsPanel.add(cancelBtn);
        
        //sets the location and size of the view manually
        //@param1: location at x-axis
        //@param2: locaton at y-axis
        //@param3: width of the view
        //@param4: height of the view
        imageLabel.setBounds(0, 0, 200, 160);
        viewDetailsPanel.setBounds(205, 0, 180, 200);
        
        outerPropertyViewPanel.setBounds(395, 30, 400, 250);
        viewPropertyDetailsPanel.setBounds(0, 0, 395, 160);
        
        flagImageLabel.setBounds(80, 20, 240, 160);
        propertyNepalLabel.setBounds(10, 120, 400, 160);
        //sets the label at the center of the panel
        //@param1: orientation of the label in the panel
        propertyNepalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        propertyNepalLabel.setFont(new Font("Arial", Font.BOLD, 26));
        
        //set the width and height of the label if setBounds cannot used
        //@param1 of Dimention: width of the view
        //@param2 of Dimention: height of the view
        imageLabel.setPreferredSize(new Dimension(200, 140));
        
        //By default panel layout is set to border layout
        //@param1: view to be organized
        //@param2: location of the view to be displayed
        searchSelectionPanel.add(searchSelectionLabel, BorderLayout.NORTH);
        searchSelectionPanel.add(searchSelectionInnerPanel, BorderLayout.CENTER);
        
        buttonsPanel.add(rentBtn);
        buttonsPanel.add(cancelBtn);

        //@param GridLayout (noOfRows, noOfColumns, verticalGap, horizontalGap)
        viewAdditionalPropertiesPanel.setLayout(new GridLayout(2, 4, 5, 5));
        viewAdditionalPropertiesPanel.add(viewNearbyLabel);
        viewAdditionalPropertiesPanel.add(viewNearbyValueLabel);
        viewAdditionalPropertiesPanel.add(viewFurnishingLabel);
        viewAdditionalPropertiesPanel.add(viewFurnishingValueLabel);
        viewAdditionalPropertiesPanel.add(viewDistanceLabel);
        viewAdditionalPropertiesPanel.add(viewDistanceValueLabel);
        viewAdditionalPropertiesPanel.add(viewInsuranceLabel);
        viewAdditionalPropertiesPanel.add(viewInsuranceValueLabel);
        
        //creating image for three different types of property type and adjusting their size
        img1 = new ImageIcon(getClass().getResource("/Images/room_rent.png"));
        Image propertyImage1 = img1.getImage().getScaledInstance(200, 160, Image.SCALE_SMOOTH);
        img1 = new ImageIcon(propertyImage1);
        
        img2 = new ImageIcon(getClass().getResource("/Images/building_rent.png"));
        Image propertyImage2 = img2.getImage().getScaledInstance(200, 160, Image.SCALE_SMOOTH);
        img2 = new ImageIcon(propertyImage2);
        
        img3 = new ImageIcon(getClass().getResource("/Images/appartment_rent.png"));
        Image propertyImage3 = img3.getImage().getScaledInstance(200, 160, Image.SCALE_SMOOTH);
        img3 = new ImageIcon(propertyImage3);
        
        searchSelectionPanel.setLayout(null);
        searchSelectionPanel.setBounds(10, 10, WIDTH - 20, 75);
        
        searchLabel.setBounds(5, 5, 400, 20);
        searchSelectionLabel.setBounds(5, 5, WIDTH - 30, 20);
        searchSelectionInnerPanel.setBounds(5, 30, WIDTH - 30, 40);
        
        searchPanel.setBounds(10, 95, WIDTH - 20, 380);
        searchInnerPanel.setBounds(WIDTH - 275, 5, 250, 20);
        
        viewRecentlyAddedSp.setBounds(5, 30, 390, 250);
        innerPropertyViewPanel.setBounds(395, 30, 400, 250);
        viewPropertyDetailSp.setBounds(200, 0, 190, 200);
        
        buttonsPanel.setBounds(5, 285, WIDTH - 30, 90);
        rentBtn.setBounds(240, 10, 140, 70);
        cancelBtn.setBounds(400, 10, 140, 70);
        
        viewAdditionalPropertiesLabel.setBounds(10, 165, 300, 20);
        viewAdditionalPropertiesPanel.setBounds(5, 185, 390, 60);
        
        
        //creating the border of the panel this border has a darkgray line of 5pixel
        outerPropertyViewPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        viewRecentlyAddedSp.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        
        //adjusting the size of different components inside the layout
        searchByPriceLabel.setPreferredSize(new Dimension(80, 20));
        searchByPriceTextField.setPreferredSize(new Dimension(140, 20));
        searchByPriceButton.setPreferredSize(new Dimension(20, 20));
        
        searchByLocationLabel.setPreferredSize(new Dimension(80, 20));
        searchByLocationCombobox.setPreferredSize(new Dimension(140, 20));
        searchByLocationButton.setPreferredSize(new Dimension(20, 20));
        
        //set the background color for the panel
        searchSelectionPanel.setBackground(itemsPanelColor);
        searchSelectionInnerPanel.setBackground(itemSelectionPanelColor);
        
        searchPanel.setBackground(itemsPanelColor);
        searchInnerPanel.setBackground(itemsPanelColor);
        searchByPricePanel.setBackground(itemsPanelColor);
        searchByLocationPanel.setBackground(itemsPanelColor);
        innerPropertyViewPanel.setBackground(Color.DARK_GRAY);
        logoViewPanel.setBackground(Color.DARK_GRAY);
        
        viewDetailsPanel.setBackground(itemsPanelColor);
        buttonsPanel.setBackground(new Color(242, 237, 236));
        
        searchLabel.setFont(headingLabelFont);
        searchSelectionLabel.setFont(headingLabelFont);
        searchByPriceLabel.setFont(headingLabelFont);
        searchByLocationLabel.setFont(headingLabelFont);
        viewAdditionalPropertiesLabel.setFont(headingLabelFont);
        
        searchSelectionInnerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 200, 10));
        searchSelectionInnerPanel.add(priceRadioButton);
        searchSelectionInnerPanel.add(locationRadioButton);
        priceRadioButton.setSelected(true);
        
        //set the foreground colr for the labels of the panel
        searchSelectionLabel.setForeground(panelHeadingColor);
        searchLabel.setForeground(panelHeadingColor);
        searchByPriceLabel.setForeground(panelHeadingColor);
        searchByLocationLabel.setForeground(panelHeadingColor);
        viewAdditionalPropertiesLabel.setForeground(panelHeadingColor);
        
        propertyNepalLabel.setForeground(Color.LIGHT_GRAY);
        
        //adding actionlistener for different events
        searchByPriceButton.addActionListener(this);
        searchByLocationButton.addActionListener(this);
        rentBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        
        //this instance of Location class holds the arraylist of different location inside valey
        Locations location = new Locations();
        locations = location.getLocations();
        
        //adding locaiton inside the combobox
        for (int i = 0; i < locations.size(); i++) {
            searchByLocationCombobox.addItem(locations.get(i));
        }
        
        add(propertyViewPanel);
        add(searchSelectionPanel);
        add(searchPanel);
        
        //this mouse event listenes for row selected via mouseclick
        //when the event is triggered the details about the property is displayed
        viewRecentlyAddedTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //retrives the selected row by the mouse
                int selectedRow = viewRecentlyAddedTable.getSelectedRow();
                String id = "";
                //retrives the id of the object
                id = viewRecentlyAddedTable.getValueAt(selectedRow, 0).toString();
                //retrives the propertytobuy object from the id
                propertyToBuy = (PropertyToBuy) searchAndSort.selectProperty(id);
                
                //when a row is selected and the object is retrived 
                if (selectedRow >= 0 && propertyToBuy != null) {
                    //this method displays the propety attributes in the panel
                    setConfirmPanel(propertyToBuy);
                    //displays a panel with property details
                    viewCardLayout.show(outerPropertyViewPanel, "propertyViewPanel");
                }
            }
        });
        
        //upon triggering this event the user is alloed to search according to the price
        priceRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //if the event is selected
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    //change the method of taking input from location to price
                    searchCardLayout.show(searchInnerPanel, "searchByPrice");
                } else {
                    //vise-versa
                    searchCardLayout.show(searchInnerPanel, "searchByLocation");
                }
            }
        });
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchByPriceButton) {
            //clears the previous content from the table
            recentlyTableModel.setRowCount(0);
            //checks if the price field is left empty
            if (searchByPriceTextField.getText().isEmpty() || searchByPriceTextField.getText().trim().equals("") || searchByPriceTextField == null || searchByPriceTextField.getText().contains("-")) {
                JOptionPane.showMessageDialog(this, "Please enter positive price amount!!", "Error: Price field empty", JOptionPane.ERROR_MESSAGE);
            } else {
                int price = 0;
                try {
                    
                    PropertyToBuy displayProperty = null;
                    //typecasting the string value from the textfield to an integer
                    price = Integer.parseInt(searchByPriceTextField.getText());
                    //retrives an array of properties with the price specified by the user
                    ArrayList<Property> foundProperties = searchAndSort.getProperties(price);
                    
                    //display attributes of each properties found for user to select from
                    for (int i = 0; i < foundProperties.size(); i++) {
                        //this panel deals only with property to buy so the object retrives must be the instance of property to buy
                        if (foundProperties.get(i) instanceof PropertyToBuy) {
                            displayProperty = (PropertyToBuy) foundProperties.get(i);
                            //adds the row in the table for user to view
                            recentlyTableModel.addRow(new Object[]{displayProperty.getId(), displayProperty.getOwnersName(), displayProperty.getLocation(), displayProperty.getPropertyType(), displayProperty.getPrice(), displayProperty.getArea()});
                        }
                    }
                    
                    //if the arraylist doesnot contain any price specified by the user
                    if (displayProperty == null) {
                        JOptionPane.showMessageDialog(this, "Property in the price range : " + price + " is unavailable!!", "Error: Property unavailable", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
                //if the user misses to provide the price
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter valid price amount!!", "Error: Incorrect number format", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } 
        //else if the user wants to search by location
        else if (e.getSource() == searchByLocationButton) {
            //clear all the previous search from the table
            recentlyTableModel.setRowCount(0);
            //checks of the value from the combobox is selected
            if (searchByLocationCombobox.getSelectedItem() == null || searchByLocationCombobox.getSelectedItem().toString().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please select the Location of Property!!", "Error: Location field empty", JOptionPane.ERROR_MESSAGE);
            } else {
                PropertyToBuy displayProperty = null;
                
                //retrive the location from the selection in the combobox
                String location = searchByLocationCombobox.getSelectedItem().toString();
                
                //retrives an arraylist of property to be displayed for the user
                //@param1: the location specified by the user
                //@param2: the type of property(PropertyToBuy)
                ArrayList<Property> selectedProperty = searchAndSort.getPropertyByLocation(location, BUY_TYPE);
                
                //display every property found in the table
                for (int i = 0; i < selectedProperty.size(); i++) {
                    displayProperty = (PropertyToBuy) selectedProperty.get(i);
                    //adding the attributes in the table rows
                    recentlyTableModel.addRow(new Object[]{displayProperty.getId(), displayProperty.getOwnersName(), displayProperty.getLocation(), displayProperty.getPropertyType(), displayProperty.getPrice(), displayProperty.getArea()});
                }
                //if the property at the selected location is not available
                if (selectedProperty.size() <= 0) {
                    JOptionPane.showMessageDialog(this, "Property at the location : " + location + " is unavailable!!", "Error: Property unavailable", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } else if (e.getSource()
                == rentBtn) {
            //check if the row is selected from the list of properties
            if (viewRecentlyAddedTable.getSelectedRow() < 0) {
                
                JOptionPane.showMessageDialog(this, "PLease select the row to be rented", "Error: Row not selected", JOptionPane.ERROR_MESSAGE);
            } 
            //checks if the property is available or is already bought
            else if (!propertyToBuy.isAvailable() || propertyToBuy == null) {
                
                JOptionPane.showMessageDialog(this, "This property is not available", "Property unavailable", JOptionPane.ERROR_MESSAGE);
            } 
            //if the user buys the property
            else {
                JOptionPane.showMessageDialog(this, "Thankyou for renting the property \nPropertyId: " + propertyToBuy.getId() + "\nLocation: " + propertyToBuy.getLocation()
                        + "\nPrice: " + propertyToBuy.getPrice(), "Property unavailable", JOptionPane.INFORMATION_MESSAGE);
                propertyToBuy.setAvailable(false);
            }
        } 
        //if the user cancels the search
        else if (e.getSource()
                == cancelBtn) {
            propertyToBuy = null;
            viewCardLayout.show(outerPropertyViewPanel, "logoViewPanel");
            recentlyTableModel.setRowCount(0);
        }
    }
    
    //this method sets the view in confirmation panel
    //@param1: the object to be displayed in the confirmation panel
    public void setConfirmPanel(PropertyToBuy property) {
        PropertyToBuy propertyDetails = property;
        
        //sets the value at the specific index in the table
        model.setValueAt(propertyDetails.getOwnersName(), 0, 1);
        model.setValueAt(propertyDetails.getContact(), 1, 1);
        model.setValueAt(propertyDetails.getLocation(), 2, 1);
        model.setValueAt(propertyDetails.getPrice(), 3, 1);
        model.setValueAt(propertyDetails.getArea(), 4, 1);
        model.setValueAt(propertyDetails.getCommunity(), 5, 1);
        
        //sets the image of the confirmation panel as specified by the user
        if (propertyDetails.getPropertyType().equals("Land")) {
            imageLabel.setIcon(img1);
        } else if (propertyDetails.getPropertyType().equals("Building")) {
            imageLabel.setIcon(img2);
        } else if (propertyDetails.getPropertyType().equals("Appartment")) {
            imageLabel.setIcon(img3);
        }
        
        //set the value of nearby property and rage if the user has specified it
        if (!property.getNearBy().equals("") && property.getDistanceRange() > 0) {
            viewNearbyValueLabel.setText(property.getNearBy());
            viewDistanceValueLabel.setText(property.getDistanceRange() + "");
        }
        
        //splits the furnishing text to display only the specific part of the text like: fully, partially, unfurnished
        String furnishing[] = property.getFurnishing().split(" ");        
        viewFurnishingValueLabel.setText(furnishing[0]);
        
        viewInsuranceValueLabel.setText(property.getInsurance());
    }
    
}
