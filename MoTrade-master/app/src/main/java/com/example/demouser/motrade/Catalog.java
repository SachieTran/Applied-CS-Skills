package com.example.demouser.motrade;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by demouser on 1/16/18.
 */

public class Catalog {

    private ArrayList<Listing> masterList;
    private HashMap<Listing.Category, ArrayList<Listing>> categoryMap;

    public Catalog() {
        masterList = new ArrayList<>();
        categoryMap = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "masterList=" + masterList.toString() +
                '}';
    }

    /**
     * create a new listing and add to list
     * @param newListing
     */
    public void addListing(Listing newListing) {

        //add to list
        masterList.add(newListing);
        //add to map
        if(categoryMap.containsKey(newListing.getCategory())) {
            //add to list at key
            ArrayList<Listing> list = categoryMap.get(newListing.getCategory());
            list.add(newListing);
        } else {
            //make new list with listing and add to map
            ArrayList<Listing> newList = new ArrayList<>();
            newList.add(newListing);
            categoryMap.put(newListing.getCategory(), newList);
        }
    }

    /**
     * delete listing
     * @param deleteListing
     */
    public void deleteListing(Listing deleteListing) {
        //remove from list
        masterList.remove(deleteListing);
        //remove from map
        ArrayList<Listing> list = categoryMap.get(deleteListing.getCategory());
        list.remove(deleteListing);
    }

    /**
     * getter for master list
     * @return masterList
     */
    public ArrayList<Listing> getMasterList() {
        return masterList;
    }

    /**
     * getter for individual category list
     * @param category
     * @return list at category
     */
    public ArrayList<Listing> getCategory(Listing.Category category) {
        return categoryMap.get(category);
    }
}

