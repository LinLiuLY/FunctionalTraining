package com.rea.higherorder

/*
 * DO NOT ATTEMPT these exercises until you've completed the recursion ones.
 */

 // ref: https://oldfashionedsoftware.com/2009/07/30/lots-and-lots-of-foldleft-examples/


object FoldingExercises {

  /**
   *
   * foldLeft will reduce a list of A's down to a B. It takes an initial value of type B
   * and a list of A's.  It also takes a function which takes the accumulated value of type B
   * and the next value in the list (of type A) and returns a value which will be feed back into
   * the accumulator of the next call.
   *
   * As the name suggests it processes the list from left to right.
   *
   * Have a close look at your implementations from the RecursionExercises.  Which parts could you
   * pull out to a function to make them all common?  Your implementation will be very close to
   * foldLeft.
   *
   * Good luck!
   *
   */

  //The foldLeft function goes through the whole List, from head to tail

  def foldLeft[A, B](initialValue: B, list: List[A])(f: (B, A) => B): B = ???

  /**
   * foldRight is the same as foldLeft, except it processes the list from right to left.
   */

   //The foldRight function goes through the whole List, from tail to head
  def foldRight[A,B](initialValue:B, list: List[A])(f: (A,B) => B):B = ???

  /**
   * Remember these, from our recursion exercises?  They can all be implemented with either
   * foldLeft or foldRight.
   */

   //def sum(list: List[Int]): Int = list.foldLeft(0)((r,c) => r+c)
   //The foldLeft method takes that initial value, 0, and the function literal, and it begins to apply the function on each member of the list (parameter ‘c’), updating the result value (parameter ‘r’) each time. That result value that we call ‘r’ is sometimes called the accumulator, since it accumulates the results of the function calls.

  def sum(l: List[Int]): Int = foldLeft(0, l)(_+_) //The first ‘_’ stands for ‘r’, and the second one stands for ‘c’.



  def length[A](x: List[A]): Int = foldLeft(0, x)((sum, _) => sum + 1)


  //List(1,2,3).foldRight(List[Int]())((element,result) => (element + 1) :: result)
  def map[A, B](x: List[A])(f: A => B): List[B] = foldRight(List[B](), x)((element, result) => f(element) :: result)

 
  //List(1,2,3).foldRight(List[Int]())( (element, result) => if (element >=2) (element :: result) else result ) 
  def filter[A](x: List[A], f: A => Boolean): List[A] = foldRight(List[A](), x)( (element, result) => if (element >=2) (element :: result) else result )


 //List(1,2,3).foldRight(List(4,5,6))((element, result) => element :: result)
 //result: List(1, 2, 3, 4, 5, 6)

  def append[A](x: List[A], y: List[A]): List[A] = foldRight(y,x)((element, result) => element :: result)


 //List(List(1,2), List(9,0)).foldRight(List[Int]())((element, result) => element ++ result)
 //result: List(1, 2, 9, 0)
  def flatten[A](x: List[List[A]]): List[A] = foldRight(List[A](), x)((element, result) => append(element, result))


  def flatMap[A, B](x: List[A], f: A => List[B]): List[B] = flatten(map(x)(f))


  //List(1,2,3).foldLeft(0)( (max, element) => if (max <= element) element else max )
  //result: 3
  // Maximum of the empty list is 0
  def maximum(x: List[Int]): Int = foldLeft(0, x)((max, element) => if (max <= element) element else max )


  //List(1,2,3).foldLeft(List[Int]())( (result, element) => element :: result)
  //result: List(3, 2, 1)
  def reverse[A](x: List[A]): List[A] = foldLeft(List[A](), x)((result, element) => element :: result)

}
