# Virtual Threads Spring Demo

Spring demo application with two controllers:
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
