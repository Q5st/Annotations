package reflection;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args){
        firstTask();
        secondTask();
    }

    public static void firstTask(){
        Main m = new Main();
        Method[] methods = m.getClass().getMethods();
        for (Method method: methods){
            if (method.isAnnotationPresent(My.class)){
                try {
                    method.invoke(m, method.getAnnotation(My.class).param1(), method.getAnnotation(My.class).param2());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    @My(param1 = 1, param2 = 2)
    public static void myMethod(int a, int b){
        System.out.println(a+b);
    }

    public static void secondTask(){
        TextContainer tc = new TextContainer();

        Method[] methods = tc.getClass().getMethods();
        String pth = tc.getClass().getAnnotation(SaveTo.class).path();
        for (Method method: methods) {
            System.out.println(method.getName());
            if (method.isAnnotationPresent(Saver.class)) {
                try {
                    method.invoke(tc, pth);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
