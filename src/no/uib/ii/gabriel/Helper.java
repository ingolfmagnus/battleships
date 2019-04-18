package no.uib.ii.gabriel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {

    public static String readInputLine(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            return br.readLine();
        } catch (IOException e) {
            return "";
        }
    }
 }
