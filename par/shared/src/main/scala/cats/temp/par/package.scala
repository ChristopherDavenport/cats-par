package cats.temp

import cats.{NonEmptyParallel, Parallel}

package object par extends NonEmptyParConversion {
  implicit def parToParallel[F[_]](implicit P: Par[F]): Parallel[F, P.ParAux] = P.parallel
}

private[temp] sealed abstract class NonEmptyParConversion {
  implicit def nonEmptyParToNonEmptyParallel[F[_]](implicit P: par.NonEmptyPar[F]): NonEmptyParallel[F, P.NonEmptyParAux] =
    P.nonEmptyParallel
}
