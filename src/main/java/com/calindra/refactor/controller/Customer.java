package com.calindra.refactor.controller;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String name;

  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addRental(Rental rental) {
    this.rentals.add(rental);
  }

  public String statement() {
    String result = "Registros de aluguéis de " + this.getName() + "\n";
    for (Rental rental : this.rentals) {
      result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
    }

    result += "Total devido é " + getTotalCharge() + "\n";
    result += "Você ganhou " + getTotalFrequentRenterPoints() + " pontos no nosso programa de fidelidade";

    return result;
  }

  private int getTotalFrequentRenterPoints() {
    int frequentRenterPoints = 0;
    for (Rental rental : this.rentals) {
      frequentRenterPoints += rental.getFrequentRenterPoints();
    }
    return frequentRenterPoints;
  }

  private double getTotalCharge() {
    double amount = 0.0;
    for (Rental rental : this.rentals) {
      amount += rental.getCharge();
    }
    return amount;
  }

  public StatementResponse objectStatement() {
    var statementResponse = new StatementResponse();
    statementResponse.setCustomerName(this.getName());
    statementResponse.setFrequentRenterPoints(getTotalFrequentRenterPoints());
    statementResponse.setAmount(getTotalCharge());
    return objectStatement();
  }

}
