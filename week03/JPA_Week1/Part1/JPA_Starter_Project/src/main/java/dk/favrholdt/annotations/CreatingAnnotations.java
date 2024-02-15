package dk.favrholdt.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreatingAnnotations {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        //annotations can be added to almost anything in java - classes, variables, methods, other annotations etc

        //goes on the line before --> can be inlined though
        @SuppressWarnings("unused")
        Cat myCat = new Cat("Stella");

        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("this thing is very important");
        } else {
            System.out.println("This thing is not very important");
        }

        for (Method method : myCat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for (int i = 0; i < annotation.times(); i++) {
                    method.invoke(myCat);
                }
            }
        }

        for (Field field : myCat.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ImportantString.class)) {
                Object objectValue = field.get(myCat);

                if (objectValue instanceof String stringValue) {
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
}