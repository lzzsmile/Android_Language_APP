package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zhuangzhili on 2017-12-03.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int textColorTypeId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorTypeId) {
        super(context, 0, words);
        textColorTypeId = colorTypeId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), textColorTypeId);
        textContainer.setBackgroundColor(color);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokTranslation);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaultTranslation);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
