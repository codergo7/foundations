package exercises.valfunction

import exercises.valfunction.ValueFunctionExercises._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class ValueFunctionExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  /////////////////////////////////////////////////////
  // Exercise 1: String API with higher-order functions
  /////////////////////////////////////////////////////

  // replace `ignore` by `test` to enable the test
  test("selectDigits examples") {
    assert(selectDigits("hello4world-80") == "480")
    assert(selectDigits("welcome") == "")
  }

  // replace `ignore` by `test` to enable the test
  test("selectDigits length is smaller") {
    forAll { (text: String) =>
      assert(selectDigits(text).length <= text.length)
    }
  }

  test("selectDigits only returns digits") {
    forAll { (text: String) =>
      selectDigits(text).foreach(c => assert(c.isDigit))
    }
  }

  test("secret example") {
    forAll { (text: String) =>
      assert(secret("Hello") == "*****")
    }
  }

  test("secret PBT") {
    forAll { (text: String) =>
      val once = secret(text)
      val twice = secret(secret(text))
      assert(once == twice)
    }
  }

  test("isValidUsername") {
    forAll { (username: String) =>
      assert(isValidUsername(username.toLowerCase) == isValidUsername (username.toUpperCase))
    }
  }

  test("Point isPositive"){
    forAll{ (x:Int, y:Int, z:Int) =>
      assert(Point(x.max(0), y.max(0), z.max(0)).isPositive)
    }
  }

  test("Point forAll"){
    forAll{(x: Int, y: Int, z: Int, predicate: Int => Boolean) =>
      assert(Point(x, y, z) .forAll(predicate) == List(x,y,z).forall(predicate))
    }
  }

  ///////////////////////
  // Exercise 2: Point
  ///////////////////////

}
