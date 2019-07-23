
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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author prashish
 */
public class RentPanel extends JPanel implements ActionListener {

    private JPanel propertyViewPanel, propertyViewInnerPanel, innerButtonPanel, searchSelectionPanel, searchSelectionInnerPanel, searchByPricePanel,
            searchPanel, searchInnerPanel, searchByPriceInnerPanel, searchByLocationPanel, searchByLocationInnerPanel, buttonsPanel, outerPropertyViewPanel, innerPropertyViewPanel,
            viewPropertyDetailsPanel, viewDetailsPanel, viewServicesPanel, logoViewPanel;

    private JLabel propertyViewLabel, searchSelectionLabel, searchByPriceLabel, searchByLocationLabel, searchLabel, viewServicesLabel,
            imageLabel, propertyNepalLabel, flagImageLabel;
    private JTextField searchByPriceTextField;
    private JComboBox searchByLocationCombobox;
    private ArrayList<Property> properties;
    private Color itemsPanelColor, itemSelectionPanelColor, panelHeadingColor;
    private ButtonGroup searchSelectionGroup;
    private JRadioButton priceRadioButton, locationRadioButton;
    private CardLayout searchCardLayout, viewCardLayout;
    private JButton searchByPriceButton, searchByLocationButton, rentBtn, cancelBtn;
    private JCheckBox viewSecurityGuardCheckBox, viewParkingSpaceCheckBox,
            viewInternetAccessCheckBox, viewElectricityBackupCheckBox, viewHotWaterCheckBox;
    private int WIDTH;
    private Font headingLabelFont;
    private PropertyToRent propertyToRent;
    private SearchAndSort searchAndSort;
    private JScrollPane viewPropertyDetailSp, viewRecentlyAddedSp;
    private ImageIcon img1, img2, img3, flagImg, searchBtnImg;
    private ArrayList<String> locations;
    private JTable viewPropertyDetailTable, viewRecentlyAddedTable;
    private DefaultTableModel model, recentlyTableModel;

