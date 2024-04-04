package Model.Movies;

import java.util.ArrayList;


public class Movies implements MovieDesc {
    private static int movieCount = 0;
    private int movieID;
    private String movieName;
    private String genre;
    private String language;
    private int  price;
    private int copiesSold;
    private int movie_review_count = 0;
    private int movie_desc_count = 0;
    private ArrayList<String> Descriptions = new ArrayList<>();
    private ArrayList<String> MovieReviews = new ArrayList<>();

    public static int getMovieCount() {
        return movieCount;
    }

    public Movies() {

    }

    public Movies(String movieName, String genre, String language, int price, int copiesSold) {
        movieCount++;
        this.setMovieID(movieCount);
        this.setMovieName(movieName);
        this.setGenre(genre);
        this.setLanguage(language);
        this.setPrice(price);
        this.setCopiesSold(copiesSold);
    }

    public Movies(int movieID, String movieName, String genre, String language, int price, int copiesSold) {
        this.setMovieID(movieID);
        this.setMovieName(movieName);
        this.setGenre(genre);
        this.setLanguage(language);
        this.setPrice(price);
        this.setCopiesSold(copiesSold);
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold=copiesSold;
    }

    public void setMovie_review_count(int movie_review_count) {
        this.movie_review_count = movie_review_count;
    }

    public void setMovie_desc_count(int movie_desc_count) {
        this.movie_desc_count = movie_desc_count;
    }

    public int getMovieID() {
        return movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public int getPrice() {
        return price;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public int getMovie_review_count() {
        return movie_review_count;
    }

    public int getMovie_desc_count() {
        return movie_desc_count;
    }

    public void display() {
        System.out.println("Movie Id: " + getMovieID());
        System.out.println("Movie Name: " + getMovieName());
        System.out.println("Movie Language: " + getLanguage());
        System.out.println("Movie Genre: " + getGenre());
        System.out.println("Movie Price: " + getPrice());
        System.out.println("Movie Copies Sold: " + getCopiesSold());
    }

    public void addReviewS(String reviewS) {
        System.out.println("Adding movie review");
        if (getMovie_review_count() < 5) {
            MovieReviews.add(reviewS);
            setMovie_review_count(getMovie_review_count() + 1);
            System.out.println("Add movie review Successfully");
        } else {
            System.out.println("5 Author Achievements Already Added. Cannot add more");
        }
    }

    public void removeReviewS(int reviewSIndex) {
        if (getMovie_review_count() > 1) {
            System.out.println("Removing movie review");
            MovieReviews.remove(reviewSIndex);
            setMovie_review_count(getMovie_review_count() - 1);
            System.out.println("movie review Removed Successfully");
        } else {
            System.out.println("movie review Empty");
        }
    }

    public void displayReviewS() {
        System.out.println("movie review :");
        for (int i = 0; i < MovieReviews.size(); i++) {
            System.out.println(MovieReviews.get(i));
        }
    }

    public void addDescription(String description) {
        System.out.println("Adding Movie Description");
        if (getMovie_desc_count() < 5) {
            Descriptions.add(description);
            setMovie_desc_count(getMovie_desc_count() + 1);
            System.out.println("Movie Description Added Successfully");
        } else {
            System.out.println("5 Movie Description Already Added. Cannot add more");
        }
    }

    public void removeDescription(int descriptionIndex) {
        if (getMovie_desc_count() > 1) {
            System.out.println("Removing Movie Description");
            Descriptions.remove(descriptionIndex);
            setMovie_desc_count(getMovie_desc_count() - 1);
            System.out.println("Movie Description Removed Successfully");
        } else {
            System.out.println("Movie Description Empty");
        }
    }

    public void displayDescription() {
        System.out.println("Movie Description:");
        for (int i = 0; i < Descriptions.size(); i++) {
            System.out.println(Descriptions.get(i));
        }
    }


}
