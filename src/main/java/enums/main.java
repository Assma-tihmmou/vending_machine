package enums;

import exceptions.NotSufficientNumberOfCoinsException;
import models.Request;
import models.VendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class main {
    static VendingMachine vendingMachine;

    public static void main(String[] args) throws NotSufficientNumberOfCoinsException {
/*
     String s="";




        HashMap<Products,Integer> myProducts = new HashMap<>();
        myProducts.put(Products.KITKAT,10);
        myProducts.put(Products.MILKA,20);
        HashMap<Coins,Integer> myCoins = new HashMap<>();
        myCoins.put(Coins.FIVE_DIRHAMS,5);
        myCoins.put(Coins.TEN_DIRHAMS,20);
        vendingMachine=new VendingMachine();
        //vendingMachine.addCoins(Coins.FIVE_DIRHAMS,5);
        vendingMachine.addProduct(Products.KITKAT,5);
        System.out.println(vendingMachine.getProductsWithStock());*/

        vendingMachine= new VendingMachine();
        List<Coins> coins = new ArrayList<>();
        coins.add(Coins.FIVE_DIRHAMS);
        coins.add(Coins.FIVE_DIRHAMS);
       // vendingMachine.addCoins(c);
        vendingMachine.addCoins(Coins.FIVE_DIRHAMS,10);
        Request request = new Request("345",coins);
        vendingMachine.sendRequest(request);
        HashMap<Coins,Integer> coinsToChange=vendingMachine.getChange();
        System.out.println(coinsToChange);

    }





}
