package com.ifat.bdd.scala_exam.main

import com.ifat.bdd.scala_exam.config.Configuration
import com.ifat.bdd.scala_exam.control.Request
import com.ifat.bdd.scala_exam.repository.{ClientsRepo, PersonsRepo}
import com.ifat.bdd.scala_exam.service.{ClientsService, CollectService, FilterBy, PersonsService, RequestService}
import com.ifat.bdd.scala_exam.validators.AgeEmailPhoneValidator

class FlowExecute(config:Configuration) {
  private val clientRepo = new ClientsRepo;
  private val personsRepo = new PersonsRepo

  def run(): Unit = {
    loadData()
    execute(getRequest())
  }

  private def loadData()={
    // first stage load data
    val clientsService = new ClientsService(config.getProperties(config.CLIENT_FILE_PATH), clientRepo, new AgeEmailPhoneValidator)
    val personsService = new PersonsService(config.getProperties(config.PERSON_FILE_PATH), personsRepo, new AgeEmailPhoneValidator)
    clientsService.loadClients()
    personsService.loadPersons()
  }

  private def execute(request:Request): Unit ={
    val collectService = new CollectService(clientRepo, personsRepo)
    val listOfHuman = collectService.getAllHumans()
    println("\nRequested data ............................................................")
    listOfHuman.filter(human => FilterBy.filterBy(human, request)).foreach(human => println("requested > " + human))
  }


  private def getRequest() : Request={
    val requestService = new RequestService(config.getProperties(config.REQUEST_FILE_PATH))
    requestService.getRequest()
  }
}
