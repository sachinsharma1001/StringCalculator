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
  @DisplayName("Add Numbers")
  public void addNumbersWithEmptyString() {
    testReporter.publishEntry("Running " + testInfo.getDisplayName());
    String numbers = "";
    StringCalculator calculator = new StringCalculator();
    int sum = calculator.add(numbers);
    assertEquals(0, sum, "When string is empty sum is 0");
  }

}
