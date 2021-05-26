package com.ifat.bdd.scala_exam.controler

import com.ifat.bdd.scala_exam.model.Gender.Gender
import com.ifat.bdd.scala_exam.model.MaritalStatus.MaritalStatus

case class Request(minAge: Int, maxAge: Int, gender: Gender, prefixName: String,
                   maritalStatus: MaritalStatus, numberOfChildren: Int) {
  //println(s"Request: minAge=$minAge maxAge=$maxAge gender=$gender prefixName=$prefixName " +
  //  s"marialStatus=$maritalStatus NumberOfChildren=$numberOfChildren")
}
