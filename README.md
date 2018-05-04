# cats-par

Parallel has 2 types instead of 1 despite the second type generally
having a canonical instance. This uses an abstract type member
to allow using a single type rather than 2. As suggestions have made
and plans in place for this in cats 2.0 this is an intermediate
solution that will be deprecated upon its release.

Temporary Solution For [typelevel/cats#2233](https://github.com/typelevel/cats/issues/2233)

Initial Credit to [@johnnek](https://github.com/johnynek) for the [idea](https://github.com/typelevel/cats/pull/2180#issuecomment-369973585)