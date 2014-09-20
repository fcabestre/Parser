package net.sigusr.parser

import org.specs2.mutable.Specification

class DirectEvaluatorSpec extends Specification {

  "The direct evaluator" should {
    "evaluate the expression '2+2' as 4" in {
      object Calculator extends Parser with DirectEvaluator
      Calculator.parseAll(Calculator.expr, "2+2").get must be_==(4.0)
    }
  }
}