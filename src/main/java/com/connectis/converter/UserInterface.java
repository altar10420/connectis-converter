package com.connectis.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    private boolean running;
    private Converter converter;

    public UserInterface() {
        this.running = true;
    }

    public void kill() {
        this.running = false;
    }

    public void run() throws IOException {

        while(running) {

            System.out.println("\nWelcome to measurement converter!\nPlease choose your option:");
            System.out.println("1 - Convert metric to imperial");
            System.out.println("2 - Convert imperial to metric");
            System.out.println("0 - Exit");

            String userInput = readUserInput();

            switch (userInput) {
                case "1":
                    converter = new MetricToImperialConverter();

                    System.out.println("1 - Convert length");
                    System.out.println("2 - Convert volume");
                    System.out.println("3 - Convert weight");
                    System.out.println("4 - Convert temperature");
                    System.out.println("0 - Return");

                    userInput = readUserInput();

                    switch (userInput) {
                        case "1":
                            System.out.println("1 - Convert [m] to [ft]");
                            System.out.println("2 - Convert [cm] to [in]");
                            userInput = readUserInput();

                            switch (userInput) {
                                case "1":
                                    System.out.println("Enter length in [m]:");
                                    userInput = readUserInput();
                                    System.out.println(userInput + "[m] is: " +
                                            converter.convertMeterFoot(userInput) + "[ft]");
                                    continue;

                                case "2":
                                    System.out.println("Enter length in [cm]:");
                                    userInput = readUserInput();
                                    System.out.println(converter.convertCentimeterInch(userInput));
                                    continue;

                                default:
                                    System.out.println("Sorry, wrong option. Please try again.");
                                    continue;
                            }

                        case "2":
                            System.out.println("Input volume in [l]");
                            userInput = readUserInput();
                            System.out.println(userInput + "[l] is: " +
                                    converter.convertLiterGallon(userInput) + "[gal]");
                            continue;
                        case "3":
                            System.out.println("Input weight to convert:\n");
                            userInput = readUserInput();
                            System.out.println(userInput + "[kg] is: " +
                                    converter.convertKilogramPound(userInput) + "[lb]");
                            continue;
                        case "4":
                            System.out.println("Input temperature to convert:\n");
                            userInput = readUserInput();
                            System.out.println(userInput + "[C] is: " +
                                    converter.convertCelsiusFahrenheit(userInput) + "[F]");
                            continue;
                        case "0":
                            continue;
                        default:
                            System.out.println("Sorry, wrong option. Please try again.");
                            continue;


                    }


                case "2":
                    converter = new ImperialToMetricConverter();

                    continue;

                case "0":
                    this.kill();
            }

        }
    }

    private static String readUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
