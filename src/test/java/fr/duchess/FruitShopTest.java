package fr.duchess;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitShopTest {

    @Test
    public void should_return_100_when_apples() {
        // Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruit("Pommes");

        // When
        int total = fruitShop.getTotal();

        // Then
        assertThat(total).isEqualTo(100);
    }

    @Test
    public void should_return_150_when_bananes() {
        // Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruit("Bananes");

        // When
        int total = fruitShop.getTotal();

        // Then
        assertThat(total).isEqualTo(150);
    }


    @Test
    public void should_return_75_when_cerises() {
        // Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruit("Cerises");

        // When
        int total = fruitShop.getTotal();

        // Then
        assertThat(total).isEqualTo(75);
    }

    @Test
    public void should_have_20_discount_when_two_cerises(){
        //Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruit("Cerises");
        fruitShop.addFruit("Cerises");

        // When
        int total = fruitShop.getTotal();

        // Then
        assertThat(total).isEqualTo(130);
    }

    @Test
    public void should_return_175_when_apple_and_cherry() {
        // Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruits("pommes,cerises");

        // When
        final int total = fruitShop.getTotal();

        // Then
        assertThat(total).isEqualTo(175);
    }

    @Test
    public void should_get_free_banana_when_2_bought(){
        //Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruit("Bananes");
        fruitShop.addFruit("Bananes");

        //When
        final int total = fruitShop.getTotal();

        //Then
        assertThat(total).isEqualTo(150);
    }

    @Test
    public void should_get_100_when_mele() {
        //Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruit("Mele");

        //When
        final int total = fruitShop.getTotal();

        //Then
        assertThat(total).isEqualTo(100);
    }

    @Test
    public void should_get_100_when_apple() {
        //Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruit("Apple");

        //When
        final int total = fruitShop.getTotal();

        //Then
        assertThat(total).isEqualTo(100);
    }
}
