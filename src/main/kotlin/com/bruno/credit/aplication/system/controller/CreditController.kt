package com.bruno.credit.aplication.system.controller

import com.bruno.credit.aplication.system.dto.CreditDtio
import com.bruno.credit.aplication.system.dto.CreditView
import com.bruno.credit.aplication.system.dto.CreditViewList
import com.bruno.credit.aplication.system.model.Credit
import com.bruno.credit.aplication.system.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credit")
class CreditController(
  private val creditService: CreditService
)
{
  @PostMapping
  fun saveCredit(@RequestBody creditDto: CreditDtio): ResponseEntity<String>{
    val creditToSave = this.creditService.save(creditDto.toEntity())
    return ResponseEntity.status(HttpStatus.CREATED)
      .body("Credit ${creditToSave} - Customer ${creditToSave.customer?.firstName} saved")
  }
  @GetMapping()
  fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>>{
    val creditViewList: List<CreditViewList> = this.creditService.findAllByCustomer(customerId).stream()
      .map { credit: Credit -> CreditViewList(credit) }.collect(Collectors.toList())
    return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
  }

  @GetMapping("/{creditCode}")
  fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long, @PathVariable creditCode: UUID):
    ResponseEntity<CreditView> {
  val credit: Credit = this.creditService.findByCredtCode(customerId, creditCode)
    return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))

  }

}