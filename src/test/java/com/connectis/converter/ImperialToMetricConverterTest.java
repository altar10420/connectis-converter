package com.connectis.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ImperialToMetricConverterTest {

    public ImperialToMetricConverter imperialToMetricConverter;

    private static final String WRONG_INPUT_LESS_THAN_ZERO = "Please enter a positive number instead.";
    private static final String WRONG_INPUT_NUMBER_OUT_OF_RANGE = "Please enter number in range of -999999 to 999999";
    private static final String WRONG_INPUT_TEMP_OUT_OF_RANGE = "Please enter temperature in range of -459.67 to 1340.33.";


    @BeforeEach
    void setUp() {
        imperialToMetricConverter = new ImperialToMetricConverter();
    }

    @ParameterizedTest
    @CsvSource(value = {"32:0"}, delimiter = ':')
    public void convertFahrenheitCelsius_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = imperialToMetricConverter.convertFahrenheitCelsius(input);
        Assertions.assertEquals(expected, convertedValue);
    }


    @ParameterizedTest
    @ValueSource(strings = {"abc", "1,234", " ", "", "@#$%!.,?"})
    public void convertFahrenheitCelsius_givenNonNumericInputOrWrongSeparatorShouldThrowNFException(String input) {

        Assertions.assertThrows(NumberFormatException.class, () ->
                {imperialToMetricConverter.convertFahrenheitCelsius(Double.parseDouble(input));});
    }

    @ParameterizedTest
    @ValueSource(strings = {"-459.68", "1340.34"})
    public void convertFahrenheitCelsius_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                {imperialToMetricConverter.convertFahrenheitCelsius(input);}, WRONG_INPUT_TEMP_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:4.54609", "0:0"}, delimiter = ':')
    public void convertGallonLiter_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = imperialToMetricConverter.convertGallonLiter(input);
        Assertions.assertEquals(expected, convertedValue);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -10, -1000})
    public void convertGallonLiter_givenLessThanZeroShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {imperialToMetricConverter.convertGallonLiter(input);}, WRONG_INPUT_LESS_THAN_ZERO);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000000, 1000000})
    public void convertGallonLiter_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {imperialToMetricConverter.convertGallonLiter(input);}, WRONG_INPUT_NUMBER_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2.54", "0:0"}, delimiter = ':')
    public void convertInchCentimeter_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = imperialToMetricConverter.convertInchCentimeter(input);
        Assertions.assertEquals(expected, convertedValue);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000000, 1000000})
    public void convertInchCentimeter_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {imperialToMetricConverter.convertInchCentimeter(input);}, WRONG_INPUT_NUMBER_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0.3048", "0:0"}, delimiter = ':')
    public void convertFootMeter_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = imperialToMetricConverter.convertFootMeter(input);
        Assertions.assertEquals(expected, convertedValue);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000000, 1000000})
    public void convertFootMeter_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {imperialToMetricConverter.convertFootMeter(input);}, WRONG_INPUT_NUMBER_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0.45359237", "0:0"}, delimiter = ':')
    public void convertPoundKilogram_givenCorrectInputShouldReturnExpectedValues(double input, double expected) {

        double convertedValue = imperialToMetricConverter.convertPoundKilogram(input);
        Assertions.assertEquals(expected, convertedValue);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000000, 1000000})
    public void convertPoundKilogram_givenOutOfRangeInputShouldTrowIllegalArgumentException(double input) {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {imperialToMetricConverter.convertPoundKilogram(input);}, WRONG_INPUT_NUMBER_OUT_OF_RANGE);
    }

}