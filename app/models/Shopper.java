package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class Shopper extends Model {

  @Id
  public String username;
  public String firstName;
  public String lastName;
  public char gender;
  public int age;
  public double numLikes;
  public double numDislikes;

  public Shopper(String username, String firstName, String lastName, char gender, int age, double numLikes, double numDislikes) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.age = age;
    this.numLikes = numLikes;
    this.numDislikes = numDislikes;
  }

  public static Finder<String,Shopper> find = new Finder<String,Shopper>(
  String.class, Shopper.class
  );

}
