package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

public class QueryDB{
 	public QueryDB(){

 	}
	
 public static List<SqlRow> getAllItemsNames() throws SQLException {
		SqlQuery items = Ebean.createSqlQuery(
                    "SELECT Item.name FROM Item ORDER BY name");
		return List<SqlRow> rawRows = items.findList();
   }
   public static List<SqlRow> getAllMerchantNames() throws SQLException {
		SqlQuery merchants = Ebean.createSqlQuery(
                    "SELECT Merchant.name FROM Merchant ORDER BY name");
		return List<SqlRow> rawRows = merchants.findList();
   }
   public static List<SqlRow> getAllUserNames() throws SQLException {
		SqlQuery users = Ebean.createSqlQuery(
                    "SELECT Shopper.username FROM Shopper ORDER BY username");
		return List<SqlRow> rawRows = users.findList();
   }
   public static List<SqlRow> getAllItemsUnderPrice(int price) throws SQLException {
		SqlQuery items = Ebean.createSqlQuery(
                    "SELECT Item.name FROM Item WHERE Item.price <= " + price + " ORDER BY name");
		return List<SqlRow> rawRows = items.findList();
   }

   public static List<SqlRow> getAllItemsUnderPriceSameCategory(int price, String category) throws SQLException {
		SqlQuery items = Ebean.createSqlQuery(
                    "SELECT Item.name FROM Item WHERE Item.priceInCents <= " + price + " AND Item.category = " + category + " ORDER BY name");
		return List<SqlRow> rawRows = items.findList();
   }

    public static List<SqlRow> getLikedItems() throws SQLException {
		SqlQuery items = Ebean.createSqlQuery(
                    "SELECT ShopperLikeItem.item.itemId FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = true ORDER BY ShopperLikeItem.item.itemId");
		return List<SqlRow> rawRows = items.findList();
   }

   public static int getNumLikesItem(long itemID){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = true AND ShopperLikeItem.item.itemId = " + itemID + " ORDER BY ShopperLikeItem.item.itemId");
   		return likes.findCount();

   }


   public static int getNumDisLikesItem(long itemID){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = false AND ShopperLikeItem.item.itemId = " + itemID + " ORDER BY ShopperLikeItem.item.itemId");
   		return likes.findCount();

   }

      public static int getNumLikesCategory(String category){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = true AND ShopperLikeItem.item.category = " + category + " ORDER BY ShopperLikeItem.item.itemId");
   		return likes.findCount();

   }


   public static int getNumDisLikesCategory(String category){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = false AND ShopperLikeItem.item.category = " + category + " ORDER BY ShopperLikeItem.item.itemId");
   		return likes.findCount();

   }
public static int getNumLikesShopper(String username){
   		SqlQuery likes = Ebean.createSqlQuery(
                    "SELECT * FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = true AND ShopperLikeItem.shopper.username = " + username +" ORDER BY ShopperLikeItem.item.itemId");
   		return likes.findCount();

   }


   public static int getNumLikesMerchantItem(String name, long itemId){
   		SqlQuery likes =  Ebean.createSqlQuery(
                    "SELECT * FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = true AND ShopperLikeItem.item.merchant.name = " + name +"AND ShopperLikeItem.item.itemId = " + itemID+  +" ORDER BY ShopperLikeItem.item.itemId");
   		return likes.findCount();
   }


      public static int getNumLikesMerchantItemCategory(String name, long itemId, String category)){
   		SqlQuery likes =  Ebean.createSqlQuery(
                    "SELECT * FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = true AND ShopperLikeItem.item.merchant.name = " + name +"AND ShopperLikeItem.item.itemId = " + itemID+ "AND ShopperLikeItem.item.category = " + category+" ORDER BY ShopperLikeItem.item.itemId");
   		return likes.findCount();
   }

   public static int getNumLikesMerchant(String name){
   		SqlQuery likes =  Ebean.createSqlQuery(
                    "SELECT * FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = true AND ShopperLikeItem.item.merchant.name = " + name +" ORDER BY ShopperLikeItem.item.itemId");
   		return likes.findCount();
   }


   public static int getNumDisLikesMerchant(String name){
   		SqlQuery likes =  Ebean.createSqlQuery(
                    "SELECT * FROM ShopperLikeItem WHERE ShopperLikeItem.didLike = false AND ShopperLikeItem.item.merchant.name = " + name +" ORDER BY ShopperLikeItem.item.itemId");
   		return likes.findCount();
   }
	

}

s h