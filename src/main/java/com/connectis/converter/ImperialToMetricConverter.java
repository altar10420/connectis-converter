package com.connectis.converter;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImperialToMetricConverter extends Converter {

    private static final double LENGTH_METER_FOOT_FACTOR = 0.3048;
    private static final double LENGTH_CENTIMETER_INCH_FACTOR = 2.54;
    private static final double VOLUME_LITER_GALLON_FACTOR = 4.54609;
    private static final double WEIGHT_KILOGRAM_POUND_FACTOR = 0.45359237;


    public ImperialToMetricConverter() {
        super(LENGTH_METER_FOOT_FACTOR,
                LENGTH_CENTIMETER_INCH_FACTOR,
                VOLUME_LITER_GALLON_FACTOR,
                WEIGHT_KILOGRAM_POUND_FACTOR);
    }

    @Override
    public String convertCelsiusFahrenheit(String input) {
        if (!StringUtils.isNumeric(input)) {
            return ENTER_NUMBER_INSTEAD;
        }

        BigDecimal inputValue, factor, substraction;

        inputValue = new BigDecimal(input);
        factor = new BigDecimal(0.555555556).setScale(4, RoundingMode.HALF_UP);
        substraction = new BigDecimal(32);


        return SUCCESSFULLY_CONVERTED_MESSAGE +
                (inputValue.subtract(substraction)).multiply(factor).toString();
    }
}
