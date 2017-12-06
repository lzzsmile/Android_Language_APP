package com.example.android.miwok;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by zhuangzhili on 2017-12-03.
 */

public class Word {
    private String miwokWord;
    private String defaultWord;
    private int songSourceId;

    private static final int NO_IMAGE_PROVIDED = -1;
    private int imageResourceId = NO_IMAGE_PROVIDED;

    public Word(String defaultTranslation, String miwokTranslation, int songId) {
        miwokWord = miwokTranslation;
        defaultWord = defaultTranslation;
        songSourceId = songId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int ImageResourceID, int songId) {
        miwokWord = miwokTranslation;
        defaultWord = defaultTranslation;
        imageResourceId = ImageResourceID;
        songSourceId = songId;
    }

    public String getDefaultTranslation() {
        return defaultWord;
    }

    public String getMiwokTranslation() {
        return miwokWord;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "miwokWord='" + miwokWord + '\'' +
                ", defaultWord='" + defaultWord + '\'' +
                ", songSourceId=" + songSourceId +
                ", imageResourceId=" + imageResourceId +
                '}';
    }

    public int getSongSourceId() {
        return songSourceId;
    }
}
