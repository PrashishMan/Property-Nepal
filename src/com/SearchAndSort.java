/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import PropertyNepal.Property;
import PropertyNepal.PropertyToBuy;
import PropertyNepal.PropertyToRent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author prashish
 */
public class SearchAndSort {

    public static int count = 1;

    private JPanel panel;
    ArrayList<Property> propertyList;

    public SearchAndSort(JPanel panel, ArrayList<Property> properties) {//
        //gets reference to the panel for displaying message dialog to the user
        this.panel = panel;
        //gets reference to the actual arraylist of the property
        this.propertyList = properties;

    }

    // Constructor Overloading when there is only arraylist as parameter
    public SearchAndSort(ArrayList<Property> properties) {
        this.propertyList = properties;

    }

    //This method checks if the value in the contact field is appripriate formatted
    public boolean isCorrectNumber(String valueInput) {
        boolean containsHifen = false;

        // removes any blank space from the valueInput
        String value = valueInput.trim();
        // seperate each charater from the string
        String chars[] = value.split("");

        for (int i = 0; i < chars.length; i++) {
            //check if the character includes the '-'to seperate extention form actual number
            if (chars[i].equals("-")) {
                containsHifen = true;
            }
        }

        //contact must contain hiffen to differenciate local id with the contact number
        if (containsHifen) {
            //split the contact number and extention
            String[] digits = value.split("-");
            String extension = digits[0];
            String number = digits[1];

            //check if both extention and number is not a charater
            if (isNumber(extension) && isNumber(number)) {
                //check if it is a lan-line number
                if (extension.length() == 2 && number.length() == 7) {
                    return true;
                } //check if it is a mobile number
                else if (extension.length() == 3 && number.length() == 10) {
                    return true;
                }
            }
        }
        return false;
    }

