/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PropertyNepal;

import java.io.Serializable;

/**
 *
 * @author prashish
 */
public class Property implements Serializable{
    private String id;
    private String ownersName;
    private String contact;
    private String propertyType;
    private String location;
    private int price;
    private boolean isAvailable;
    private static final long serialVersionUID = 6529685098267757699L;

    public Property(String id, String ownersName, String contact, String propertyType, String location, int price) {
        this.id = id;
        this.ownersName = ownersName;
        this.contact = contact;
        this.propertyType = propertyType;
        this.location = location;
        this.price = price;
        this.isAvailable = true;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public Object[] getContent(){
        
        Object[] obj = new Object[13];
        obj[0] = getId();
        obj[1] = getOwnersName();
        obj[2] = getContact();
        obj[3] = getPropertyType();
        obj[4] = getLocation();
        obj[5] = getPrice();
        
        return obj;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
}
