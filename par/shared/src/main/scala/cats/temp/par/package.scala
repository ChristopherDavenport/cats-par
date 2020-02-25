package cats.temp

import cats.{NonEmptyParallel, Parallel}

package object par extends NonEmptyParConversion {
  @deprecated("Use Cats Parallel Directly - Fixed by cats 2.1.1", since = "1.0.0-RC2")
  implicit def parToParallel[F[_]](implicit P: Par[F]): Parallel.Aux[F, P.ParAux] = P.parallel
}

private[temp] sealed abstract class NonEmptyParConversion {
  @deprecated("Use Cats NonEmptyParallel Directly - Fixed by cats 2.1.1", since = "1.0.0-RC2")
  implicit def nonEmptyParToNonEmptyParallel[F[_]](implicit P: par.NonEmptyPar[F]): NonEmptyParallel.Aux[F, P.NonEmptyParAux] =
    P.nonEmptyParallel
}
