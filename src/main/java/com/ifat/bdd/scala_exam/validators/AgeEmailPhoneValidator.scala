package com.ifat.bdd.scala_exam.validators

import com.ifat.bdd.scala_exam.extensions.Extensions.StringDataExt
import com.ifat.bdd.scala_exam.model.Human

class AgeEmailPhoneValidator extends Validator {
  override def validate(human: Human): Boolean = {
    val validity= human.age >0 && human.email.isEmail && human.phone.isPhone()
    println(s"Is valid ? $validity  see: ${human} \n")
    validity
  }
}
