Verify Compilation:
```shell
./gradlew compileJava
```

Build & test:

```shell
./gradlew build
```

## Verify Build Components

To ensure all build components work correctly after making changes:

```shell
# Build without tests
./gradlew build -x test

# Run unit tests
./gradlew test

# Run SpotBugs
./gradlew spotbugsMain spotbugsTest
```

## Updating Protobuf Definitions

When updating the protobuf definitions in `internal/durabletask-protobuf/protos/orchestrator_service.proto`:

1. Manually copy the updated protobuf file from dapr/durabletask-protobuf
2. Update the commit hash in `internal/durabletask-protobuf/PROTO_SOURCE_COMMIT_HASH` to reflect the new commit
3. Regenerate the Java classes from the protobuf definitions:

```shell
./gradlew generateProto
```

## Test locally from dapr/java-sdk

```shell
./gradlew publishToMavenLocal
```

or simply `./gradlew build publishToMavenLocal -PskipSigning`

Check if it was released locally with:
```shell
ls ~/.m2/repository/io/dapr/durabletask-client/ 
```

Then update the durabletask-client in the java-sdk pom.xml file to the newest version you released locally.