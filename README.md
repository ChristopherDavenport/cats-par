# cats-par [![Build Status](https://travis-ci.org/ChristopherDavenport/cats-par.svg?branch=master)](https://travis-ci.org/ChristopherDavenport/cats-par) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/cats-par_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/cats-par_2.12)

Parallel has 2 types instead of 1 despite the second type generally
having a canonical instance. This uses an abstract type member
to allow using a single type rather than 2. As suggestions have made
and plans in place for this in cats 2.0 this is an intermediate
solution that will be deprecated upon its release.

## Reasoning

Temporary Solution For [typelevel/cats#2233](https://github.com/typelevel/cats/issues/2233)

Initial Credit to [@johnnek](https://github.com/johnynek) for the [idea](https://github.com/typelevel/cats/pull/2180#issuecomment-369973585)

## Quick Start

To use cats-par in an existing SBT project with Scala 2.11 or a later version, add the following dependency to your
`build.sbt`:

```scala
libraryDependencies += "io.chrisdavenport" %% "testcontainers-specs2" % "<version>"
```

## Examples

```scala
import cats._
import cats.data._
import cats.temp.par._

// Without This You Require a second type parameter and to continue, this second
// param up the entire call stack
def without[F[_]: Monad, G[_], A, C, D](
  as: List[A], 
  f: A => Kleisli[F, C, D]
)(implicit P: Parallel[F, G]): Kleisli[F, C, List[D]] = {
  as.parTraverse(f)
}

// With This It Is Just Another Contstraint on your Abstract F
def with[F[_]: Monad : Par, A, C, D](
  as: List[A],
  f: A => Kleisli[F, C, D]
): Kleisli[F, C, List[D]] = {
  as.parTraverse(f)
}
```
