package com.ifat.bdd.scala_exam.service

import java.io.File

import com.fasterxml.jackson.databind.ObjectMapper
import com.ifat.bdd.scala_exam.controler.{JRequest, Request}
import com.ifat.bdd.scala_exam.extensions.Extensions.RequestExtensionConverter


class RequestService(requestFileName: String) {
  private val objectMapper: ObjectMapper = new ObjectMapper

  def getRequest(): Request = {
    println("Getting request.............................................................")
    loadRequest().toRequest()
  }

  private def loadRequest(): JRequest = {
    objectMapper.readValue(new File(requestFileName), classOf[JRequest])
  }

}
