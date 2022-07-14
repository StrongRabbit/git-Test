package com.git.test.GitTest;

import jdk.nashorn.internal.objects.annotations.Function;
import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamdaTest {
    @Test
    public void test() {
//        Consumer<String> c2 = System.out::println;
//        c2.accept("666");

        Comparator<Integer> compare = Integer::compare;
        int compare1 = compare.compare(1, 2);
        System.out.println(compare1);


    }

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1002, "马云", 12, 9876.12));
        list.add(new Employee(1003, "刘强东", 33, 3000.82));
        list.add(new Employee(1004, "雷军", 26, 7657.37));
        list.add(new Employee(1005, "李彦宏", 65, 5555.32));
        list.add(new Employee(1006, "比尔盖茨", 42, 9500.43));
        list.add(new Employee(1007, "任正非", 26, 4333.32));
        list.add(new Employee(1008, "扎克伯格", 35, 2500.32));

        return list;
    }

    @Test
    public void test01() {
        List<Employee> employees = getEmployees();
//        employees.stream().filter(e -> e.getSalary() > 7000).limit(2).forEach(System.out::println);
//
//        employees.stream().skip(5).limit(2).forEach(System.out::println);
//
//        employees.stream().map(Employee::getName).forEach(System.out::print);
//
//        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
//        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
//
//        System.out.println("-------------------------------------------");
//        employees.stream().sorted().limit(3).forEach(System.out::print);
//
//        System.out.println("==================================================");
//        boolean b = employees.stream().anyMatch(e -> e.getSalary() > 5000);
//        System.out.println(b);
//
//        boolean b1 = employees.stream().anyMatch(e -> e.getName().length() > 3);
//        System.out.println(b1);
//
//        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
//        Optional<Double> max = doubleStream.max(Double::compare);
//        System.out.println(max);

        List<Integer> list = Arrays.asList(72,25,32,34,43,56,81,15,29,71);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toList());
       collect.forEach(System.out::println);

    }
    @Test
    public void test02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
//        Employee employee = new Employee();
//        Class<? extends Employee> aClass = employee.getClass();

        Class<?> aClass = Class.forName("com.git.test.GitTest.Employee");
        Employee employee1 = (Employee) aClass.newInstance();
//        Method[] methods = aClass.getDeclaredMethods();
//        for (Method m: methods){
//            System.out.print(m.getName());
//            System.out.print(m.getModifiers());
//            System.out.print(m.getReturnType());
//            System.out.println(m.getParameterCount());
//        }

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(employee1,"666");
        System.out.println(name.get(employee1));


        Method setAge = aClass.getDeclaredMethod("setAge", int.class);
        setAge.setAccessible(true);
        setAge.invoke(employee1, 15);

//        Stream<Method> stream = Arrays.stream(methods);
//        stream.forEach(System.out::println);

    }

}
