package com.example.myapp.lab2;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {

    private String title;
    private String duration;
    private Integer imageId;

    public MovieModel(String title, String duration, Integer imageId) {
        this.title = title;
        this.duration = duration;
        this.imageId = imageId;
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) { return new MovieModel(in); }

        @Override
        public MovieModel[] newArray(int size) { return new MovieModel[size]; }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    //serializeaza si deserealizeaza acest obiect
    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray( new String[]{this.title, this.duration, this.imageId.toString()});
    }
    public MovieModel( Parcel in){
        String[] data = new String[3];

        in.readStringArray(data);
        // the ordeerr needs to be the same as in the WriteToParcel() method
        this.title = data[0];
        this.duration = data[1];
        this.imageId = Integer.valueOf(data[2]);
    }
}
