package com.fis.module;

import java.util.Objects;
import java.util.Set;

public class Storage {
    private String name;
    private String location;
    private Set<Evidence> evidence;
    public Storage(){

    }

    public Storage(String name, String location, Set<Evidence> evidence) {
        this.name = name;
        this.location = location;
        this.evidence = evidence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Evidence> getEvidence() {
        return evidence;
    }

    public void setEvidence(Set<Evidence> evidence) {
        this.evidence = evidence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;
        Storage storage = (Storage) o;
        return name.equals(storage.name) && location.equals(storage.location) && evidence.equals(storage.evidence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, evidence);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", evidence=" + evidence +
                '}';
    }
}
