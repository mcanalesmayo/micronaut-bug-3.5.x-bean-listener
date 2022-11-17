## Micronaut bug starting from 3.5.x

Running tests individually succeeds:
```sh
./gradlew test --tests "com.example.DemoControllerAIntegTest"
./gradlew test --tests "com.example.DemoControllerBIntegTest"
```

Running tests as the whole package fails:
```sh
./gradlew test
```

From what I could see while debugging, this is what is happening:
1. First test succeeds
2. Its bean context gets cleaned
3. Second test's `JacksonDatabind` uses an `ObjectMapper` which was not processed by the bean listeners (in this case `ObjectMapperBeanEventListener`). This is because it's using the bean context from the first test instead of the newly created one for the second test. Since it was cleaned, it has no listeners.
4. Second test fails as it is not able to deserialize using the custom deserializer which should've been registered by the `ObjectMapperBeanEventListener`

Verified that downgrading to Micronaut 3.4.x and running `./gradlew test` works fine.
Micronaut version 3.5.x fails.