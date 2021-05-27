package com.ifat.bdd.scala_exam.main

import com.ifat.bdd.scala_exam.config.Configuration
import com.ifat.bdd.scala_exam.repository.{ClientsRepo, PersonsRepo}
import com.ifat.bdd.scala_exam.service.{ClientsService, CollectService, FilterBy, PersonsService, RequestService}
import com.ifat.bdd.scala_exam.validators.AgeEmailPhoneValidator



object Main {

  def main(args: Array[String]): Unit = {

    val appConfig= new Configuration()
    appConfig.readConfig()

    new FlowExecute(appConfig).run()
    println("end")

  }
}