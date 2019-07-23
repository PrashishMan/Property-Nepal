/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import PropertyNepal.Property;
import PropertyNepal.PropertyToRent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author prashish
 */
public class LoanPanel extends JPanel implements ActionListener {

    private JPanel ownersDetailsPanel, ownersDetailsLeftPanel, ownersDetailsRightPanel, propertyDetailsPanel, propertyDetailsLeftPanel, propertyDetailsRightPanel, paymentDetailsPanel, paymentDetailsSelectionPanel, servicePanel, serviceCheckBoxPanel, viewPanel, logoViewPanel, propertyViewPanel, innerPropertyViewPanel, viewPropertyDetailsPanel, viewDetailsPanel, viewServicesPanel, recentlyAddedViewPanel, recentlyAddedTablePanel;

    private JLabel ownersFNameLabel, ownersLNameLabel, contactNumberLabel, locationLabel, ownersDetailsLabel, propertyDetailsLabel,
            propertyTypeLabel, noOfRoomsLabel, serviceLabel, paymentRequiredLabel, amountLabel, propertyNepalLabel, imageLabel, viewOwnersNameLabel, viewContactNumberLabel, viewLocationLabel, viewNoOfRoomsLabel, viewPriceLabel, viewPaymentRequiredLabel, viewServicesLabel, flagImageLabel, propertyNepalLogoLabel,
            recentlyAddedLabel;

    private JTextField ownersFNameTextField, ownersLNameTextField, contactNumberTextField, noOfRoomsTextField, amountTextField;

    private JComboBox locationComboBox, propertyTypeComboBox;

    private ButtonGroup paymentRequiredGroup;

    private JCheckBox securityGuardCheckBox, hotWaterCheckBox, internetAccessCheckBox, parkingSpaceCheckBox, electricityBackupCheckBox, viewSecurityGuardCheckBox, viewParkingSpaceCheckBox,
            viewInternetAccessCheckBox, viewElectricityBackupCheckBox, viewHotWaterCheckBox;

    private JRadioButton weeklyPaymentRadioButton, monthlyPaymentRadioButton, annualPaymentRadioButton;

    private Color itemsPanelColor, itemSelectionPanelColor, panelHeadingColor;

    Font headingLabelFont;

    private ArrayList<String> locations;

    private PropertyToRent propertyToRent;

    private JButton doneBtn, clearBtn, confirmBtn, viewDetailsBtn, editBtn, deleteBtn, cancelBtn;

    private JScrollPane viewPropertyDetailSp, viewRecentlyAddedSp;

    private JTable viewPropertyDetailTable, viewRecentlyAddedTable;

    private DefaultTableModel model, recentlyTableModel;

    private ImageIcon img1, img2, img3, flagImg;

    private CardLayout viewCardLayout;

    private ArrayList<Property> totalPropertyToRent;

    private int propertyCount, selectedRow;

    private boolean isRowSelected, isViewSelected;

    private SearchAndSort searchAndSort;

