package com.calindra.refactor.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

  @Mock
  private CustomerRepository customerRepository;

  @InjectMocks
  private PaymentController paymentController;

  @Test
  @DisplayName("Testa se statement vai ser retornado")
  void testIfStatementWillBeReturned() {
    var customerId = "1";
    var customer = new Customer("diego");

    var doctorStrange = new NewReleaseMovie("Doutor Estranho");
    var doctorStrangeRental = new Rental(doctorStrange, 3);
    customer.addRental(doctorStrangeRental);

    when(customerRepository.getCustomer(customerId)).thenReturn(customer);
    assertEquals(paymentController.getStatement(customerId), "Registros de aluguéis de diego\n" +
        "\tDoutor Estranho\t9.0\n" +
        "Total devido é 9.0\n" +
        "Você ganhou 2 pontos no nosso programa de fidelidade");
  }
}