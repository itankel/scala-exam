package com.ifat.bdd.scala_exam.controler

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

case class JRequest @JsonCreator()(@JsonProperty("min_age") minAge: String,
                                   @JsonProperty("max_age") maxAge: String,
                                   @JsonProperty("gender") gender: String,
                                   @JsonProperty("prefix_name") prefixName: String,
                                   @JsonProperty("Marital Status") maritalStatus: String,
                                   @JsonProperty("Number of Children") numberOfChildren: String) extends Serializable {
  println(s"JRequest: minAge = $minAge maxAge=$maxAge gender=$gender prefixName=$prefixName " +
    s"marialStatus=$maritalStatus numberOfChildren = $numberOfChildren")
}
