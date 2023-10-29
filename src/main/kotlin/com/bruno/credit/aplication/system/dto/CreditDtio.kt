package com.bruno.credit.aplication.system.dto

import com.bruno.credit.aplication.system.model.Credit
import com.bruno.credit.aplication.system.model.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDtio(
  val creditValue:BigDecimal = BigDecimal.ZERO,
  val dateFistInstallment: LocalDate,
  val numberOfInstallments: Int = 0,
  val customerId: Long
) {
  fun toEntity(): Credit = Credit(
    creditValue = this.creditValue,
    dateFistInstallment = this.dateFistInstallment,
    numberOfInstallments = this.numberOfInstallments,
    customer = Customer(id = this.customerId)

  )


}
