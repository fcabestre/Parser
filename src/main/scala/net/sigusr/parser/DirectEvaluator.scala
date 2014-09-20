package net.sigusr.parser

import scala.util.parsing.combinator._

trait DirectEvaluator extends Parsers {

  type T = Double

  def op(p: ~[String, T]) : T => T = p match {
    case "+"~e => _ + e
    case "-"~e => _ - e
    case "*"~e => _ * e
    case "/"~e => _ / e
  }

  def num(p: String): T = p.toDouble
}
