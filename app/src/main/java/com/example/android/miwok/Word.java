package com.example.android.miwok;

/**
 * Created by Alejandro on 22/10/2016.
 */

public class Word {
    // creamos las variables para un objeto "word"
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId= NO_IMAGE_PROVIDED;
    private int mAudioSource;

    // variable constant con valor -1
    private static final int NO_IMAGE_PROVIDED = -1;
    //private Context wContext;
    // This is the constructor of the Word object with three inputs: 2 Strings and 1 integer
    public Word (String miwokTranslation, String defaultTranslation, int imageResourceId, int audioSource){

        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioSource = audioSource;
    }
    // This is another constructor of the Word object with two inputs: 2 Strings
    public Word (String miwokTranslation, String defaultTranslation, int audioSource){

        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioSource = audioSource;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public int getAudioSource(){ return mAudioSource; }
    public boolean hasImage(){
        if (mImageResourceId == -1){
            return false;}
        else {return true;}
    }

 //This method represents the whole object as a string, usually for debugging purposes.
    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioSource=" + mAudioSource +
                '}';
    }
}
