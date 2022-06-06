package com.fis.core.model;

import com.fis.enums.EmployeeStatus;
import com.fis.enums.Rank;

import java.util.Objects;
import java.util.Set;

public class Detective extends AbstractEntity {
    private Person person;
    private String badgeNumber;
    private Rank rank;
    private boolean armed;
    private EmployeeStatus status;
    private Set<CriminalCase> criminalCase;
    private Set<TrackEntry> trackEntries;

    public Detective() {
    }

    public Detective(Long id, int version, Person person, String badgeNumber, Rank rank, boolean armed,
                     EmployeeStatus status, Set<CriminalCase> criminalCase, Set<TrackEntry> trackEntries) {
        super(id,version);
        this.person = person;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.criminalCase = criminalCase;
        this.trackEntries = trackEntries;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public boolean isArmed() {
        return armed;
    }

    public void setArmed(boolean armed) {
        this.armed = armed;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Set<CriminalCase> getCriminalCase() {
        return criminalCase;
    }

    public void setCriminalCase(Set<CriminalCase> criminalCase) {
        this.criminalCase = criminalCase;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detective)) return false;
        if (!super.equals(o)) return false;
        Detective detective = (Detective) o;
        return armed == detective.armed && person.equals(detective.person) && badgeNumber.equals(detective.badgeNumber) && rank == detective.rank && status == detective.status && criminalCase.equals(detective.criminalCase) && trackEntries.equals(detective.trackEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), person, badgeNumber, rank, armed, status, criminalCase, trackEntries);
    }

    @Override
    public String toString() {
        return "Detective{" +
                "person=" + person +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", rank=" + rank +
                ", armed=" + armed +
                ", status=" + status +
                ", criminalCase=" + criminalCase +
                ", trackEntries=" + trackEntries +
                '}';
    }
}
