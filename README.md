# Virtual Threads Spring Demo

This repository contains a Spring demo application using "Virtual Threads",
a feature described in [JEP 444](https://openjdk.org/jeps/444)
and released in [Java 21](https://www.happycoders.eu/java/java-21-features/).

The application has two controllers:
* `ControllerEvolution1_Sequential`: sequential code on platform threads or virtual threads
* `ControllerEvolution2_CompletableFuture`: asynchronous code using CompletableFuture

Start the application in dev mode using:

```shell
mvn spring-boot:run
```

Then query the endpoints using:

```shell
curl localhost:8080/stage1-seq/product/1
curl localhost:8080/stage2-cf/product/1
```

To switch to virtual threads, uncomment the two bean definitions in `SpringVirtualThreadTestApplication.java`, then access this endpoint again:

```shell
curl localhost:8080/stage1-seq/product/1
```

Within IntelliJ, you can also open the `endpoints-test.http` file to run the HTTP requests.


## Java 21 IDE Support

[IntelliJ IDEA](https://www.jetbrains.com/idea/) supports Java 21 as of version 2023.2.2.
As long as this version is not yet released,
you can install the release candidate via the [JetBrains Toolbox App](https://www.jetbrains.com/toolbox-app/)
by going into the IntelliJ IDEA settings and activating the "Early Access Program".


## Java Downloads

You can download Java 21 from here: https://jdk.java.net/21/

To install multiple Java versions on Linux or macOS, I recommend using [SDKMAN!](https://sdkman.io/)

To install multiple Java versions on Windows,
have a look at this tutorial: [How to Change Java Versions in Windows](https://www.happycoders.eu/java/how-to-switch-multiple-java-versions-windows/)


## Other Java 21 Examples

You might also find these GitHub repositories interesting:

* https://github.com/SvenWoltmann/virtual-threads
* https://github.com/SvenWoltmann/virtual-threads-quarkus
* https://github.com/SvenWoltmann/pattern-matching-for-switch
