package Exile;

import com.example.demouser.motrade.Catalog;
import com.example.demouser.motrade.Listing;

import java.util.ArrayList;

/**
 * Created by demouser on 1/16/18.
 */

public class Catalog_activity {
    public Catalog my_catalog = new Catalog();
    public ArrayList<Listing> listings;
    public  ArrayList<String> names;
    String[] productStrings = {
            "black sweat pants 1", "adidas superstar", "iPhone 6s", "Hello ", "Hello ", "Hello ",
            "adidas superstar", "iPhone 6s", "Hello ", "Hello ", "adidas superstar", "iPhone 6s",
            "Hello ", "Hello ", "adidas superstar", "iPhone 6s", "Hello ", "Hello "
    };

    public void hardCode(){ // hardcode some products
//        addListing(new Listing("name 1", "description 1", "sellerName 1", Listing.Category.GOOD));
//        addListing(new Listing("name 2", "description 2", "sellerName 2", Listing.Category.SERVICE));
//        addListing(new Listing("name 3", "description 3", "sellerName 3", Listing.Category.GOOD));
//        addListing(new Listing("name 4", "description 4", "sellerName 4", Listing.Category.SERVICE));
//        addListing(new Listing("name 5", "description 5", "sellerName 5", Listing.Category.GOOD));
//        addListing(new Listing("name 6", "description 6", "sellerName 6", Listing.Category.SERVICE));
//        addListing(new Listing("name 7", "description 7", "sellerName 7", Listing.Category.GOOD));
    }

    public void addListing(Listing listing) {
        listings.add(listing);
        names.add(listing.getName());
    }
}

