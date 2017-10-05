package com.example.android.lublin;

/**
 * Created by Komputer on 2017-01-27.
 */

public class Word {

    /** Default translation for the word */
    private int mAttLocation;

    /** Miwok translation for the word */
    private int mAttAddress;


    private String mLoc;


    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

//    public Word(int defaultTranslation, int miwokTranslation, double Lat, double Lon) {
//        mDefaultTranslation = defaultTranslation;
//        mMiwokTranslation = miwokTranslation;
//        mLat = Lat;
//        mLon = Lon;
//    }
//
//    public Word(int defaultTranslation, int miwokTranslation, double Lat, double Lon, int imageResourceId) {
//        mDefaultTranslation = defaultTranslation;
//        mMiwokTranslation = miwokTranslation;
//        mLat = Lat;
//        mLon = Lon;
//        mImageResourceId = imageResourceId;


//    }


    public Word(int attLocation, int attAddress, String Loc, int imageResourceId) {
        mAttLocation = attLocation;
        mAttAddress = attAddress;
        mLoc = Loc;
        mImageResourceId = imageResourceId;


    }


    public  int getAttLocation() {
        return mAttLocation;
    }
    public  int getAttAddress() {
        return mAttAddress;
    }
    public String getLoc() {return mLoc; }
    public  int getImageResourceId() {
        return mImageResourceId;
    }
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}




