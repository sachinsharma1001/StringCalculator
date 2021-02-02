package com.mycompany.stringcalculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("String Calculator Test")
public class StringCalculatorTest {

  private TestInfo testInfo;
  private TestReporter testReporter;

  @BeforeAll
  public void setUpClass(TestReporter testReporter, TestInfo testInfo) {
    this.testReporter = testReporter;
    this.testInfo = testInfo;
  }

  @Test
  @DisplayName("Add Numbers with empty string")
  public void addNumbersWithEmptyString_shouldReturn0() {
    testReporter.publishEntry("Running " + testInfo.getDisplayName());
    String numbers = "";
    StringCalculator calculator = new StringCalculator();
    int sum = calculator.add(numbers);
    assertEquals(0, sum, "Test runs successfully by passing empty string");
  }
  
  @Test
  @DisplayName("Add Numbers with multiple numbers")
  public void addNumbersWithMultipleNumberShouldReturnSum() {
    testReporter.publishEntry("Running " + testInfo.getDisplayName());
    String numbers = "1,2,3";
    StringCalculator calculator = new StringCalculator();
    int sum = calculator.add(numbers);
    assertEquals(6, sum, "Test runs successfully by adding multiple numbers");
  }

  @Test
  @DisplayName("Add Numbers with new line")
  public void addNumbersWithNumberNewLineShouldReturnSum() {
    testReporter.publishEntry("Running " + testInfo.getDisplayName());
    String numbers = "1\n2,3";
    StringCalculator calculator = new StringCalculator();
    int sum = calculator.add(numbers);
    assertEquals(6, sum, "Test runs successfully by passing new line with numbers");
  }

  @Test
  @DisplayName("Add Numbers with different delimiters")
  public void addNumbersWithNumberWithDifferentDelimiterShouldReturnSum() {
    testReporter.publishEntry("Running " + testInfo.getDisplayName());
    String numbers = "//;\n1;2\n3";
    StringCalculator calculator = new StringCalculator();
    int sum = calculator.add(numbers);
    assertEquals(6, sum, "Test runs successfully by passing different delimiter and multiple numbers");
  }
  
  @Test
  @DisplayName("Add Negative Numbers")
  public void addNumbersWithNegativeNumber_shouldThrowException() {
    testReporter.publishEntry("Running " + testInfo.getDisplayName());
    String numbers = "-1,-2";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new StringCalculator().add(numbers));

    String expectedMessage = "Negative Number: ";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }
  
  @Test
  @DisplayName("Add Numbers with number greater than 1000")
  public void addNumbersWithNumberWithNumber1000ShouldReturnSum() {
    testReporter.publishEntry("Running " + testInfo.getDisplayName());
    String numbers = "1,1001";
    StringCalculator calculator = new StringCalculator();
    int sum = calculator.add(numbers);
    assertEquals(1, sum, "Test runs successfully by passing different number greater than 1000");
  }

}
