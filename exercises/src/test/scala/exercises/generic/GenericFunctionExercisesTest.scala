package exercises.generic

import exercises.generic.GenericFunctionExercises._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class GenericFunctionExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  ////////////////////
  // Exercise 1: Pair
  ////////////////////

  test("Pair swap") {
    assert(Pair(0, 1).swap == Pair(1, 0))
    assert(Pair("John", "Doe").swap == Pair("Doe", "John"))
  }

  test("Pair map") {
    assert(Pair(0, 1).map(identity) == Pair(0, 1))
  }

  test("Pair decoded") {


  }

  test("Pair zipWith") {
    assert(Pair(0, 2).zipWith(Pair(3, 4))((x, y) => x + y) == Pair(3, 6))
  }

  test("Pair productNames") {}

  ////////////////////////////
  // Exercise 2: Predicate
  ////////////////////////////

  test("Predicate &&") {

    assert((isEven && isPositive) (12) == true)
    assert((isEven && isPositive) (11) == false)
    assert((isEven && isPositive) (-4) == false)
    assert((isEven && isPositive) (-7) == false)
  }

  test("Predicate && PBT") {
    forAll { (eval1: Int => Boolean, value: Int) =>
      val p1 = Predicate(eval1)

      assert((p1 && Predicate.False) (value) == false)
      assert((p1 && Predicate.True) (value) == p1(value))

      //def False[A]: Predicate[A] = Predicate(_ => false)
      //def True[A]: Predicate[A] = Predicate(_ => true)

      //assert((p1 && False) (value) == false)
      //assert((p1 && True) (value) == p1(value))

      //(p1 && p2).eval(value)
      //(p1 && p2) (value)
    }
  }

  test("Predicate || PBT") {
    forAll { (eval1: Int => Boolean, value: Int) =>
      val p1 = Predicate(eval1)

      assert((p1 || Predicate.False) (value) == p1(value))
      assert((p1 || Predicate.True) (value) == true)
    }
  }


  ignore("Predicate ||") {}

  test("Predicate flip") {
    assert(Predicate.True.flip(5) == false)
    assert(Predicate.False.flip(-5) == true)

    //assert(isPositive.flip(5) == false)
    //assert(isPositive.flip(-5) == true)
  }

  test("Predicate isValidUser"){
    assert(isValidUser(User("John", 20)) == true)
    assert(isValidUser(User("John", 17)) == false)
    assert(isValidUser(User("john", 20)) == false)
    assert(isValidUser(User("x"   , 23)) == false)
  }

  ////////////////////////////
  // Exercise 3: JsonDecoder
  ////////////////////////////

  test("JsonDecoder UserId") {}

  test("JsonDecoder LocalDate") {}

  test("JsonDecoder weirdLocalDateDecoder") {}

}
