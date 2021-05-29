package com.ifat.bdd.scala_exam.main

import com.ifat.bdd.scala_exam.config.Configuration



object Main {

  def main(args: Array[String]): Unit = {

    val appConfig= new Configuration()
    appConfig.readConfig()

    new FlowExecute(appConfig).run()
    println("end")

  }
}