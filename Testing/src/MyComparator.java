/**
 * Created by Anton on 25.12.2016.
 */

import java.util.TreeSet;

public class MyComparator {
    public static void main (String[] args) {
        TreeSet<Employee> myTree = new TreeSet<Employee>();
        myTree.add(new Employee("Alexi Layho", 30, 30000));
        myTree.add(new Employee("Bon Jovi", 28, 31000));
        myTree.add(new Employee("Christina Scabbia", 35, 32000));
        myTree.add(new Employee("James Hetfield", 42, 29000));
        myTree.add(new Employee("Elvis Presley", 28, 27000));
        myTree.add(new Employee("Sandra Nasic", 40, 100000));

        for (Employee asd : myTree) {
            System.out.println("Name: " + asd.name + " Age: " + asd.age + " Salary: " + asd.salary);
        }
    }
}

class Employee implements Comparable<Employee> {
    String name;
    int age;
    int salary;

    Employee (String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo (Employee emp) {
        return (this.age - emp.age);
    }

}
