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
public class PropertyToBuy extends Property implements Serializable {

    private int area, distanceRange;
    private String nearBy, community, furnishing, insurance;
    private static final long serialVersionUID = 6529685098267757699L;
    
    public PropertyToBuy(String id, String ownersName, String contact, String propertyType, String location, int price, int area, String community, String furnishing, String insurance) {
        super(id, ownersName, contact, propertyType, location, price);
        distanceRange = 0;
        nearBy = "";
        this.area = area;
        this.community = community;
        this.furnishing = furnishing;
        this.insurance = insurance;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getNearBy() {
        return nearBy;
    }

    public void setNearBy(String nearBy) {
        this.nearBy = nearBy;
    }

    public int getDistanceRange() {
        return distanceRange;
    }

    public void setDistanceRange(int distanceRange) {
        this.distanceRange = distanceRange;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public Object[] getContent() {

        //to display only initial value such as: partial, fully or unfurnished duw to limited space
        String[] furnishingValue =furnishing.split(" ");
        String initValue = furnishingValue[0];
        
        Object[] obj = super.getContent();

        obj[6] = area;
        obj[7] = community;
        obj[8] = initValue;
        obj[9] = insurance;
        obj[10] = nearBy;
        obj[11] = distanceRange;

        return obj;
    }

}
