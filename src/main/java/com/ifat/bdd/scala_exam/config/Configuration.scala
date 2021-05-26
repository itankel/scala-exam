package com.ifat.bdd.scala_exam.config

import java.util.Properties

import scala.io.Source

class Configuration {
  private val CONFIG_FILE_NAME = "/application.properties"
  val PERSON_FILE_PATH = "person_file_path"
  val CLIENT_FILE_PATH = "client_file_path"
  val REQUEST_FILE_PATH = "request_file_path"

  private val properties: Properties = new Properties()

  def readConfig(): Unit = {
    val url = getClass.getResource(CONFIG_FILE_NAME)
    if (url != null) {
      val source = Source.fromURL(url)
      properties.load(source.bufferedReader())
    }
    else {
      println("Can't find application.properties file in " + url.getPath)
    }

  }

  def getProperties(propertyName: String): String = {
    properties.getProperty(propertyName)
  }


}
