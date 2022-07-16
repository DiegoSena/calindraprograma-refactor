package com.calindra.refactor.controller;

public class NewReleaseMovie extends Movie{

  public NewReleaseMovie(String title) {
    super(title);
  }

  @Override
  public double getCharge(int daysRented) {
    return daysRented * 3.0;
  }

  @Override
  public int getFrequentRenterPoints(int daysRented) {
    if (daysRented > 1) {
      return 2;
    }
    return 1;
  }
}
