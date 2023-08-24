import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int personsN;
        int sum = 0;
        String ProductsList = "";

        personsN = getPersonsN();

        while (true){
            Product product = addProduct();
            if (product.name.equalsIgnoreCase("завершить")) {
                ProductsList = ProductsList.trim();
                break;
            }
            sum += product.price;
            ProductsList += " " + product.name;
        }
        countSumPerPerson(personsN, sum, ProductsList);
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
    public static Product addProduct() {
        Product good;
        System.out.println("Введите название товара или \"завершить\", если все товары добавлены: ");
        String name = scanner.next();
        if (name.equalsIgnoreCase("завершить"))
            return new Product("завершить", 0);
        System.out.println("Введите стоимость товара: ");
        double price = scanner.nextDouble();
        return good = new Product(name, price);
    }
    public  static  double countSumPerPerson(int personsN, int sum, String goodsList){
        double res = (double) sum/personsN;
        System.out.println("Добавленные товары:\n");
        System.out.println(goodsList);
        System.out.println(String.format("Каждый человек должен заплатить: %.2f " + Format.chooseRublesEnding(res), res));
        return res;
    }


}