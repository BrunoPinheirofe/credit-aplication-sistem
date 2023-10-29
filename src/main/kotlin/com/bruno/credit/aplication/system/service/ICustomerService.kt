package com.bruno.credit.aplication.system.service

import com.bruno.credit.aplication.system.model.Customer


interface ICustomerService {

  fun save(customer: Customer):Customer
  fun findById(customerID: Long):Customer

  fun delete(customerID: Long)


}