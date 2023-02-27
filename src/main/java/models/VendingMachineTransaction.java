package models;

import enums.Coins;
import enums.Products;
import exceptions.NotSufficientNumberOfCoinsException;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class VendingMachineTransaction {

    public VendingMachine vendingMachine;

    public VendingMachineTransaction(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void getRequest(Request request) throws NotSufficientNumberOfCoinsException {
        Products selectedProduct = null;
        if (!request.isHasCanceled()) {
            selectedProduct = getProduct(request.getIdProduct());

           if (request.getAmount() >= selectedProduct.getPrice())
                getChange(selectedProduct.getPrice(), request.getAmount());

            vendingMachine.dispenseProduct(selectedProduct);
            vendingMachine.updateStock(selectedProduct);
        }
    }

    private void getChange(double price, double amount) throws NotSufficientNumberOfCoinsException {
        double change = amount - price;
        HashMap<Coins, Integer> coinsToChange = new HashMap<>();

        for (Coins coins : Coins.values()) {
            if (change > coins.getCoinsNumber() && vendingMachine.getCoinsWithStock().get(coins)>0  ) {
                coinsToChange.put(coins, (int) change /coins.getCoinsNumber());
                change = change % coins.getCoinsNumber();
            }
        }
        if(machineHasCoins(coinsToChange)){
            vendingMachine.dispenseChange(coinsToChange);
            vendingMachine.updateCoinsStock(coinsToChange);
        }
        else{
            throw new NotSufficientNumberOfCoinsException("Not Sufficient Number Of Coins Exception");
        }
    }


    public Products getProduct(String idProduct){
            Products selectedProduct = null;
            for (Products product : Products.values()) {
                if (product.getId() == idProduct) {
                    selectedProduct = product;
                }
            }
            return selectedProduct;
        }

    public boolean machineHasCoins(HashMap<Coins, Integer> coinsToChange) {
        AtomicBoolean flag= new AtomicBoolean(true);
        coinsToChange.forEach((key, value) -> {
            if (vendingMachine.getCoinsWithStock().get(key) < value)
                flag.set(false);
        });
        return flag.get();
    }
}
