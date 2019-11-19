package com.connectis.converter;

public class ImperialToMetricConverter extends Converter {

    private static final double LENGTH_METER_FOOT_FACTOR = 1.5;
    private static final double LENGTH_CENTIMETER_INCH_FACTOR = 1.5;
    private static final double VOLUME_LITER_GALLON_FACTOR = 1.5;
    private static final double WEIGHT_KILOGRAM_POUND_FACTOR = 1.5;
    private static final double TEMP_CELSIUS_FAHRENHEIT_FACTOR = 1.5;


    public ImperialToMetricConverter() {
        super(LENGTH_METER_FOOT_FACTOR,
                LENGTH_CENTIMETER_INCH_FACTOR,
                VOLUME_LITER_GALLON_FACTOR,
                WEIGHT_KILOGRAM_POUND_FACTOR,
                TEMP_CELSIUS_FAHRENHEIT_FACTOR);
    }
}
