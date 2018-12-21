
import java.lang.annotation.*;

import java.lang.reflect.Method;

import java.time.Duration;

import java.time.Instant;


@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD)
@interface LogExecutionTime {


}


interface IPerson {

    void walk();

    @LogExecutionTime
    void drink();


    String getName();

}


//dynamic proxy

class MyInvocationHandler implements java.lang.reflect.InvocationHandler {

    private IPerson target;


    public MyInvocationHandler(IPerson target) {

        this.target = target;

    }


    @Override

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Instant start = Instant.now();

        Object result = method.invoke(target, args);

        Instant stop = Instant.now();


        if (isLoggable(method)) {

            Duration duration = Duration.between(start, stop);

            System.out.println(target.getName() + " has been " + method.getName() + "ing for " + duration);

        }

        return result;

    }


    private boolean isLoggable(Method method) {

        Annotation[] annotations = method.getAnnotations();

        for (Annotation annotation : annotations) {

            if (annotation instanceof LogExecutionTime) {

                return true;

            }

        }

        return false;

    }

}


public class Ex1 {


    public static void main(String[] args) {

        IPerson person = new Person.Builder().setName("John").build();

        person.walk();

        person.drink();

    }

}


class Person implements IPerson {

    private String name;


    private Person(Builder builder) {

        this.name = builder.name;

    }


    @Override

    public void walk() {

        System.out.println(name + " is walking!");

    }


    @Override

    public void drink() {

        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }

        System.out.println(name + " is drinking!");

    }


    @Override

    public String getName() {

        return name;

    }


    static class Builder {

        private String name;


        public Builder setName(String name) {

            this.name = name;

            return this;

        }


        public IPerson build() {

            Person person = new Person(this);


            IPerson personProxy = (IPerson) java.lang.reflect.Proxy.newProxyInstance(

                    MyInvocationHandler.class.getClassLoader(),

                    new Class[]{IPerson.class},

                    new MyInvocationHandler(person));


            return personProxy;

        }

    }

}