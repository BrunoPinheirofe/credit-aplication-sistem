package com.bruno.credit.aplication.system.dto

import com.bruno.credit.aplication.system.enummeration.Status
import com.bruno.credit.aplication.system.model.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
  val creditCode: UUID,
  val crediValue: BigDecimal,
  val status: Status,
  val emailCustomer: String?,
  val incomeCustomer: BigDecimal?
){

  constructor(credit: Credit): this(
    creditCode = credit.creditCode,
    crediValue = credit.creditValue,
    status = credit.status,
    emailCustomer = credit.customer?.email,
    incomeCustomer = credit.customer?.income
  )

}
