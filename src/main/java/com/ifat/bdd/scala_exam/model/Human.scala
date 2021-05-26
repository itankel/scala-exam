package com.ifat.bdd.scala_exam.model

import com.ifat.bdd.scala_exam.control.Request
import com.ifat.bdd.scala_exam.model.Gender.Gender

trait Human {
  val age: Int
  val gender: Gender
  val email: String
  val phone: String
  def filterBy(request: Request) :Boolean
}