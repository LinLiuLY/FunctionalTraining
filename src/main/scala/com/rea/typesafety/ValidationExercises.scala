package com.rea.typesafety

import scalaz._, Scalaz._

object ValidationExercises {

  val allBad = Map[String,String]()
  val goodInput = Map("firstName" -> "Vladimir", "lastName" -> "Putin", "password" -> "crimea14")
  val passwordTooShort = goodInput + ("password" -> "crim3a")
  val passwordNoNumbers = goodInput + ("password" -> "crimeaasd")
  val passwordNoNumbersAndTooShort = goodInput + ("password" -> "crime")
  val noFirstName = goodInput - "firstName"
  val noLastName = goodInput - "lastName"

  def validateKey(key: String, input:Map[String,String]): ValidationNel[ErrorCode, String] = ???

  def nameValidation(name: String): ValidationNel[ErrorCode, String] = ???

  def passwordStrengthValidation(password: String): ValidationNel[ErrorCode, String] = ???

  def passwordLengthValidation(password: String): ValidationNel[ErrorCode, String] = ???

  def validateInput(input: Map[String, String]): ValidationNel[ErrorCode, String] = ???

  def main(args: Array[String]) {
     println("Good input = " + validateInput(goodInput))
     println("All Bad input" + validateInput(allBad))
  }


}

case class Person(firstName:String,lastName:String, password:String)

sealed trait ErrorCode

case object passwordToShort extends ErrorCode

case object passwordTooWeak extends ErrorCode

case class keyNotFound(key: String) extends ErrorCode

case class nameIsEmpty(key: String) extends ErrorCode
