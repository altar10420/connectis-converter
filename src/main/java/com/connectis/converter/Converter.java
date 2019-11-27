package com.connectis.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.commons.lang3.StringUtils;

public abstract class Converter {

    private final BigDecimal LENGTH_METER_FOOT_FACTOR;
    private final BigDecimal LENGTH_CENTIMETER_INCH_FACTOR;
    private final BigDecimal VOLUME_LITER_GALLON_FACTOR;
    private final BigDecimal WEIGHT_KILOGRAM_POUND_FACTOR ;
    private final BigDecimal TEMP_CELSIUS_FAHRENHEIT_FACTOR;


    public static final String SUCCESSFULLY_CONVERTED_MESSAGE = "Converted value is: ";
    private static final String ENTER_NUMBER_INSTEAD = "Please enter a number instead";

    public Converter(double LENGTH_METER_FOOT_FACTOR,
                     double LENGTH_CENTIMETER_INCH_FACTOR,
                     double VOLUME_LITER_GALLON_FACTOR,
                     double WEIGHT_KILOGRAM_POUND_FACTOR,
                     double TEMP_CELSIUS_FAHRENHEIT_FACTOR) {

        this.LENGTH_METER_FOOT_FACTOR = new BigDecimal(LENGTH_METER_FOOT_FACTOR).setScale(3, RoundingMode.HALF_UP);
        this.LENGTH_CENTIMETER_INCH_FACTOR = new BigDecimal(LENGTH_CENTIMETER_INCH_FACTOR).setScale(3, RoundingMode.HALF_UP);
        this.VOLUME_LITER_GALLON_FACTOR = new BigDecimal(VOLUME_LITER_GALLON_FACTOR).setScale(3, RoundingMode.HALF_UP);
        this.WEIGHT_KILOGRAM_POUND_FACTOR = new BigDecimal(WEIGHT_KILOGRAM_POUND_FACTOR).setScale(3, RoundingMode.HALF_UP);
        this.TEMP_CELSIUS_FAHRENHEIT_FACTOR = new BigDecimal(TEMP_CELSIUS_FAHRENHEIT_FACTOR).setScale(3, RoundingMode.HALF_UP);


    }

    public String convertMeterFoot(String input) {
        if (!StringUtils.isNumeric(input)) {
            return ENTER_NUMBER_INSTEAD;
        }

            return SUCCESSFULLY_CONVERTED_MESSAGE +
                    new BigDecimal(input).multiply(LENGTH_METER_FOOT_FACTOR).toString();
    }

    public String convertCentimeterInch(String input) {
        if (!StringUtils.isNumeric(input)) {
            return ENTER_NUMBER_INSTEAD;
        }

        return SUCCESSFULLY_CONVERTED_MESSAGE +
                new BigDecimal(input).multiply(LENGTH_CENTIMETER_INCH_FACTOR).toString();
    }

    public String convertLiterGallon(String input) {
        if (!StringUtils.isNumeric(input)) {
            return ENTER_NUMBER_INSTEAD;
        }

        return SUCCESSFULLY_CONVERTED_MESSAGE +
                new BigDecimal(input).multiply(VOLUME_LITER_GALLON_FACTOR).toString();
    }

    public String convertKilogramPound(String input) {
        if (!StringUtils.isNumeric(input)) {
            return ENTER_NUMBER_INSTEAD;
        }

        return SUCCESSFULLY_CONVERTED_MESSAGE +
                new BigDecimal(input).multiply(WEIGHT_KILOGRAM_POUND_FACTOR).toString();
    }

    public String convertCelsiusFahrenheit(String input) {
        if (!StringUtils.isNumeric(input)) {
            return ENTER_NUMBER_INSTEAD;
        }

        return SUCCESSFULLY_CONVERTED_MESSAGE +
                new BigDecimal(input).multiply(TEMP_CELSIUS_FAHRENHEIT_FACTOR).toString();
    }

}
