package JDBC_SQL.problem1;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.currentTimeMillis;

/**
 * Created by Anton on 28.01.2017.
 */

//? Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java приложения.
//        id - порядковый номер записи, первичный ключ
//        prodid - уникальный номер товара
//        title - название товара
//        cost - стоимость
//  ? При запуске приложения очистить таблицу и заполнить 10.000 товаров вида:
//        id_товара 1 товар1 10
//        id_товара 2 товар2 20
//        id_товара 3 товар3 30
//        ...
//        id_товара 10000 товар10000 100010
//        т.е. просто тестовые данные
//  ? Написать консольное приложение, которое позволяет узнать цену товара по его имени, либо если такого товара нет, то должно быть выведено сообщение "Такого товара нет".
// Пример консольной комманды для получения цены: "/цена товар545"
//  ? В этом же приложении должна быть возможность изменения цены товара(указываем имя товара и новую цену). Пример: "/сменитьцену товар10 10000"
//  ? Вывести товары в заданном ценовом диапазоне. Консольная комманда: "/товарыпоцене 100 600"

public class MainClass {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement ps;
    static Scanner in = new Scanner (System.in);
    static ResultSet rs;

    public static void main(String[] args) {
        connect();

        try {
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS mydatabase.goods (id INT NOT NULL AUTO_INCREMENT, prodid INT NOT NULL, title VARCHAR(80) NOT NULL, cost DECIMAL(10,2) NOT NULL, PRIMARY KEY (id));");
            stmt.execute("DELETE FROM goods");
            ps = connection.prepareStatement("INSERT INTO goods (prodid, title, cost) VALUES (?, ?, ?)");

            connection.setAutoCommit(false);
            long t1 = currentTimeMillis();

            //1й вариант исполнения - addBatch
            /*for (int i = 1; i < 10001; i++) {
                ps.setInt(1, i);
                ps.setString(2, "товар " + i);
                ps.setInt(3, i * 10);
                ps.addBatch();
            }
            ps.executeBatch();*/

            //2й вариант исполнения - executeUpdate
            for (int i = 1; i < 10001; i++) {
                ps.setInt(1, i);
                ps.setString(2, "товар" + i);
                ps.setInt(3, i * 10);
                ps.executeUpdate();
            }

            connection.setAutoCommit(true);     // или для второго способа то же самое connection.commit();
            System.out.println("Время заполнения базы: " + (currentTimeMillis() - t1) + " мс.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Доступные команды: \n /цена *имя товара* \n /сменитьцену *имя товара* *цена* \n /товарыпоцене *цена* *цена* \n /выход");
        boolean stopReading = false;

        while (true) {
            System.out.println("Введите ваш запрос: ");
            String s = in.next();

            switch (s) {
                case "/цена":
                    s = in.next();
                    if (isExistItem(s)) {
                        try {
                            System.out.println(rs.getInt(2));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                    System.out.println("Такого товара нет.");
                    }
                    break;
                case "/сменитьцену":        //добавить обработчик неправильно введенная цена
                    s = in.next();
                    int newPrice = in.nextInt();
                    if (isExistItem(s)) {
                        try {
                            stmt.executeUpdate("UPDATE goods SET cost = " + newPrice + " WHERE title = '" + s + "';");
                            System.out.println("Цена успешно изменена.");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Такого товара нет.");
                    }
                    break;
                case "/товарыпоцене":           //можно ещё добавить обработчик если второе число меньше первого; введены слишком большие числа;
                    try {
                        float num1 = in.nextFloat();    //считываем 2 числа
                        float num2 = in.nextFloat();
                        if ((num1 > 0) & (num2 > 0)) {      //если они больше нуля
                            rs = stmt.executeQuery("SELECT title, cost FROM goods WHERE cost BETWEEN " + num1 + " AND " + num2);    //то выполняем запрос
                                if (rs.next()) {    //если запрос не пустой
                                    while (rs.next()) {
                                        System.out.println(rs.getString(1) + ", " + rs.getInt(2));  //то выводим информацию
                                    }
                                } else {System.out.println("Ваш запрос не вернул результатов.");}    //если запрос пустой, выводим ошибку.
                        } else {
                            System.out.println("Введите положительные числа");      //если любое из 2 чисел отрицательное, выводим ошибку.
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (InputMismatchException e2) {
                        System.out.println("Введены неверные числа.");

                    }
                    break;
                case "/выход":
                    System.exit(0);
                    disconnect();
            }
            in.nextLine();  //чтобы сканер начал читать с начала строки следующий ввод
        }
    }


    public static boolean isExistItem(String nameOfItem) {
        try {
                        rs = stmt.executeQuery("SELECT title, cost FROM mydatabase.goods WHERE title='" + nameOfItem + "';");
                        if (rs.next()) {
                            return true;
                        } else {
                            return false;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

        return false;
    }

    public static void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useSSL=false", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}