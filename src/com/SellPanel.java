package com;

import PropertyNepal.Property;
import PropertyNepal.PropertyToBuy;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SellPanel extends JPanel implements ActionListener {

    
//creating variable for Jpanel;
    private JPanel ownerDetailsPanel, ownerDetailsLeftPanel, ownerDetailsRightPanel, propertyDetailsPanel, propertyDetailsLeftPanel, propertyDetailsRightPanel,
            geographicalPropertyPanel, geographicalPropertyLeftPanel, geographicalPropertyRightPanel, viewPanel, logoViewPanel, propertyViewPanel,
            innerPropertyViewPanel, viewPropertyDetailsPanel, viewDetailsPanel, viewAdditionalPropertiesPanel, recentlyAddedViewPanel, recentlyAddedTablePanel,
            additionalPropertiesPanel, additionalPropertiesLeftPanel, additionalPropertiesRightPanel;

    
//creating variable for JLabel;
    private JLabel ownersFNameLabel, ownersLNameLabel, ownersContactLabel, ownerDetailsLabel,
            propertyTypeLabel, propertyLocationLabel, propertyAreaLabel, communityLabel, furnishingLabel, insuranceLabel, propertyDetailsLabel, priceLabel,
            geographicalPropertiesLabel, nearByLabel, distanceRangeLabel, propertyNepalLabel, imageLabel, viewOwnersNameLabel, viewContactNumberLabel,
            viewLocationLabel, viewNoOfRoomsLabel, viewPriceLabel, viewPaymentRequiredLabel, viewAdditionalPropertiesLabel, flagImageLabel, propertyNepalLogoLabel,
            recentlyAddedLabel, additionalPropertiesLabel, viewFurnishingLabel, viewInsuranceLabel, viewNearbyLabel, viewDistanceLabel, viewFurnishingValueLabel,
            viewInsuranceValueLabel, viewNearbyValueLabel, viewDistanceValueLabel;
    
//creating variable for text field
    private JTextField ownerFNameTextField, ownerLNameTextField, ownerContactTextField, priceTextField, areaTextField, distanceRangeTextField;

    private JComboBox propertyTypeComboBox, locationComboBox, communityComboBox, furnishingComboBox, insuranceComboBox, nearByComboBox;

    private Color itemsPanelColor, itemSelectionPanelColor, panelHeadingColor;

    private CardLayout viewCardLayout;

    private JButton doneBtn, clearBtn, confirmBtn, viewDetailsBtn, editBtn, deleteBtn, cancelBtn;

    private JScrollPane viewPropertyDetailSp, viewRecentlyAddedSp;

    private JTable viewPropertyDetailTable, viewRecentlyAddedTable;

    private DefaultTableModel model, recentlyTableModel;

    private ImageIcon img1, img2, img3, flagImg;

    private Font headingLabelFont;

    private ArrayList locations;

    private int propertyCount, selectedRow;

    private boolean isRowSelected, isViewSelected;

    private PropertyToBuy propertyToBuy;

    ArrayList<Property> properties;

    private SearchAndSort searchAndSort;

    
    //this is the container of the file
    public SellPanel(int WIDTH, ArrayList<Property> properties) {
        
        setLayout(null); //important
        //owner's instance variable

        setBackground(new Color(224, 106, 81));

        //instance of this class SearchAndSort handles the
        searchAndSort = new SearchAndSort(this, properties);
        this.properties = properties;

        itemsPanelColor = new Color(64, 64, 64);
        itemSelectionPanelColor = new Color(255, 255, 255);
        panelHeadingColor = new Color(160, 160, 160);
        headingLabelFont = new Font("Arial", Font.BOLD, 14);

        this.properties = properties;
        ownerDetailsPanel = new JPanel();
        ownerDetailsLeftPanel = new JPanel();
        ownerDetailsRightPanel = new JPanel();

        propertyDetailsPanel = new JPanel();
        propertyDetailsLeftPanel = new JPanel();
        propertyDetailsRightPanel = new JPanel();

        geographicalPropertyPanel = new JPanel();
        geographicalPropertyRightPanel = new JPanel();
        geographicalPropertyLeftPanel = new JPanel();

        additionalPropertiesPanel = new JPanel();
        additionalPropertiesLeftPanel = new JPanel();
        additionalPropertiesRightPanel = new JPanel();

        viewCardLayout = new CardLayout();
        viewPanel = new JPanel(viewCardLayout);

        logoViewPanel = new JPanel();
        propertyViewPanel = new JPanel();
        innerPropertyViewPanel = new JPanel();

        viewPropertyDetailsPanel = new JPanel();
        viewAdditionalPropertiesPanel = new JPanel();
        viewDetailsPanel = new JPanel();

        recentlyAddedViewPanel = new JPanel();
        recentlyAddedTablePanel = new JPanel();

        ownersFNameLabel = new JLabel("first name");
        ownersLNameLabel = new JLabel("last name");
        ownersContactLabel = new JLabel("contact number");
        ownerDetailsLabel = new JLabel("Owner's detail");

        propertyDetailsLabel = new JLabel("Property Details");
        propertyTypeLabel = new JLabel("Type");
        propertyLocationLabel = new JLabel("Location");
        propertyAreaLabel = new JLabel("Area (Sq ft.)");
        communityLabel = new JLabel("Community");
        furnishingLabel = new JLabel("Furnishing");
        insuranceLabel = new JLabel("Insurance");
        priceLabel = new JLabel("Price");
        nearByLabel = new JLabel("Near By");
        distanceRangeLabel = new JLabel("Distance (Km)");

        geographicalPropertiesLabel = new JLabel("Surrounding");

        additionalPropertiesLabel = new JLabel("Additional Properties");

        viewOwnersNameLabel = new JLabel("Owners Name: ");
        viewContactNumberLabel = new JLabel("Number: ");
        viewLocationLabel = new JLabel("Location: ");
        viewNoOfRoomsLabel = new JLabel("No Of Rooms: ");
        viewPriceLabel = new JLabel("Price: ");
        viewPaymentRequiredLabel = new JLabel("Payment Required: ");
        propertyNepalLabel = new JLabel("Property Nepal");
        imageLabel = new JLabel();
        viewAdditionalPropertiesLabel = new JLabel("Additional Properties: ");

        viewFurnishingLabel = new JLabel("Furnishing: ");
        viewInsuranceLabel = new JLabel("Insurance: ");
        viewNearbyLabel = new JLabel("Near By: ");
        viewDistanceLabel = new JLabel("Distance(KM): ");

        viewFurnishingValueLabel = new JLabel("");
        viewInsuranceValueLabel = new JLabel("");
        viewNearbyValueLabel = new JLabel("----");
        viewDistanceValueLabel = new JLabel("----");

        recentlyAddedLabel = new JLabel("Recently Added");

        flagImageLabel = new JLabel();

        propertyNepalLogoLabel = new JLabel("Property Nepal");
        propertyNepalLogoLabel.setFont(new Font("Arial", Font.BOLD, 24));

        ownerFNameTextField = new JTextField();
        ownerLNameTextField = new JTextField();
        ownerContactTextField = new JTextField();
        priceTextField = new JTextField();
        areaTextField = new JTextField();
        distanceRangeTextField = new JTextField();

        //property instance variable
        locationComboBox = new JComboBox();
        communityComboBox = new JComboBox();
        furnishingComboBox = new JComboBox();
        insuranceComboBox = new JComboBox();
        propertyTypeComboBox = new JComboBox();
        nearByComboBox = new JComboBox();

        //
        doneBtn = new JButton("Done");
        clearBtn = new JButton("Clear");

        confirmBtn = new JButton("OK");
        editBtn = new JButton("Edit");
        deleteBtn = new JButton("Delete");

        cancelBtn = new JButton("Cancel");

        viewDetailsBtn = new JButton("Details");

        model = new DefaultTableModel(new Object[][]{{"Owner: ", ""}, {"Contact: ", ""}, {"Location: ", ""}, {"Price : ", ""},
        {"Area:", ""}, {"Locality:", ""}}, new String[]{"Attributes", "Value"});
        viewPropertyDetailTable = new JTable(model);
        TableColumnModel columnModel = viewPropertyDetailTable.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(30);
        viewPropertyDetailTable.setRowHeight(20);

        viewPropertyDetailSp = new JScrollPane(viewPropertyDetailTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        recentlyTableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name", "Location", "Type", "Price", "Area"});
        viewRecentlyAddedTable = new JTable(recentlyTableModel);
        viewRecentlyAddedSp = new JScrollPane(viewRecentlyAddedTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        TableColumnModel columnRecentModel = viewRecentlyAddedTable.getColumnModel();

        columnRecentModel.getColumn(0).setPreferredWidth(30);
        columnRecentModel.getColumn(1).setPreferredWidth(60);
        columnRecentModel.getColumn(2).setPreferredWidth(70);
        columnRecentModel.getColumn(3).setPreferredWidth(55);
        columnRecentModel.getColumn(4).setPreferredWidth(40);
        columnRecentModel.getColumn(5).setPreferredWidth(35);

        viewRecentlyAddedTable.setRowHeight(30);

        //owner's left panel+rightPanel on Main Panel
        ownerDetailsLeftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        ownerDetailsLeftPanel.add(ownersFNameLabel);
        ownerDetailsLeftPanel.add(ownersLNameLabel);
        ownerDetailsLeftPanel.add(ownersContactLabel);

        //adding views inside owners righr panel 
        ownerDetailsRightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 6));
        ownerDetailsRightPanel.add(ownerFNameTextField);
        ownerDetailsRightPanel.add(ownerLNameTextField);
        ownerDetailsRightPanel.add(ownerContactTextField);

        //adding content inside ownersDetails panel
        ownerDetailsPanel.setLayout(null);
        ownerDetailsPanel.add(ownerDetailsRightPanel);
        ownerDetailsPanel.add(ownerDetailsLeftPanel);
        ownerDetailsPanel.add(ownerDetailsLabel);

        //property left panel + right panel on main Panel
        propertyDetailsLeftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 11));
        propertyDetailsLeftPanel.add(propertyTypeLabel);
        propertyDetailsLeftPanel.add(propertyLocationLabel);
        propertyDetailsLeftPanel.add(priceLabel);
        propertyDetailsLeftPanel.add(propertyAreaLabel);

        //addind view inside pproperty detail right panel
        propertyDetailsRightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 7));
        propertyDetailsRightPanel.add(propertyTypeComboBox);
        propertyDetailsRightPanel.add(locationComboBox);
        propertyDetailsRightPanel.add(priceTextField);
        propertyDetailsRightPanel.add(areaTextField);

        //adding view and panel to the property detail panel
        propertyDetailsPanel.setLayout(null);
        propertyDetailsPanel.add(propertyDetailsRightPanel);
        propertyDetailsPanel.add(propertyDetailsLeftPanel);
        propertyDetailsPanel.add(propertyDetailsLabel);

        //geographicalPropertyPanel stores 2 panel and label
        //georaphical property panel stores the area of the property, nearby location, and distance from it
        geographicalPropertyPanel.setLayout(null);
        geographicalPropertyPanel.add(geographicalPropertiesLabel);
        geographicalPropertyPanel.add(geographicalPropertyLeftPanel);
        geographicalPropertyPanel.add(geographicalPropertyRightPanel);

        //stores the views that describe the requirement
        geographicalPropertyLeftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 13));
        geographicalPropertyLeftPanel.add(nearByLabel);
        geographicalPropertyLeftPanel.add(distanceRangeLabel);

        //stores the views that stores the value from the user
        geographicalPropertyRightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        geographicalPropertyRightPanel.add(nearByComboBox);
        geographicalPropertyRightPanel.add(distanceRangeTextField);

        additionalPropertiesLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 13));
        additionalPropertiesLeftPanel.add(communityLabel);
        additionalPropertiesLeftPanel.add(furnishingLabel);
        additionalPropertiesLeftPanel.add(insuranceLabel);

        additionalPropertiesRightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        additionalPropertiesRightPanel.add(communityComboBox);
        additionalPropertiesRightPanel.add(furnishingComboBox);
        additionalPropertiesRightPanel.add(insuranceComboBox);

        additionalPropertiesPanel.setLayout(null);
        additionalPropertiesPanel.add(additionalPropertiesLabel);
        additionalPropertiesPanel.add(additionalPropertiesLeftPanel);
        additionalPropertiesPanel.add(additionalPropertiesRightPanel);

        //this panel displays the user input
        viewPanel.add(logoViewPanel, "logoViewPanel");
        viewPanel.add(propertyViewPanel, "propertyViewPanel");
        viewPanel.add(recentlyAddedViewPanel, "recentlyAddedViewPanel");

        logoViewPanel.setLayout(null);
        logoViewPanel.add(flagImageLabel);
        logoViewPanel.add(propertyNepalLogoLabel);

        propertyViewPanel.setLayout(null);
        propertyViewPanel.add(propertyNepalLabel);
        propertyViewPanel.add(innerPropertyViewPanel);

        innerPropertyViewPanel.setLayout(null);
        innerPropertyViewPanel.add(viewPropertyDetailsPanel);
        innerPropertyViewPanel.add(confirmBtn);
        innerPropertyViewPanel.add(cancelBtn);
        innerPropertyViewPanel.add(viewAdditionalPropertiesLabel);
        innerPropertyViewPanel.add(viewAdditionalPropertiesPanel);

        //this panel displays the recently added property in the table
        recentlyAddedViewPanel.setLayout(null);
        recentlyAddedViewPanel.add(recentlyAddedLabel);
        recentlyAddedViewPanel.add(recentlyAddedTablePanel);

        recentlyAddedTablePanel.setLayout(null);
        recentlyAddedTablePanel.add(viewRecentlyAddedSp);
        recentlyAddedTablePanel.add(viewDetailsBtn);
        recentlyAddedTablePanel.add(editBtn);
        recentlyAddedTablePanel.add(deleteBtn);

        //@param (noOfRows, noOfColumns, verticalGap, horizontalGap)
        viewAdditionalPropertiesPanel.setLayout(new GridLayout(2, 4, 5, 5));
        viewAdditionalPropertiesPanel.add(viewNearbyLabel);
        viewAdditionalPropertiesPanel.add(viewNearbyValueLabel);
        viewAdditionalPropertiesPanel.add(viewFurnishingLabel);
        viewAdditionalPropertiesPanel.add(viewFurnishingValueLabel);
        viewAdditionalPropertiesPanel.add(viewDistanceLabel);
        viewAdditionalPropertiesPanel.add(viewDistanceValueLabel);
        viewAdditionalPropertiesPanel.add(viewInsuranceLabel);
        viewAdditionalPropertiesPanel.add(viewInsuranceValueLabel);

        viewPropertyDetailsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        viewPropertyDetailsPanel.add(imageLabel);
        viewPropertyDetailsPanel.add(viewDetailsPanel);

        viewDetailsPanel.setLayout(null);
        viewDetailsPanel.add(viewPropertyDetailSp);

        propertyTypeComboBox.addItem(null);
        propertyTypeComboBox.addItem("Land");
        propertyTypeComboBox.addItem("Building");
        propertyTypeComboBox.addItem("Appartment");

        communityComboBox.addItem(null);
        communityComboBox.addItem("Residential Area");
        communityComboBox.addItem("Commercial Area");
        communityComboBox.addItem("Industrial Area");

        furnishingComboBox.addItem(null);
        furnishingComboBox.addItem("Unfurnished");
        furnishingComboBox.addItem("Partially furnished");
        furnishingComboBox.addItem("Fully furnished");

        insuranceComboBox.addItem(null);
        insuranceComboBox.addItem("Level 1");
        insuranceComboBox.addItem("Level 2");
        insuranceComboBox.addItem("Level 3");
        insuranceComboBox.addItem("Level 4");

        nearByComboBox.addItem(null);
        nearByComboBox.addItem("Hospital & Clinics");
        nearByComboBox.addItem("Super Market");
        nearByComboBox.addItem("School & Colleges");
        nearByComboBox.addItem("Police Station");
        nearByComboBox.addItem("Fire Hydrant");
        nearByComboBox.addItem("Historical Places");

        //Owners setBound+setPreferredSize+setBackground
        ownerDetailsPanel.setBounds(10, 10, 380, 120);
        ownerDetailsLeftPanel.setBounds(5, 30, 170, 85);
        ownerDetailsRightPanel.setBounds(170, 30, 205, 85);
        ownerDetailsLabel.setBounds(5, 5, 120, 20);

        //Property setBound+setPreferredSize+setBackground
        propertyDetailsPanel.setBounds(10, 140, 380, 150);
        propertyDetailsLabel.setBounds(5, 5, 330, 20);
        propertyDetailsLeftPanel.setBounds(5, 30, 170, 115);
        propertyDetailsRightPanel.setBounds(170, 30, 205, 115);

        geographicalPropertyPanel.setBounds(10, 300, 380, 105);
        geographicalPropertiesLabel.setBounds(5, 5, 340, 20);
        geographicalPropertyLeftPanel.setBounds(5, 30, 170, 70);
        geographicalPropertyRightPanel.setBounds(170, 30, 205, 70);

        additionalPropertiesPanel.setBounds(400, 340, 410, 130);
        additionalPropertiesLabel.setBounds(5, 5, 340, 20);
        additionalPropertiesLeftPanel.setBounds(5, 30, 190, 95);
        additionalPropertiesRightPanel.setBounds(195, 30, 210, 95);

        viewPanel.setBounds(400, 10, 410, 320);
        flagImageLabel.setBounds(60, 20, 290, 260);
        propertyNepalLogoLabel.setBounds(120, 180, 200, 200);

        propertyNepalLabel.setBounds(10, 5, 400, 25);
        innerPropertyViewPanel.setBounds(5, 30, 400, 285);
        viewPropertyDetailsPanel.setBounds(2, 5, 395, 160);
        viewAdditionalPropertiesLabel.setBounds(10, 165, 100, 20);
        viewAdditionalPropertiesPanel.setBounds(5, 185, 390, 60);

        recentlyAddedLabel.setBounds(5, 5, 400, 20);
        recentlyAddedTablePanel.setBounds(5, 30, 400, 285);
        viewRecentlyAddedSp.setBounds(0, 0, 400, 250);

        viewDetailsBtn.setBounds(270, 255, 120, 20);
        editBtn.setBounds(5, 250, 130, 30);
        deleteBtn.setBounds(134, 250, 130, 30);

        confirmBtn.setBounds(266, 250, 130, 30);
        cancelBtn.setBounds(40, 250, 130, 30);

        viewPropertyDetailSp.setBounds(0, 10, 185, 140);

        doneBtn.setBounds(20, 420, 140, 40);
        clearBtn.setBounds(230, 420, 140, 40);

        imageLabel.setPreferredSize(new Dimension(200, 140));
        viewDetailsPanel.setPreferredSize(new Dimension(195, 160));

        viewOwnersNameLabel.setPreferredSize(new Dimension(200, 20));
        viewContactNumberLabel.setPreferredSize(new Dimension(200, 20));
        viewLocationLabel.setPreferredSize(new Dimension(200, 20));
        viewPriceLabel.setPreferredSize(new Dimension(200, 20));
        viewNoOfRoomsLabel.setPreferredSize(new Dimension(200, 20));
        viewPaymentRequiredLabel.setPreferredSize(new Dimension(200, 20));

        ownerFNameTextField.setPreferredSize(new Dimension(170, 20));
        ownerLNameTextField.setPreferredSize(new Dimension(170, 20));
        ownerContactTextField.setPreferredSize(new Dimension(170, 20));
        distanceRangeTextField.setPreferredSize(new Dimension(70, 20));

        propertyTypeComboBox.setPreferredSize(new Dimension(170, 20));
        locationComboBox.setPreferredSize(new Dimension(170, 20));
        communityComboBox.setPreferredSize(new Dimension(170, 20));
        furnishingComboBox.setPreferredSize(new Dimension(170, 20));
        insuranceComboBox.setPreferredSize(new Dimension(170, 20));
        nearByComboBox.setPreferredSize(new Dimension(170, 20));
        priceTextField.setPreferredSize(new Dimension(170, 20));

        areaTextField.setPreferredSize(new Dimension(70, 20));

        img1 = new ImageIcon(getClass().getResource("/Images/room_rent.png"));
        Image propertyImage1 = img1.getImage().getScaledInstance(180, 140, Image.SCALE_SMOOTH);
        img1 = new ImageIcon(propertyImage1);

        img2 = new ImageIcon(getClass().getResource("/Images/building_rent.png"));
        Image propertyImage2 = img2.getImage().getScaledInstance(180, 140, Image.SCALE_SMOOTH);
        img2 = new ImageIcon(propertyImage2);

        img3 = new ImageIcon(getClass().getResource("/Images/appartment_rent.png"));
        Image propertyImage3 = img3.getImage().getScaledInstance(180, 140, Image.SCALE_SMOOTH);
        img3 = new ImageIcon(propertyImage3);

        flagImg = new ImageIcon(getClass().getResource("/Images/flag.png"));
        Image flagImage = flagImg.getImage().getScaledInstance(340, 260, Image.SCALE_SMOOTH);
        flagImg = new ImageIcon(flagImage);

        logoViewPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        viewAdditionalPropertiesPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));

        flagImageLabel.setIcon(flagImg);
        flagImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ownerDetailsPanel.setBackground(itemsPanelColor);
        ownerDetailsLeftPanel.setBackground(Color.WHITE);
        ownerDetailsRightPanel.setBackground(Color.lightGray);

        propertyDetailsPanel.setBackground(itemsPanelColor);
        propertyDetailsLeftPanel.setBackground(Color.WHITE);
        propertyDetailsRightPanel.setBackground(Color.lightGray);

        geographicalPropertyPanel.setBackground(itemsPanelColor);
        geographicalPropertyLeftPanel.setBackground(Color.WHITE);
        geographicalPropertyRightPanel.setBackground(Color.lightGray);

        additionalPropertiesPanel.setBackground(itemsPanelColor);
        additionalPropertiesLeftPanel.setBackground(Color.WHITE);
        additionalPropertiesRightPanel.setBackground(Color.lightGray);

        propertyViewPanel.setBackground(itemsPanelColor);
        innerPropertyViewPanel.setBackground(itemSelectionPanelColor);

        viewDetailsPanel.setBackground(Color.GRAY);
        viewPropertyDetailsPanel.setBackground(Color.GRAY);
        viewAdditionalPropertiesPanel.setBackground(Color.WHITE);
        viewPanel.setBackground(Color.DARK_GRAY);

        logoViewPanel.setBackground(new Color(188, 198, 203));
        recentlyAddedTablePanel.setBackground(Color.WHITE);
        recentlyAddedViewPanel.setBackground(Color.DARK_GRAY);

        ownerDetailsLabel.setForeground(panelHeadingColor);
        propertyDetailsLabel.setForeground(panelHeadingColor);
        geographicalPropertiesLabel.setForeground(panelHeadingColor);
        additionalPropertiesLabel.setForeground(panelHeadingColor);
        propertyNepalLabel.setForeground(panelHeadingColor);
        recentlyAddedLabel.setForeground(panelHeadingColor);

        ownerDetailsLabel.setFont(headingLabelFont);
        propertyDetailsLabel.setFont(headingLabelFont);
        geographicalPropertiesLabel.setFont(headingLabelFont);
        additionalPropertiesLabel.setFont(headingLabelFont);

        propertyNepalLabel.setFont(headingLabelFont);
        recentlyAddedLabel.setFont(headingLabelFont);

        doneBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        confirmBtn.addActionListener(this);

        editBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        cancelBtn.addActionListener(this);

        viewDetailsBtn.addActionListener(this);

        Locations location = new Locations();
        locations = location.getLocations();

        for (int i = 0; i < locations.size(); i++) {
            locationComboBox.addItem(locations.get(i));

        }

        propertyCount = properties.size() + 420;
        selectedRow = -1;
        isRowSelected = false;
        isViewSelected = false;

        add(ownerDetailsPanel);
        add(propertyDetailsPanel);
        add(geographicalPropertyPanel);
        add(additionalPropertiesPanel);
        add(viewPanel);
        add(doneBtn);
        add(clearBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == doneBtn) {

            //setting every textfield blak incase while showing error the text is displayed red
            ownersFNameLabel.setForeground(Color.BLACK);
            ownersLNameLabel.setForeground(Color.BLACK);
            ownersContactLabel.setForeground(Color.BLACK);
            propertyTypeLabel.setForeground(Color.BLACK);
            propertyLocationLabel.setForeground(Color.BLACK);
            priceLabel.setForeground(Color.BLACK);
            propertyAreaLabel.setForeground(Color.BLACK);
            nearByLabel.setForeground(Color.BLACK);
            distanceRangeLabel.setForeground(Color.BLACK);
            communityLabel.setForeground(Color.BLACK);
            furnishingLabel.setForeground(Color.BLACK);
            insuranceLabel.setForeground(Color.BLACK);

            //checking for any fields that was left blank
            if (ownerFNameTextField.getText().isEmpty() || ownerFNameTextField.getText().trim().equals("") || ownerFNameTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the First Name !!", "Error: invalid First Name", JOptionPane.ERROR_MESSAGE);
                ownersFNameLabel.setForeground(Color.RED);
            } else if (ownerLNameTextField.getText().isEmpty() || ownerLNameTextField.getText().trim().equals("") || ownerLNameTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the Last Name !!", "Error: invalid Last Name", JOptionPane.ERROR_MESSAGE);
                ownersLNameLabel.setForeground(Color.RED);
            } else if (ownerContactTextField.getText().isEmpty() || ownerContactTextField.getText().trim().equals("") || ownerContactTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the Contact number !!", "Error: invalid Contact Number", JOptionPane.ERROR_MESSAGE);
                ownersContactLabel.setForeground(Color.RED);
            } else if (!searchAndSort.isCorrectNumber(ownerContactTextField.getText())) {
                JOptionPane.showMessageDialog(this, "Error : Please enter correct contact number format\n"
                        + "lan line: 01 - _._._._._._._ or \n"
                        + "mobile No: 977-_._._._._._._._._._!!", "Error: invalid Contact Number", JOptionPane.ERROR_MESSAGE);

                ownersContactLabel.setForeground(Color.RED);
            } else if (propertyTypeComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Error : Please Select the Property Type !!", "Error: invalid Property Type", JOptionPane.ERROR_MESSAGE);
                propertyTypeLabel.setForeground(Color.RED);
            } else if (locationComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Error : Please Select the Property Type !!", "Error: invalid Property Type", JOptionPane.ERROR_MESSAGE);
                propertyLocationLabel.setForeground(Color.RED);
            } else if (priceTextField.getText().isEmpty() || priceTextField.getText().trim().equals("") || priceTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the price !!", "Error: invalid price", JOptionPane.ERROR_MESSAGE);
                priceLabel.setForeground(Color.RED);
            } else if (areaTextField.getText().isEmpty() || areaTextField.getText().trim().equals("") || areaTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the Area of the property !!", "Error: Area not defined", JOptionPane.ERROR_MESSAGE);
                propertyAreaLabel.setForeground(Color.RED);
            } else if (!searchAndSort.isNumber(priceTextField.getText()) || priceTextField.getText().contains("-")) {
                JOptionPane.showMessageDialog(this, "Error : Please enter positive integer digit in price !!", "Error: invalid price input", JOptionPane.ERROR_MESSAGE);
                priceLabel.setForeground(Color.RED);
            } else if (!searchAndSort.isNumber(areaTextField.getText()) || areaTextField.getText().contains("-")) {
                JOptionPane.showMessageDialog(this, "Error : Please enter positive integer digit in Area field !!", "Error: invalid area value input", JOptionPane.ERROR_MESSAGE);
                propertyAreaLabel.setForeground(Color.RED);
            } else if (communityComboBox.getSelectedIndex() <= 0 || communityComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Error : Please community around the property !!", "Error: community not defined", JOptionPane.ERROR_MESSAGE);
            } else if (furnishingComboBox.getSelectedIndex() <= 0 || furnishingComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Error : Please furnishing around the property !!", "Error: furnishing not defined", JOptionPane.ERROR_MESSAGE);
            } //executes after checking every required information is filled 
            else {

                String propertyId = "SP-" + propertyCount;
                String ownersName = ownerFNameTextField.getText().trim() + " " + ownerLNameTextField.getText().trim();
                String contactNumber = ownerContactTextField.getText();
                String propertyType = propertyTypeComboBox.getSelectedItem().toString();
                String location = locationComboBox.getSelectedItem().toString();
                int price = Integer.parseInt(priceTextField.getText());

                int area = Integer.parseInt(areaTextField.getText());

                String community = communityComboBox.getSelectedItem().toString();
                String furnishing = furnishingComboBox.getSelectedItem().toString();
                String insurance = "";
                if (insuranceComboBox.getSelectedItem() != null) {
                    insurance = insuranceComboBox.getSelectedItem().toString();
                }

                propertyToBuy = new PropertyToBuy(propertyId, ownersName, contactNumber, propertyType, location, price, area, community, furnishing, insurance);

                if (nearByComboBox.getSelectedItem() != null) {
                    if (distanceRangeTextField.getText().equals("") || distanceRangeTextField.getText().isEmpty()) {
                        distanceRangeLabel.setForeground(Color.RED);
                        JOptionPane.showMessageDialog(this, "Error : Please enter the distance from the nearby area !!", "Error: Range not defined", JOptionPane.ERROR_MESSAGE);
                    } else if (!searchAndSort.isNumber(distanceRangeTextField.getText()) || distanceRangeTextField.getText().contains("-")) {
                        JOptionPane.showMessageDialog(this, "Error : Please enter integer digit in distance !!", "Error: invalid range input", JOptionPane.ERROR_MESSAGE);
                        priceLabel.setForeground(Color.RED);
                    }
                    String nearBy = nearByComboBox.getSelectedItem().toString();
                    propertyToBuy.setNearBy(nearBy);
                    propertyToBuy.setDistanceRange(Integer.parseInt(distanceRangeTextField.getText()));
                }

                if (properties.size() > 0) {
                    //executes if there is no object available with similar properties or the row is selected to update
                    if (!searchAndSort.isPropertyRedundant(propertyToBuy, 2) || isRowSelected) {

                        //when a row is selected to update
                        if (isRowSelected) {
                            //setting the id to its original id since it is required to update other attributes only
                            propertyToBuy.setId((viewRecentlyAddedTable.getValueAt(selectedRow, 0)).toString());
                        }

                        viewCardLayout.show(viewPanel, "propertyViewPanel");
                        //adds above attributes to the confirmation panel
                        setConfirmPanel(propertyToBuy);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: This Property already exists.\n please edit the property", "Error: Redundant Property!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    viewCardLayout.show(viewPanel, "propertyViewPanel");
                    setConfirmPanel(propertyToBuy);
                }

            }
        } else if (e.getSource() == confirmBtn) {
            //checks if the propertyId doesnot exist and any row on recentlyAddedTable is not selected and propertyToRent is initiallized
            if (!isViewSelected) {
                String id = propertyToBuy.getId();
                String ownersName = propertyToBuy.getOwnersName();
                String location = propertyToBuy.getLocation();
                String propertyType = propertyToBuy.getPropertyType();
                int price = propertyToBuy.getPrice();
                int area = propertyToBuy.getArea();

                Object[] obj = {id, ownersName, location, propertyType, price, area};

                //if a row needs to be updated
                if (isRowSelected) {
                    for (int i = 0; i < obj.length; i++) {
                        viewRecentlyAddedTable.setValueAt(obj[i], selectedRow, i);
                    }

                    int index = searchAndSort.getPropertyIndex(id, 2);
                    if (index != -1) {
                        PropertyToBuy property = updateProperty(properties.get(index));;
                        properties.set(index, propertyToBuy);
                    }

                } //else row needs to be added
                else {
                    recentlyTableModel.addRow(obj);

                    propertyCount++;

                    properties.add(propertyToBuy);
                }
            }

            selectedRow = -1;
            isRowSelected = false;
            isViewSelected = false;
            viewCardLayout.show(viewPanel, "recentlyAddedViewPanel");

        } else if (e.getSource()
                == viewDetailsBtn) {

            //get the selected row in the recently added table
            selectedRow = viewRecentlyAddedTable.getSelectedRow();
            //this prevents the ok button to add another object while clicking Ok in confirmation panel
            isViewSelected = true;

            //if any row is not selected
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select the row to View", "Error row not selected", JOptionPane.ERROR_MESSAGE);
            } else {
                String id = recentlyTableModel.getValueAt(selectedRow, 0).toString();
                propertyToBuy = (PropertyToBuy) searchAndSort.selectProperty(id);
                setConfirmPanel(propertyToBuy);
                viewCardLayout.show(viewPanel, "propertyViewPanel");

            }
        } else if (e.getSource() == editBtn) {

            selectedRow = viewRecentlyAddedTable.getSelectedRow();
            isRowSelected = true;

            if (selectedRow != -1) {

                PropertyToBuy editProperty = (PropertyToBuy) searchAndSort.selectProperty(recentlyTableModel.getValueAt(selectedRow, 0).toString());

                String[] name = editProperty.getOwnersName().split(" ");

                String fName = name[0];
                String lName = name[1];

                ownerFNameTextField.setText(fName);
                ownerLNameTextField.setText(lName);
                ownerContactTextField.setText(editProperty.getContact());
                locationComboBox.setSelectedItem(editProperty.getLocation());
                propertyTypeComboBox.setSelectedItem(editProperty.getPropertyType());
                priceTextField.setText(editProperty.getPrice() + "");
                areaTextField.setText(editProperty.getArea() + "");

                nearByComboBox.setSelectedItem(editProperty.getNearBy());
                distanceRangeTextField.setText(editProperty.getDistanceRange() + "");

                communityComboBox.setSelectedItem(editProperty.getCommunity());
                furnishingComboBox.setSelectedItem(editProperty.getFurnishing());
                insuranceComboBox.setSelectedItem(editProperty.getInsurance());

            } else {
                JOptionPane.showMessageDialog(this, "Please select the row to edit!!", "Error row not selected", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == deleteBtn) {

            selectedRow = viewRecentlyAddedTable.getSelectedRow();
            if (selectedRow != -1) {
                int delValue = JOptionPane.showConfirmDialog(this, "Do you really want to delete this property", "Confirm Property Delete", JOptionPane.YES_NO_OPTION);
                Property deleteProperty = (PropertyToBuy) searchAndSort.selectProperty(recentlyTableModel.getValueAt(selectedRow, 0).toString());
                if (delValue == JOptionPane.YES_OPTION && deleteProperty instanceof PropertyToBuy) {

                    isRowSelected = false;
                    for (int i = 0; i < properties.size(); i++) {
                        if (properties.get(i).getId().equals(deleteProperty.getId())) {
                            properties.remove(i);
                            recentlyTableModel.removeRow(selectedRow);
                        }
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select the row to Delete!!", "Error row not selected", JOptionPane.ERROR_MESSAGE);

            }
        } else if (e.getSource()
                == clearBtn) {
            ownerFNameTextField.setText("");
            ownerLNameTextField.setText("");
            ownerContactTextField.setText("");
            areaTextField.setText("");
            priceTextField.setText("");
            distanceRangeTextField.setText("");

            locationComboBox.setSelectedItem(null);
            propertyTypeComboBox.setSelectedItem(null);
            nearByComboBox.setSelectedItem(null);
            communityComboBox.setSelectedItem(null);
            furnishingComboBox.setSelectedItem(null);
            insuranceComboBox.setSelectedItem(null);

            propertyToBuy = null;
        } else if (e.getSource() == cancelBtn) {
            if (isViewSelected || isRowSelected) {
                isViewSelected = false;
                isRowSelected = false;

                viewCardLayout.show(viewPanel, "recentlyAddedViewPanel");
            } else {
                viewCardLayout.show(viewPanel, "logoViewPanel");
            }

        }

    }

    public PropertyToBuy updateProperty(Property buyProperty) {
        PropertyToBuy property = null;
        //if the object rentProperty belongs to PropertyToRent class
        if (buyProperty instanceof PropertyToBuy) {
            property = (PropertyToBuy) buyProperty;
            property.setId(propertyToBuy.getId());
            property.setOwnersName(propertyToBuy.getOwnersName());
            property.setLocation(propertyToBuy.getLocation());
            property.setContact(propertyToBuy.getContact());
            property.setPropertyType(propertyToBuy.getPropertyType());
            property.setPrice(propertyToBuy.getPrice());
            property.setArea(propertyToBuy.getArea());
            property.setNearBy(propertyToBuy.getNearBy());
            property.setDistanceRange(propertyToBuy.getDistanceRange());
            property.setCommunity(propertyToBuy.getCommunity());
            property.setFurnishing(propertyToBuy.getFurnishing());
            property.setInsurance(propertyToBuy.getInsurance());

        }
        return property;

    }

    public void setConfirmPanel(PropertyToBuy property) {
        PropertyToBuy propertyDetails = property;

        model.setValueAt(propertyDetails.getOwnersName(), 0, 1);
        model.setValueAt(propertyDetails.getContact(), 1, 1);
        model.setValueAt(propertyDetails.getLocation(), 2, 1);
        model.setValueAt(propertyDetails.getPrice(), 3, 1);
        model.setValueAt(propertyDetails.getArea(), 4, 1);
        model.setValueAt(propertyDetails.getCommunity(), 5, 1);

        if (propertyDetails.getPropertyType().equals("Land")) {
            imageLabel.setIcon(img1);
        } else if (propertyDetails.getPropertyType().equals("Building")) {
            imageLabel.setIcon(img2);
        } else if (propertyDetails.getPropertyType().equals("Appartment")) {
            imageLabel.setIcon(img3);
        }

        if (!property.getNearBy().equals("") && property.getDistanceRange() > 0) {
            viewNearbyValueLabel.setText(property.getNearBy());
            viewDistanceValueLabel.setText(property.getDistanceRange() + "");
        }

        String furnishing[] = property.getFurnishing().split(" ");

        viewFurnishingValueLabel.setText(furnishing[0]);
        viewInsuranceValueLabel.setText(property.getInsurance());
    }
}
