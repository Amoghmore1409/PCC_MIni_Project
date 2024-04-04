package Model.Casting;

import Model.Actors.Actors;
import Model.Movies.Movies;

public class Casting {
     Movies b_temp;
     Actors a_temp;
     String publicationDate;
     String publisher;

    public Casting(Actors a, Movies b, String publicationDate, String publisher) {
        setA_temp(a);
        setB_temp(b);
        setCastingDate(publicationDate);
        setDirector(publisher);
    }



    public void setB_temp(Movies b_temp) {
        this.b_temp = b_temp;
    }

    public void setA_temp(Actors a_temp) {
        this.a_temp = a_temp;
    }

    public void setCastingDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setDirector(String publisher) {
        this.publisher = publisher;
    }

    public Movies getB_temp() {
        return b_temp;
    }

    public Actors getA_temp() {
        return a_temp;
    }

    public String getCastingDate() {
        return publicationDate;
    }

    public String getDirector() {
        return publisher;
    }
    public void display() {
        System.out.println("Author P_id: " + getA_temp());
        System.out.println("Book P_id:"+getB_temp());
        System.out.println("Casting Date: " + getCastingDate());
        System.out.println("Director:" + getDirector());
    }
}
