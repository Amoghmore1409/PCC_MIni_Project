package Model.Actors;

public interface ActDesc {

    public interface ActorDesc {
        void addAchievement(String achievement);
        void removeAchievement(int achievementIndex);
        void displayAchievements();
        void addReview(String reviewerName, int rating, String comment);
        void removeReview(int reviewIndex);
        void displayReviews();
    }

}
