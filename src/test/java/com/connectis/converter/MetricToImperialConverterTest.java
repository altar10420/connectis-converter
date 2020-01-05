package com.connectis.converter;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MetricToImperialConverterTest {

    public MetricToImperialConverter metricToImperialConverter;

    private static final String WRONG_INPUT_LESS_THAN_ZERO = "Please enter a positive number instead.";
    private static final String WRONG_INPUT_TEMP_OUT_OF_RANGE = "Please enter temperature in range of -273.15 to 726.85.";
    private static final String WRONG_INPUT_NUMBER_OUT_OF_RANGE = "Please enter number in range of -999999 to 999999";


    @BeforeEach
    void setUp() {
        metricToImperialConverter = new MetricToImperialConverter();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:33.8", "-1:30.2", "0:32"}, delimiter = ':')
    public void convertCelsiusFahrenheit_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = metricToImperialConverter.convertCelsiusFahrenheit(input);
        Assertions.assertEquals(expected, convertedValue);
    }


    @ParameterizedTest
    @ValueSource(strings = {"abc", "1,234", " ", "", "@#$%!.,?"})
    public void convertCelsiusFahrenheit_givenNonNumericInputOrWrongSeparatorShouldThrowNFException(String input) {

        Assertions.assertThrows(NumberFormatException.class, () ->
                {metricToImperialConverter.convertCelsiusFahrenheit(Double.parseDouble(input));});
    }

    @ParameterizedTest
    @ValueSource(strings = {"-273.16", "726.86"})
    public void convertCelsiusFahrenheit_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                {metricToImperialConverter.convertCelsiusFahrenheit(input);}, WRONG_INPUT_TEMP_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"4.54609:1", "0:0"}, delimiter = ':')
    public void convertLiterGallon_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = metricToImperialConverter.convertLiterGallon(input);
        Assertions.assertEquals(expected, convertedValue);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -10, -1000})
    public void convertLiterGallon_givenLessThanZeroShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {metricToImperialConverter.convertLiterGallon(input);}, WRONG_INPUT_LESS_THAN_ZERO);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000000, 1000000})
    public void convertLiterGallon_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {metricToImperialConverter.convertLiterGallon(input);}, WRONG_INPUT_NUMBER_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"2.54:1", "0:0"}, delimiter = ':')
    public void convertCentimeterInch_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = metricToImperialConverter.convertCentimeterInch(input);
        Assertions.assertEquals(expected, convertedValue);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000000, 1000000})
    public void convertCentimeterInch_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {metricToImperialConverter.convertCentimeterInch(input);}, WRONG_INPUT_NUMBER_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"0.3048:1", "0:0"}, delimiter = ':')
    public void convertMeterFoot_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = metricToImperialConverter.convertMeterFoot(input);
        Assertions.assertEquals(expected, convertedValue);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000000, 1000000})
    public void convertMeterFoot_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {metricToImperialConverter.convertMeterFoot(input);}, WRONG_INPUT_NUMBER_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"0.45359237:1", "0:0"}, delimiter = ':')
    public void convertKilogramPound_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = metricToImperialConverter.convertKilogramPound(input);
        Assertions.assertEquals(expected, convertedValue);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000000, 1000000})
    public void convertKilogramPound_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {metricToImperialConverter.convertKilogramPound(input);}, WRONG_INPUT_NUMBER_OUT_OF_RANGE);
    }

}
