package com.fis.module;

import com.fis.enums.EmployeeStatus;

import java.util.Set;

public class Detective {
    private Person person;
    private String badgeNumber;
    private Rank rank;
    private boolean armed;
    private EmployeeStatus status;
    private Set<CriminalCase> criminalCase;
    private Set<TrackEntry> trackEntries;

    public Detective(Person person, String badgeNumber, Rank rank, boolean armed, EmployeeStatus status, Set<CriminalCase> criminalCase, Set<TrackEntry> trackEntries) {
        this.person = person;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.criminalCase = criminalCase;
        this.trackEntries = trackEntries;
    }
}
