package com.gfs.vendingmachine;

import java.util.List;

class Main {

    public static void main(String[] args) {

        VendingMachine vendingMachine = VendingMachineFactory.createVendingMachine();

        /**
         * 1.
         * You try to buy a shasta and you get an error.
         * Fix the error so you can buy a shasta.
         */
        System.out.println("Shasta costs: $0." + vendingMachine.selectItemAndGetPrice(Item.SHASTA));

        /**
         * 2.
         * You selected a Pepsi.  It is $0.35.  You put in $0.50.  You get your Pepsi
         * but you get the wrong change.  Can you fix it so you get the right change?
         *
         */
        System.out.println("Pepsi costs: $0." + vendingMachine.selectItemAndGetPrice(Item.PEPSI));
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);

        System.out.println("You have inserted: $0." + vendingMachine.getCurrentBalance());
        Bucket<Item, List<Coin>> bucket = vendingMachine.collectItemAndChange();

        System.out.println("You have chosen a " + bucket.getFirst() + " and your change is ");
        for (Coin coin : bucket.getSecond()) {
            System.out.println(coin);
        }

        /**
         * 3.
         * After buying the Pepsi, the total sales should be $0.35
         *
         */
        System.out.println("Total Sales: $0." + vendingMachine.getTotalSales());

    }

}
