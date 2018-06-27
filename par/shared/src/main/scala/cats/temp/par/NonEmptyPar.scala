package cats.temp.par

import cats.NonEmptyParallel

trait NonEmptyPar[F[_]]{
  type NonEmptyParAux[A]
  def nonEmptyParallel: NonEmptyParallel[F, NonEmptyParAux]
}

object NonEmptyPar {
  def apply[F[_]](implicit ev: NonEmptyPar[F]) = ev

  type Aux[F[_], G[_]] = NonEmptyPar[F]{type NonEmptyParAux[A] = G[A]}

  implicit def fromNonEmptyParallel[F[_], G[_]](implicit P: NonEmptyParallel[F, G]): NonEmptyPar.Aux[F, G] =
    new NonEmptyPar[F]{
      type NonEmptyParAux[A] = G[A]
      def nonEmptyParallel: NonEmptyParallel[F, NonEmptyParAux] = P
    }

}
