package com.ifat.bdd.scala_exam.main

import com.ifat.bdd.scala_exam.config.Configuration
import com.ifat.bdd.scala_exam.repository.{ClientsRepo, PersonsRepo}
import com.ifat.bdd.scala_exam.service.{ClientsService, CollectService, FilterBy, PersonsService, RequestService}
import com.ifat.bdd.scala_exam.validators.AgeEmailPhoneValidator



object MainObj {

  def main(args: Array[String]): Unit = {

    val appConfig= new Configuration()
    appConfig.readConfig()

    // first stage load data
    val clientRepo = new ClientsRepo;
    val personsRepo = new PersonsRepo
    val clientsService = new ClientsService(appConfig.getProperties(appConfig.CLIENT_FILE_PATH), clientRepo, new AgeEmailPhoneValidator)
    val personsService = new PersonsService(appConfig.getProperties(appConfig.PERSON_FILE_PATH), personsRepo, new AgeEmailPhoneValidator)
    clientsService.loadClients()
    personsService.loadPersons()

    // read the request
    val requestService = new RequestService(appConfig.getProperties(appConfig.REQUEST_FILE_PATH))
    val request = requestService.getRequest()

    //collect
    val collectService = new CollectService(clientRepo, personsRepo)
    val listOfHuman = collectService.getAllHumans()
    println("\nRequested data ............................................................")
    listOfHuman.filter(human => FilterBy.filterBy(human, request)).foreach(human => println("requested > " + human))
    println("end")

    // dump the response to console


  }
}