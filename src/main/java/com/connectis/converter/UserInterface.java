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

            System.out.println("Welcome to measurement converter!\nPlease choose your option:");
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
                            System.out.println("Input length to convert:\n");
                            userInput = readUserInput();
                            System.out.println(converter.convertLength(Integer.parseInt(userInput)));
                            continue;
                        case "2":
                            System.out.println("Input volume to convert:\n");
                            userInput = readUserInput();
                            System.out.println(converter.convertLength(Integer.parseInt(userInput)));
                            continue;
                        case "3":
                            System.out.println("Input volume to convert:\n");
                            userInput = readUserInput();
                            System.out.println(converter.convertLength(Integer.parseInt(userInput)));
                            continue;
                        case "4":
                            System.out.println("Input volume to convert:\n");
                            userInput = readUserInput();
                            System.out.println(converter.convertLength(Integer.parseInt(userInput)));
                            continue;
                        case "0":
                            continue;

                    }

                    continue;

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
