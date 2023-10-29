package com.bruno.credit.aplication.system.controller

import com.bruno.credit.aplication.system.dto.CustomerDto
import com.bruno.credit.aplication.system.dto.CustomerUpdateDto
import com.bruno.credit.aplication.system.dto.CustomerView
import com.bruno.credit.aplication.system.model.Customer
import com.bruno.credit.aplication.system.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/customers")
class CustomerController(
  private val customerService: CustomerService
) {
  @PostMapping()
  fun saveCustomert(@RequestBody customerDto: CustomerDto): ResponseEntity<String>{
    val savedCustomer = this.customerService.save(customerDto.toEntity())
    return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email} saved...")
  }
  @GetMapping("/{id}")
  fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
    val customer:Customer = this.customerService.findById(id)
    return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
  }

  @DeleteMapping("/{id}")
  fun deleteById(@PathVariable id:Long){
    this.customerService.delete(id)
  }

  @PatchMapping()
  fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                     @RequestBody customerUpdateDto: CustomerUpdateDto): ResponseEntity<CustomerView>
  {
    val customer = this.customerService.findById(id)
    val customerToUpdate = customerUpdateDto.toEntity(customer)
    val customerUpdated = this.customerService.save(customerToUpdate)
    return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))


  }

}