package net.sigusr.parser

import net.sigusr.parser.SyntaxTree.{float, Term}
import scala.util.parsing.combinator.Parsers

trait TermBuilder extends Parsers {

  type T = Term

  def op(p: ~[String, T]) : T => T = p match {
    case "+"~e => SyntaxTree.+(_, e)
    case "-"~e => SyntaxTree.-(_, e)
    case "*"~e => SyntaxTree.*(_, e)
    case "/"~e => SyntaxTree./(_, e)
  }

  def num(p: String): T = float(p.toDouble)
}
