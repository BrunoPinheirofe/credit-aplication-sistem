package com.bruno.credit.aplication.system.repository

import com.bruno.credit.aplication.system.model.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
  fun findByCreditCode (creditCode: UUID): Credit?

  @Query(value = "SELECT * FROM TB_CREDIT WHERE CUSTOMER_ID = ?1", nativeQuery = true)
  fun findAllByCustomer(customerId: Long): List<Credit>
}