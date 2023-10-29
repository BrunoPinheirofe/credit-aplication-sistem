package com.bruno.credit.aplication.system.service.impl

import com.bruno.credit.aplication.system.model.Credit
import com.bruno.credit.aplication.system.repository.CreditRepository
import com.bruno.credit.aplication.system.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*


@Service
class CreditService(
  private val creditRepository: CreditRepository,
  private val custumerService: CustomerService
): ICreditService {
  override fun save(credit: Credit): Credit {
    credit.apply {
      customer = custumerService.findById(credit.customer?.id!!)
    }
     return this.creditRepository.save(credit)
  }

  override fun findAllByCustomer(customerID: Long): List<Credit> = this.creditRepository.findAllByCustomer(customerID)

  override fun findByCredtCode(customerID: Long, creditCode: UUID): Credit {
   val credit:Credit = (this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("CreditCode: $creditCode not found"))
  return if(credit.customer?.id == customerID) credit else throw RuntimeException("contact admin")
  }
}