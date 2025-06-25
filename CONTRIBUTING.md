Verify Compilation:
```shell
./gradlew compileJava
```

Build & test:

```shell
./gradlew build
```

## Updating Protobuf Definitions

When updating the protobuf definitions in `internal/durabletask-protobuf/protos/orchestrator_service.proto`:

1. Manually copy the updated protobuf file from dapr/durabletask-protobuf
2. Update the commit hash in `internal/durabletask-protobuf/PROTO_SOURCE_COMMIT_HASH` to reflect the new commit
3. Regenerate the Java classes from the protobuf definitions:

```shell
./gradlew generateProto
```