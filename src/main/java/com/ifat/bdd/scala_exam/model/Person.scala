package com.ifat.bdd.scala_exam.model

import com.ifat.bdd.scala_exam.control.Request
import com.ifat.bdd.scala_exam.model.Gender.{Gender, NONE}

case class Person(age: Int, name: String, gender: Gender, company: String,
                  email: String, phone: String, address: String) extends Human{
  println(s"Person: age=$age name= $name gender=$gender Company=$company Email = $email " +
    s"phone=$phone address=$address")

  override def filterBy(request:Request): Boolean = {
    request match {
      case Request(-1, -1, NONE, "", MaritalStatus.NONE, -1) => true
      case Request (-1, -1,gender,"",maritalStatus, numberOfChildren) => false
      case Request(min, -1,NONE,"" , MaritalStatus.NONE, -1) => this.age >= min
      case Request(-1, max, NONE, "", MaritalStatus.NONE, -1) => this.age <= max
      case Request(min, max, NONE, "",MaritalStatus.NONE, -1) => this.age >= min && this.age <= max
      case Request (-1, -1, NONE, prefixName, MaritalStatus.NONE, -1) => this.name.toUpperCase.startsWith(prefixName.toUpperCase)
      case Request (-1, -1,gender,"",MaritalStatus.NONE, -1) => this.gender==gender
      case Request(_, _, _, _, _, _) => true
    }
  }
}

