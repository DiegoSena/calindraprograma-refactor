package com.calindra.refactor.controller;

public class Rental {

  private Movie movie;
  private int days;

  public Rental(Movie movie, int days) {
    this.movie = movie;
    this.days = days;
  }


  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }
}
