package com.fis.model;

import java.util.Objects;
import java.util.Set;

public class Evidence {
    private CriminalCase criminalCase;
    private Storage storage;
    private String number;
    private String itemName;
    private String notes;
    private boolean archired;
    private Set<TrackEntry> trackEntry;
    public Evidence(){

    }

    public Evidence(CriminalCase criminalCase, Storage storage, String number, String itemName, String notes, boolean archired, Set<TrackEntry> trackEntry) {
        this.criminalCase = criminalCase;
        this.storage = storage;
        this.number = number;
        this.itemName = itemName;
        this.notes = notes;
        this.archired = archired;
        this.trackEntry = trackEntry;
    }

    public CriminalCase getCriminalCase() {
        return criminalCase;
    }

    public void setCriminalCase(CriminalCase criminalCase) {
        this.criminalCase = criminalCase;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isArchired() {
        return archired;
    }

    public void setArchired(boolean archired) {
        this.archired = archired;
    }

    public Set<TrackEntry> getTrackEntry() {
        return trackEntry;
    }

    public void setTrackEntry(Set<TrackEntry> trackEntry) {
        this.trackEntry = trackEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evidence)) return false;
        Evidence evidence = (Evidence) o;
        return archired == evidence.archired && criminalCase.equals(evidence.criminalCase) && storage.equals(evidence.storage) && number.equals(evidence.number) && itemName.equals(evidence.itemName) && notes.equals(evidence.notes) && trackEntry.equals(evidence.trackEntry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criminalCase, storage, number, itemName, notes, archired, trackEntry);
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "criminalCase=" + criminalCase +
                ", storage=" + storage +
                ", number='" + number + '\'' +
                ", itemName='" + itemName + '\'' +
                ", notes='" + notes + '\'' +
                ", archired=" + archired +
                ", trackEntry=" + trackEntry +
                '}';
    }
}
