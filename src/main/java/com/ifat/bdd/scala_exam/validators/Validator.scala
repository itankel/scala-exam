package com.ifat.bdd.scala_exam.validators

import com.ifat.bdd.scala_exam.model.Human

trait Validator {
  def validate(human: Human): Boolean
}
