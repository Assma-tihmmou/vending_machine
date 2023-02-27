package models;

import enums.Coins;
import enums.Products;

import java.util.HashMap;
import java.util.List;

public class Request {

   private String idProduct;
   private boolean HasCanceled=false;
   private List<Coins> requestCoins;
   private double amount;


   public Request(String idProduct, List<Coins> requestCoins) {
      this.idProduct = idProduct;
      this.requestCoins = requestCoins;
   }





   public void setHasCanceled(boolean hasCanceled) {
      HasCanceled = hasCanceled;
   }

   public boolean isHasCanceled() {
      return HasCanceled;
   }



   public String getIdProduct() {
      return idProduct;
   }



   public double getAmount() {
      amount=0;
      for(Coins coin:requestCoins){
         amount+=coin.getCoinsNumber();
      }
      return amount;
   }


}
