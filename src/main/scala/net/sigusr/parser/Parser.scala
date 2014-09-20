package net.sigusr.parser

import scala.util.parsing.combinator.JavaTokenParsers

trait Parser extends JavaTokenParsers {

  type T

  def op(p: ~[String, T]) : T => T
  def num(p: String): T

  def doRep(p: ~[T, List[(T) => T]]) : T = p match {case t~tl => tl.foldRight(t)(_ apply _)}
  def doParen(p: ~[~[String, T], String]) : T = p match { case "("~e~")" => e }

  def expr: Parser[T] = term~rep("+"~term ^^ op | "-"~term ^^ op) ^^ doRep
  def term: Parser[T] = factor~rep("*"~factor ^^ op | "/"~factor ^^ op)^^ doRep
  def factor: Parser[T] = floatingPointNumber ^^ num | "("~expr~")" ^^ doParen
}



