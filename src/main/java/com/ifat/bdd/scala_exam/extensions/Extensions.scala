package com.ifat.bdd.scala_exam.extensions

import com.ifat.bdd.scala_exam.control
import com.ifat.bdd.scala_exam.control.{JRequest, Request}
import com.ifat.bdd.scala_exam.model._

import scala.collection.mutable.ArrayBuffer

object Extensions {

  implicit class ClientExtensionConverter(rowData: ArrayBuffer[String]) {
    def toClient(): Client = {
      Client(rowData(0).trim, rowData(1).trim, Gender.withName(rowData(2).trim.toUpperCase), rowData(3).trim.toInt,
        rowData(4).trim, rowData(5).trim, rowData(6).trim,
        rowData(7).trim, rowData(8).trim.toInt, MaritalStatus.withName(rowData(9).trim.toUpperCase), rowData(10).trim.toInt)
    }
  }

  implicit class PersonExtensionConverter(jPerson: JPerson) {
    def toPerson(): Person = {
      Person(jPerson.age, jPerson.name.trim, Gender.withName(jPerson.gender.toUpperCase), jPerson.company.trim
        , jPerson.email.trim, jPerson.phone.trim, jPerson.address.trim)
    }
  }

  implicit class RequestExtensionConverter(jRequest: JRequest) {
    def toRequest(): Request = {
      val request :Request = jRequest match {
        case JRequest(null,null,null,null,null,null) =>control.Request(-1,-1,Gender.NONE,"",MaritalStatus.NONE,-1)
        case JRequest(minAge,null,null,null,null,null) => control.Request(jRequest.minAge.toInt,-1,Gender.NONE,"",MaritalStatus.NONE,-1)
        case JRequest(null,maxAge,null,null,null,null) => control.Request(-1,jRequest.maxAge.toInt,Gender.NONE,"",MaritalStatus.NONE,-1)
        case JRequest(minAge,maxAge,null,null,null,null) => control.Request(jRequest.minAge.toInt,jRequest.maxAge.toInt,Gender.NONE,"",MaritalStatus.NONE,-1)
        case JRequest(null,null,null,prefixName,null,null) => control.Request(-1,-1,Gender.NONE,jRequest.prefixName,MaritalStatus.NONE,-1)
        case JRequest(null,null,gender,null,null,null) => control.Request(-1,-1,Gender.withName(jRequest.gender.toUpperCase),"",MaritalStatus.NONE,-1)
        case JRequest(null,null,gender,null,maritalStatus,numberOfChildren) => control.Request(-1,-1,Gender.withName(jRequest.gender.toUpperCase)
          ,"",MaritalStatus.withName(jRequest.maritalStatus.trim.toUpperCase),jRequest.numberOfChildren.toInt)
        case _ => control.Request(-1,-1,Gender.NONE,"",MaritalStatus.NONE,-1)
      }
      request
    }
  }


  implicit class StringDataExt(str: String) {

    private val emailRegex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r

    def isEmail(): Boolean = {
      str match {
        case null => false
        case str if str.trim.isEmpty => false
        case str if emailRegex.findFirstMatchIn(str).isDefined => true
        case _ => false
      }
    }

    private val phoneReg = """^(\d{3}[-])(\d{4}[-])\d{2}$|^(\+\d{1,3}( )?)?((\(\d{3}\))|\d{3})[- .]?\d{3}[- .]?\d{4}$""".r

    def isPhone(): Boolean = {
      str match {
        case null => false
        case str if str.trim.isEmpty => false
        case str if phoneReg.findFirstMatchIn(str).isDefined => true
        case _ => false
      }
    }
  }
}
