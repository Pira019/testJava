package pira_exercice.java_Junit01.converter;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class ConverterUtilTest {

	 int[][] celsiusFahrenheitMapping = new int[][] { { 10, 50 }, { 40, 104 }, { 0, 32 } };

	    @TestFactory
	    Stream<DynamicTest> ensureThatCelsiumConvertsToFahrenheit() {
	    	
	        return Arrays.stream(celsiusFahrenheitMapping).map(entry -> {
	            // access celcius and fahrenheit from entry
	            int celsius = entry[0];
	            int fahrenheit = entry[1];
	           
	            return dynamicTest(celsius +"  Celsius are  "+ fahrenheit, () -> { assertEquals(fahrenheit,ConverterUtil.convertCelsiusToFahrenheit(celsius));});
	         //   return null;
	            // return a dynamicTest which checks that that the convertion from celcius to
	            // fahrenheit is correct
	        });

	    }

	    @TestFactory
	     public Stream<DynamicTest> ensureThatFahrenheitConvertsToCelsius() {
	    	
	    	   // TODO Write a similar test fahrenheit to celsius
	         ConverterUtil converter = new ConverterUtil();
	            int[][] data = new int[][] { { 10,50 }, { 40, 104}, { 0, 32 } };
	            return Arrays.stream(data).map(entry -> {
	                int celsius = entry[0];
	                int fahrenheit = entry[1];
	                return dynamicTest(celsius + " Celsius are " + fahrenheit, () -> {
	                    assertEquals(celsius, converter.convertFahrenheitToCelsius(fahrenheit));
	                });
	            });
	        }

}
