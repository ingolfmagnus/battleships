package no.uib.ii.gabriel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {

    public static String readInputLine() {
        return readInputLine("");
    }

    public static String readInputLine(String prompt){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(prompt);
        try {
            return br.readLine();
        } catch (IOException e) {
            return "";
        }
    }
 }
