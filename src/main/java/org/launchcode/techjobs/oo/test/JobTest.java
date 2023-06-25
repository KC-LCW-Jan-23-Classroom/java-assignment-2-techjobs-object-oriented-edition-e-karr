package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

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
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

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


}
