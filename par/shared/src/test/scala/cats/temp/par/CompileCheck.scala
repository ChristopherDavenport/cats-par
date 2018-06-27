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

  def withF[F[_]: NonEmptyPar, A, B](as: NonEmptyList[A], f: A => F[B]) = {
    Parallel.parNonEmptyTraverse(as)(f)
  }

  def nonEmptyListNonEmptyTraverse[F[_]: NonEmptyPar, A](as: NonEmptyList[F[A]]) = {
    Parallel.parNonEmptySequence(as)
  }

  def doParTupled[F[_]: NonEmptyPar, A, B](fa: F[A], fb: F[B]): F[(A, B)] = {
    (fa, fb).parTupled
  }

}
