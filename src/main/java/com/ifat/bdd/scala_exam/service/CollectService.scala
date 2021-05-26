package com.ifat.bdd.scala_exam.service

import com.ifat.bdd.scala_exam.repository.{ClientsRepo, PersonsRepo}

class CollectService(clientsRepo: ClientsRepo, personsRepo: PersonsRepo) {

  def getAllHumans()={
    clientsRepo.getAll()++personsRepo.getAll()
  }
}