    //this method check is the given value in the field such as price is a number or not
    public boolean isNumber(String value) {

        try {
            //Type caseting the string value it ensure it is a character
            double num = Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //this method check if the property is reduntact and prevents from inputting the same property twice
    public boolean isPropertyRedundant(Property compareProperty, int i) {

        //this object get the value from the binary search
        //sorting the arraylist for binarysort
        propertyList = mergeSort(propertyList);
        boolean isAvailable = false;
        if (propertyList.size() > 1) {
            ArrayList<Property> properties = getProperties(compareProperty.getPrice());
            

            Property property;
            for (int count = 0; count < properties.size(); count++) {
                property = properties.get(count);
                //checks the given object and the object at index of thre arraylist is object of PropertyToRent
                if (i == 1 && compareProperty instanceof PropertyToRent) {
                    PropertyToRent obj = (PropertyToRent) compareProperty;
                    PropertyToRent rentProperty = (PropertyToRent) property;
                    //needs to Implement bineay search **********************************************
                    if (rentProperty.getOwnersName().equals(obj.getOwnersName()) && rentProperty.getContact().equals(obj.getContact()) && rentProperty.getLocation().equals(obj.getLocation())
                            && rentProperty.getPropertyType().equals(obj.getPropertyType()) && rentProperty.getPrice() == obj.getPrice() && rentProperty.getRoomsNo() == obj.getRoomsNo()) {
                        isAvailable = true;
                    }
                } //checks the given object and the index of thre arraylist is object of PropertyToBuy or not
                else if (i == 2 && compareProperty instanceof PropertyToBuy) {
                    PropertyToBuy obj = (PropertyToBuy) compareProperty;
                    PropertyToBuy buyProperty = (PropertyToBuy) property;
                    if (buyProperty.getOwnersName().equals(obj.getOwnersName()) && buyProperty.getContact().equals(obj.getContact()) && buyProperty.getLocation().equals(obj.getLocation())
                            && buyProperty.getPropertyType().equals(obj.getPropertyType()) && buyProperty.getPrice() == obj.getPrice() && buyProperty.getArea() == obj.getArea()) {
                        isAvailable = true;
                    }
                }
            }
        }

        // when no object if found
        return isAvailable;
    }

    public ArrayList<Property> mergeSort(ArrayList<Property> properties) {

        System.out.println(properties.size());
        int finalIndex = properties.size();
        int midIndex = finalIndex / 2;

        //termitates the recurssion when the there is single value in the ArrayList
        if (properties.size() <= 1) {
            return null;
        }

        //To store first part of the array
        ArrayList<Property> firstArray = new ArrayList();

        //To store second part of the array
        ArrayList<Property> secondArray = new ArrayList();

        //add value from the begining to the middle index of the array
        for (int i = 0; i < midIndex; i++) {
            firstArray.add(properties.get(i));
        }

        //add value from the middle to the final index of the array
        for (int j = midIndex; j < finalIndex; j++) {

            secondArray.add(properties.get(j));
        }

        //keeps recurring the same process until each value in the ArrayList is breaked down to single unit
        mergeSort(firstArray);
        mergeSort(secondArray);

        //checks for smaller unit and shorts accordingly to the new ArrayList
        mergeArray(firstArray, secondArray, properties);
        return properties;

    }

    public void mergeArray(ArrayList<Property> firstArray, ArrayList<Property> secondArray, ArrayList<Property> properties) {
        int firstIndex = 0;
        int secondIndex = 0;
        int finalIndex = 0;

        //loops until there is value remaining in both ArrayList
        //set method inserts in the specific index
        while (firstIndex < firstArray.size() && secondIndex < secondArray.size()) {
            if (firstArray.get(firstIndex).getPrice() < secondArray.get(secondIndex).getPrice()) {
                //swap the value of the current index
                properties.set(finalIndex, firstArray.get(firstIndex));
                firstIndex++;
            } else {
                properties.set(finalIndex, secondArray.get(secondIndex));
                secondIndex++;
            }
            finalIndex++;
        }

        //add the remaining value from to the ArrayList
        while (firstArray.size() > firstIndex) {
            properties.set(finalIndex, firstArray.get(firstIndex));
            firstIndex++;
            finalIndex++;
        }

        while (secondArray.size() > secondIndex) {
            properties.set(finalIndex, secondArray.get(secondIndex));
            secondIndex++;
            finalIndex++;
        }

    }

    //returns the index of the property, this helps program to locate the property for any update or deletion
    public int getPropertyIndex(String id, int type) {
        //needs to Implement bineay search **********************************************
        Property property = selectProperty(id);
        propertyList = mergeSort(propertyList);
        int index = -1;

        if (type == 1 && property instanceof PropertyToRent) {
            PropertyToRent compareProperty = (PropertyToRent) getProperty(property.getPrice(), type);
            index = propertyList.indexOf(compareProperty);
        } else {
            PropertyToBuy compareProperty = (PropertyToBuy) getProperty(property.getPrice(), type);
            index = propertyList.indexOf(compareProperty);
        }

//       
        return index;

    }

    //retrives multiple index that satisfies the condition, from the sorted array to display in the JTable
    //@value  value to be compared in the arraylist
    //@ id the type of instance of the object 
    public Property getProperty(double value, int id) {
        int minIndex = 0;

        //sorting the original property list
        propertyList = mergeSort(propertyList);

        int maxIndex = propertyList.size() - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;

            double price = -1;
            //checking if the midindex does not exceed the arraylist size
            if (midIndex < propertyList.size()) {
                price = propertyList.get(midIndex).getPrice();
            }

            if (price == value) {
                return propertyList.get(midIndex);

            } else if (price < value) {
                minIndex = midIndex + 1;
            } else if (price > value) {
                maxIndex = midIndex - 1;
            }
        }

        return null;
    }

    public ArrayList<Property> getProperties(double value) {
        int minIndex = 0;

        //sorting the original property list
        propertyList = mergeSort(propertyList);
        ArrayList<Property> searchList = new ArrayList(propertyList);
        ArrayList<Property> foundProperties = new ArrayList();

        int maxIndex = searchList.size() - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;

            double price = -1;
            //checking if the midindex does not exceed the arraylist size
            if (midIndex < searchList.size()) {
                price = searchList.get(midIndex).getPrice();
            }

            if (price == value) {

                foundProperties.add(searchList.get(midIndex));
                searchList.remove(midIndex);

            } else if (price < value) {
                minIndex = midIndex + 1;
            } else if (price > value) {
                maxIndex = midIndex - 1;
            }
        }

        return foundProperties;
    }

    //return property object from the id provided in the parameter
    public Property selectProperty(String id) {

        //sorts the array beore performing the bnary sort
        ArrayList<Property> propertyById = mergeSortId(propertyList);

        //this property object stores the object that shall be retrived
        Property property = null;

        int minIndex = 0;
        int maxIndex = propertyList.size() - 1;
        int midId = -1;
        int searchId = -1;

        String[] searchValue = id.split("-");

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
//            JOptionPane.showMessageDialog(panel,id);
            String[] midValue = propertyById.get(midIndex).getId().split("-");

            try {
                midId = Integer.parseInt(midValue[1]);
                searchId = Integer.parseInt(searchValue[1]);

            } catch (NumberFormatException e) {
            }
            if (midId == searchId) {
                property = propertyById.get(midIndex);
                return property;
            } else if (midId < searchId) {
                minIndex = midIndex + 1;
            } else if (midId > searchId) {
                maxIndex = midIndex - 1;
            }

        }

