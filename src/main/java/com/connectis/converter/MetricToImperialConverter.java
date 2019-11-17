package com.connectis.converter;

public class MetricToImperialConverter extends Converter {

    private static final double LENGTH_FACTOR = 1.5;
    private static final double VOLUME_FACTOR = 1.5;
    private static final double WEIGHT_FACTOR = 1.5;
    private static final double TEMP_FACTOR = 1.5;

    public MetricToImperialConverter() {
        super(LENGTH_FACTOR, VOLUME_FACTOR, WEIGHT_FACTOR, TEMP_FACTOR);
    }

}
