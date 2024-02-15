package dk.favrholdt.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
//@Target is used to specify which kind of java element this annotation is valid to be used on
//ElementType.Type = only for classes
//ELementTyoe.Method = for methods

@Retention(RetentionPolicy.RUNTIME)
//keep his annotation around through the running of the program so that other code can look at the annotation and use it

//RetentionPolicy.SOURCE - java will get rid of this annotation before it even starts to compile the code
//RetentionPolicy.CLASS - java will keep it through compilation but when program starts up runtime it will get rid of it

//create custom annotation with @interface
public @interface VeryImportant {

}