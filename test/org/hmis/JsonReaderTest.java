package org.hmis;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JsonReaderTest {

	@ParameterizedTest (name = "{index} => transformar({0})")
	@CsvSource({"data/coches.json"})
	void testLeerCochesJSON(String ruta) throws Exception {
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals (4, coches.length);
	}

	@ParameterizedTest (name = "{index} => transformar({0})")
	@CsvSource({ "data/coches.json, Toyota, Corolla, 2022, 22000" })
	void testLeerCochesJSONprimero(String ruta, String marca, String modelo, String anno, String precio){
		Coche primero = new Coche (marca, modelo, Integer.parseInt(anno), Integer.parseInt(precio));
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(primero, coches[0]);
		assertTrue (primero.equals(coches[0]));
		assertTrue (coches[0].equals(primero));
	}
	
	@Test
    void testLeerCochesJSONExcepcion() {
        String ruta = "ruta/incorrecta"; // Proporciona una ruta incorrecta para provocar una excepción
        Coche [] coches = JsonReader.leerCochesJSON(ruta);
        assertNull(coches);
    }
	
	@Test
    void incializacion() {
        JsonReader aux = new JsonReader();
        assertNotNull(aux);
    }


}