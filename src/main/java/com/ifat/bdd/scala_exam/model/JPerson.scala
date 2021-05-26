package com.ifat.bdd.scala_exam.model

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

@JsonCreator
case class JPerson @JsonCreator()(@JsonProperty("age") age: Int, @JsonProperty("name") name: String,
                                  @JsonProperty("gender") gender: String, @JsonProperty("company") company: String,
                                  @JsonProperty("email") email: String, @JsonProperty("phone") phone: String,
                                  @JsonProperty("address") address: String) extends Serializable {
  println(s"JPerson: age=$age name= $name gender=$gender Company=$company Email = $email " +
    s"phone=$phone address=$address")
}
