package com.ifat.bdd.scala_exam.repository

import com.ifat.bdd.scala_exam.model.Client

import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.collection.mutable.ArrayBuffer

class ClientsRepo {
  private var clientsArray =ArrayBuffer[Client]()

  def addClient(client:Client): Unit ={
    clientsArray+=client
  }

  def getAll() :ArrayBuffer[Client] = {
    clientsArray.map(identity)
  }


}
