/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import PropertyNepal.Property;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author prashish
 */
public class AddPropertyLayoutPanel extends JPanel implements ActionListener {
    private JLabel infoLabel;
    private JScrollPane viewScroller;
    private JTable propertyTable;
    private CardLayout sellerPreference;
    private LoanPanel loanPanel;
    private SellPanel sellPanel;
    private JPanel propertyOptionPanel, sellPropertyPanel;
    private JButton loanPropertyBtn, sellPropertyBtn;
    
    public AddPropertyLayoutPanel(JLabel label, int WIDTH, int HEIGHT, ArrayList<Property> properties){
        //label at the bottom of the frame to display the panel the user is at
        infoLabel = label;
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        //set the weight and height of the panel to in accordance to its parents
        setSize(WIDTH, HEIGHT);
        
        //this cardlayyout helps user switch between property to rent and property to buy
        sellerPreference = new CardLayout();
        
        //Panel holding only the buttons
        propertyOptionPanel = new JPanel();
        
        //Panel implementing the cardlayout
        sellPropertyPanel = new JPanel(sellerPreference);   
        
        loanPropertyBtn = new JButton("Loan");
        loanPropertyBtn.addActionListener(this);  
               
        sellPropertyBtn = new JButton("Sell");
        
        sellPropertyBtn.addActionListener(this);

        loanPanel = new LoanPanel(WIDTH, properties);
        sellPanel = new SellPanel(WIDTH, properties);
        
        //Options such as rent buy lease the property
        propertyOptionPanel.setLayout(null);
        
        propertyOptionPanel.add(loanPropertyBtn);
        propertyOptionPanel.add(sellPropertyBtn);
        
        propertyOptionPanel.setBounds(0, 0, WIDTH, 44);
        sellPropertyPanel.setBounds(0, 44, WIDTH, HEIGHT - 44);
        
        loanPropertyBtn.setBounds(10, 3, 400, 40);
        sellPropertyBtn.setBounds(410, 3, 400, 40);
        
        propertyOptionPanel.setBackground(new Color(90, 95, 90));
        
        sellPropertyPanel.add(loanPanel, "loanPanel");
        sellPropertyPanel.add(sellPanel, "sellPanel");
        
        //add buttons to the panel
        add(propertyOptionPanel);
        add(sellPropertyPanel);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loanPropertyBtn){
           //switch the panel view from sell panel to the loan panel
            sellerPreference.show(sellPropertyPanel, "loanPanel");
            infoLabel.setText("Rent Property");
        }
        
        else if(e.getSource() == sellPropertyBtn){
            
            //switch the panel from the loan panel to the sell panel
            sellerPreference.show(sellPropertyPanel, "sellPanel");
            infoLabel.setText("Buy Property");
        }
        
    }
    
}
