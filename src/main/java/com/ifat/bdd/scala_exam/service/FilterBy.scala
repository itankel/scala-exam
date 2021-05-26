package com.ifat.bdd.scala_exam.service

import com.ifat.bdd.scala_exam.controler.Request
import com.ifat.bdd.scala_exam.model.Human

object FilterBy {
  def filterBy(human:Human,request:Request):Boolean= {
    human.filterBy(request)
  }
}
