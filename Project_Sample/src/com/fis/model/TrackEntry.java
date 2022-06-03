package com.fis.model;

import com.fis.enums.TrackAction;

import java.time.LocalDateTime;
import java.util.Objects;

public class TrackEntry {
    private LocalDateTime date;
    private Evidence evidence;
    private Detective derevtive;
    private TrackAction action;
    private String reason;
    public TrackEntry(){

    }

    public TrackEntry(LocalDateTime date, Evidence evidence, Detective derevtive, TrackAction action, String reason) {
        this.date = date;
        this.evidence = evidence;
        this.derevtive = derevtive;
        this.action = action;
        this.reason = reason;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Detective getDerevtive() {
        return derevtive;
    }

    public void setDerevtive(Detective derevtive) {
        this.derevtive = derevtive;
    }

    public TrackAction getAction() {
        return action;
    }

    public void setAction(TrackAction action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrackEntry)) return false;
        TrackEntry that = (TrackEntry) o;
        return date.equals(that.date) && evidence.equals(that.evidence) && derevtive.equals(that.derevtive) && action == that.action && reason.equals(that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, evidence, derevtive, action, reason);
    }

    @Override
    public String toString() {
        return "TrackEntry{" +
                "date=" + date +
                ", evidence=" + evidence +
                ", derevtive=" + derevtive +
                ", action=" + action +
                ", reason='" + reason + '\'' +
                '}';
    }
}
