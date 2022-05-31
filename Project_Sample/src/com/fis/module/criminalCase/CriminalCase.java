package com.fis.module.criminalCase;

import com.fis.enums.CaseStatus;
import com.fis.enums.CaseType;
import com.fis.module.detective.Detective;
import com.fis.module.evidence.Evidence;

import java.util.Objects;
import java.util.Set;

public class CriminalCase {
    private String number;
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;
    private CaseStatus status;
    private String notes;
    private Set<Evidence> evidenceSet;
    private Detective leadInvestigator;
    private Set<Detective> assigned;
    public CriminalCase(){

    }

    public CriminalCase(String number, CaseType type, String shortDescription, String detailedDescription, CaseStatus status, String notes, Set<Evidence> evidenceSet, Detective leadInvestigator, Set<Detective> assigned) {
        this.number = number;
        this.type = type;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.status = status;
        this.notes = notes;
        this.evidenceSet = evidenceSet;
        this.leadInvestigator = leadInvestigator;
        this.assigned = assigned;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    public Detective getLeadInvestigator() {
        return leadInvestigator;
    }

    public void setLeadInvestigator(Detective leadInvestigator) {
        this.leadInvestigator = leadInvestigator;
    }

    public Set<Detective> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<Detective> assigned) {
        this.assigned = assigned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CriminalCase)) return false;
        CriminalCase that = (CriminalCase) o;
        return number.equals(that.number) && type == that.type && shortDescription.equals(that.shortDescription) && detailedDescription.equals(that.detailedDescription) && status == that.status && notes.equals(that.notes) && evidenceSet.equals(that.evidenceSet) && leadInvestigator.equals(that.leadInvestigator) && assigned.equals(that.assigned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type, shortDescription, detailedDescription, status, notes, evidenceSet, leadInvestigator, assigned);
    }

    @Override
    public String toString() {
        return "CriminalCase{" +
                "number='" + number + '\'' +
                ", type=" + type +
                ", shortDescription='" + shortDescription + '\'' +
                ", detailedDescription='" + detailedDescription + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                ", evidenceSet=" + evidenceSet +
                ", leadInvestigator=" + leadInvestigator +
                ", assigned=" + assigned +
                '}';
    }
}
