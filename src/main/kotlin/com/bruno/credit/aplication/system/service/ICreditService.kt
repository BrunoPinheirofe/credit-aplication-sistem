package com.bruno.credit.aplication.system.service

import com.bruno.credit.aplication.system.model.Credit
import java.util.*

interface ICreditService {

  fun save(credit: Credit): Credit
  fun findAllByCustomer(customerID: Long): List<Credit>
  fun findByCredtCode(customerID: Long, creditCode: UUID): Credit
}