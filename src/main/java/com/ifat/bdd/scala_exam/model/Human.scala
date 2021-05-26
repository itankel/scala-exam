package com.ifat.bdd.scala_exam.model

import com.ifat.bdd.scala_exam.controler.Request
import com.ifat.bdd.scala_exam.model.Gender.Gender

trait Human {
  val age: Int
  val gender: Gender
  val email: String
  val phone: String
  def filterBy(request: Request) :Boolean
}

//  Person(                Client(
//  age: Int,                  age: Int
//  name: String,              firstName: String,
//                             lastName: String
//  gender: Gender,             gender: Gender
//  company: String,
//  email: String,              email: String,
//  phone: String,              phone: String,
//  address: String
//                              education: String,
//                              occupation: String,
//                              salary: Int,
//                              maritalStatus: MaritalStatus,
//                              numberOfChildren: Int)