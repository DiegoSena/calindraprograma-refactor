package com.calindra.refactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class PaymentController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/{customerId}/statement")
  public String getStatement(@PathVariable String customerId) {
    var customer = customerRepository.getCustomer(customerId);
    return customer.statement();
  }


}
