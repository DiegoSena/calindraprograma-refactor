package com.calindra.refactor.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void statement() {
    var customer = new Customer("diego");

    var doctorStrange = new Movie("Doutor Estranho", Movie.NEW_RELEASE);
    var doctorStrangeRental = new Rental(doctorStrange, 3);
    customer.addRental(doctorStrangeRental);

    assertEquals(customer.statement(), "Registros de aluguéis de diego\n" +
        "\tDoutor Estranho\t9.0\n" +
        "Total devido é 9.0\n" +
        "Você ganhou 2 pontos no nosso programa de fidelidade");
  }
}