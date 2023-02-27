import enums.Coins;
import enums.Products;
import exceptions.NotSufficientNumberOfCoinsException;
import models.Request;
import models.VendingMachine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    public static VendingMachine vendingMachine;
    public static HashMap<Products,Integer> myProducts;
    public static HashMap<Coins,Integer> myCoins;


    @BeforeAll
    public static void setUp(){
      vendingMachine= new VendingMachine( );
    }


    @Test
    public void givenOneProductToAdd_whenAddProduct_thenDisplayOneProduct(){
            vendingMachine.addProduct(Products.KITKAT,10);
           assertEquals("Welcome, You Select One Of This Product \n" +
                   "ProductId ---------ProductName  ------------   ProductPrice \n" +
                   " 345---------Kitkat-----------  5.0" +
                   "",vendingMachine.displayProducts());
    }

    @Test
    public void givenOneProductToAdd_whenAddProduct_thenUpdateQuantity(){
        vendingMachine.addProduct(Products.KITKAT,5);
       assertEquals(5,vendingMachine.getProductsWithStock().get(Products.KITKAT));
    }

    @Test
    public void givenCoinsToAdd_whenAddCoins_thenUpdateNumberOfCoins(){
        vendingMachine.addCoins(Coins.FIVE_DIRHAMS,10);
        assertEquals(10,vendingMachine.getCoinsWithStock().get(Coins.FIVE_DIRHAMS));

    }

    @Test
    public void givenRequest_whenSendRequest_thenGetProduct() throws NotSufficientNumberOfCoinsException {
        List<Coins> coins = new ArrayList<>();
        coins.add(Coins.TEN_DIRHAMS);
        Request request = new Request("345",coins);
        vendingMachine.sendRequest(request);
        assertEquals(Products.KITKAT,vendingMachine.dispenseProduct());

    }
@Test
    public void givenRequest_whenSendRequest_thenGetChange() throws NotSufficientNumberOfCoinsException {
        vendingMachine= new VendingMachine();
        List<Coins> coins = new ArrayList<>();
        coins.add(Coins.FIVE_DIRHAMS);
        coins.add(Coins.FIVE_DIRHAMS);
        vendingMachine.addCoins(Coins.FIVE_DIRHAMS,10);
        Request request = new Request("345",coins);
        vendingMachine.sendRequest(request);
        HashMap<Coins,Integer> coinsToChange=vendingMachine.getChange();
        assertEquals(3,coinsToChange.get(Coins.FIVE_DIRHAMS) );

    }










}
