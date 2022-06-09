package com.fis.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private String transactionType;
    private String bankAccount;
    private Integer amount;
    private String message;
    private LocalDateTime dateTime;
    public Transaction(){

    }

    public Transaction(String transactionType, String bankAccount, Integer amount, String message, LocalDateTime dateTime) {
        this.transactionType = transactionType;
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return transactionType.equals(that.transactionType) && bankAccount.equals(that.bankAccount) && amount.equals(that.amount) && message.equals(that.message) && dateTime.equals(that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionType, bankAccount, amount, message, dateTime);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType='" + transactionType + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
