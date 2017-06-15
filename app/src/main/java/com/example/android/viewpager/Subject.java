package com.example.android.viewpager;

/**
 * Created by Aditya on 6/14/2017.
 */

public class Subject {

    private String mSubjectName;

    private String mSubjectDescription;

    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Subject(String name,String description,int resourceId){
        mSubjectName = name;
        mSubjectDescription = description;
        mImageResourceId = resourceId;

    }

    public String getSubjectName(){
       return mSubjectName;
    }
    public String getSubjectDescription(){
        return mSubjectDescription;
    }
    public int getImageResourceId(){

        return mImageResourceId;
    }

    public boolean hasImage(){

        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
