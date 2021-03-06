package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alejandro on 22/10/2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    Activity mContext;
    private int mAudioFile;



    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, R.layout.list_item, words);
        mContext = context;
        mColorResourceId = colorResourceId;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view

        //View listItemView = convertView;
        //if(listItemView == null) {
          //  listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) rowView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) rowView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) rowView.findViewById(R.id.word_image);
        if (currentWord.hasImage()== true){
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer = rowView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        mAudioFile = currentWord.getAudioSource();



        // Find the ImageView in the list_item.xml layout with the ID list_item_icon

        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return rowView;
    }




}
