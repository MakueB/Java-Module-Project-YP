
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> productList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int personsN;

        personsN = getPersonsN();
        addProduct();
        countSumPerPerson(personsN, productList);
    }

    public static int getPersonsN() {
        int personsN = 0;
        while (personsN < 2) {
            System.out.println("На скольких человек необходимо разделить счет?");
            if (scanner.hasNextInt()) personsN = scanner.nextInt();
            else personsN = 0;
            scanner.nextLine();
            if (personsN < 2)
                System.out.println("Ошибка! Введите целое число больше 1\n");
            else break;
        }
        return personsN;
    }

    public static void addProduct() {
        Product product;
        double price = -1;
        String name = "";
        while (true) {
            while (true) {
                System.out.println("Введите название товара или \"завершить\", если все товары добавлены: ");
                name = scanner.next();
                if (name.equalsIgnoreCase("завершить")) {
                    if (productList.isEmpty())
                        System.out.println("Введите название хотя бы 1 товара");
                    else
                        return;
                } else
                    break;
            }

            while (price < 0) {
                System.out.println("Введите стоимость товара: ");
                scanner.nextLine();
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                } else {
                    price = -1;
                }
                if (price < 0)
                    System.out.println("Стоимость должна быть не ниже 0");
            }
            productList.add(new Product(name, price));
            price = -1;
        }
    }

    public static double countSumPerPerson(int personsN, @androidx.annotation.NonNull List<Product> productList) {
        double res = -1;
        double sum = 0;
        String textSeparator = "***********************************************";
        for (int i = 0; i < productList.size(); i++) {
            sum += productList.get(i).price;
        }
        res = sum / personsN;
        System.out.println("\n" + textSeparator +"\nДобавленные товары:\n");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).name);
        }
        System.out.println(String.format("\nКаждый человек должен заплатить: %.2f "
                + Format.chooseRublesEnding(res), res) +
                "\n" + textSeparator);

        return res;
    }


}