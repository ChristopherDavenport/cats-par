package cats.temp.par

import cats.Parallel

trait Par[F[_]]{
  type ParAux[A]
  def parallel: Parallel[F, ParAux]
}

object Par {
  def apply[F[_]](implicit ev: Par[F]) = ev

  type Aux[F[_], G[_]] = Par[F]{type ParAux[A] = G[A]}

  implicit def fromParallel[F[_], G[_]](implicit P: Parallel[F, G]): Par.Aux[F, G] = 
    new Par[F]{
      type ParAux[A] = G[A]
      def parallel: Parallel[F, ParAux] = P
    }
  
}