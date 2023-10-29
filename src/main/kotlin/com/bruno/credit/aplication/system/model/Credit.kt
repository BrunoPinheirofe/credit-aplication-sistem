package com.bruno.credit.aplication.system.model

import com.bruno.credit.aplication.system.enummeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name ="tb_credit")
data class Credit(
  @Column(unique = true, nullable = false)
  val creditCode: UUID? = UUID.randomUUID(),
  @Column(nullable = false)
  val creditValue: BigDecimal = BigDecimal.ZERO,
  @Column(nullable = false)
  val dateFistInstallment: LocalDate,
  @Column(nullable = false)
  val numberOfInstallments: Int = 0,
  @Column(nullable = false)
  @Enumerated
  val status: Status = Status.IN_PROGESS,
  @ManyToOne
  var customer: Customer? = null,
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null


)
