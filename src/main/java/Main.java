import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int personsN;
        List<Product> productList = new ArrayList<>();

        personsN = getPersonsN();
        addProduct(productList);
        countSumPerPerson(personsN, productList);
    }
    public static int getPersonsN() {
        int personsN = 0;
        while (personsN < 2) {
            Scanner scanner = new Scanner(System.in);
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
    public static void addProduct(List<Product> productList) {
        double price = -1;
        String name;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            while (true) {
                System.out.println("Введите название товара или \"завершить\", если все товары добавлены: ");
                name = scanner.nextLine();
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
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                } else {
                    price = -1;
                }
                if (price < 0)
                    System.out.println("Ошибка! Стоимость - число не ниже 0");
                scanner.nextLine();
            }
            productList.add(new Product(name, price));
            price = -1;
        }
    }
    public static void countSumPerPerson(int personsN, List<Product> productList) {
        double res;
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
    }
}