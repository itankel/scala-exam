package com.ifat.bdd.scala_exam.service

import java.io.File
import java.util.List

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.ifat.bdd.scala_exam.model.JPerson
import com.ifat.bdd.scala_exam.repository.PersonsRepo
import com.ifat.bdd.scala_exam.extensions.Extensions._
import com.ifat.bdd.scala_exam.validators.Validator

import scala.jdk.CollectionConverters._

class PersonsService(fileName:String, personRepo: PersonsRepo, validator :Validator) {
  private val objectMapper: ObjectMapper = new ObjectMapper

  def loadPersons(): Unit ={
    println("Start loading person data .........................................................")
    getPersons.filter(jPerson=>isValid(jPerson))
      .foreach(jPerson=>personRepo.addPerson(jPerson.toPerson()))
    println(s"Finished loading person data .....................................................")
  }

  private def getPersons() : Iterable[JPerson] ={
    objectMapper.readValue(new File(fileName), new TypeReference[List[JPerson]]() {}).asScala
  }

  private def isValid(jPerson:JPerson):Boolean ={
    validator.validate(jPerson.toPerson)
  }

}
