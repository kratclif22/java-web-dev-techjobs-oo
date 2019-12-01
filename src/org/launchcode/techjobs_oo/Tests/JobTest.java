package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    private Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    @Before
    @Test
    public void testSettingJobId() {
        assertTrue((testJob1 != testJob2) && ((testJob1.getId() - testJob2.getId()) == -1));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", testJob3.getName());
        assertSame("Product tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().getValue());
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertEquals("Desert", testJob3.getLocation().getValue());
        assertTrue(testJob3.getLocation() instanceof Location);
        assertEquals("Quality control", testJob3.getPositionType().getValue());
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job testJob4 = new Job("Farmer", new Employer("Monsanto"), new Location("Saint Louis"), new PositionType("Tractor Driver"), new CoreCompetency("Crops"));
        Job testJob5 = new Job("Farmer", new Employer("Monsanto"), new Location("Saint Louis"), new PositionType("Tractor Driver"), new CoreCompetency("Crops"));
        assertFalse(testJob4.equals(testJob5));
    }

    @Test
    public void testToStringForBlankLine() {
        assertTrue(testJob1.toString().startsWith(" \n"));
        assertTrue(testJob1.toString().endsWith("\n "));
    }

    @Test
    public void testToStringForFieldsDataAndNewLine() {
        Job testJob6 = new Job("Farmer", new Employer("Monsanto"), new Location("Saint Louis"), new PositionType("Tractor Driver"), new CoreCompetency("Crops"));
        assertTrue(testJob6.toString().contains("Name: " + testJob6.getName() + "\n"));
    }

    @Test
    public void testToStringForEmptyFieldMessage() {
        Job testJob6 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue(testJob6.toString().contains("Name: Data not available"));
        assertTrue(testJob6.toString().contains("Employer: Data not available"));
        assertTrue(testJob6.toString().contains("Location: Data not available"));
        assertTrue(testJob6.toString().contains("Position Type: Data not available"));
        assertTrue(testJob6.toString().contains("Core Competency: Data not available"));
    }

    //BONUS
    @Test
    public void testToStringJobDoesNotExist() {
        Job testJob6 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue(testJob6.toString().contains("OOPS! This job does not seem to exist."));
    }
}
