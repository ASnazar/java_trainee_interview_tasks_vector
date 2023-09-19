package org.example;

public class Task1 {
    public static void main(String[] args) {
        int numberRails = 3;
        String exampleString = "WEAREDISCOVEREDFLEEATONCE";
        String encodedString = "WECRLTEERDSOEEFEAOCAIVDEN";
        System.out.println(encoding(exampleString, numberRails).equals(encodedString));
        System.out.println(decoding(encodedString,numberRails).equals(exampleString));
    }

    public static String encoding(String text, int numberRails) {
        if (numberRails < 2 || text.isEmpty()) {
            return text;
        }
        StringBuilder[] rails = new StringBuilder[numberRails];
        for (int i = 0; i < numberRails; i++) {
            rails[i] = new StringBuilder();
        }
        int indexReil = 0;
        int step = 1;
        for (char ch : text.toCharArray()) {
            rails[indexReil].append(ch);
            if (indexReil == 0) {
                step = 1;
            } else if (indexReil == numberRails - 1) {
                step = -1;
            }
            indexReil += step;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder rail :
                rails) {
            result.append(rail);
        }
        return result.toString();
    }

    public static String decoding(String text, int numberRails) {
        if (numberRails < 2 || text.isEmpty()) {
            return text;
        }
        StringBuilder[] rails = new StringBuilder[numberRails];
        for (int i = 0; i < numberRails; i++) {
            rails[i] = new StringBuilder();
        }
        int[] railLengths = new int[numberRails];
        int indexRail = 0;
        int step = 1;
        for (int i = 0; i < text.length(); i++) {
            railLengths[indexRail]++;
            if (indexRail == 0) {
                step = 1;
            } else if (indexRail == numberRails - 1) {
                step = -1;
            }
            indexRail += step;
        }
        int textIndex = 0;
        for (int rail = 0; rail < numberRails; rail++) {
            for (int i = 0; i < railLengths[rail]; i++) {
                rails[rail].append(text.charAt(textIndex));
                textIndex++;
            }
        }
        StringBuilder result = new StringBuilder();
        indexRail = 0;
        step = 1;
        for (int i = 0; i < text.length(); i++) {
            result.append(rails[indexRail].charAt(0));
            rails[indexRail].deleteCharAt(0);
            if (indexRail == 0) {
                step = 1;
            } else if (indexRail == numberRails - 1) {
                step = -1;
            }
            indexRail += step;
        }
        return result.toString();
    }
}
