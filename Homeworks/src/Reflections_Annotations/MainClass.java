package Reflections_Annotations;

import Reflections_Annotations.Annotations.AfterSuite;
import Reflections_Annotations.Annotations.BeforeSuite;
import Reflections_Annotations.Annotations.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Anton on 28.02.2017.
 */

//        Создать класс, который может выполнять «тесты»,
//        в качестве тестов выступают классы с наборами методов с аннотациями @Test.
//        Для этого у него должен быть статический метод start(),
//        которому в качестве параметра передается или объект типа Class, или имя класса.
//        Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite если такой имеется,
//        далее запущены методы с аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite.
//        К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
//        в соответствии с которыми будет выбираться порядок их выполнения,
//        если приоритет одинаковый то порядок не имеет значения.
//        Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
//        иначе необходимо бросить RuntimeException при запуске «тестирования».

public class MainClass {
    public static void main(String[] args) {
        //реализация если передаем строку в start
        start("Reflections_Annotations.Test1");

        //реализация если передаем объект Class в start
//        Class classObj = Test1.class;
//        start(classObj);
    }

    public static void start(String transmitted) {

        try {
            //реализация если передаем строку в start
        Class executedClass = Class.forName(transmitted);
        Method[] methods = executedClass.getMethods();
        Object classObject = executedClass.newInstance();

//            реализация если передаем объект Class в start
//        Method[] methods = transmitted.getMethods();
//        Object classObject = transmitted.newInstance();

        int counter = 0;
        final int MAX_PRIORITY_TEST = 10;
        final int MIN_PRIORITY_TEST = 1;

        //Execute BeforeSuite. If there're more than one, throw RuntimeException
        for (Method o : methods) {
            if (o.getAnnotation(BeforeSuite.class) != null) {
                counter++;
                if (counter > 1) {
                    throw new RuntimeException();
                } else {
                    try {
                        o.invoke(classObject);//execute BeforeSuite
                    } catch (IllegalAccessException | InvocationTargetException  e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    //Execute all Tests (they should have priorities, execution depends on it)

        for (int priority = MAX_PRIORITY_TEST; priority >= MIN_PRIORITY_TEST; priority--) {  //for priority from 10 to 1
            for (Method o : methods) {  //for all methods in class
                if (o.getAnnotation(Test.class) != null) {  //if it's Test annotation
                    if (o.getAnnotation(Test.class).priority() == priority) {    //if this method has current priority
                        try {
                            o.invoke(classObject);//execute this test
                            System.out.print(" (priority is " + o.getAnnotation(Test.class).priority() + ")\n");
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    //Execute AfterSuite. If there're more than one, throw RuntimeException
        counter = 0;
        for (Method o : methods) {
            if (o.getAnnotation(AfterSuite.class) != null) {
                counter++;
                if (counter > 1) {
                    throw new RuntimeException();
                } else {
                    try {
                        o.invoke(classObject);//execute AfterSuite
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

class Test1 {
    @BeforeSuite
    public void first() {
        System.out.println("Info before suite");
    }

    @Test(priority = 9)
    public void second() {
        System.out.print("Some testing info 1");
    }

    @Test(priority = 5)
    public void third() {
        System.out.print("Some testing info 2");
    }

    @Test(priority = 6)
    public void fourth() {
        System.out.print("Some testing info 3");
    }

    @Test(priority = 1)
    public void fifth() {
        System.out.print("Some testing info 4");
    }

    @Test(priority = 5)
    public void sixth() {
        System.out.print("Some testing info 5");
    }

    @AfterSuite
    public void seventh() {
        System.out.println("After suite info");
    }
}