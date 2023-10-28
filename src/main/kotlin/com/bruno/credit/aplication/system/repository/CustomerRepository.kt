package com.bruno.credit.aplication.system.repository

import com.bruno.credit.aplication.system.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CustomerRepository: JpaRepository<Customer,Long> {
}