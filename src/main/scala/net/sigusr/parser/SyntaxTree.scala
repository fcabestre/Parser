package net.sigusr.parser

object SyntaxTree {
  sealed abstract class Term
  case class +(l: Term, r: Term) extends Term
  case class -(l: Term, r: Term) extends Term
  case class *(l: Term, r: Term) extends Term
  case class /(l: Term, r: Term) extends Term
  case class float(v: Double) extends Term
}

