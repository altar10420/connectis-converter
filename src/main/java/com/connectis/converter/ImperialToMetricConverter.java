package com.connectis.converter;

public class ImperialToMetricConverter extends Converter {

    private static final double LENGTH_FACTOR = 2.5;
    private static final double VOLUME_FACTOR = 2.5;
    private static final double WEIGHT_FACTOR = 2.5;
    private static final double TEMP_FACTOR = 2.5;

    public ImperialToMetricConverter() {
        super(LENGTH_FACTOR, VOLUME_FACTOR, WEIGHT_FACTOR, TEMP_FACTOR);
    }
}