    public LoanPanel(int WIDTH, ArrayList<Property> properties) {

        setLayout(null);
        setBackground(new Color(214, 238, 128));

        itemsPanelColor = new Color(64, 64, 64);
        itemSelectionPanelColor = new Color(255, 255, 255);
        panelHeadingColor = new Color(160, 160, 160);

        headingLabelFont = new Font("Arial", Font.BOLD, 14);

        viewCardLayout = new CardLayout();

        ownersDetailsPanel = new JPanel();
        ownersDetailsLeftPanel = new JPanel();
        ownersDetailsRightPanel = new JPanel();

        propertyDetailsPanel = new JPanel();
        propertyDetailsLeftPanel = new JPanel();
        propertyDetailsRightPanel = new JPanel();

        paymentDetailsPanel = new JPanel();
        paymentDetailsSelectionPanel = new JPanel();

        servicePanel = new JPanel();
        serviceCheckBoxPanel = new JPanel();

        viewPanel = new JPanel(viewCardLayout);

        logoViewPanel = new JPanel();
        propertyViewPanel = new JPanel();
        innerPropertyViewPanel = new JPanel();

        viewPropertyDetailsPanel = new JPanel();
        viewServicesPanel = new JPanel();
        viewDetailsPanel = new JPanel();

        recentlyAddedViewPanel = new JPanel();
        recentlyAddedTablePanel = new JPanel();

        ownersDetailsLabel = new JLabel("Oweners Details");

        ownersFNameLabel = new JLabel("First Name: ");
        ownersLNameLabel = new JLabel("Last Name: ");
        contactNumberLabel = new JLabel("Contact no: ");

        propertyDetailsLabel = new JLabel("Property Details");
        propertyTypeLabel = new JLabel("Property Type: ");
        locationLabel = new JLabel("Property Location: ");
        noOfRoomsLabel = new JLabel("No of Rooms: ");

        paymentRequiredLabel = new JLabel("Payment Required");
        amountLabel = new JLabel("Price: ");

        serviceLabel = new JLabel("Services");

        viewOwnersNameLabel = new JLabel("Owners Name: ");
        viewContactNumberLabel = new JLabel("Number: ");
        viewLocationLabel = new JLabel("Location: ");
        viewNoOfRoomsLabel = new JLabel("No Of Rooms: ");
        viewPriceLabel = new JLabel("Price: ");
        viewPaymentRequiredLabel = new JLabel("Payment Required: ");
        propertyNepalLabel = new JLabel("Property Nepal");
        imageLabel = new JLabel();
        viewServicesLabel = new JLabel("Services: ");

        recentlyAddedLabel = new JLabel("Recently Added");

        flagImageLabel = new JLabel();

        propertyNepalLogoLabel = new JLabel("Property Nepal");
        propertyNepalLogoLabel.setFont(new Font("Arial", Font.BOLD, 24));

        ownersFNameTextField = new JTextField();
        ownersLNameTextField = new JTextField();
        contactNumberTextField = new JTextField();
        noOfRoomsTextField = new JTextField();
        amountTextField = new JTextField();

        locationComboBox = new JComboBox();
        propertyTypeComboBox = new JComboBox();

        weeklyPaymentRadioButton = new JRadioButton("Weekly");
        monthlyPaymentRadioButton = new JRadioButton("Monthly");
        annualPaymentRadioButton = new JRadioButton("Annually");

        paymentRequiredGroup = new ButtonGroup();

        securityGuardCheckBox = new JCheckBox("Security Guards");
        internetAccessCheckBox = new JCheckBox("Internet Access");
        hotWaterCheckBox = new JCheckBox("Hot Water");
        parkingSpaceCheckBox = new JCheckBox("Parking Space");
        electricityBackupCheckBox = new JCheckBox("Electricity Backup");

        viewSecurityGuardCheckBox = new JCheckBox("Security Guards");
        viewInternetAccessCheckBox = new JCheckBox("Internet Access");
        viewHotWaterCheckBox = new JCheckBox("Hot Water");
        viewParkingSpaceCheckBox = new JCheckBox("Parking Space");
        viewElectricityBackupCheckBox = new JCheckBox("Electricity Backup");

        doneBtn = new JButton("Done");
        clearBtn = new JButton("Clear");

        confirmBtn = new JButton("Ok");
        cancelBtn = new JButton("Cancel");

        editBtn = new JButton("Edit");
        deleteBtn = new JButton("Delete");

        viewDetailsBtn = new JButton("Details");

        model = new DefaultTableModel(new Object[][]{{"Owner: ", ""}, {"Contact: ", ""}, {"Location: ", ""}, {"Price(M) : ", ""},
        {"Rooms:", ""}, {"Duration:", ""}}, new String[]{"Attributes", "Value"});
        viewPropertyDetailTable = new JTable(model);
        TableColumnModel columnModel = viewPropertyDetailTable.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(20);
        viewPropertyDetailTable.setRowHeight(20);

        viewPropertyDetailSp = new JScrollPane(viewPropertyDetailTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        recentlyTableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name", "Location", "Type", "Price(M) ", "Terms"});
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

        paymentRequiredGroup.add(weeklyPaymentRadioButton);
        paymentRequiredGroup.add(monthlyPaymentRadioButton);
        paymentRequiredGroup.add(annualPaymentRadioButton);

        propertyTypeComboBox.addItem(null);
        propertyTypeComboBox.addItem("Room");
        propertyTypeComboBox.addItem("Building");
        propertyTypeComboBox.addItem("Appartment");

        ownersDetailsLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 14, 10));
        ownersDetailsLeftPanel.add(ownersFNameLabel);
        ownersDetailsLeftPanel.add(ownersLNameLabel);
        ownersDetailsLeftPanel.add(contactNumberLabel);

        ownersDetailsRightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 6));
        ownersDetailsRightPanel.add(ownersFNameTextField);
        ownersDetailsRightPanel.add(ownersLNameTextField);
        ownersDetailsRightPanel.add(contactNumberTextField);

        ownersDetailsPanel.setLayout(null);
        ownersDetailsPanel.add(ownersDetailsLabel);
        ownersDetailsPanel.add(ownersDetailsLeftPanel);
        ownersDetailsPanel.add(ownersDetailsRightPanel);

        propertyDetailsPanel.setLayout(null);
        propertyDetailsPanel.add(propertyDetailsLabel);
        propertyDetailsPanel.add(propertyDetailsLeftPanel);
        propertyDetailsPanel.add(propertyDetailsRightPanel);

        propertyDetailsLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 14, 10));
        propertyDetailsLeftPanel.add(propertyTypeLabel);
        propertyDetailsLeftPanel.add(locationLabel);
        propertyDetailsLeftPanel.add(amountLabel);
        propertyDetailsLeftPanel.add(noOfRoomsLabel);

        propertyDetailsRightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 6));
        propertyDetailsRightPanel.add(propertyTypeComboBox);
        propertyDetailsRightPanel.add(locationComboBox);
        propertyDetailsRightPanel.add(amountTextField);
        propertyDetailsRightPanel.add(noOfRoomsTextField);

        paymentDetailsPanel.setLayout(null);
        paymentDetailsPanel.add(paymentRequiredLabel);
        paymentDetailsPanel.add(paymentDetailsSelectionPanel);

        paymentDetailsSelectionPanel.setLayout(null);
        paymentDetailsSelectionPanel.add(weeklyPaymentRadioButton);
        paymentDetailsSelectionPanel.add(monthlyPaymentRadioButton);
        paymentDetailsSelectionPanel.add(annualPaymentRadioButton);

        servicePanel.setLayout(null);
        servicePanel.add(serviceLabel);
        servicePanel.add(serviceCheckBoxPanel);

        serviceCheckBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 4));
        serviceCheckBoxPanel.add(securityGuardCheckBox);
        serviceCheckBoxPanel.add(parkingSpaceCheckBox);
        serviceCheckBoxPanel.add(internetAccessCheckBox);
        serviceCheckBoxPanel.add(electricityBackupCheckBox);
        serviceCheckBoxPanel.add(hotWaterCheckBox);

        //adding multiple panel in the cardlayout of the view panel
        viewPanel.add(logoViewPanel, "logoViewPanel");
        viewPanel.add(propertyViewPanel, "propertyViewPanel");
        viewPanel.add(recentlyAddedViewPanel, "recentlyAddedViewPanel");

        //add logo of the property along with the property Nepal label to logo view panel
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

        innerPropertyViewPanel.add(viewServicesLabel);
        innerPropertyViewPanel.add(viewServicesPanel);

        viewPropertyDetailsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        viewPropertyDetailsPanel.add(imageLabel);
        viewPropertyDetailsPanel.add(viewDetailsPanel);

        viewDetailsPanel.setLayout(null);
        viewDetailsPanel.add(viewPropertyDetailSp);

        recentlyAddedViewPanel.setLayout(null);
        recentlyAddedViewPanel.add(recentlyAddedLabel);
        recentlyAddedViewPanel.add(recentlyAddedTablePanel);

        recentlyAddedTablePanel.setLayout(null);
        recentlyAddedTablePanel.add(viewRecentlyAddedSp);
        recentlyAddedTablePanel.add(viewDetailsBtn);
        recentlyAddedTablePanel.add(editBtn);
        recentlyAddedTablePanel.add(deleteBtn);

        viewServicesPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
        viewServicesPanel.add(viewSecurityGuardCheckBox);
        viewServicesPanel.add(viewParkingSpaceCheckBox);
        viewServicesPanel.add(viewInternetAccessCheckBox);
        viewServicesPanel.add(viewElectricityBackupCheckBox);
        viewServicesPanel.add(viewHotWaterCheckBox);

        viewSecurityGuardCheckBox.setEnabled(false);
        viewParkingSpaceCheckBox.setEnabled(false);
        viewInternetAccessCheckBox.setEnabled(false);
        viewElectricityBackupCheckBox.setEnabled(false);
        viewHotWaterCheckBox.setEnabled(false);

        ownersDetailsPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        propertyDetailsPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        servicePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        paymentDetailsPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        propertyViewPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        viewServicesPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        logoViewPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        recentlyAddedViewPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        ownersFNameTextField.setPreferredSize(new Dimension(190, 20));
        ownersLNameTextField.setPreferredSize(new Dimension(190, 20));
        contactNumberTextField.setPreferredSize(new Dimension(190, 20));

        propertyTypeComboBox.setPreferredSize(new Dimension(200, 20));
        locationComboBox.setPreferredSize(new Dimension(200, 20));
        amountTextField.setPreferredSize(new Dimension(200, 20));
        noOfRoomsTextField.setPreferredSize(new Dimension(80, 20));

        imageLabel.setPreferredSize(new Dimension(200, 140));
        viewDetailsPanel.setPreferredSize(new Dimension(195, 160));

        viewOwnersNameLabel.setPreferredSize(new Dimension(200, 20));
        viewContactNumberLabel.setPreferredSize(new Dimension(200, 20));
        viewLocationLabel.setPreferredSize(new Dimension(200, 20));
        viewPriceLabel.setPreferredSize(new Dimension(200, 20));
        viewNoOfRoomsLabel.setPreferredSize(new Dimension(200, 20));
        viewPaymentRequiredLabel.setPreferredSize(new Dimension(200, 20));

        ownersDetailsPanel.setBounds(10, 10, 380, 120);
        ownersDetailsLabel.setBounds(5, 5, 330, 20);
        ownersDetailsLeftPanel.setBounds(5, 30, 150, 85);
        ownersDetailsRightPanel.setBounds(155, 30, 220, 85);

        contactNumberLabel.setBounds(10, 55, 120, 20);
        contactNumberTextField.setBounds(130, 55, 220, 20);

        propertyDetailsPanel.setBounds(10, 140, 380, 150);
        propertyDetailsLabel.setBounds(5, 5, 370, 20);
        propertyDetailsLeftPanel.setBounds(5, 30, 150, 115);
        propertyDetailsRightPanel.setBounds(155, 30, 220, 115);

        servicePanel.setBounds(10, 300, 380, 120);
        serviceLabel.setBounds(5, 5, 370, 20);
        serviceCheckBoxPanel.setBounds(5, 30, 370, 85);

        paymentDetailsPanel.setBounds(400, 340, 410, 80);
        paymentRequiredLabel.setBounds(5, 5, 400, 20);
        paymentDetailsSelectionPanel.setBounds(5, 30, 400, 45);

        weeklyPaymentRadioButton.setBounds(10, 10, 100, 20);
        monthlyPaymentRadioButton.setBounds(140, 10, 100, 20);
        annualPaymentRadioButton.setBounds(270, 10, 100, 20);

        recentlyAddedLabel.setBounds(5, 5, 400, 20);
        recentlyAddedTablePanel.setBounds(5, 30, 400, 285);
        viewRecentlyAddedSp.setBounds(0, 0, 400, 250);

        viewPanel.setBounds(400, 10, 410, 320);
        flagImageLabel.setBounds(60, 20, 290, 260);
        propertyNepalLogoLabel.setBounds(120, 180, 200, 200);

        propertyNepalLabel.setBounds(10, 5, 400, 25);
        innerPropertyViewPanel.setBounds(5, 30, 400, 285);
        viewPropertyDetailsPanel.setBounds(2, 5, 395, 160);
        viewServicesLabel.setBounds(10, 165, 100, 20);
        viewServicesPanel.setBounds(5, 185, 390, 60);

        confirmBtn.setBounds(236, 250, 130, 30);
        cancelBtn.setBounds(40, 250, 130, 30);

        editBtn.setBounds(5, 255, 130, 30);
        deleteBtn.setBounds(134, 255, 130, 30);
        viewDetailsBtn.setBounds(270, 255, 120, 20);

        viewPropertyDetailSp.setBounds(0, 10, 185, 140);

        doneBtn.setBounds(260, 430, 140, 40);
        clearBtn.setBounds(420, 430, 140, 40);

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

        flagImageLabel.setIcon(flagImg);
        flagImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ownersDetailsPanel.setBackground(itemsPanelColor);
        ownersDetailsLeftPanel.setBackground(itemSelectionPanelColor);
        ownersDetailsRightPanel.setBackground(new Color(224, 224, 224));

        propertyDetailsPanel.setBackground(itemsPanelColor);
        propertyDetailsLeftPanel.setBackground(itemSelectionPanelColor);
        propertyDetailsRightPanel.setBackground(new Color(224, 224, 224));

        paymentDetailsPanel.setBackground(itemsPanelColor);
        paymentDetailsSelectionPanel.setBackground(itemSelectionPanelColor);

        servicePanel.setBackground(itemsPanelColor);
        serviceCheckBoxPanel.setBackground(itemSelectionPanelColor);

        propertyViewPanel.setBackground(itemsPanelColor);
        innerPropertyViewPanel.setBackground(itemSelectionPanelColor);
        viewDetailsPanel.setBackground(Color.GRAY);
        viewPropertyDetailsPanel.setBackground(Color.GRAY);
        viewServicesPanel.setBackground(Color.DARK_GRAY);

        viewPanel.setBackground(Color.DARK_GRAY);
        logoViewPanel.setBackground(Color.GRAY);
        recentlyAddedTablePanel.setBackground(Color.WHITE);
        recentlyAddedViewPanel.setBackground(Color.DARK_GRAY);

        ownersDetailsLabel.setForeground(panelHeadingColor);
        propertyDetailsLabel.setForeground(panelHeadingColor);
        paymentRequiredLabel.setForeground(panelHeadingColor);
        serviceLabel.setForeground(panelHeadingColor);
        propertyNepalLabel.setForeground(panelHeadingColor);
        recentlyAddedLabel.setForeground(panelHeadingColor);
        propertyNepalLogoLabel.setForeground(Color.ORANGE);

        ownersDetailsLabel.setFont(headingLabelFont);
        propertyDetailsLabel.setFont(headingLabelFont);
        paymentRequiredLabel.setFont(headingLabelFont);
        serviceLabel.setFont(headingLabelFont);
        propertyNepalLabel.setFont(headingLabelFont);
        recentlyAddedLabel.setFont(headingLabelFont);

        Locations location = new Locations();
        locations = location.getLocations();

        for (int i = 0; i < locations.size(); i++) {
            locationComboBox.addItem(locations.get(i));
        }

        doneBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        confirmBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        editBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        viewDetailsBtn.addActionListener(this);

        add(ownersDetailsPanel);
        add(propertyDetailsPanel);
        add(paymentDetailsPanel);
        add(servicePanel);
        add(viewPanel);
        add(doneBtn);
        add(clearBtn);

        selectedRow = -1;

        isRowSelected = false;
        isViewSelected = false;

        totalPropertyToRent = properties;
        propertyCount = totalPropertyToRent.size() + 120;
        searchAndSort = new SearchAndSort(this, totalPropertyToRent);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == doneBtn) {

            //setting every textfield blak incase while showing error the text is displayed red
            ownersFNameLabel.setForeground(Color.BLACK);
            ownersLNameLabel.setForeground(Color.BLACK);
            contactNumberLabel.setForeground(Color.BLACK);
            propertyTypeLabel.setForeground(Color.BLACK);
            locationLabel.setForeground(Color.BLACK);
            noOfRoomsLabel.setForeground(Color.BLACK);
            amountLabel.setForeground(Color.BLACK);

            //checking for any fields that was left blank
            if (ownersFNameTextField.getText().isEmpty() || ownersFNameTextField.getText().trim().equals("") || ownersFNameTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the First Name !!", "Error: invalid First Name", JOptionPane.ERROR_MESSAGE);
                ownersFNameLabel.setForeground(Color.RED);
            } else if (ownersLNameTextField.getText().isEmpty() || ownersLNameTextField.getText().trim().equals("") || ownersLNameTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the Last Name !!", "Error: invalid Last Name", JOptionPane.ERROR_MESSAGE);
                ownersLNameLabel.setForeground(Color.RED);
            } else if (contactNumberTextField.getText().isEmpty() || contactNumberTextField.getText().trim().equals("") || ownersLNameTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the Contact number !!", "Error: invalid Contact Number", JOptionPane.ERROR_MESSAGE);
                contactNumberLabel.setForeground(Color.RED);
            } else if (!searchAndSort.isCorrectNumber(contactNumberTextField.getText())) {
                JOptionPane.showMessageDialog(this, "Error : Please enter correct contact number format\n"
                        + "lan line: 01 - _._._._._._._ or \n"
                        + "mobile No: 977-_._._._._._._._._._!!", "Error: invalid Contact Number", JOptionPane.ERROR_MESSAGE);

                contactNumberLabel.setForeground(Color.RED);
            } else if (propertyTypeComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Error : Please Select the Property Type !!", "Error: invalid Property Type", JOptionPane.ERROR_MESSAGE);
                propertyTypeLabel.setForeground(Color.RED);
            } else if (locationComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Error : Please Select the Property Type !!", "Error: invalid Property Type", JOptionPane.ERROR_MESSAGE);
                locationLabel.setForeground(Color.RED);
            } else if (amountTextField.getText().isEmpty() || amountTextField.getText().trim().equals("") || amountTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the price !!", "Error: invalid price", JOptionPane.ERROR_MESSAGE);
                amountLabel.setForeground(Color.RED);
            } else if (!searchAndSort.isNumber(amountTextField.getText()) || amountTextField.getText().contains("-")) {
                JOptionPane.showMessageDialog(this, "Error : Please enter positive integer digit in price !!", "Error: invalid price input", JOptionPane.ERROR_MESSAGE);
                amountLabel.setForeground(Color.RED);
            } else if (noOfRoomsTextField.getText().isEmpty() || noOfRoomsTextField.getText().trim().equals("") || noOfRoomsTextField == null) {
                JOptionPane.showMessageDialog(this, "Error : Please enter the no of rooms required !!", "Error: Rooms not defined", JOptionPane.ERROR_MESSAGE);
                noOfRoomsLabel.setForeground(Color.RED);
            } else if (!searchAndSort.isNumber(noOfRoomsTextField.getText()) || noOfRoomsTextField.getText().contains("-")) {
                JOptionPane.showMessageDialog(this, "Error : Please enter positive integer digit in rooms number !!", "Error: invalid room number input", JOptionPane.ERROR_MESSAGE);
                noOfRoomsLabel.setForeground(Color.RED);
            } else if (!weeklyPaymentRadioButton.isSelected() && !monthlyPaymentRadioButton.isSelected() && !annualPaymentRadioButton.isSelected()) {
                JOptionPane.showMessageDialog(this, "Error : Please select the terms for payment !!", "Error: payment terms not selected", JOptionPane.ERROR_MESSAGE);
            } //executes after checking every required information is filled 
            else {

                String paymentTerms = null;

                //setting the code of the property
                String propertyId = "BP-" + propertyCount;
                String ownersName = ownersFNameTextField.getText().trim() + " " + ownersLNameTextField.getText().trim();
                String contactNumber = contactNumberTextField.getText();
                String propertyType = propertyTypeComboBox.getSelectedItem().toString();
                String location = locationComboBox.getSelectedItem().toString();
                int price = Integer.parseInt(amountTextField.getText());
                //stores the price on the monthly basis
                int monthlyPrice = 0;
                int roomsNumber = Integer.parseInt(noOfRoomsTextField.getText());

                if (weeklyPaymentRadioButton.isSelected()) {
                    paymentTerms = weeklyPaymentRadioButton.getText();
                    //converting weekly price on the monthly basis
                    //formula: get price per day and multiply by no of days in month
                    //due to integer rounding off not accurate
                    monthlyPrice = (price / 7) * 30;
                } else if (monthlyPaymentRadioButton.isSelected()) {
                    paymentTerms = monthlyPaymentRadioButton.getText();
                    monthlyPrice = price;
                } else if (annualPaymentRadioButton.isSelected()) {
                    paymentTerms = annualPaymentRadioButton.getText();
                    monthlyPrice = price / 12;
                }

                propertyToRent = new PropertyToRent(propertyId, ownersName, contactNumber, propertyType, location, monthlyPrice, roomsNumber, paymentTerms);

                if (securityGuardCheckBox.isSelected()) {
                    propertyToRent.setSecuritySelected(true);
                }

                if (parkingSpaceCheckBox.isSelected()) {
                    propertyToRent.setParkingSelected(true);
                }

                if (internetAccessCheckBox.isSelected()) {
                    propertyToRent.setInternetAccessSelected(true);
                }

                if (electricityBackupCheckBox.isSelected()) {
                    propertyToRent.setElectricityBackupSelected(true);
                }

                if (hotWaterCheckBox.isSelected()) {
                    propertyToRent.setHotWaterSelected(true);
                }

                //executes if there is no object available with similar properties or the row is selected to update
                if (totalPropertyToRent.size() > 0) {
                    if (!searchAndSort.isPropertyRedundant(propertyToRent, 1) || isRowSelected) {

                        //when a row is selected to update
                        if (isRowSelected) {
                            //setting the id to its original id since it is required to update other attributes only
                            propertyToRent.setId((viewRecentlyAddedTable.getValueAt(selectedRow, 0)).toString());
                        }

                        //change the panel to view the property in the table
                        viewCardLayout.show(viewPanel, "propertyViewPanel");
                        //adds above attributes to the confirmation panel
                        setConfirmPanel(propertyToRent);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: This Property already exists.\n please edit the property", "Error: Redundant Property!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    viewCardLayout.show(viewPanel, "propertyViewPanel");
                    setConfirmPanel(propertyToRent);
                }

            }

        } else if (e.getSource() == confirmBtn) {
            //checks if any row on recentlyAddedTable is not selected
            if (!isViewSelected) {

                //retrives all the data to be displayed in the confirmation table
                String id = propertyToRent.getId();
                String ownersName = propertyToRent.getOwnersName();
                String location = propertyToRent.getLocation();
                String propertyType = propertyToRent.getPropertyType();
                int price = propertyToRent.getPrice();
                String terms = propertyToRent.getPaymentTerms();

                Object[] obj = {id, ownersName, location, propertyType, price, terms};

                //if a row needs to be updated
                if (isRowSelected) {
                    for (int i = 0; i < obj.length; i++) {

                        //sets the value in the table for display
                        //@param1: object value to be displayed
                        //@param2: row of the table to be updated
                        //@param3: column of the table to be updated
                        viewRecentlyAddedTable.setValueAt(obj[i], selectedRow, i);
                    }

                    int index = searchAndSort.getPropertyIndex(id, 1);
                    if (index != -1) {
                        PropertyToRent property = updateProperty(totalPropertyToRent.get(index));;

                        totalPropertyToRent.set(index, propertyToRent);
                    }

                } //else row needs to be added
                else {
                    recentlyTableModel.addRow(obj);
                    propertyCount++;

                    totalPropertyToRent.add(propertyToRent);
                }
            }

            selectedRow = -1;
            isRowSelected = false;
            isViewSelected = false;
            viewCardLayout.show(viewPanel, "recentlyAddedViewPanel");

        } else if (e.getSource() == viewDetailsBtn) {

            selectedRow = viewRecentlyAddedTable.getSelectedRow();
            isViewSelected = true;

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select the row to View", "Error row not selected", JOptionPane.ERROR_MESSAGE);
            } else {
                String id = recentlyTableModel.getValueAt(selectedRow, 0).toString();
                propertyToRent = (PropertyToRent) searchAndSort.selectProperty(id);
                setConfirmPanel(propertyToRent);
                viewCardLayout.show(viewPanel, "propertyViewPanel");

            }
        } else if (e.getSource() == editBtn) {

            selectedRow = viewRecentlyAddedTable.getSelectedRow();
            isRowSelected = true;

            if (selectedRow != -1) {

                PropertyToRent editProperty = (PropertyToRent) searchAndSort.selectProperty(recentlyTableModel.getValueAt(selectedRow, 0).toString());

                String[] name = editProperty.getOwnersName().split(" ");

                String fName = name[0];
                String lName = name[1];

                ownersFNameTextField.setText(fName);
                ownersLNameTextField.setText(lName);
                contactNumberTextField.setText(editProperty.getContact());
                noOfRoomsTextField.setText(editProperty.getRoomsNo() + "");

                locationComboBox.setSelectedItem(editProperty.getLocation());
                propertyTypeComboBox.setSelectedItem(editProperty.getPropertyType());

                if (editProperty.isSecuritySelected()) {
                    securityGuardCheckBox.setSelected(true);
                } else {
                    securityGuardCheckBox.setSelected(false);
                }

                if (editProperty.isParkingSelected()) {
                    parkingSpaceCheckBox.setSelected(true);
                } else {
                    parkingSpaceCheckBox.setSelected(false);
                }

                if (editProperty.isInternetAccessSelected()) {
                    internetAccessCheckBox.setSelected(true);
                } else {
                    internetAccessCheckBox.setSelected(false);
                }

                if (editProperty.isElectricityBackupSelected()) {
                    electricityBackupCheckBox.setSelected(true);
                } else {
                    electricityBackupCheckBox.setSelected(false);
                }

                if (editProperty.isHotWaterSelected()) {
                    hotWaterCheckBox.setSelected(true);
                } else {
                    hotWaterCheckBox.setSelected(false);
                }

                int price = editProperty.getPrice();

                if (editProperty.getPaymentTerms().equals(weeklyPaymentRadioButton.getText())) {
                    weeklyPaymentRadioButton.setSelected(true);
                    price = (price / 30) * 7;
                } else if (editProperty.getPaymentTerms().equals(monthlyPaymentRadioButton.getText())) {
                    monthlyPaymentRadioButton.setSelected(true);

                } else if (editProperty.getPaymentTerms().equals(annualPaymentRadioButton.getText())) {
                    annualPaymentRadioButton.setSelected(true);
                    price = price * 12;
                }
                amountTextField.setText(price + "");
            } else {
                JOptionPane.showMessageDialog(this, "Please select the row to edit!!", "Error row not selected", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == deleteBtn) {

            selectedRow = viewRecentlyAddedTable.getSelectedRow();
            if (selectedRow != -1) {
                int delValue = JOptionPane.showConfirmDialog(this, "Do you really want to delete this property", "Confirm Property Delete", JOptionPane.YES_NO_OPTION);
                Property deleteProperty = (PropertyToRent) searchAndSort.selectProperty(recentlyTableModel.getValueAt(selectedRow, 0).toString());
                if (delValue == JOptionPane.YES_OPTION && deleteProperty instanceof PropertyToRent) {

                    isRowSelected = false;
                    for (int i = 0; i < totalPropertyToRent.size(); i++) {
                        if (totalPropertyToRent.get(i).getId().equals(deleteProperty.getId())) {
                            totalPropertyToRent.remove(i);
                            recentlyTableModel.removeRow(selectedRow);
                        }
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select the row to Delete!!", "Error row not selected", JOptionPane.ERROR_MESSAGE);

            }
        } else if (e.getSource() == clearBtn) {
            ownersFNameTextField.setText("");
            ownersLNameTextField.setText("");
            contactNumberTextField.setText("");
            noOfRoomsTextField.setText("");
            amountTextField.setText("");

            locationComboBox.setSelectedItem(null);
            propertyTypeComboBox.setSelectedItem(null);

            securityGuardCheckBox.setSelected(false);
            internetAccessCheckBox.setSelected(false);
            electricityBackupCheckBox.setSelected(false);
            hotWaterCheckBox.setSelected(false);
            parkingSpaceCheckBox.setSelected(false);

            weeklyPaymentRadioButton.setSelected(false);
            annualPaymentRadioButton.setSelected(false);
            monthlyPaymentRadioButton.setSelected(false);

            propertyToRent = null;
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

    public PropertyToRent updateProperty(Property rentProperty) {
        PropertyToRent property = null;
        //if the object rentProperty belongs to PropertyToRent class
        if (rentProperty instanceof PropertyToRent) {
            property = (PropertyToRent) rentProperty;
            property.setId(propertyToRent.getId());
            property.setOwnersName(propertyToRent.getOwnersName());
            property.setLocation(propertyToRent.getLocation());
            property.setContact(propertyToRent.getContact());
            property.setPropertyType(propertyToRent.getPropertyType());
            property.setPrice(propertyToRent.getPrice());
            property.setRoomsNo(propertyToRent.getRoomsNo());
            property.setPaymentTerms(propertyToRent.getPaymentTerms());
            property.setSecuritySelected(propertyToRent.isSecuritySelected());
            property.setParkingSelected(propertyToRent.isParkingSelected());
            property.setInternetAccessSelected(propertyToRent.isInternetAccessSelected());
            property.setHotWaterSelected(propertyToRent.isHotWaterSelected());
            property.setElectricityBackupSelected(propertyToRent.isElectricityBackupSelected());

        }
        return property;

    }

    public void setConfirmPanel(PropertyToRent property) {
        PropertyToRent propertyDetails = property;

        model.setValueAt(propertyDetails.getOwnersName(), 0, 1);
        model.setValueAt(propertyDetails.getContact(), 1, 1);
        model.setValueAt(propertyDetails.getLocation(), 2, 1);
        model.setValueAt(propertyDetails.getPrice(), 3, 1);
        model.setValueAt(propertyDetails.getRoomsNo(), 4, 1);
        model.setValueAt(propertyDetails.getPaymentTerms(), 5, 1);

        if (propertyDetails.isSecuritySelected()) {
            viewSecurityGuardCheckBox.setSelected(true);
        } else {
            viewSecurityGuardCheckBox.setSelected(false);
        }

        if (propertyDetails.isParkingSelected()) {
            viewParkingSpaceCheckBox.setSelected(true);
        } else {
            viewParkingSpaceCheckBox.setSelected(false);
        }

        if (propertyDetails.isInternetAccessSelected()) {
            viewInternetAccessCheckBox.setSelected(true);
        } else {
            viewInternetAccessCheckBox.setSelected(false);
        }

        if (propertyDetails.isElectricityBackupSelected()) {
            viewElectricityBackupCheckBox.setSelected(true);
        } else {
            viewElectricityBackupCheckBox.setSelected(false);
        }

        if (propertyDetails.isHotWaterSelected()) {
            viewHotWaterCheckBox.setSelected(true);
        } else {
            viewHotWaterCheckBox.setSelected(false);
        }

        if (propertyDetails.getPropertyType().equals("Room")) {
            imageLabel.setIcon(img1);
        } else if (propertyDetails.getPropertyType().equals("Building")) {
            imageLabel.setIcon(img2);
        } else if (propertyDetails.getPropertyType().equals("Appartment")) {
            imageLabel.setIcon(img3);
        }
    }

}
