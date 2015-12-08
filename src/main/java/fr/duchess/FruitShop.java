package fr.duchess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FruitShop {

    public static final String POMMES = "pommes";
    public static final String CERISES = "cerises";
    public static final String BANANES = "bananes";
    public static final String APPLES = "apples";
    public static final String MELE = "mele";
    public static final int CHERRY_DISCOUNT = 20;
    public static final int APPLES_PRICE = 100;
    public static final int MELE_DISCOUNT = 50;

    private int total = 0;

    private int nbCerises = 0;
    private int nbBananes = 0;
    private int nbPommes = 0;
    private int nbMeles = 0;

    public int getTotal() {
        return total;
    }

    public void addApple() {
        nbPommes++;

        //Case discount for 3 apples, one offered
        if(nbPommes == 3){
            nbPommes = 0;
        }else{
            total += APPLES_PRICE;
        }
    }

    public void addMele() {
        total += APPLES_PRICE;
        nbMeles ++;

        //Case of two Meles, 50 discount
        if(nbMeles == 2){
            total -= MELE_DISCOUNT;
            nbMeles = 0;
        }
    }

    public void addCherry() {
        total += 75;
        nbCerises++;

        //Case discount for two cherries
        if(nbCerises == 2){
            total -= CHERRY_DISCOUNT;
            nbCerises = 0;

        }
    }
    public void addBanana() {
        nbBananes++;

        //Case discount: offered banana if 2 bought
        if(nbBananes == 2){
            nbBananes = 0;
        }else{
            total += 150;
        }
    }


    public void addAll(String fruits) {
        StringTokenizer tokenizer = new StringTokenizer(fruits, ",");
        while (tokenizer.hasMoreElements()) {
            add(tokenizer.nextToken().trim());
        }
    }

    public void add(String fruit) {
        switch (fruit.toLowerCase()){
            case POMMES : addApple(); break;
            case APPLES: addApple(); break;
            case MELE: addMele(); break;
            case CERISES: addCherry(); break;
            case BANANES: addBanana(); break;
            default: System.out.print(fruit + " is not an existing fruit. Please try again.\n");
        }
    }

    public static void main (String args[]){

        FruitShop fruitShop = new FruitShop();

        BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));

        try {

            while (true){

                final String myFruits = entree.readLine();
                fruitShop.addAll(myFruits);
                System.out.print(" > " + fruitShop.getTotal() + "\n");
            }

        } catch (IOException e) {
            System.out.println("An error occured: "+e.getMessage());
        }

    }

}
