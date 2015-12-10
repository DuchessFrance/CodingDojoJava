package fr.duchess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

public class FruitShop {

    private int total;

    private Map<Fruit, Integer> fruitQuantity ;

    public FruitShop() {
        fruitQuantity = new HashMap<>();
        fruitQuantity.put(Fruit.BANANES,0);
        fruitQuantity.put(Fruit.CERISES,0);
        fruitQuantity.put(Fruit.POMMES,0);
        fruitQuantity.put(Fruit.MELE,0);
        fruitQuantity.put(Fruit.APPLES,0);
    }

    public static void main (String args[]){

        FruitShop fruitShop = new FruitShop();

        BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));

        try {

            while (true){

                final String myFruit = entree.readLine();
                fruitShop.addFruit(myFruit);
                System.out.print(" > "+ fruitShop.getTotal()+ "\n");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: "+e.getMessage());
        }

    }

    public int getTotal() {
        return total;
    }

    public void addFruit(String fruit) {

        final Optional<Fruit> optionalFruit = Fruit.getFruit(fruit.toUpperCase());

        if(optionalFruit.isPresent()){

            final Fruit myFruit = optionalFruit.get();
            total += myFruit.getPrice();

            fruitQuantity.merge(myFruit, 1, Integer::sum);

            total -= myFruit.getDiscount(fruitQuantity.get(myFruit));
        }
    }

    public void addFruits(String fruits) {
        String[] myFruits = fruits.split(",");
        for (String myFruit : myFruits) {
            addFruit(myFruit.trim());
        }
    }
}
