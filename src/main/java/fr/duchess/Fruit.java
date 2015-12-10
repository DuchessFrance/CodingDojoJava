package fr.duchess;

import java.util.Optional;
import java.util.stream.Stream;

public enum Fruit {
    POMMES(100,0,0),
    MELE(100,0,0),
    APPLES(100,0,0),
    BANANES(150,2,150),
    CERISES(75,2,20);

    private int price;
    private int discountQuantity;
    private int discountAmount;

    Fruit(int price, int discountQuantity, int discountAmount) {
        this.price = price;
        this.discountQuantity = discountQuantity;
        this.discountAmount = discountAmount;
    }

    Fruit(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount(int quantity){
        if(discountQuantity> 0  && quantity % discountQuantity == 0){
            return discountAmount;
        }
        return 0;
    }

    public static Optional<Fruit> getFruit(final String value) {
        return Stream.of(values()).filter(x -> x.name().equals(value)).findFirst();
    }
}
