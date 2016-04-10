package com.rea.higherorder

object ComposingExercises {
  //compose makes a new function that composes other functions f(g(x))
  //val fComposeG = f _ compose g _

  def add(a: Int, b: Int) = a + b

  // 1. We want to partially apply add
  def addTwo: Int => Int = add(_, 2)

  println(addTwo(5))

  def subtract(a: Int, b: Int) = a - b

  // 2. We want to partially apply subtract
  def minusThree: Int => Int = subtract(_, 3)

  println(minusThree(5))

  // 3. How do we create a new function from addTwo and minusThree?
  val addTwoMinusThree: Int => Int = addTwo _ compose minusThree _

  println(addTwoMinusThree(5))

  
  def prettyPrint(i:Int) = s"The number is $i"

  //4.
  val addTwoMinusThreePrettyPrint: Int => String = prettyPrint _ compose addTwoMinusThree _

  println(addTwoMinusThreePrettyPrint(9))

  // 5. How do we convert (compose) f and g into a brand new function?
  // def compose_[A, B, C](f: B => C, g: A => B): A => C = ???

  def compose_[A, B, C](f: B => C, g: A => B): A => C = {
    x:A => f(g(x))
  } 

}


