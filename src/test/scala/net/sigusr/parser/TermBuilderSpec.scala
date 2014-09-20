package net.sigusr.parser

import org.specs2.mutable.Specification

class TermBuilderSpec extends Specification {

  "The term builder" should {
    "evaluate the expression '2+2' as the term +(float(2),float(2))" in {
      object ExprParser extends Parser with TermBuilder
      ExprParser.parseAll(ExprParser.expr, "2+2").get must be_==(SyntaxTree.+(SyntaxTree.float(2), SyntaxTree.float(2)))
    }
  }
}