        return null;

    }

    public ArrayList<Property> mergeSortId(ArrayList<Property> properties) {

        ArrayList<Property> property = properties;
        int finalIndex = properties.size();
        int midIndex = finalIndex / 2;

        //termitates the recurssion when the there is single value in the ArrayList
        if (properties.size() <= 1) {
            return null;
        }

        //To store first part of the array
        ArrayList<Property> firstArray = new ArrayList();

        //To store second part of the array
        ArrayList<Property> secondArray = new ArrayList();

        //add value from the begining to the middle index of the array
        for (int i = 0; i < midIndex; i++) {
            firstArray.add(properties.get(i));
        }

        //add value from the middle to the final index of the array
        for (int j = midIndex; j < finalIndex; j++) {

            secondArray.add(properties.get(j));
        }

        //keeps recurring the same process until each value in the ArrayList is breaked down to single unit
        mergeSortId(firstArray);
        mergeSortId(secondArray);

        //checks for smaller unit and shorts accordingly to the new ArrayList
        mergeArrayId(firstArray, secondArray, property);
        return property;

    }

    public void mergeArrayId(ArrayList<Property> firstArray, ArrayList<Property> secondArray, ArrayList<Property> properties) {
        int firstIndex = 0;
        int secondIndex = 0;
        int finalIndex = 0;

        //loops until there is value remaining in both ArrayList
        //set method inserts in the specific index
        while (firstIndex < firstArray.size() && secondIndex < secondArray.size()) {
            String firstId[] = firstArray.get(firstIndex).getId().split("-");
            String secondId[] = secondArray.get(secondIndex).getId().split("-");
            int firstIdValue = 0;
            int secondIdValue = 0;

            try {
                firstIdValue = Integer.parseInt(firstId[1]);
                secondIdValue = Integer.parseInt(secondId[1]);
            } catch (NumberFormatException e) {
            }

            if (firstIdValue < secondIdValue) {
                //swap the value of the current index
                properties.set(finalIndex, firstArray.get(firstIndex));
                firstIndex++;
            } else {
                properties.set(finalIndex, secondArray.get(secondIndex));
                secondIndex++;
            }
            finalIndex++;
        }

        //add the remaining value from to the ArrayList
        while (firstArray.size() > firstIndex) {
            properties.set(finalIndex, firstArray.get(firstIndex));
            firstIndex++;
            finalIndex++;
        }

        while (secondArray.size() > secondIndex) {
            properties.set(finalIndex, secondArray.get(secondIndex));
            secondIndex++;
            finalIndex++;
        }

    }

    public ArrayList<Property> selectionSort(ArrayList propertyArray) {

        ArrayList<Property> properties = new ArrayList();
        for (int i = 0; i < propertyArray.size(); i++) {
            properties.add(propertyList.get(i));

        }
        for (int i = 0; i < properties.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < properties.size(); j++) {
                if (properties.get(j).getLocation().compareTo(properties.get(minIndex).getLocation()) < 0) {
                    minIndex = j;

                }
            }
            Property tempLocation = properties.get(i);
            properties.set(i, properties.get(minIndex));
            properties.set(minIndex, tempLocation);

        }

        for (int i = 0; i < properties.size(); i++) {
            System.out.println(properties.get(i).getLocation());
        }
        return properties;
    }

    public ArrayList<Property> selectionSortLocation(ArrayList propertyArray) {

        ArrayList<Property> properties = new ArrayList(propertyArray);
        for (int i = 0; i < properties.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < properties.size(); j++) {
                if (properties.get(j).getLocation().compareTo(properties.get(minIndex).getLocation()) < 0) {
                    System.out.println("Locaition : " + properties.get(j).getLocation() + " is  smaller than " + properties.get(minIndex).getLocation());
                    minIndex = j;

                }
            }
            Property tempLocation = properties.get(i);
            properties.set(i, properties.get(minIndex));
            properties.set(minIndex, tempLocation);

        }

        for (int i = 0; i < properties.size(); i++) {
            System.out.println(properties.get(i).getLocation());
        }
        return properties;
    }

    public ArrayList<Property> getPropertyByLocation(String value, int type) {
        int minIndex = 0;

        int maxIndex = propertyList.size() - 1;

        propertyList = selectionSortLocation(propertyList);

        ArrayList<Property> searchList = new ArrayList(propertyList);
        ArrayList<Property> foundProperties = new ArrayList();
        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            String location = "";
            if (midIndex <= maxIndex) {
                location = searchList.get(midIndex).getLocation();
            }
            if (location.equalsIgnoreCase(value)) {
                if (type == 1 && searchList.get(midIndex) instanceof PropertyToRent) {
                    foundProperties.add(searchList.get(midIndex));
                } else if (type == 2 && searchList.get(midIndex) instanceof PropertyToBuy) {
                    foundProperties.add(searchList.get(midIndex));
                }
                searchList.remove(midIndex);

            } //location from the middle index is smaller than the given value
            else if (location.compareTo(value) < 0) {
                System.out.println(location + " is smaller than " + value);
                System.out.println("mid" + midIndex);
                System.out.println("max" + maxIndex);
                minIndex = midIndex + 1;

            } //location in the middle index is greater than the given value
            else if (location.compareTo(value) > 0) {
                System.out.println(location + " is greater than " + value);
                System.out.println("mid" + midIndex);
                System.out.println("max" + maxIndex);
                maxIndex = midIndex - 1;
            }
        }

        return foundProperties;
    }
}
