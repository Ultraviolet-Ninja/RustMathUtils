extern crate jni;

use jni::sys::{jboolean, jlong};
use jni::objects::JClass;
use jni::JNIEnv;

#[no_mangle]
#[allow(non_snake_case)]
pub extern fn Java_number_MathUtils_isPrime(_env: JNIEnv, _class: JClass, java_num: jlong) -> jboolean {
    let number = java_num as i64;

    if number <= 1 {
        return jboolean::from(false);
    }
    if (number % 2 == 0) || (number % 3 == 0) {
        return jboolean::from(number <= 3);
    }

    let mut counter = 5;
    while counter * counter <= number {
        if (number % counter == 0) || (number % (counter + 2) == 0) {
            return jboolean::from(false);
        }
        counter += 6;
    }
    return jboolean::from(true);
}