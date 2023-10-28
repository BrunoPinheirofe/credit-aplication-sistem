package com.bruno.credit.aplication.system.model

import jakarta.persistence.*

@Entity
@Table(name = "tb_customer")
data class Customer(
  @Column(nullable = false)
  var fistName: String = "",
  @Column(nullable = false)
  var lastName: String = "",
  @Column(nullable = false, unique = true)
  val cpf: String,
  @Column(nullable = false, unique = true)
  var email: String = "",
  @Column(nullable = false)
  var password: String,
  @Column(nullable = false)
  @Embedded
  var address: Address = Address(),
  @Column(nullable = false)
  @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST), mappedBy = "customer")
  var credits: List<Credit> = mutableListOf(),
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null
)
