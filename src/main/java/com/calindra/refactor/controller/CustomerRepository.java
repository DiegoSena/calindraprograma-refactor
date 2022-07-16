package com.calindra.refactor.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

  private Map<String, Customer> customers = new HashMap<>();

  public CustomerRepository() {
    var diego = new Customer("Diego");

    var starWars = new RegularMovie("Star Wars");
    var starWarsRental = new Rental(starWars, 3);
    diego.addRental(starWarsRental);
    customers.put("1", diego);

    var joao = new Customer("Joao");

    var matrix = new RegularMovie("Matrix");
    var matrixRentral = new Rental(matrix, 2);
    joao.addRental(matrixRentral);

    var toyStory = new ChildrenMovie("Toy Story");
    var toyStoryRental = new Rental(toyStory, 2);
    joao.addRental(toyStoryRental);

    customers.put("2", joao);

    var guilherme = new Customer("Guilherme");

    var doctorStrange = new NewReleaseMovie("Doutor Estranho");
    var doctorStrangeRental = new Rental(doctorStrange, 3);
    guilherme.addRental(doctorStrangeRental);

    customers.put("3", guilherme);

    var madeira = new Customer("Madeira");

    customers.put("4", madeira);
  }

  public Customer getCustomer(String customerId) {
    return customers.get(customerId);
  }
}
