package Generics.GenericsHomework3;

/**
 * Created by Anton on 26.01.2017.
 */

//        Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//        Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        Для хранения фруктов внутри коробки можете использовать ArrayList;
//        Сделать метод getWeight() который высчитывает вес коробки, зная кол-во фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противной случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//        Ну и не забываем про метод добавления фрукта в коробку;

public class MainClass {
    public static void main(String[] args) {
        Apple apl = new Apple();
        Box<Apple> boxOfApples1 = new Box(apl, 55, apl.getWeightOfFruit());
        System.out.println("Weight of box #1 of apples:" + boxOfApples1.getWeight());

        Box<Apple> boxOfApples2 = new Box(apl, 10, apl.getWeightOfFruit());
        System.out.println("Weight of box #2 of apples:" + boxOfApples2.getWeight());

        boxOfApples2.moveFruitsToOtherBox(5, boxOfApples1);
        System.out.println("New weight of box #1 of apples:" + boxOfApples1.getWeight());
        System.out.println("New weight of box #2 of apples: " + boxOfApples2.fruitStorage.size());
        System.out.println();

        Orange orng = new Orange();
        Box<Orange> boxOfOranges1 = new Box(orng, 25, orng.getWeightOfFruit());
        System.out.println("Weight of box #1 of oranges:" + boxOfOranges1.getWeight());

        Box<Orange> boxOfOranges2 = new Box(orng, 30, orng.getWeightOfFruit());
        System.out.println("Weight of box #2 of oranges:" + boxOfOranges2.getWeight());

        boxOfOranges2.moveFruitsToOtherBox(15, boxOfOranges1);
        System.out.println("New weight of box #1 of oranges:" + boxOfOranges1.getWeight());
        System.out.println("New weight of box #2 of oranges: " + boxOfOranges2.getWeight());

        //boxOfOranges2.moveFruitsToOtherBox(15, boxOfApples1); //error!

        System.out.println();
        System.out.println("Boxes of apples #1 and oranges #1" + (boxOfApples1.compare(boxOfOranges1) ? " equal in weight" : " are not equal in weight"));
        System.out.println("Boxes of apples #2 and oranges #2" + (boxOfApples2.compare(boxOfOranges2) ? " equal in weight" : " are not equal in weight"));
        System.out.println();

        System.out.println("Weight of apple #1 box: " + boxOfApples1.getWeight());
        boxOfApples1.addFruitToBox(30);
        System.out.println("Add 30 apples: " + boxOfApples1.getWeight());
    }
}