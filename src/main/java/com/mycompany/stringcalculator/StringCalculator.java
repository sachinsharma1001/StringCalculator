package com.mycompany.stringcalculator;

public class StringCalculator {

  public int add(String numbers) {
    int sum = 0;

    if (numbers.isEmpty()) {
      return sum;
    }

    String[] arr = numbers.split(",");
    for (String number : arr) {
      sum += Integer.parseInt(number);
    }

    return sum;
  }
}
