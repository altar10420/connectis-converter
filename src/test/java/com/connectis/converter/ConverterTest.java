package com.connectis.converter;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConverterTest {

    public Converter metricToImperialConverter;
    public Converter imperialToMetricConverter;

    public static final String SUCCESSFULLY_CONVERTED_MESSAGE = "Converted value is: ";
    public static final String WRONG_INPUT = "Please enter a positive number instead";

    private static final double LENGTH_METER_FOOT_FACTOR = 1/0.3048;
    private static final double LENGTH_CENTIMETER_INCH_FACTOR = 1/2.54;
    private static final double VOLUME_LITER_GALLON_FACTOR = 1/4.54609;
    private static final double WEIGHT_KILOGRAM_POUND_FACTOR = 1/0.45359237;


    @BeforeEach
    void setUp() {
        metricToImperialConverter = new MetricToImperialConverter();
    }


    @Test
    public void convertMeterFoot_givenLiteralInputShouldReturnWrongInput() {

        String message = metricToImperialConverter.convertMeterFoot("abc");
        Assertions.assertEquals(WRONG_INPUT, message);
    }

    @Test
    public void convertMeterFoot_givenNegativeNumberShouldReturnWrongInput() {

        String message = metricToImperialConverter.convertMeterFoot("-123");
        Assertions.assertEquals(WRONG_INPUT, message);
    }

    @Test
    public void convertMeterFoot_givenInputOneMeterShouldReturnExpectedFootValue() {

        String result = metricToImperialConverter.convertMeterFoot("1");
        String expected = "Converted value is: " + 3.2808;
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void convertCelsiusFahrenheit_givenLessThanRangeShouldReturnWrongInput() {
        String result = metricToImperialConverter.convertCelsiusFahrenheit("9999999");
        String expected = "Wrong input. Please try again.";
        Assertions.assertEquals(expected, result);
    }
}
