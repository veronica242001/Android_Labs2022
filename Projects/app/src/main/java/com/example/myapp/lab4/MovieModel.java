package com.example.myapp.lab4;

public class MovieModel {

    private String Title;
    private String Year;
    private String indbID;
    private String Poster;

    public MovieModel(String title, String year, String indbID, String poster) {
        Title = title;
        Year = year;
        this.indbID = indbID;
        Poster = poster;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getIndbID() {
        return indbID;
    }

    public void setIndbID(String indbID) {
        this.indbID = indbID;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
