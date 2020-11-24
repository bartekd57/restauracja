import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orders {
    Scanner scan = new Scanner(System.in);

    public void printMenu(ArrayList<Dish> dishes) {
        System.out.println("Witamy w naszej restuaracji");
        System.out.println("Dzisiejsze Menu:");
        for (Dish dish : dishes) {
            System.out.println(dish);

        }
    }

    public ArrayList<Dish> getDishes() {
        ArrayList<Dish> dishes = new ArrayList<>();

        dishes.add(new Dish(1, "Pizza Margherita", 24.99));
        dishes.add(new Dish(2, "Pizza Mafioso", 29.99));
        dishes.add(new Dish(3, "Spaghetti Bolognese", 31.99));
        dishes.add(new Dish(4, "Spaghetti Carbonara", 26.99));
        dishes.add(new Dish(5, "Lasagne", 24.99));
        dishes.add(new Dish(6, "Gazpacho", 16.99));
        dishes.add(new Dish(7, "Cannelloni ze szpinakiem", 29.99));
        dishes.add(new Dish(8, "Bruschetta", 13.99));
        dishes.add(new Dish(9, "Tiramisu", 19.99));
        dishes.add(new Dish(10, "Panna Cotta", 19.99));

        return dishes;
    }

    public String getYourChoice() {

        System.out.println("Zamów wybrane produkty, wymieniając ich numery po przecinku");
        String line = scan.nextLine();
        return line;
    }


    public int[] getDishesNumbers(String line) {
        String[] split = line.split(",");
        int numOfDishes = split.length;
        int[] dishesNumbers = new int[numOfDishes];
        for (int i = 0; i < split.length; i++) {
            dishesNumbers[i] = Integer.parseInt(split[i]) - 1;
        }
        return dishesNumbers;
    }

    private double countPrices(int[] dishesNumbers, ArrayList<Dish> list) {
        int sum = 0;
        for (int i = 0; i < dishesNumbers.length; i++) {
            double price = list.get(dishesNumbers[i]).getPrice();
            sum += price;
        }
        return sum;
    }

    private double countTip(double sumOfPrices) {
        double tip;
        if (sumOfPrices < 100)
            tip = 0.15 * sumOfPrices;
        else
            tip = 0.1 * sumOfPrices;
        return tip;
    }

    private double sumToPay(double sumPrices, double tip) {
        return sumPrices + tip;
    }

    public void mainMethod() {
        ArrayList<Dish> dishes = getDishes();
        printMenu(dishes);
        String yourChoice = getYourChoice();
        int[] dishesNumbers = getDishesNumbers(yourChoice);
        double sumOfPrices = countPrices(dishesNumbers, dishes);
        double tip = countTip(sumOfPrices);
        double sumToPay = sumToPay(sumOfPrices, tip);

        System.out.print("Do zapłaty: ");
        System.out.printf("%.2f", sumToPay);
        System.out.println();
        System.out.print("Koszt dań:");
        System.out.printf("%.2f", sumOfPrices);
        System.out.println();
        System.out.print("Koszt obsługi: ");
        System.out.printf("%.2f", tip);

    }


}


