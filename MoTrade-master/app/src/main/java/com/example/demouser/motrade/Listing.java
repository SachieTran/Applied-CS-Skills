package com.example.demouser.motrade;

import java.util.ArrayList;

/**
 * Created by demouser on 1/16/18.
 */

public class Listing {

    protected String name;
    protected String price;
    protected String description;
    protected ArrayList<String> pictureFiles;
    protected String sellerName;
    protected Category category;

    public enum Category {
        GOOD, SERVICE;
    }

    public Listing(String name, String price, String description, String sellerName, Category category, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.sellerName = sellerName;
        this.category = category;
        pictureFiles = new ArrayList<>();
        pictureFiles.add(image);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainPicture() {
        return pictureFiles.get(0);
    }

    public ArrayList<String> getPictureFiles() {
        return pictureFiles;
    }

    public void setPictureFiles(ArrayList<String> pictureFiles) {
        this.pictureFiles = pictureFiles;
    }

    /**
     * Inserts the picture into the pictures list
     * @param pictureFile the string address of the image
     * @param makeFirst if true, insert at front of list, otherwise insert at end
     */
    public void addPicture(String pictureFile, boolean makeFirst) {
        if (makeFirst) {
            pictureFiles.add(0, pictureFile);
        } else {
            pictureFiles.add(pictureFile);
        }
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", pictureFiles=" + pictureFiles +
                ", sellerName='" + sellerName + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Listing listing = (Listing) o;

        if (name != null ? !name.equals(listing.name) : listing.name != null) return false;
        if (price != null ? !price.equals(listing.price) : listing.price != null) return false;
        if (description != null ? !description.equals(listing.description) : listing.description != null)
            return false;
        if (pictureFiles != null ? !pictureFiles.equals(listing.pictureFiles) : listing.pictureFiles != null)
            return false;
        if (sellerName != null ? !sellerName.equals(listing.sellerName) : listing.sellerName != null)
            return false;
        return category == listing.category;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pictureFiles != null ? pictureFiles.hashCode() : 0);
        result = 31 * result + (sellerName != null ? sellerName.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    /*
    public static void main(String[] args) {

        Listing testListing = new Listing("bagel", "$1837",
                "stolen from Prospect",
                "Jorge",
                Category.GOOD);
        System.out.println(testListing.toString());

        Listing testListing2 = new Listing("bagel", "$1837",
                "stolen from Prospect",
                "Jorge",
                Category.GOOD);

        System.out.println(testListing.equals(testListing2));
    }*/
}
