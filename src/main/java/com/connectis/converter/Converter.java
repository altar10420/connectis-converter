package com.connectis.converter;

public abstract class Converter {

    private final double LENGTH_FACTOR;
    private final double VOLUME_FACTOR;
    private final double WEIGHT_FACTOR ;
    private final double TEMP_FACTOR;

    public Converter(double LENGTH_FACTOR, double VOLUME_FACTOR, double WEIGHT_FACTOR, double TEMP_FACTOR) {
        this.LENGTH_FACTOR = LENGTH_FACTOR;
        this.VOLUME_FACTOR = VOLUME_FACTOR;
        this.WEIGHT_FACTOR = WEIGHT_FACTOR;
        this.TEMP_FACTOR = TEMP_FACTOR;
    }

    //TODO
    //metry, centymetry, co z liczbami z poza zakresu?
    //jaki jest typ inputu?
    //czy user moze podawac jednostke w input "1m", "1cm" ?

    public double convertLength(int input) {
        return input * LENGTH_FACTOR;
    }

    public double convertVolume(int input) {
        return input * VOLUME_FACTOR;
    }

    public double convertWeight(int input) {
        return input * WEIGHT_FACTOR;
    }

    public double convertTemp(int input) {
        return input * TEMP_FACTOR;
    }


}
