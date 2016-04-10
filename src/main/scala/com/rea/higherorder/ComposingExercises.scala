package com.rea.higherorder

object ComposingExercises {


  def add(a: Int, b: Int) = a + b

  // 1. We want to partially apply add
  def addTwo: Int => Int = a => add(a, 2)

  println(addTwo(5))

  def subtract(a: Int, b: Int) = a - b

  // 2. We want to partially apply subtract
  def minusThree: Int => Int = a => subtract(a, 3)

  println(minusThree(5))

  // 3. How do we create a new function from addTwo and minusThree?
  val addTwoMinusThree: Int => Int = a => addTwo(a) + minusThree(a)
  
  def prettyPrint(i:Int) = s"The number is $i"

  //4.
  val addTwoMinusThreePrettyPrint: Int => String = a => prettyPrint(addTwoMinusThree(a))

  // 5. How do we convert (compose) f and g into a brand new function?
  // def compose_[A, B, C](f: B => C, g: A => B): A => C = ???

  def compose_[A, B, C](f: B => C, g: A => B): A => C = {
    x:A => f(g(x))
  } 

}


