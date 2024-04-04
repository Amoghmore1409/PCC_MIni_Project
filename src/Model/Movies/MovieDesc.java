package Model.Movies;

public interface MovieDesc {
    void addReviewS(String reviewS);
    void removeReviewS(int reviewSIndex);
    void displayReviewS();

    void addDescription(String description);
    void removeDescription(int descriptionIndex);
    void displayDescription();
}
