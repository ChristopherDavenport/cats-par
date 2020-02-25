package cats.temp.par

import cats.NonEmptyParallel

@deprecated("Use Cats NonEmptyParallel Directly - Fixed by cats 2.1.1", since = "1.0.0-RC2")
trait NonEmptyPar[F[_]]{
  type NonEmptyParAux[A]
  def nonEmptyParallel: NonEmptyParallel.Aux[F, NonEmptyParAux]
}

object NonEmptyPar {
  @deprecated("Use Cats NonEmptyParallel Directly - Fixed by cats 2.1.1", since = "1.0.0-RC2")
  def apply[F[_]](implicit ev: NonEmptyPar[F]) = ev

  @deprecated("Use Cats NonEmptyParallel Directly - Fixed by cats 2.1.1", since = "1.0.0-RC2")
  type Aux[F[_], G[_]] = NonEmptyPar[F]{type NonEmptyParAux[A] = G[A]}

  @deprecated("Use Cats NonEmptyParallel Directly - Fixed by cats 2.1.1", since = "1.0.0-RC2")
  implicit def fromNonEmptyParallel[F[_], G[_]](implicit P: NonEmptyParallel.Aux[F, G]): NonEmptyPar.Aux[F, G] =
    new NonEmptyPar[F]{
      type NonEmptyParAux[A] = G[A]
      def nonEmptyParallel: NonEmptyParallel.Aux[F, NonEmptyParAux] = P
    }

}
