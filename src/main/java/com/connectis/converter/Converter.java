package com.connectis.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Converter {

    private final BigDecimal LENGTH_METER_FOOT_FACTOR;
    private final BigDecimal LENGTH_CENTIMETER_INCH_FACTOR;
    private final BigDecimal VOLUME_LITER_GALLON_FACTOR;
    private final BigDecimal WEIGHT_KILOGRAM_POUND_FACTOR ;
    private final BigDecimal TEMP_CELSIUS_FAHRENHEIT_FACTOR;

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

    //TODO
    //metry, centymetry, co z liczbami z poza zakresu?
    //jaki jest typ inputu?
    //czy user moze podawac jednostke w input "1m", "1cm" ?

//    public double convertLength(String input) {
//
//        int value = 0;
//
////        if (input.endsWith("m")) {
////            value =  Integer.parseInt(input.substring(0, input.indexOf("m")));
////        }
////
////        if (input.endsWith("cm")) {
////            value = Integer.parseInt(input.substring(0, input.indexOf("cm")));
////        }
//
//        return value * LENGTH_METER_FOOT_FACTOR;
//    }

//    public double convertMeterFoot(String input) {
//        Double d = Double.parseDouble(input);
//        return Double.parseDouble(String.format("%.3f", d)) * LENGTH_METER_FOOT_FACTOR;
//    }

    public BigDecimal convertMeterFoot(String input) {
        return new BigDecimal(input).multiply(LENGTH_METER_FOOT_FACTOR);
    }

    public BigDecimal convertCentimeterInch(String input) {
        return new BigDecimal(input).multiply(LENGTH_CENTIMETER_INCH_FACTOR);
    }

    public BigDecimal convertLiterGallon(String input) {
        return new BigDecimal(input).multiply(VOLUME_LITER_GALLON_FACTOR);
    }

    public BigDecimal convertKilogramPound(String input) {
        return new BigDecimal(input).multiply(WEIGHT_KILOGRAM_POUND_FACTOR);
    }

    public BigDecimal convertCelsiusFahrenheit(String input) {
        return new BigDecimal(input).multiply(TEMP_CELSIUS_FAHRENHEIT_FACTOR);
    }


}
