package com.rea.higherorder

object ComposingExercises {
  //compose makes a new function that composes other functions f(g(x))
  //val fComposeG = f _ compose g _

  //def addUmm(x: String) = x + " umm"
  //def addAhem(x: String) = x + " ahem"
  //val ummThenAhem = addAhem _ compose addUmm

  //addAhem is a method. compose method is defined on functions. 
  //addAhem _ converts addAhem from method to function, so compose can be called on it. 
  //compose expects a function as it's argument. 
  //You are giving it a method addUmm by converting addUmm into a function with addUmm _ 

  //(The underscore can be left out because the compiler can automatically convert a method into a function when it knows that a function is expected anyway)
  //addUhum _
  //is an eta expansion. It converts methods into functions.



  def add(a: Int, b: Int) = a + b

  // 1. We want to partially apply add
  def addTwo: Int => Int = add(_, 2)

  println(addTwo(5))

  def subtract(a: Int, b: Int) = a - b

  // 2. We want to partially apply subtract
  def minusThree: Int => Int = subtract(_, 3)

  println(minusThree(5))


  // 3. How do we create a new function from addTwo and minusThree?
  val addTwoMinusThree: Int => Int = addTwo compose minusThree

  println(addTwoMinusThree(5))

  //if def addTwo(x: Int)= add(2,x) 
  //if def minusThree(x: Int)= subtract(x,3)
  //Then al addTwoMinusThree: Int => Int = addTwo _ compose minusThree 
  //should add the underscore

  
  def prettyPrint(i:Int) = s"The number is $i"

  //4.
  val addTwoMinusThreePrettyPrint: Int => String = prettyPrint _ compose addTwoMinusThree

  println(addTwoMinusThreePrettyPrint(9))

  // 5. How do we convert (compose) f and g into a brand new function?
  // def compose_[A, B, C](f: B => C, g: A => B): A => C = ???

  def compose_[A, B, C](f: B => C, g: A => B): A => C = {
    x:A => f(g(x))
  } 

}


