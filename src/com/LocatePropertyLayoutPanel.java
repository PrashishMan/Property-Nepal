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
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author prashish
 */
public class LocatePropertyLayoutPanel extends JPanel implements ActionListener{
    private JPanel propertyOptionPanel, propertyPanel;
    private RentPanel rentPanel;
    private BuyPanel buyPanel;
    private JButton rentPropertyBtn, buyPropertyBtn;
    private CardLayout buyerPreference;
    private JLabel label;
    
    
    public LocatePropertyLayoutPanel(JLabel label, int WIDTH, int HEIGHT, ArrayList<Property>properties){
       
        this.label = label;
        setBackground(Color.GRAY);
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        
        buyerPreference = new CardLayout();
        propertyOptionPanel = new JPanel();
        propertyPanel = new JPanel(buyerPreference);   
        
        rentPropertyBtn = new JButton("Rent");
        rentPropertyBtn.setBounds(10, 3, 400, 40);
        rentPropertyBtn.addActionListener(this);
               
        buyPropertyBtn = new JButton("Buy");
        buyPropertyBtn.setBounds(410, 3, 400, 40);
        buyPropertyBtn.addActionListener(this);
        
        rentPanel = new RentPanel(WIDTH, properties);
        buyPanel = new BuyPanel(WIDTH, properties);
        
        //Options such as rent buy lease the property
        propertyOptionPanel.setLayout(null);
        propertyOptionPanel.setBackground(new Color(90, 95, 90));
        propertyOptionPanel.setBounds(0, 0, WIDTH, 44);
        
        propertyOptionPanel.add(rentPropertyBtn);
        propertyOptionPanel.add(buyPropertyBtn);
        
        //Buy property panel parameters
        propertyPanel.setBounds(0, 44, WIDTH, HEIGHT - 44);
        
        propertyPanel.add(rentPanel, "rentPanel");
        propertyPanel.add(buyPanel, "buyPanel");
        
        add(propertyOptionPanel);
        add(propertyPanel);
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rentPropertyBtn){
            
            buyerPreference.show(propertyPanel, "rentPanel");
            label.setText("Rent Property");
        }
        
        else if(e.getSource() == buyPropertyBtn){
            
            buyerPreference.show(propertyPanel, "buyPanel");
            label.setText("Buy Property");
        
        }
        
    }
    
}
