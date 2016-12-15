package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

import java.sql.SQLException;
import java.util.List;

public class QueryDB{
 	public QueryDB(){

 	}
	
 public static List<SqlRow> getAllItemsNames() throws SQLException {
		SqlQuery items = Ebean.createSqlQuery(
                    "SELECT item.name FROM item ORDER BY item.name");
		return items.findList();
   }
   public static List<SqlRow> getAllMerchantNames() throws SQLException {
		SqlQuery merchants = Ebean.createSqlQuery(
                    "SELECT merchant.name FROM merchant ORDER BY merchant.name");
		return merchants.findList();
   }
   public static List<SqlRow> getAllUserNames() throws SQLException {
		SqlQuery users = Ebean.createSqlQuery(
                    "SELECT shopper.username FROM shopper ORDER BY shopper.username");
		return users.findList();
   }
   public static List<SqlRow> getAllItemsUnderPrice(int price) throws SQLException {
		SqlQuery items = Ebean.createSqlQuery(
                    "SELECT item.name FROM item WHERE item.price <= " + price + " ORDER BY item.name");
		return items.findList();
   }

   public static List<SqlRow> getAllItemsUnderPriceSameCategory(int price, String category) throws SQLException {
		SqlQuery items = Ebean.createSqlQuery(
                    "SELECT item.name FROM item WHERE item.priceInCents <= " + price + " AND item.category = " + category + " ORDER BY item.name");
		return items.findList();
   }

    public static List<SqlRow> getLikedItems() throws SQLException {
		SqlQuery items = Ebean.createSqlQuery(
                    "SELECT shopper_like_item.item.itemId FROM shopper_like_item WHERE shopper_like_item.did_like = true ORDER BY shopper_like_item.item.itemId");
		return items.findList();
   }

   public static int getNumLikesItem(long itemID){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM shopper_like_item WHERE shopper_like_item.did_like = true AND shopper_like_item.item.itemId = " + itemID + " ORDER BY shopper_like_item.item.itemId");
   		return likes.findList().size();

   }


   public static int getNumDisLikesItem(long itemID){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM shopper_like_item WHERE shopper_like_item.did_like = false AND shopper_like_item.item.itemId = " + itemID + " ORDER BY shopper_like_item.item.itemId");
   		return likes.findList().size();

   }

      public static int getNumLikesCategory(String category){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM shopper_like_item WHERE shopper_like_item.did_like = true AND shopper_like_item.item.category = " + category + " ORDER BY shopper_like_item.item.itemId");
   		return likes.findList().size();

   }


   public static int getNumDisLikesCategory(String category){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM shopper_like_item WHERE shopper_like_item.did_like = false AND shopper_like_item.item.category = " + category + " ORDER BY shopper_like_item.item.itemId");
   		return likes.findList().size();

   }
public static int getNumLikesShopper(String username){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM shopper_like_item WHERE shopper_like_item.did_like = true AND shopper_like_item.shopper.username = " + username +" ORDER BY shopper_like_item.item.itemId");
   		return likes.findList().size();

   }


   public static int getNumLikesMerchantItem(String name, long itemId){
   		SqlQuery likes =  Ebean.createSqlQuery(
                    "SELECT * FROM shopper_like_item WHERE shopper_like_item.did_like = true AND shopper_like_item.item.merchant.name = " + name +"AND shopper_like_item.item.itemId = " + Long.toString(itemId)  +" ORDER BY shopper_like_item.item.itemId");
   		return likes.findList().size();
   }


      public static int getNumLikesMerchantItemCategory(String name, long itemId, String category) {
   		SqlQuery likes =  Ebean.createSqlQuery(
                    "SELECT * FROM shopper_like_item WHERE shopper_like_item.did_like = true AND shopper_like_item.item.merchant.name = " + name +"AND shopper_like_item.item.itemId = " + Long.toString(itemId) + "AND shopper_like_item.item.category = " + category+" ORDER BY shopper_like_item.item.itemId");
   		return likes.findList().size();
   }

   public static int getNumLikesMerchant(String name){

      SqlUpdate likes = Ebean.createSqlUpdate("SELECT * FROM shopper_like_item,merchants,item WHERE shopper_like_item.did_like = true AND merchant.name = :merchantName AND shopper_like_item.item_item_id=item.item_id AND merchant.name=item.merchantname");
      likes.setParameter("merchantName", name);
      
      return likes.execute().size();
   }


   public static int getNumDisLikesMerchant(String name){
   		SqlQuery likes =  Ebean.createSqlQuery(
                    "SELECT * FROM shopper_like_item WHERE shopper_like_item.did_like = false AND shopper_like_item.item.merchant.name = " + name +" ORDER BY shopper_like_item.item.itemId");
   		return likes.findList().size();
   }
	

}