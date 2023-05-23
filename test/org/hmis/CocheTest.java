package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CocheTest {

    @Test
    void testEqualsObject() {
        Coche c = new Coche();   // Arrange
        assertTrue(c.equals(c));  // Action // Assert
    }

    @Test
    void testEqualsObjectNull() {
        Coche c = new Coche();   // Arrange
        assertFalse(c.equals(null));  // Action // Assert
    }

    @Test
    void testEqualsObjectString() {
        Coche c = new Coche();   // Arrange
        assertFalse(c.equals(""));  // Action // Assert
    }

    @ParameterizedTest
    @MethodSource("cochesProvider")
    void testEqualsObjectMultiple(Coche primero, Coche segundo, boolean expected) {
        assertEquals(expected, primero.equals(segundo));  // Action // Assert
    }

    static Stream<Object[]> cochesProvider() {
        Coche primero = new Coche("Toyota", "Corolla", 2022, 22000);
        Coche segundo = new Coche("Toyota", "Corolla", 2022, 22000);
        Coche tercero = new Coche("Toyota", "Corolla", 2023, 22000);
        Coche cuarto = new Coche("Nissan", "Corolla", 2022, 22000);
        Coche quinto = new Coche("Toyota", "Auris", 2022, 22000);
        Coche sexto = new Coche("Toyota", "Corolla", 2022, 32000);

        return Stream.of(
                new Object[]{primero, primero, true},
                new Object[]{primero, segundo, true},
                new Object[]{primero, tercero, false},
                new Object[]{primero, cuarto, false},
                new Object[]{primero, quinto, false},
                new Object[]{primero, sexto, false}
        );
    }

    @ParameterizedTest
    @MethodSource("cochesProvider")
    void testGetterAndSetter(Coche coche) {
        coche.setMarca("Toyota");  // Set marca
        coche.setModelo("Corolla");  // Set modelo
        coche.setAño(2022);  // Set año
        coche.setPrecio(22000);  // Set precio

        assertEquals("Toyota", coche.getMarca());  // Assert marca
        assertEquals("Corolla", coche.getModelo());  // Assert modelo
        assertEquals(2022, coche.getAño());  // Assert año
        assertEquals(22000, coche.getPrecio());  // Assert precio
    }

    @Test
    void testToString() {
        Coche c = new Coche("Toyota", "Corolla", 2022, 22000);   // Arrange
        String expected = "Coche [marca=Toyota, modelo=Corolla, año=2022, precio=22000]";  // Expected result
        assertEquals(expected, c.toString());  // Action // Assert
    }
}
