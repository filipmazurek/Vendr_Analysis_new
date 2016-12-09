package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class UserZen extends Model {

  @Id
  public String email;
  public String name;
  public String password;

  public UserZen(String email, String name, String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }

  public static Finder<String,UserZen> find = new Finder<String,UserZen>(
  String.class, UserZen.class
  );

  public static UserZen authenticate(String email, String password) {
    return find.where().eq("email", email)
    .eq("password", password).findUnique();
  }
}
