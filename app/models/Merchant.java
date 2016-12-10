package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class Merchant extends Model {

  @Id
  public String name;
  public String password;

  public Merchant(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public static Finder<String,Merchant> find = new Finder<String,Merchant>(
  String.class, Merchant.class
  );

  public static Merchant authenticate(String name, String password) {
    return find.where().eq("name", name)
    .eq("password", password).findUnique();
  }
}
