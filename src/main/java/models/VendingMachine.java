package models;

import enums.Coins;
import enums.Products;
import exceptions.NotSufficientNumberOfCoinsException;
import exceptions.RequestInappropriateCoinsException;

import java.util.HashMap;

public class VendingMachine {

    private HashMap<Coins, Integer> coinsWithStock;
    private HashMap<Products,Integer> productsWithStock;
    private VendingMachineTransaction vendingMachineTransaction=new VendingMachineTransaction(this);
    private Products selectProduct;
    private HashMap<Coins,Integer> coinsToChange;

    public VendingMachine() {
        productsWithStock=new HashMap<>();
        coinsWithStock=new HashMap<>();
        for(Products product:Products.values()){
            this.productsWithStock.put(product,0);
        }
        for(Coins coin : Coins.values()){
            this.coinsWithStock.put(coin,0);
        }
    }

    public void addProduct(Products product, int quantity){
       this.productsWithStock.replace(product,quantity);
    }

    public void addCoins(Coins coin, int number){
        this.coinsWithStock.replace(coin,number);
    }


    public HashMap<Coins, Integer> getCoinsWithStock() {
        return coinsWithStock;
    }

    public HashMap<Products, Integer> getProductsWithStock() {
        return productsWithStock;
    }


    public String displayProducts(){
        String s= "Welcome, You Select One Of This Product \n" +
                  "ProductId ---------ProductName  ------------   ProductPrice \n ";
       for(Products product: Products.values()){
           if(productsWithStock.get(product)>0){
            s+=product.getId()+"---------"+
                    product.getLibel()+"-----------  "+product.getPrice();
         }
      }    return s;
    }

     public void cancelRequest(Request request){
        request.setHasCanceled(true);
    }

    public void sendRequest(Request request) throws NotSufficientNumberOfCoinsException {
            vendingMachineTransaction.getRequest(request);
    }

    public Products dispenseProduct(){
        return selectProduct;
    }
    public HashMap<Coins,Integer> getChange(){
        return
            this.coinsToChange;}



    public void updateStock(Products product) {
        int quantity = productsWithStock.get(product);
        productsWithStock.replace(product,++quantity);
    }

    public void dispenseProduct(Products selectedProduct) {
        this.selectProduct=selectedProduct;
    }


    public void dispenseChange(HashMap<Coins, Integer> coinsToChange) {
        this.coinsToChange=coinsToChange;
    }

    public void updateCoinsStock(HashMap<Coins, Integer> coinsToChange) {
        coinsToChange.forEach((key,value)->{
            coinsWithStock.replace(key,coinsWithStock.get(key)-value);
        });
    }

    public VendingMachine resetMachine(){
         return new VendingMachine();
    }


}
