package com.ifat.bdd.scala_exam.repository

import com.ifat.bdd.scala_exam.model.{ Person}

import scala.collection.mutable.ArrayBuffer

class PersonsRepo {
  private var personArray =ArrayBuffer[Person]()

  def addPerson(person:Person): Unit ={
    personArray+=person
  }

  def getAll() :ArrayBuffer[Person] = {
    personArray.map(identity)
  }

}
