package net.sigusr.parser

object ExprParser extends Parser with TermBuilder {
  def main(args: Array[String]) {
    println("input : "+ args(0))
    println(parseAll(expr, args(0)))
  }
}
