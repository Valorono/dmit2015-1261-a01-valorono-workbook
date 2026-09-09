package dmit2015.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.within;

class ProductTest {

    @Test
    void getName_whenProductCreated_shouldReturnCorrectName() {
        // Arrange
        Product currentProduct = new Product("Laptop", 1200, 5);
        // Act
        String actualName = currentProduct.getName();
        // Assert
        assertThat(actualName)
                .isEqualTo("Laptop");

    }

    @Test
    void getPrice_whenProductCreated_shouldReturnCorrectPrice() {
        // Arrange
        Product currentProduct = new Product("Laptop", 1200, 5);
        // Act
        double actualPrice = currentProduct.getPrice();
        // Assert
        assertThat(actualPrice)
                .isEqualTo(1200);

    }

    @Test
    void getPrice_whenProductCreated_shouldReturnCorrectPriceWithTax () {
        // Arrange
        Product currentProduct = new Product("Laptop", 1200, 5);
        // Act
        double actualPrice = currentProduct.getPriceWithTax();
        // Assert
        assertThat(actualPrice)
                .isCloseTo(1260, within(0.01));
    }

    @Test
    void constructor_whenNameIsNull_shouldThrowException () {
        assertThatThrownBy(() ->
                new Product(null, 100, 5)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_whenNameIsBlank_shouldThrowException () {
        assertThatThrownBy(() ->
                new Product("", 100, 5)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_whenNameIsWhiteSpace_shouldThrowException () {
        assertThatThrownBy(() ->
                new Product(" ", 100, 5)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_whenPriceIsZero_shouldThrowException() {
        assertThatThrownBy(() ->
                new Book("Invalid Price", 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_whenPriceIsNegative_shouldThrowException() {
        assertThatThrownBy(() ->
                new Book("Invalid Price", -5)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getInventoryValue_whenProductIsCreated_shouldReturnQuantity() {
        // Arrange
        Product currentProduct = new Product("Laptop", 1200, 5);
        // Act
        int actualInventoryValue = currentProduct.getInventoryValue();
        // Assert
        assertThat(actualInventoryValue)
                .isEqualTo(6000);
    }


}