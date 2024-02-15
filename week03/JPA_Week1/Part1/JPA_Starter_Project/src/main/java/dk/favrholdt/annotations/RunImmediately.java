package dk.favrholdt.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunImmediately {

    //these parameter can only be primitive, String, Class or Array type
    int times(); //acts like a normal field

    // int times() default 1;
    // specify default = requires to pass a parameter
}
