package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamExample {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(new Employee(1, "Name1"), new Employee(2, "Name2"));
        long employeeCount = list.stream().filter(e -> e.getName().contains("1")).count();
        System.out.println(employeeCount);

        //Iterate List using IntStream
        System.out.println("Iterating the list");
        Employee employee = new Employee();
        IntStream.range(0, list.size()).forEach((e) -> {
            employee.setId(e);
            employee.setName("Name updated " + e);
        });
        System.out.println(employee.getName());

        //Intstream Generate
        IntSupplier intSupplier = () -> {
            return 1;
        };
        List<Integer> ints = IntStream.generate(intSupplier).limit(10).boxed().collect(Collectors.toList());
        ints.stream().forEach(System.out::println);

        IntStream intStream = IntStream.empty();
    }
}

class Employee {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}