package com.bruno.credit.aplication.system.dto

import com.bruno.credit.aplication.system.model.Customer
import java.math.BigDecimal

data class CustomerView(
  val firstName: String,
  val lastName: String,
  val email: String,
  val cpf: String,
  val income: BigDecimal,
  val zipCode: String,
  val street: String
) {
  constructor(customer: Customer) : this(
    firstName = customer.firstName,
    lastName = customer.lastName,
    email = customer.email,
    cpf = customer.cpf,
    income = customer.income,
    zipCode = customer.address.zipCode,
    street = customer.address.street
  ) {

  }


}
