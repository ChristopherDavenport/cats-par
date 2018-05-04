package cats.temp.par

import cats.Parallel

trait Par[F[_]]{
  type P[A]
  implicit def parallel: Parallel[F, P]
}

object Par {
  def apply[F[_]](implicit ev: Par[F]) = ev

  type Aux[F[_], G[_]] = Par[F]{type P[A] = G[A]}

  implicit def fromParallel[F[_], G[_]](implicit Parallel: Parallel[F, G]): Par.Aux[F, G] = 
    new Par[F]{
      type P[A] = G[A]
      implicit def parallel: Parallel[F, P] = Parallel
    }
  
}