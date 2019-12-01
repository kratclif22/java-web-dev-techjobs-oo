package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency) {
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    @Override
    public String toString() {
        String noData = "Data not available";
        String nameData = this.name;
        String employerData = this.employer.getValue();
        String locationData = this.location.getValue();
        String positionData = this.positionType.getValue();
        String coreCompData = this.coreCompetency.getValue();

        if (nameData.equals("")) {
            nameData = noData;
        }
        if (employerData.equals("")) {
            employerData = noData;
        }
        if (locationData.equals("")) {
            locationData = noData;
        }
        if (positionData.equals("")) {
            positionData = noData;
        }
        if (coreCompData.equals("")) {
            coreCompData = noData;
        }
        if (nameData.equals(noData) && employerData.equals(noData) && locationData.equals(noData)
        && positionData.equals(noData) && coreCompData.equals(noData)) {
            return " \n" +
                    "ID: " + this.id + "\n" +
                    "Name: " + nameData + "\n" +
                    "Employer: " + employerData + "\n" +
                    "Location: " + locationData + "\n" +
                    "Position Type: " + positionData + "\n" +
                    "Core Competency: " + coreCompData + "\n" +
                    "OOPS! This job does not seem to exist." +
                    "\n ";
        } else {
            return " \n" +
                    "ID: " + this.id + "\n" +
                    "Name: " + nameData + "\n" +
                    "Employer: " + employerData + "\n" +
                    "Location: " + locationData + "\n" +
                    "Position Type: " + positionData + "\n" +
                    "Core Competency: " + coreCompData +
                    "\n ";
        }
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
