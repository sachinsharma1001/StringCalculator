package com.mycompany.stringcalculator;

public class StringCalculator {

  public int add(String numbers) {
    int sum = 0;

    String delimiter = Character.toString(numbers.charAt(2));
    String numberStr = numbers.substring(numbers.indexOf("\n") + 1, numbers.length());

    if (!numberStr.isEmpty()) {
      String[] arr = numberStr.replace("\n", delimiter).trim().split(delimiter);
      for (String number : arr) {
        sum += Integer.parseInt(number);
      }
    }
    return sum;
  }
}
