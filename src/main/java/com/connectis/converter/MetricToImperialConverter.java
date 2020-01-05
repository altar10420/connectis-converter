package com.connectis.converter;


public class MetricToImperialConverter {

    private static final double LENGTH_METER_FOOT_FACTOR = 0.3048;
    private static final double LENGTH_CENTIMETER_INCH_FACTOR = 2.54;
    private static final double VOLUME_LITER_GALLON_FACTOR = 4.54609;
    private static final double WEIGHT_KILOGRAM_POUND_FACTOR = 0.45359237;
    private static final double TEMP_CELSIUS_FAHRENHEIT_FACTOR_MULTIPLIER = 1.8;
    private static final double TEMP_CELSIUS_FAHRENHEIT_FACTOR_ADDITION = 32;

    private static final String WRONG_INPUT_LESS_THAN_ZERO = "Please enter a positive number instead.";
    private static final String WRONG_INPUT_TEMP_OUT_OF_RANGE = "Please enter temperature in range of -273.15 to 726.85.";
    private static final String WRONG_INPUT_NUMBER_OUT_OF_RANGE = "Please enter number in range of -999999 to 999999";


    public double convertCelsiusFahrenheit(double input) {

        if (input < -273.15 || input > 726.85) {
            throw new IllegalArgumentException(WRONG_INPUT_TEMP_OUT_OF_RANGE);
        }

        return (input * TEMP_CELSIUS_FAHRENHEIT_FACTOR_MULTIPLIER)
                + TEMP_CELSIUS_FAHRENHEIT_FACTOR_ADDITION;
    }

    public double convertMeterFoot(double input){

        checkIfOutOfRange(input);

        return input / LENGTH_METER_FOOT_FACTOR;
    }

    public double convertCentimeterInch(double input) {

        checkIfOutOfRange(input);

        return input / LENGTH_CENTIMETER_INCH_FACTOR;
    }

    public double convertLiterGallon(double input) {

        checkIfOutOfRange(input);

        if (input < 0) {
            throw new IllegalArgumentException(WRONG_INPUT_LESS_THAN_ZERO);
        }

        return input / VOLUME_LITER_GALLON_FACTOR;
    }

    public double convertKilogramPound(double input) {

        checkIfOutOfRange(input);

        return input / WEIGHT_KILOGRAM_POUND_FACTOR;
    }

    private void checkIfOutOfRange(double input) {
        if (input < -999999 || input > 999999) {
            throw new IllegalArgumentException(WRONG_INPUT_NUMBER_OUT_OF_RANGE);
        }
    }
}