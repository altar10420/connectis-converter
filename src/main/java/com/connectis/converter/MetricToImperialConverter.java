package com.connectis.converter;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MetricToImperialConverter extends Converter {

    private static final double LENGTH_METER_FOOT_FACTOR = 1/0.3048;
    private static final double LENGTH_CENTIMETER_INCH_FACTOR = 1/2.54;
    private static final double VOLUME_LITER_GALLON_FACTOR = 1/4.54609;
    private static final double WEIGHT_KILOGRAM_POUND_FACTOR = 1/0.45359237;


    public MetricToImperialConverter() {
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

        BigDecimal inputValue, factor, addition;

        inputValue = new BigDecimal(input);
        factor = new BigDecimal(1.8).setScale(4, RoundingMode.HALF_UP);
        addition = new BigDecimal(32);


        return SUCCESSFULLY_CONVERTED_MESSAGE +
                (inputValue.multiply(factor)).add(addition).toString();
    }
}
