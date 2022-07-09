package com.calindra.refactor.controller;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String name;

  private List<Rental> rentalList = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addRental(Rental r) {
    this.rentalList.add(r);
  }

  public String statement() {
    double totalAmount = 0.0;
    int frequentRenterPoints = 0;
    var rentals = rentalList;

    String result = "Registros de aluguéis de " + this.getName() + "\n";
    for (Rental rental : rentals) {
      double thisAmount = 0;

      switch (rental.getMovie().getCode()) {
        case Movie.REGULAR:
          thisAmount += 2.0;
          if (rental.getDays() > 2)
            thisAmount += (rental.getDays() - 2) * 1.5;
          break;
        case Movie.NEW_RELEASE:
          thisAmount += rental.getDays() * 3.0;
          break;
        case Movie.CHILDRENS:
          thisAmount += 1.5;
          if (rental.getDays() > 3)
            thisAmount += (rental.getDays() - 3) * 1.5;
          break;
      }

      frequentRenterPoints++;
      if ((rental.getMovie().getCode() == Movie.NEW_RELEASE) && rental.getDays() > 1)
        frequentRenterPoints++;

      result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
    }

    result += "Total devido é " + totalAmount + "\n";
    result += "Você ganhou " + frequentRenterPoints + " pontos no nosso programa de fidelidade";

    return result;
  }
}
