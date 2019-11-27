package com.connectis.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    private boolean firstMenuRunning;
    private boolean secondMenuRunning;
    private Converter converter;
    private String inputUnit;
    private String outputUnit;

    public UserInterface() {
        this.firstMenuRunning = true;
    }

    public void kill() {
        this.firstMenuRunning = false;
        this.secondMenuRunning = false;
    }

    public void run() throws IOException {

        while(firstMenuRunning) {

            System.out.println("\nWelcome to measurement converter!\nPlease choose your option:");
            System.out.println("1 - Convert metric to imperial");
            System.out.println("2 - Convert imperial to metric");
            System.out.println("0 - Exit");

            String userInput = readUserInput();


            switch (userInput) {

                case "1" :
                    converter = new MetricToImperialConverter();
                    firstMenuRunning = false;
                    secondMenuRunning = true;
                    break;
                case "2" :
                    converter = new ImperialToMetricConverter();
                    firstMenuRunning = false;
                    secondMenuRunning = true;
                    break;
                case "0" :
                    this.kill();
                    break;
                default :
                    System.out.println("Wrong input, please try again.");
            }
        }

        while (secondMenuRunning) {

            System.out.println("1 - Convert length m/ft");
            System.out.println("2 - Convert length cm/in");
            System.out.println("3 - Convert volume l/gal");
            System.out.println("4 - Convert weight kg/lb");
            System.out.println("5 - Convert temperature C/F");
            System.out.println("0 - Return");

            String userInput = readUserInput();

            switch (userInput) {
                case "1":
                    if (isMetric(converter)) {
                        inputUnit = "[m]";
                        outputUnit = "[ft]";
                    } else {
                        inputUnit = "[ft]";
                        outputUnit = "[m]";
                    }
                    System.out.println("Enter length in " + inputUnit);
                    userInput = readUserInput();
                    System.out.println(converter.convertMeterFoot(userInput) + outputUnit);
                    continue;

                case "2" :
                    if (isMetric(converter)) {
                        inputUnit = "[cm]";
                        outputUnit = "[in]";
                    } else {
                        inputUnit = "[in]";
                        outputUnit = "[cm]";
                    }
                    System.out.println("Enter length in " + inputUnit);
                    userInput = readUserInput();
                    System.out.println(converter.convertCentimeterInch(userInput) + outputUnit);
                    continue;

                case "3" :
                    if (isMetric(converter)) {
                        inputUnit = "[l]";
                        outputUnit = "[gal]";
                    } else {
                        inputUnit = "[gal]";
                        outputUnit = "[l]";
                    }
                    System.out.println("Enter volume in " + inputUnit);
                    userInput = readUserInput();
                    System.out.println(converter.convertLiterGallon(userInput) + outputUnit);
                    continue;

                case "4" :
                    if (isMetric(converter)) {
                        inputUnit = "[kg]";
                        outputUnit = "[lb]";
                    } else {
                        inputUnit = "[lb]";
                        outputUnit = "[kg]";
                    }
                    System.out.println("Enter weight in " + inputUnit);
                    userInput = readUserInput();
                    System.out.println(converter.convertLiterGallon(userInput) + outputUnit);
                    continue;

                case "5" :
                    if (isMetric(converter)) {
                        inputUnit = "[C]";
                        outputUnit = "[F]";
                    } else {
                        inputUnit = "[F]";
                        outputUnit = "[C]";
                    }
                    System.out.println("Enter temperature in " + inputUnit);
                    userInput = readUserInput();
                    System.out.println(converter.convertLiterGallon(userInput) + outputUnit);
                    continue;

                case "0" :
                    this.firstMenuRunning = true;
                    this.run();
            }

        }

    }

    private static String readUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static boolean isMetric(Object o) {
        return o.getClass().getSimpleName().equals("MetricToImperialConverter");
    }
}
