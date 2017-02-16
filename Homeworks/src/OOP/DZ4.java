package java1;

/*
    Author Malyshev Anton. Homework #4. j1hw4
*/

public class DZ4 {

    public static void main(String[] args) {
        new DZ4().start();

    }

    void start() {
        employee s1 = new employee("Fedorov V.V", "880045678458", "Manager", "fedorov@ya.ru", 30000, 26);
        employee s2 = new employee("Marushkin E.E.", "634618348", "CEO", "dsdadsd@ya.ru", 150000, 50);
        employee s3 = new employee("Abostov D.D.", "31543185848", "CTO", "qweqweqwe@ya.ru", 80000, 42);
        employee s4 = new employee("Obscurin O.P.", "123248445", "Executive manager", "cxccczz@ya.ru", 85000, 33);
        employee s5 = new employee("Menzurin D.W.", "23158828", "Manager", "ffffeewww@ya.ru", 30000, 22);

        employee[] emp = {s1, s2, s3, s4, s5};

        System.out.println("Employees older than 40:");

        for (int i = 0; i < emp.length; i++) {
            if (emp[i].age > 40) {
                System.out.println(emp[i].getAll());
            }
        }

    }

}

class employee {

    String fio, tel, position, email;
    int salary, age;

    employee(String fio,String tel,String position,String email, int salary, int age) {
        this.fio = fio;
        this.tel = tel;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }

    String getAll() {
        return ("Full name: " + fio + ", tel number: " + tel + ", position: " + position + ", email: " + email + ", salary: " + salary + ", age: " + age + ".");
    }

}