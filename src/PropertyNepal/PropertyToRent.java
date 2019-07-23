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
public class PropertyToRent extends Property implements Serializable {

    private int roomsNo;
    private boolean securitySelected, parkingSelected, hotWaterSelected, internetAccessSelected, electricityBackupSelected;
    private String paymentTerms;
    private static final long serialVersionUID = 6529685098267757699L;

    public PropertyToRent(String id, String ownersName, String contact, String propertyType, String location, int price, int roomsNo, String paymentTerms) {
        super(id, ownersName, contact, propertyType, location, price);
        this.roomsNo = roomsNo;
        this.paymentTerms = paymentTerms;

    }

    public PropertyToRent(String id, String ownersName, String contact, String propertyType, String location, int price) {
        super(id, ownersName, contact, propertyType, location, price);
    }

//    
//    public void setId(String id){
//        super.setId(id);
//    }
//    
//    public String getId(){
//        return super.getId();
//    }
    public int getRoomsNo() {
        return roomsNo;
    }

    public void setRoomsNo(int roomsNo) {
        this.roomsNo = roomsNo;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public boolean isSecuritySelected() {
        return securitySelected;
    }

    public void setSecuritySelected(boolean securitySelected) {
        this.securitySelected = securitySelected;
    }

    public boolean isParkingSelected() {
        return parkingSelected;
    }

    public void setParkingSelected(boolean parkingSelected) {
        this.parkingSelected = parkingSelected;
    }

    public boolean isHotWaterSelected() {
        return hotWaterSelected;
    }

    public void setHotWaterSelected(boolean hotWaterSelected) {
        this.hotWaterSelected = hotWaterSelected;
    }

    public boolean isInternetAccessSelected() {
        return internetAccessSelected;
    }

    public void setInternetAccessSelected(boolean internetAccessSelected) {
        this.internetAccessSelected = internetAccessSelected;
    }

    public boolean isElectricityBackupSelected() {
        return electricityBackupSelected;
    }

    public void setElectricityBackupSelected(boolean electricityBackupSelected) {
        this.electricityBackupSelected = electricityBackupSelected;
    }

    public Object[] getContent() {

        Object[] obj = super.getContent();

        obj[6] = getRoomsNo();
        obj[7] = getPaymentTerms();

        if (isParkingSelected()) {
            obj[8] = "Check";
        }
        if (isSecuritySelected()) {
            obj[9] = "Check";
        }
        if (isHotWaterSelected()) {
            obj[10] = "Check";
        }

        if (isElectricityBackupSelected()) {
            obj[11] = "Check";
        }

        if (isInternetAccessSelected()) {
            obj[12] = "Check";
        }

        return obj;
    }

}
