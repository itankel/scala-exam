package com.ifat.bdd.scala_exam.service

import java.io.File

import com.ifat.bdd.scala_exam.extensions.Extensions.ClientExtensionConverter
import com.ifat.bdd.scala_exam.repository.ClientsRepo
import com.ifat.bdd.scala_exam.validators.Validator
import org.apache.poi.ss.usermodel.{DataFormatter, Row, WorkbookFactory}

import scala.collection.mutable.ArrayBuffer

class ClientsService(val fileName: String, repo: ClientsRepo, validator: Validator) {
  private val workbook = WorkbookFactory.create(new File(fileName))
  private val sheet = workbook.getSheetAt(0)

  def loadClients() = {
    println("Start loading clients data  .........................................................")
    val formatter = new DataFormatter()
    for (r <- sheet.getFirstRowNum to sheet.getLastRowNum) {
      val currentRow = sheet.getRow(r)
      if (currentRow.getRowNum > 0) {
        println(s"row $currentRow")
        val cells = ArrayBuffer[String]()
        for (c <- currentRow.getFirstCellNum to currentRow.getLastCellNum) {
          val opCell = currentRow.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL)
          cells += formatter.formatCellValue(opCell)
        }
        println(cells)
        val client = cells.toClient
        if (validator.validate(client)) repo.addClient(cells.toClient)
      }
    }
    println("Finished loading clients data  .........................................................")
  }

}
