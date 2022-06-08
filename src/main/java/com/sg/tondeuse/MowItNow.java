package com.sg.tondeuse;

import com.sg.tondeuse.utils.MowItNowUtils;

import java.io.*;

public class MowItNow {
    public static void main(String[] args) {
        try {
            MowItNowUtils.parseFile(args[0]);
        } catch (IOException e) {
            System.out.println("Error " + e + " encountered while parsing the file " + args[0]);
        }
    }
}
