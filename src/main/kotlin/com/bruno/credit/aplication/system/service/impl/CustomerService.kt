package com.bruno.credit.aplication.system.service.impl

import com.bruno.credit.aplication.system.model.Customer
import com.bruno.credit.aplication.system.repository.CustomerRepository
import com.bruno.credit.aplication.system.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException


@Service
class CustomerService(
  private val customerRepository: CustomerRepository
): ICustomerService {
  override fun save(customer: Customer): Customer = this.customerRepository.save(customer)


  override fun findById(customerID: Long): Customer =
    this.customerRepository.findById(customerID).orElseThrow { throw RuntimeException("Id $customerID not found!") }

  override fun delete(customerID: Long) = this.customerRepository.deleteById(customerID)
}