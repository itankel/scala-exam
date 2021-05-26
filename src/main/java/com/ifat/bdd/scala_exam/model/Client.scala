package com.ifat.bdd.scala_exam.model

import com.ifat.bdd.scala_exam.control.Request
import com.ifat.bdd.scala_exam.model.Gender.{Gender, NONE}
import com.ifat.bdd.scala_exam.model.MaritalStatus.MaritalStatus

case class Client(firstName: String, lastName: String, gender: Gender, age: Int, email: String,
                  phone: String, education: String, occupation: String,
                  salary: Int, maritalStatus: MaritalStatus, numberOfChildren: Int)  extends Human {
  println(s" firstName= $firstName lastName=$lastName gender=$gender age=$age email=$email " +
    s"phone=$phone education=$education occupation=$occupation salary=$salary " +
    s"maritalStatus=$maritalStatus numberOfChildern=$numberOfChildren")


  override def filterBy(request:Request): Boolean = {
    request match {
      case Request(-1, -1, NONE, "", MaritalStatus.NONE, -1) => true
      case Request(min, -1,NONE,"" , MaritalStatus.NONE, -1) => this.age >= min
      case Request(-1, max, NONE, "", MaritalStatus.NONE, -1) => this.age <= max
      case Request(min, max, NONE, "",MaritalStatus.NONE, -1) => this.age >= min && this.age <= max
      case Request (-1, -1, NONE, prefixName, MaritalStatus.NONE, -1) => (this.firstName+this.lastName).toUpperCase.startsWith(prefixName.toUpperCase)
      case Request (-1, -1,gender,"",MaritalStatus.NONE, -1) => this.gender==gender
      case Request (-1, -1, gender,"",maritalStatus, numberOfChildren) => gender==this.gender && maritalStatus==this.maritalStatus && numberOfChildren ==this.numberOfChildren
      case Request(_, _, _, _, _, _) => true
    }
  }
}

