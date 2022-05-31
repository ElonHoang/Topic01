package com.fis.module.detective;

import com.fis.enums.EmployeeStatus;
import com.fis.module.criminalCase.CriminalCase;
import com.fis.module.person.Person;
import com.fis.module.rank.Rank;
import com.fis.module.trackEntry.TrackEntry;

import java.util.Set;

public class Detective {
    private Person person;
    private String badgeNumber;
    private Rank rank;
    private boolean armed;
    private EmployeeStatus status;
    private Set<CriminalCase> criminalCase;
    private Set<TrackEntry> trackEntries;

}
