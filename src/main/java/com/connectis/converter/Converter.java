package com.connectis.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Converter {

    private final BigDecimal LENGTH_METER_FOOT_FACTOR;
    private final BigDecimal LENGTH_CENTIMETER_INCH_FACTOR;
    private final BigDecimal VOLUME_LITER_GALLON_FACTOR;
    private final BigDecimal WEIGHT_KILOGRAM_POUND_FACTOR ;


    public static final String SUCCESSFULLY_CONVERTED_MESSAGE = "Converted value is: ";
    public static final String WRONG_INPUT_LETTERS_OR_NEGATIVE = "Please enter a positive number instead";
    public static final String WRONG_INPUT_LETTERS_OR_OUT_OF_RANGE = "Wrong input. Please try again.";


    public Converter(double LENGTH_METER_FOOT_FACTOR,
                     double LENGTH_CENTIMETER_INCH_FACTOR,
                     double VOLUME_LITER_GALLON_FACTOR,
                     double WEIGHT_KILOGRAM_POUND_FACTOR) {

        this.LENGTH_METER_FOOT_FACTOR = new BigDecimal(LENGTH_METER_FOOT_FACTOR).setScale(4, RoundingMode.HALF_UP);
        this.LENGTH_CENTIMETER_INCH_FACTOR = new BigDecimal(LENGTH_CENTIMETER_INCH_FACTOR).setScale(4, RoundingMode.HALF_UP);
        this.VOLUME_LITER_GALLON_FACTOR = new BigDecimal(VOLUME_LITER_GALLON_FACTOR).setScale(4, RoundingMode.HALF_UP);
        this.WEIGHT_KILOGRAM_POUND_FACTOR = new BigDecimal(WEIGHT_KILOGRAM_POUND_FACTOR).setScale(4, RoundingMode.HALF_UP);

    }

    public String convertMeterFoot(String input) {
        if (!this.isInputPositiveNumeric(input)) {
            return WRONG_INPUT_LETTERS_OR_NEGATIVE;
        }

            return SUCCESSFULLY_CONVERTED_MESSAGE +
                    new BigDecimal(input).multiply(LENGTH_METER_FOOT_FACTOR).toString();
    }

    public String convertCentimeterInch(String input) {
        if (!this.isInputPositiveNumeric(input)) {
            return WRONG_INPUT_LETTERS_OR_NEGATIVE;
        }

        return SUCCESSFULLY_CONVERTED_MESSAGE +
                new BigDecimal(input).multiply(LENGTH_CENTIMETER_INCH_FACTOR).toString();
    }

    public String convertLiterGallon(String input) {
        if (!this.isInputPositiveNumeric(input)) {
            return WRONG_INPUT_LETTERS_OR_NEGATIVE;
        }

        return SUCCESSFULLY_CONVERTED_MESSAGE +
                new BigDecimal(input).multiply(VOLUME_LITER_GALLON_FACTOR).toString();
    }

    public String convertKilogramPound(String input) {
        if (!this.isInputPositiveNumeric(input)) {
            return WRONG_INPUT_LETTERS_OR_NEGATIVE;
        }

        return SUCCESSFULLY_CONVERTED_MESSAGE +
                new BigDecimal(input).multiply(WEIGHT_KILOGRAM_POUND_FACTOR).toString();
    }

    public abstract String convertCelsiusFahrenheit(String input);

    public boolean isInputPositiveNumeric(String input) {
        try {
            double numberCheck = Double.parseDouble(input);
            if (!(numberCheck >= 0)) {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isInputNumeric(String input) {
        try {
            double numberCheck = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
