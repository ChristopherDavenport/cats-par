package cats.temp

import cats.Parallel

package object par {
  implicit def parToParallel[F[_]](implicit P: Par[F]): Parallel[F, P.ParAux] = P.parallel
}