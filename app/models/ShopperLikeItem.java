package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class ShopperLikeItem extends Model {

  @Id
  public Long likeId;
  @OneToOne
  public Item item;
  @OneToOne
  public Shopper shopper;
  public boolean didLike;

  public ShopperLikeItem(Item item, Shopper shopper, boolean didLike) {
    this.item = item;
    this.shopper = shopper;
    this.didLike = didLike;
  }

  public static Finder<String,ShopperLikeItem> find = new Finder<String,ShopperLikeItem>(
  String.class, ShopperLikeItem.class
  );

}
