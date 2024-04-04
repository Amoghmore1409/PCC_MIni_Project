package Model.Actors;

import java.util.ArrayList;
import java.util.Scanner;

public class Actors implements ActDesc {

    private int actorID;
    private String actorName;
    private String actorGenre;
    private int actorRating;
    private String actorLanguage;
    private int actorAchievements_count = 0;
    private int actorReview_count = 0;
    private ArrayList<String> actorAchievements = new ArrayList<>();
    private ArrayList<String> actorReviews = new ArrayList<>();



    public Actors() {

    }

    public Actors(int actorID, String actorName, String actorGenre, String actorLanguage, int actorRating) {
        this.setActorID(actorID);
        this.setActorName(actorName);
        this.setActorGenre(actorGenre);
        this.setActorLanguage(actorLanguage);
        this.setActorRating(actorRating);
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setActorGenre(String actorGenre) {
        this.actorGenre = actorGenre;
    }

    public void setActorRating(int actorRating) {
        this.actorRating = actorRating;
    }

    public void setActorLanguage(String actorLanguage) {
        this.actorLanguage = actorLanguage;
    }

    public void setActorAchievements_count(int actorAchievements_count) {
        this.actorAchievements_count = actorAchievements_count;
    }

    public void setActorReviewCount(int actorReviewCount) {
        this.actorReview_count = actorReviewCount;
    }

    public int getActorID() {
        return actorID;
    }

    public String getActorName() {
        return actorName;
    }

    public String getActorGenre() {
        return actorGenre;
    }

    public int getActorRating() {
        return actorRating;
    }

    public String getActorLanguage() {
        return actorLanguage;
    }

    public int getActorAchievements_count() {
        return actorAchievements_count;
    }

    public int getActorReviewCount() {
        return actorReview_count;
    }

    public void display() {
        System.out.println("Actor Id: " + getActorID());
        System.out.println("Actor Name:" + getActorName());
        System.out.println("Actor Genre: " + getActorGenre());
        System.out.println("Actor Rating: " + getActorRating());
        System.out.println("Actor Language: " + getActorLanguage());
    }

    public void addAchievement(String achievement) {
        System.out.println("Adding Actor Achievement");
        if (getActorAchievements_count() < 5) {
            actorAchievements.add(achievement);
            setActorAchievements_count(getActorAchievements_count() + 1);
            System.out.println("Actor Achievement Added Successfully");
        } else {
            System.out.println("5 Actor Achievements Already Added. Cannot add more");
        }
    }

    public void removeAchievement(int achievementIndex) {
        if (getActorAchievements_count() > 1) {
            System.out.println("Removing Actor Achievement");
            actorAchievements.remove(achievementIndex);
            setActorAchievements_count(getActorAchievements_count() - 1);
            System.out.println("Actor Achievement Removed Successfully");
        } else {
            System.out.println("Actor Achievements Empty");
        }
    }

    public void displayAchievements() {
        System.out.println("Actor Achievements:");
        for (int i = 0; i < actorAchievements.size(); i++) {
            System.out.println(actorAchievements.get(i));
        }
    }

    public void addReview(String review) {
        System.out.println("Adding Actor Review");
        if (getActorReviewCount() < 5) {
            actorReviews.add(review);
            setActorReviewCount(getActorReviewCount() + 1);
            System.out.println("Actor Review Added Successfully");
        } else {
            System.out.println("5 Actor Reviews Already Added. Cannot add more");
        }
    }

    public void removeReview(int reviewIndex) {
        if (getActorReviewCount() > 1) {
            System.out.println("Removing Actor Review");
            actorReviews.remove(reviewIndex);
            setActorReviewCount(getActorReviewCount() - 1);
            System.out.println("Actor Review Removed Successfully");
        } else {
            System.out.println("Actor Reviews Empty");
        }
    }

    public void displayReviews() {
        System.out.println("Actor Reviews:");
        for (int i = 0; i < actorReviews.size(); i++) {
            System.out.println(actorReviews.get(i));
        }
    }

    public int getActorRating(Scanner sc) {
        while (true) {
            try {
                System.out.println("Enter Actor Rating: ");
                actorRating = sc.nextInt();
                if (actorRating < 0 || actorRating > 10) {
                    throw new RatingException("Rating must be between 0 and 10.");

                } else {

                    return actorRating;
                }
            } catch (RatingException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
