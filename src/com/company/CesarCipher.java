package com.company;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CesarCipher {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        String cipher = encode(text, 3);

        System.out.println(cipher);

    }


    public static String encode(String plainText, int shift) {

        if (shift > 26) {
            shift = shift % 26;
        } else if (shift < 0) {
            shift = (shift % 26) + 26;
        }

        String chiperText = "";

        int lenght = plainText.length();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = (char) (ch + shift);

                    if (c > 'z') {
                        chiperText += (char) (ch - (26 - shift));
                    } else {
                        chiperText += c;
                    }
                } else if (Character.isUpperCase(ch)) {
                    char c = (char) (ch + shift);

                    if (c > 'Z') {
                        chiperText += (char) (ch - (26 - shift));
                    } else {
                        chiperText += c;
                    }
                }
            } else {
                chiperText += ch;
            }
        }

        return chiperText;
    }

}