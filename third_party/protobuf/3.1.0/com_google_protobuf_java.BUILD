java_import(
    name = "protobuf",
    jars = ["protobuf-java-3.1.0.jar"],
)

proto_lang_toolchain(
    name = "java_toolchain",
    command_line = "--java_out=shared,immutable:$(OUT)",
    runtime = ":protobuf",
    visibility = ["//visibility:public"],
)
