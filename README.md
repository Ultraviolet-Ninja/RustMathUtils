# Using Rust with Java
## Description
A way to use compiled Rust code as native functions in Java.

## How to Set Up
1. Create a Java file that has `public static native` methods
2. Compile that file to a header file using `javac -h . ClassName.java`
3. Start up a Rust library project
    1. The main file must be `lib.rs`
    2. In the `Cargo.toml` file, there should be a dependency for `jni = "0.19.0"` and a lib section where `crate-type = ["cdylib"]`
    3. The functions in the Rust file must match the ones in the header file compiled earlier with the same parameters and parameter types
    4. The Rust code should then run like normal and output a Java result (if a return value is needed)
    5. Perform a `cargo build` on the project
4. Make the connection using a static code block in Java and grab the DLL file from the Rust project and use `System.load()` to load the DLL

### Notes
Not sure how this could get used in the future. The linking becomes one of the most time consuming parts of the operation, then, calling the native method also creates a performance hinderance. I'd probably have to discover other places where this integration could be used.