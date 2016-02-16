# FCollections
Functional/Fluent Style Collections for Java. This library is centered around a number of Interfaces (and their implementations) that are extensions to the usual Java Collections Interfaces. These
interfaces essentially add a number of methods that are common to more functionally oriented languages (eg map, filter
and reduce). Typically each collection has a mutable and immutable interface as well.

Some naming naming/general conventions:
* Most of the new Interfaces extend or use an existing Java Interface
* The name of the new Interface is typically the name of the old Interface with an F prepended to it (eg List -> FList).
* Implementations are often based around pre-existing classes that add an F before the collection name (eg ArrayList -> ArrayFList).
* Immutable is shortened to Im (eg ImFList is the immutable version of FList).
* Immutable version of a collection deprecate the mutation methods and throw if they are called, but add Copy methods. 
  * These methods are named similarly to the mutation methods but add Cp at the end (eg removeAll -> removeAllCp).
  * These methods return a copy of the collection which has the expected change made to it

This library is designed for Java 8. Specifically it is intended to work nicely with the lambda expressions.

# Links I found Helpful While making this library and getting it deployed on Maven Central

## Deploying to Maven Central
http://central.sonatype.org/pages/ossrh-guide.html#deployment
http://central.sonatype.org/pages/gradle.html
http://yennicktrevels.com/blog/2013/10/11/automated-gradle-project-deployment-to-sonatype-oss-repository/

## PGP Keys
http://blog.sonatype.com/2010/01/how-to-generate-pgp-signatures-with-maven/#.VUWA061Viko

## Reference Functional Libraries
http://www.scala-lang.org/api/2.11.4/index.html#scala.collection.Set
http://www.functionaljava.org/
https://functionaljava.googlecode.com/svn/artifacts/3.0/javadoc/index.html?fj/data/List.html