package com.calindra.refactor.controller;

public class RegularMovie extends Movie{

  public RegularMovie(String title) {
    super(title);
  }

  @Override
  public double getCharge(int daysRented) {
    var amount = 2.0;

    if (daysRented > 2)
      amount += (daysRented - 2) * 1.5;

    return amount;
  }

  @Override
  public int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
