package Model.Movies;

public class Cast {
    private static int castCount = 0;
    int castID;
    String title;
    String publishedDate;
    String language;

    public Cast() {
        castCount++;
        this.setCastID(castCount);
    }

    public Cast(String title, String publishedDate, String language) {
        castCount++;
        this.setCastID(castCount);
        this.setTitle(title);
        this.setPublishedDate(publishedDate);
        this.setLanguage(language);
    }

    public void setCastID(int castID) {
        this.castID = castID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCastID() {
        return castID;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getLanguage() {
        return language;
    }

    public void display() {
        System.out.println("Cast ID: " + getCastID());
        System.out.println("Title: " + getTitle());
        System.out.println("Published Date: " + getPublishedDate());
        System.out.println("Language: " + getLanguage());
    }
}
