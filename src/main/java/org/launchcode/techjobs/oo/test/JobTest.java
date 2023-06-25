package org.launchcode.techjobs.oo.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

  @Test
  public void testSettingJobId() {
    Job test1 = new Job();
    Job test2 = new Job();

    assertNotEquals(test1.getId(), test2.getId());
  }

  @Test
  public void testJobConstructorSetsAllFields() {
    Job test1 = new Job(
      "Product tester",
      new Employer("ACME"),
      new Location("Desert"),
      new PositionType("Quality control"),
      new CoreCompetency("Persistence")
    );

    assertEquals("Product tester", test1.getName());
    assertEquals("ACME", test1.getEmployer().getValue());
    assertEquals("Desert", test1.getLocation().getValue());
    assertEquals("Quality control", test1.getPositionType().getValue());
    assertEquals("Persistence", test1.getCoreCompetency().getValue());

    assertTrue(test1.getName() instanceof String);
    assertTrue(test1.getEmployer() instanceof Employer);
    assertTrue(test1.getLocation() instanceof Location);
    assertTrue(test1.getPositionType() instanceof PositionType);
    assertTrue(test1.getCoreCompetency() instanceof CoreCompetency);
  }

  @Test
  public void testJobsForEquality() {
    Job test1 = new Job(
      "Product tester",
      new Employer("ACME"),
      new Location("Desert"),
      new PositionType("Quality control"),
      new CoreCompetency("Persistence")
    );
    Job test2 = new Job(
      "Product tester",
      new Employer("ACME"),
      new Location("Desert"),
      new PositionType("Quality control"),
      new CoreCompetency("Persistence")
    );

    assertFalse(test1.equals(test2));
  }

  @Test
  public void testToStringStartsAndEndsWithNewLine() {
    Job test1 = new Job(
      "Product tester",
      new Employer("ACME"),
      new Location("Desert"),
      new PositionType("Quality control"),
      new CoreCompetency("Persistence")
    );

    String stringValue = test1.toString();

    assertEquals('\n', stringValue.charAt(0));
    assertEquals('\n', stringValue.charAt(stringValue.length() - 1));
  }

  @Test
  public void testToStringContainsCorrectLabelsAndData() {
    Job test1 = new Job(
      "Product tester",
      new Employer("ACME"),
      new Location("Desert"),
      new PositionType("Quality control"),
      new CoreCompetency("Persistence")
    );

    String expectedValue =
      "\nID: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n";

    String actualValue = test1.toString();

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void testToStringHandlesEmptyField() {
    Job test1 = new Job(
      "Product tester",
      new Employer(),
      new Location(""),
      new PositionType("Quality control"),
      new CoreCompetency()
    );

    String expectedValue =
      "\nID: 1\nName: Product tester\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Quality control\nCore Competency: Data not available\n";

    String actualValue = test1.toString();

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void testToStringHandlesJobWithOnlyIdData() {
    Job test1 = new Job();

    String expectedValue = "OOPS! This job does not seem to exist";
    String actualValue = test1.toString();

    assertEquals(expectedValue, actualValue);
  }
}
