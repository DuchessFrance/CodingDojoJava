package fr.duchess;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitShopTest {

    @Test
    public void should_return_0_when_empty_basket() {
        // Given
        FruitShop fruitShop = new FruitShop();

        // When
        int total = fruitShop.getTotal();

        // Then
        assertThat(total).isEqualTo(0);
    }

    @Test
    public void should_return_100_when_apple() {
        // Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addApple();

        // When
        final int total = fruitShop.getTotal();

        // Then
        assertThat(total).isEqualTo(100);
    }

    @Test
    public void should_return_75_when_cherry() {
        // Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addCherry();

        // When
        final int total = fruitShop.getTotal();

        // Then
        assertThat(total).isEqualTo(75);
    }

    @Test
    public void should_return_150_when_banana() {
        // Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addBanana();

        // When
        final int total = fruitShop.getTotal();

        // Then
        assertThat(total).isEqualTo(150);
    }

    @Test
    public void should_return_230_when_apple_and_two_cherries(){
        //Given
        FruitShop fruitShop = new FruitShop();
        fruitShop.addApple();
        fruitShop.addCherry();
        fruitShop.addCherry();

        //When
        final int total = fruitShop.getTotal();

        //Then
        assertThat(total).isEqualTo(230);
    }

    @Test
    public void should_add_apple(){
        //Given
        String apple = "Pommes";
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.add(apple);

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(100);

    }

    @Test
    public void should_add_cherry(){
        //Given
        String cherry = "Cerises";
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.add(cherry);

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(75);

    }

    @Test
    public void should_add_banana(){
        //Given
        String banane = "Bananes";
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.add(banane);

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(150);

    }

    @Test
    public void should_have_20_discount_for_two_cherries(){
        //Given
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.addCherry();
        fruitShop.addCherry();

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(130);
    }

    @Test
    public void should_have_free_second_banana(){
        //Given
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.addBanana();
        fruitShop.addBanana();

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(150);
    }

    @Test
    public void should_return_200_for_three_apples(){
        //Given
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.addApple();
        fruitShop.addApple();
        fruitShop.addApple();

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(200);
    }

    @Test
    public void should_return_150_for_two_meles(){
        //Given
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.add("Mele");
        fruitShop.add("Mele");

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(150);
    }


    @Test
    public void should_return_150_for_two_meles_added_one_time(){
        //Given
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.addAll("Mele, Mele");

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(150);
    }



    @Test
    public void should_return_150_for_two_meles_added_one_time_and_lower_case(){
        //Given
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.addAll("mele, mele");

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(150);
    }
}
