package com.mycompany.stringcalculator;

public class StringCalculator {

  private static int count = 0;

  public int add(String numbers) {
    GetCalledCount();
    int sum = 0;

//    String delimiter = Character.toString(numbers.charAt(2));
//    String numberStr = numbers.substring(numbers.indexOf(",\n") + 1, numbers.length());

    if (!numbers.isEmpty()) {
      String[] arr = numbers.split(",|\n");
      for (String number : arr) {
        sum += checkNumber(number);
      }
    }
    return sum;
  }

  public int checkNumber(String number) {
    int num = Integer.parseInt(number);
    if (num < 0) {
      throw new IllegalArgumentException("Negative Number: " + number);
    } else if (num > 1000) {
      num = 0;
    }
    return num;
  }

  public void GetCalledCount() {
    count++;
  }
}
