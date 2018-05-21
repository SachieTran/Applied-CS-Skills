package com.example.demouser.motrade;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by demouser on 1/18/18.
 */

public class ListViewAdapter extends ArrayAdapter<Listing> {

    Context context;

    public ListViewAdapter(Context context, int resourceId,
                           ArrayList<Listing> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtPrice;
        TextView txtDesc;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Listing listing = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            holder.txtPrice = (TextView) convertView.findViewById(R.id.price);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtDesc.setText(listing.getDescription());
        holder.txtTitle.setText(listing.getName());
        holder.txtPrice.setText(listing.getPrice());
        Log.d("View height", "Height: " + R.dimen.browsing_image_view);
        ItemViewActivity.setPic(context, listing.getMainPicture(), holder.imageView);
        //holder.imageView.setImageResource(listing.getMainPicture());

        return convertView;
    }
}
