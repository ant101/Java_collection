package java1;

 /*
 * Student Malyshev Anton. Homework #5. j1hw5
 */

import java.util.Random;

public class DZ5 {
    
    public static void main (String[] args) {
        new DZ5().go();
    }
    
    void go() {
        Dog Dog = new Dog("Dog","Bobik");
        Horse Horse = new Horse("Horse","Guaso");
        MyCat MyCat = new MyCat("Cat","Persik Peach");
        Animal[] mas = {Dog, Horse, MyCat};
        
        for (int i = 0; i < mas.length; i++) {
            mas[i].run();
            mas[i].swim();
            System.out.println(mas[i].type + " " + mas[i].name + " went ashore");
            
            if (mas[i].leap()) {                         //if method "leap" returns true, it means that animal leapt
            System.out.println(mas[i].type + " " + mas[i].name + " leapt");    
            } else { System.out.println(mas[i].type + " " + mas[i].name + " didn't leap"); }
            System.out.println();
        }
    }
}

class Animal {
    String type, name;

    Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    void run() {
        System.out.println(this.type + " " + this.name + " is running");
    }

    void swim() {
        System.out.println(this.type + " " + this.name + " is swimming");
    }

    boolean leap() {
        return true;     //it doesn't matter what it returns, because we override in inheritors
    }
    
    float getRandom() {       //get random height of obstacle
        Random random = new Random();
        return random.nextFloat() * 4;
    }
}

/////////////////////////////

class Dog extends Animal {
    Dog(String type, String name) {
        super (type, name);
    }
    
    @Override
    boolean leap() {
        float ch = getRandom();
        System.out.println("Obstacle height = " + ch);
        if (ch < 0.5) {
            return true;
        } else { return false; }
    }
}

/////////////////////////////

class Horse extends Animal {
    Horse(String type, String name) {
        super (type, name);
    }
    
    @Override
    boolean leap() {
        float ch;
        ch = getRandom();
        System.out.println("Obstacle height = " + ch);
        if (ch < 2.47) {
            return true;
        } else { return false; }
        
    }
}
    
/////////////////////////////

class MyCat extends Animal {
    MyCat(String type, String name) {
        super (type, name);
    }
    
    @Override
    void swim() {
        System.out.println("Cat " + this.name + " can't swim!");
    }
        
    @Override
    boolean leap() {
        float ch;
        ch = getRandom();
        System.out.println("Obstacle height = " + ch);
        if (ch < 2) {
            return true;
        } else { return false; }
        
    }
}
    
