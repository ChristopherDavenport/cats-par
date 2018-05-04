package cats.temp.par

import cats._
import cats.implicits._
import cats.data._
// import cats.temp.par._ // Due to Package Location

object CompileCheck {

  def withF[F[_]: Monad: Par, A, C, D](as: List[A], f: A => Kleisli[F, C, D]) = {
    as.parTraverse(f)
  }

  def listTraverse[F[_]: Par: Monad, A](as: List[F[A]]) = {
    as.parSequence
  }
}