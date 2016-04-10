package com.rea.recursion


// Taken from http://tmorris.net/posts/scala-exercises-for-beginners/index.html

/**
 * Ok here are the rules.
 *
 * You can't use any of the standard list functions, like `map`, `filter`, `flatMap`, `append`, `:::`, `:+`, etc.
 * 
 * But you can always use `::` to construct a new list by prepending an element to another list.
 *
 * You CAN and are encouraged to use the solutions from the exercises below to solve the harder
 * ones towards the end.
 *
 * Keep an eye out for repetition and similarities between your answers.
 *
 * REMEMBER: Follow the types, they almost always guide you to the solution.  If it compiles and looks a little
 * too simple, it's probably correct.  As Sherlock Holmes once said, "Each one is suggestive, together they are
 * most certainly conclusive."
 *
 * See if you can make your solution tail recursive, where possible.
 *
 */
object RecursionExercises1 {

  def plusOne(n: Int) = n + 1

  def minusOne(n: Int) = n - 1

  // Add two non-negative Integers together.  You are only allowed to use plusOne and minusOne above
  // def add(a: Int, b: Int): Int = ???

  def add(a: Int, b: Int): Int = plusOne(a) + minusOne(b)

  println(add(5,6))

  // You are not permitted to use any list functions such as map, flatMap, ++, flatten etc
  //def sum(l: List[Int]): Int = ???

  
  def sum(l: List[Int]): Int = l match {
    case h :: t => h + sum(t)
    case Nil => 0 //Nil– Represents an emptry List of anything of zero length. Its not that it refers to nothing but it refers to List which has no contents
  }

  println(sum(List(1, 2, 3, 9)))

  //Again no list functions are permitted for the following
  //def length[A](x: List[A]): Int = ???

  def length[A](x: List[A]): Int =  x match {
    case h :: t =>  1 + length(t)
    case Nil => 0
  }

  println(length(List(1, 2, 3, 9)))

  // Do you notice anything similar between sum and length? Hmm...

  // Mapping over a list.  You are given a List of type A and a function converting an A to a B
  // and you give back a list of type B.  No list functions allowed!
  def map[A, B](x: List[A], f: A => B): List[B] = x match {
    case h :: t => f(h) :: map(t, f)
    case Nil => Nil
  }

  println(map(List(1, 2, 3, 9), (x:Int) => x+1 ))


  // Given a function from A => Boolean, return a list with only those item where the function returned true.
  //def filter[A](x: List[A], f: A => Boolean): List[A] = ???

  def filter[A](x: List[A], f: A => Boolean): List[A] = x match {
    case h :: t if f(h) => h :: filter(t, f) 
    case h :: t if !f(h) => filter(t, f)
    case Nil => Nil
  }  

  println(filter(List(1, 2, 3, 9), (x:Int) => x > 2 ))


  // This pattern should be familiar by now... psst... look at add.
  def append[A](x: List[A], y: List[A]): List[A] = x match {
    case Nil => y
    case h :: t => h :: append(t, y)
  }

  println(append(List(1,2,3), List(0,9,8)))

  // Flatten a list of lists to a single list.  Remember you can't use list.flatten.  Can you use a previous
  // solution to solve this one?
  //def flatten[A](x: List[List[A]]): List[A] = ???

  def flatten[A](x: List[List[A]]): List[A] = x match {
    case h :: t => append(h , flatten(t))
    case Nil => Nil
  }

  println(flatten(List(List(1,2,3), List(4,5,6))))

  // Follow the types.  You've done a great job getting here. Follow the types.
  // def flatMap[A, B](x: List[A], f: A => List[B]): List[B] = ???

  def flatMap[A, B](x: List[A], f: A => List[B]): List[B] = x match {
    case h :: t => flatten(map(x, f))
    case Nil => Nil
  }

  println(flatMap(List(1,2,3), (x : Int) => List(x+1, x , x-1)))

  // Maximum of the empty list is 0
  //def maximum(x: List[Int]): Int = ???

  def maximum(x: List[Int]): Int = x match {
    case Nil => 0
    case h :: t if h > maximum(t) => h 
    case h :: t if h <= maximum(t) => maximum(t)  
  }

  println(maximum(List(3,5,6,0,9,14)))


  // Reverse a list
  def reverse[A](x: List[A]): List[A] = x case {
    case h :: t => append(reverse(t), List(h))
    case Nil => Nil
  }

  println(reverse(List(5,3,9)))

}
