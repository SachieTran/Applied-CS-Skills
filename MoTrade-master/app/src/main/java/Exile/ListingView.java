package Exile;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import com.example.demouser.motrade.Listing;
import com.example.demouser.motrade.R;

/**
 * Created by demouser on 1/16/18.
 */

public class ListingView extends RelativeLayout {

    private Listing listing;

    private ImageView productImage;
    private TextView productName;
    private TextView productDescription;
    private TextView productPrice;

    public ListingView(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

        //create and add image
        productImage = new ImageView(context);
        productImage.setImageResource(R.drawable.puppy);
        addView(productImage);
        //create and add description
        productDescription = new TextView(context);
        productDescription.setText("Description will go here");
        productDescription.setLeft(productImage.getRight());
        addView(productDescription);
        //productDescription.setLeft(productImage.getRight());

    }

    public Listing getListing() {
        return listing;
    }
}
