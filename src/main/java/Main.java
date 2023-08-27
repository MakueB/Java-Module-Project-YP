import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static int sum = 0;
    public static String productsList = "";
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int personsN;

        personsN = getPersonsN();
        addProduct();
        countSumPerPerson(personsN, sum, productsList);
    }
    public static int getPersonsN(){
        int personsN = 0;
        while (personsN < 2) {
            System.out.println("На скольких человек необходимо разделить счет?");
            if(scanner.hasNextInt()) personsN = scanner.nextInt();
            else personsN = 0;
            scanner.nextLine();
            if (personsN < 2)
                System.out.println("Ошибка! Введите целое число больше 1\n");
            else  break;
        }
        return  personsN;
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
                    try {
                        if (productsList.equals(""))
                            throw new RuntimeException();
                        return;
                    } catch (RuntimeException e) {
                        System.out.println("Введите название хотя бы 1 товара");
                    }
                } else {
                    productsList += "\n" + name;
                    break;
                }
            }

            while (price < 0) {
                System.out.println("Введите стоимость товара: ");
                scanner.nextLine();
                if (scanner.hasNextDouble()){
                    price = scanner.nextDouble();
                } else {
                    price = -1;
                }
                if (price < 0)
                    System.out.println("Стоимость должна быть не ниже 0");
            }
            product = new Product(name, price);
            productsList = productsList.trim() + "\n";
            sum += price;
            price = -1;
        }
    }
    public  static  double countSumPerPerson(int personsN, int sum, String productsList){
        double res = (double) sum/personsN;
        System.out.println("\n***********************************************\nДобавленные товары:\n");
        System.out.println(productsList);
        System.out.println(String.format("Каждый человек должен заплатить: %.2f "
                + Format.chooseRublesEnding(res), res) +
                "\n***********************************************");
        return res;
    }


}