    public RentPanel(int WIDTH, ArrayList<Property> properties) {
        this.properties = properties;
        this.WIDTH = WIDTH;
        setLayout(null);
        setBackground(new Color(92, 232, 162));
        headingLabelFont = new Font("Arial", Font.BOLD, 14);

        searchBtnImg = new ImageIcon(getClass().getResource("/Images/searchBtn.png"));
        Image buttonImage = searchBtnImg.getImage().getScaledInstance(21, 20, Image.SCALE_SMOOTH);
        searchBtnImg = new ImageIcon(buttonImage);

        flagImg = new ImageIcon(getClass().getResource("/Images/flag.png"));
        Image flagImage = flagImg.getImage().getScaledInstance(240, 160, Image.SCALE_SMOOTH);
        flagImg = new ImageIcon(flagImage);

        itemsPanelColor = new Color(64, 64, 64);
        itemSelectionPanelColor = new Color(255, 255, 255);
        panelHeadingColor = new Color(160, 160, 160);

        searchCardLayout = new CardLayout();
        viewCardLayout = new CardLayout();

        propertyViewPanel = new JPanel();
        propertyViewInnerPanel = new JPanel();
        innerButtonPanel = new JPanel();
        searchSelectionPanel = new JPanel();
        searchSelectionInnerPanel = new JPanel();
        searchPanel = new JPanel();
        buttonsPanel = new JPanel();
        searchInnerPanel = new JPanel(searchCardLayout);
        outerPropertyViewPanel = new JPanel(viewCardLayout);

        searchByPricePanel = new JPanel();
        searchByPriceInnerPanel = new JPanel();
        searchByLocationPanel = new JPanel();
        searchByLocationInnerPanel = new JPanel();
        viewDetailsPanel = new JPanel();

        innerPropertyViewPanel = new JPanel();
        viewPropertyDetailsPanel = new JPanel();
        viewServicesPanel = new JPanel();
        buttonsPanel = new JPanel();
        logoViewPanel = new JPanel();

        searchAndSort = new SearchAndSort(this, properties);

        searchSelectionLabel = new JLabel("Search By: ");
        propertyViewLabel = new JLabel("View Property");
        searchByPriceLabel = new JLabel("Price : ");
        searchByLocationLabel = new JLabel("Location : ");
        searchLabel = new JLabel("Search");
        viewServicesLabel = new JLabel("Services: ");
        imageLabel = new JLabel();
        flagImageLabel = new JLabel(flagImg);

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

        viewSecurityGuardCheckBox = new JCheckBox("Security Guards");
        viewInternetAccessCheckBox = new JCheckBox("Internet Access");
        viewHotWaterCheckBox = new JCheckBox("Hot Water");
        viewParkingSpaceCheckBox = new JCheckBox("Parking Space");
        viewElectricityBackupCheckBox = new JCheckBox("Electricity Backup");

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

        outerPropertyViewPanel.add(logoViewPanel, "logoViewPanel");
        outerPropertyViewPanel.add(innerPropertyViewPanel, "propertyViewPanel");

        searchInnerPanel.add(searchByPricePanel, "searchByPrice");
        searchInnerPanel.add(searchByLocationPanel, "searchByLocation");

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
        innerPropertyViewPanel.add(viewServicesLabel);
        innerPropertyViewPanel.add(viewServicesPanel);

        viewPropertyDetailsPanel.setLayout(null);
        viewPropertyDetailsPanel.add(imageLabel);
        viewPropertyDetailsPanel.add(viewPropertyDetailSp);

        viewServicesPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
        viewServicesPanel.add(viewSecurityGuardCheckBox);
        viewServicesPanel.add(viewParkingSpaceCheckBox);
        viewServicesPanel.add(viewInternetAccessCheckBox);
        viewServicesPanel.add(viewElectricityBackupCheckBox);
        viewServicesPanel.add(viewHotWaterCheckBox);

        buttonsPanel.setLayout(null);
        buttonsPanel.add(rentBtn);
        buttonsPanel.add(cancelBtn);

        imageLabel.setBounds(0, 0, 200, 160);
        viewDetailsPanel.setBounds(205, 0, 180, 200);

        outerPropertyViewPanel.setBounds(395, 30, 400, 250);
        viewPropertyDetailsPanel.setBounds(0, 0, 395, 160);
        viewServicesLabel.setBounds(10, 160, 100, 20);
        viewServicesPanel.setBounds(0, 180, 390, 60);

        flagImageLabel.setBounds(80, 20, 240, 160);
        propertyNepalLabel.setBounds(10, 120, 400, 160);
        propertyNepalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        propertyNepalLabel.setFont(new Font("Arial", Font.BOLD, 26));

        imageLabel.setPreferredSize(new Dimension(200, 140));

        searchSelectionPanel.add(searchSelectionLabel, BorderLayout.NORTH);
        searchSelectionPanel.add(searchSelectionInnerPanel, BorderLayout.CENTER);

        buttonsPanel.add(rentBtn);
        buttonsPanel.add(cancelBtn);

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

        outerPropertyViewPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        viewRecentlyAddedSp.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));

        searchByPriceLabel.setPreferredSize(new Dimension(80, 20));
        searchByPriceTextField.setPreferredSize(new Dimension(140, 20));
        searchByPriceButton.setPreferredSize(new Dimension(20, 20));

        searchByLocationLabel.setPreferredSize(new Dimension(80, 20));
        searchByLocationCombobox.setPreferredSize(new Dimension(140, 20));
        searchByLocationButton.setPreferredSize(new Dimension(20, 20));

        viewSecurityGuardCheckBox.setEnabled(false);
        viewParkingSpaceCheckBox.setEnabled(false);
        viewInternetAccessCheckBox.setEnabled(false);
        viewElectricityBackupCheckBox.setEnabled(false);
        viewHotWaterCheckBox.setEnabled(false);

        searchSelectionPanel.setBackground(itemsPanelColor);
        searchSelectionInnerPanel.setBackground(itemSelectionPanelColor);

        searchPanel.setBackground(itemsPanelColor);
        searchInnerPanel.setBackground(itemsPanelColor);
        searchByPricePanel.setBackground(itemsPanelColor);
        searchByLocationPanel.setBackground(itemsPanelColor);
        innerPropertyViewPanel.setBackground(Color.DARK_GRAY);
        viewServicesPanel.setBackground(Color.LIGHT_GRAY);
        logoViewPanel.setBackground(Color.DARK_GRAY);

        viewDetailsPanel.setBackground(itemsPanelColor);
        buttonsPanel.setBackground(new Color(242, 237, 236));

        searchLabel.setFont(headingLabelFont);
        searchSelectionLabel.setFont(headingLabelFont);
        searchByPriceLabel.setFont(headingLabelFont);
        searchByLocationLabel.setFont(headingLabelFont);
        viewServicesLabel.setFont(headingLabelFont);

        searchSelectionInnerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 200, 10));
        searchSelectionInnerPanel.add(priceRadioButton);
        searchSelectionInnerPanel.add(locationRadioButton);
        priceRadioButton.setSelected(true);

        searchSelectionLabel.setForeground(panelHeadingColor);
        searchLabel.setForeground(panelHeadingColor);
        searchByPriceLabel.setForeground(panelHeadingColor);
        searchByLocationLabel.setForeground(panelHeadingColor);
        viewServicesLabel.setForeground(panelHeadingColor);

        propertyNepalLabel.setForeground(Color.LIGHT_GRAY);

        searchByPriceButton.addActionListener(this);
        searchByLocationButton.addActionListener(this);
        rentBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        Locations location = new Locations();
        locations = location.getLocations();

        for (int i = 0; i < locations.size(); i++) {
            searchByLocationCombobox.addItem(locations.get(i));
        }

        add(propertyViewPanel);
        add(searchSelectionPanel);
        add(searchPanel);

        viewRecentlyAddedTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = viewRecentlyAddedTable.getSelectedRow();
                String id = "";
                id = viewRecentlyAddedTable.getValueAt(selectedRow, 0).toString();
                propertyToRent = (PropertyToRent) searchAndSort.selectProperty(id);

                if (selectedRow >= 0 && propertyToRent != null) {
                    setConfirmPanel(propertyToRent);
                    viewCardLayout.show(outerPropertyViewPanel, "propertyViewPanel");
                }
            }
        });

        priceRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    searchCardLayout.show(searchInnerPanel, "searchByPrice");
                } else {
                    searchCardLayout.show(searchInnerPanel, "searchByLocation");
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchByPriceButton) {
            recentlyTableModel.setRowCount(0);
            if (searchByPriceTextField.getText().isEmpty() || searchByPriceTextField.getText().trim().equals("") || searchByPriceTextField == null || searchByPriceTextField.getText().contains("-")) {
                JOptionPane.showMessageDialog(this, "Please enter the price amount!!", "Error: Price field empty", JOptionPane.ERROR_MESSAGE);
            } else {
                int price = 0;
                try {

                    price = Integer.parseInt(searchByPriceTextField.getText());
                    ArrayList<Property> foundProperties = searchAndSort.getProperties(price);
                    PropertyToRent selectedProperties = null; 
                    for (int i = 0; i < foundProperties.size(); i++) {
                        if (foundProperties.get(i) instanceof PropertyToRent) {
                            selectedProperties = (PropertyToRent) foundProperties.get(i);
                            recentlyTableModel.addRow(new Object[]{selectedProperties.getId(), selectedProperties.getOwnersName(), selectedProperties.getLocation(), selectedProperties.getPropertyType(), selectedProperties.getPrice(), selectedProperties.getPaymentTerms()});
                        }
                    }
                    if (selectedProperties == null) {
                        JOptionPane.showMessageDialog(this, "Property in the price range : " + price + " is unavailable!!", "Error: Property unavailable", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter valid price amount!!", "Error: Incorrect number format", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (e.getSource() == searchByLocationButton) {
            recentlyTableModel.setRowCount(0);
            if (searchByLocationCombobox.getSelectedItem() == null || searchByLocationCombobox.getSelectedItem().toString().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please select the Location of Property!!", "Error: Location field empty", JOptionPane.ERROR_MESSAGE);
            } else {
                PropertyToRent displayProperty = null;
                String location = searchByLocationCombobox.getSelectedItem().toString();

                ArrayList<Property> selectedProperty = searchAndSort.getPropertyByLocation(location, 1);

                for (int i = 0; i < selectedProperty.size(); i++) {
                    displayProperty = (PropertyToRent) selectedProperty.get(i);
                    recentlyTableModel.addRow(new Object[]{displayProperty.getId(), displayProperty.getOwnersName(), displayProperty.getLocation(), displayProperty.getPropertyType(), displayProperty.getPrice(), displayProperty.getPaymentTerms()});
                }
                if (selectedProperty.size() <= 0) {
                    JOptionPane.showMessageDialog(this, "Property at the location : " + location + " is unavailable!!", "Error: Property unavailable", JOptionPane.ERROR_MESSAGE);
                }

            }
        } else if (e.getSource()
                == rentBtn) {
            if (viewRecentlyAddedTable.getSelectedRow() < 0) {

                JOptionPane.showMessageDialog(this, "PLease select the row to be rented", "Error: Row not selected", JOptionPane.ERROR_MESSAGE);
            } else if (!propertyToRent.isAvailable() || propertyToRent == null) {

                JOptionPane.showMessageDialog(this, "This property is not available", "Property unavailable", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Thankyou for renting the property \nPropertyId: " + propertyToRent.getId() + "\nLocation: " + propertyToRent.getLocation()
                        + "\nPrice: " + propertyToRent.getPrice(), "Property unavailable", JOptionPane.INFORMATION_MESSAGE);
                propertyToRent.setAvailable(false);
            }
        } else if (e.getSource()
                == cancelBtn) {

            propertyToRent = null;
            viewCardLayout.show(outerPropertyViewPanel, "logoViewPanel");
            recentlyTableModel.setRowCount(0);
        }
    }

    public void setConfirmPanel(PropertyToRent property) {
        PropertyToRent propertyDetails = property;

        System.out.println("Owners Name : " + propertyDetails.getOwnersName());
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
