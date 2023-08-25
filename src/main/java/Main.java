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
            personsN = scanner.nextInt();
            if (personsN < 2)
                System.out.println("Количество человек, между которыми возможно разделить счет\n должно быть > 1");
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
                    productsList += " " + name;
                    break;
                }
            }

            while (price < 0) {
                System.out.println("Введите стоимость товара: ");
                price = scanner.nextDouble();
                if (price < 0)
                    System.out.println("Стоимость должна быть выше 0");
            }
            product = new Product(name, price);
            productsList = productsList.trim();
            sum += price;
            price = -1;
        }
    }
    public  static  double countSumPerPerson(int personsN, int sum, String productsList){
        double res = (double) sum/personsN;
        System.out.println("\n********************************************\nДобавленные товары:\n");
        System.out.println(productsList);
        System.out.println(String.format("Каждый человек должен заплатить: %.2f "
                + Format.chooseRublesEnding(res), res) +
                "\n********************************************");
        return res;
    }


}