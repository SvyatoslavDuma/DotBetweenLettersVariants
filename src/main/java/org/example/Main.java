package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            System.out.println("Enter line:");
            str = sc.nextLine();

            if (str.length() < 2) {
                System.out.println("The string is too short. Please enter a string with at least 2 characters.");
            } else {
                break;
            }
        }

        SecondSolution.secondSolution(str);

        List<String> pairs = getListOfPairs(str);

        List<String> combinations = getCombinations(str.length() - 1);

        List<String> result = getResult(combinations, pairs);


        for (String s : result) {
            System.out.println(s);
        }


    }

    public static List<String> getListOfPairs(String str) {
        List<String> listOfPairs = new ArrayList<>(str.length() - 1);
        char[] strCharArray = str.toCharArray();
        for (int i = 0; i < strCharArray.length - 1; i++) {
            listOfPairs.add(String.valueOf(strCharArray[i]) + strCharArray[i + 1]);
        }
        return listOfPairs;
    }

    public static List<String> getCombinations(int length) {
        int combinationsCount = (int) Math.pow(2, length);
        List<String> combinations = new ArrayList<>(combinationsCount);
        for (int i = 0; i < combinationsCount; i++) {
            combinations.add(convertToBinary(length, i));
        }
        return combinations;
    }

    public static List<String> getResult(List<String> combinations, List<String> pairs) {
        List<String> result = new ArrayList<>(combinations.size());

        for (String combination : combinations) {
            result.add(getResultString(combination, pairs));
        }
        return result;
    }

    private static String getResultString(String combination, List<String> pairs) {
        StringBuilder sb = new StringBuilder();
        char[] combToChar = combination.toCharArray();

        for (int i = 0; i < combToChar.length; i++) {
            if (i == 0) {
                if (combToChar[i] == '0') {
                    sb.append(pairs.get(i));
                } else {
                    sb.append(pairs.get(i).charAt(0)).append(".").append(pairs.get(i).charAt(1));
                }
            } else {
                if (combToChar[i] == '0') {
                    sb.append(pairs.get(i).charAt(1));
                } else {
                    sb.append(".").append(pairs.get(i).charAt(1));
                }
            }
        }


        return sb.toString();
    }


    private static String convertToBinary(int bits, int number) {
        String binaryString = Integer.toBinaryString(number);

        StringBuilder paddedBinaryString = new StringBuilder(bits);

        for (int i = binaryString.length(); i < bits; i++) {
            paddedBinaryString.append('0');
        }

        paddedBinaryString.append(binaryString);

        return paddedBinaryString.toString();
    }

}

