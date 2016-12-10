package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class Item extends Model {

  @Id
  public Long itemId;
  public String name;
  public String category;
  public Double priceInCents;
  @OneToOne
  public Merchant merchant;

  public Item(Merchant merchant, String name, String category, Double priceInCents) {
    this.merchant = merchant;
    this.name = name;
    this.category = category;
    this.priceInCents = priceInCents;
  }

  public static Finder<String,Item> find = new Finder<String,Item>(
  String.class, Item.class
  );

}
