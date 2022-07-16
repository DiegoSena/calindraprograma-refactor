package com.calindra.refactor.controller;

public class StatementResponse {
  private String customerName;
  private int frequentRenterPoints;
  private double amount;

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public int getFrequentRenterPoints() {
    return frequentRenterPoints;
  }

  public void setFrequentRenterPoints(int frequentRenterPoints) {
    this.frequentRenterPoints = frequentRenterPoints;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
