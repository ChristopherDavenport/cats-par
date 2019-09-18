package cats.temp.par

import cats.Parallel

@deprecated("Use Cats Parallel Directly - Fixed by cats 2.0.0", since = "cats 1.0.0-RC2")
trait Par[F[_]]{
  type ParAux[A]
  def parallel: Parallel.Aux[F, ParAux]
}

object Par {
  @deprecated("Use Cats Parallel Directly - Fixed by cats 2.0.0", since = "cats 1.0.0-RC2")
  def apply[F[_]](implicit ev: Par[F]) = ev

  @deprecated("Use Cats Parallel Directly - Fixed by cats 2.0.0", since = "cats 1.0.0-RC2")
  type Aux[F[_], G[_]] = Par[F]{type ParAux[A] = G[A]}

  @deprecated("Use Cats Parallel Directly - Fixed by cats 2.0.0", since = "1.0.0-RC2")
  implicit def fromParallel[F[_], G[_]](implicit P: Parallel.Aux[F, G]): Par.Aux[F, G] = 
    new Par[F]{
      type ParAux[A] = G[A]
      def parallel: Parallel.Aux[F, ParAux] = P
    }
  
}