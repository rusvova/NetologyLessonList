import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void listProducts(ArrayList<String> products) {
        if (products.size() == 0) {
            System.out.println("Список покупок пуст!");
        } else {
            System.out.println("Список покупок:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> operations = new ArrayList<>();
        operations.add("Добавить покупку");
        operations.add("Показать все покупки");
        operations.add("Удалить покупки");
        operations.add("Поиск покупки");

        ArrayList<String> product = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию: (или введите 'end' для выхода)");
            for (int i = 0; i < operations.size(); i++) {
                System.out.println((i + 1) + ". " + operations.get(i));
            }
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            switch (input) {
                case "1": {
                    System.out.println("Какую покупку хотите добавить?");
                    String addProduct = scanner.nextLine();
                    product.add(addProduct);
                    System.out.println("Итого в списке покупок: " + product.size());
                }
                break;

                case "2": {
                    listProducts(product);
                }
                break;

                case "3": {
                    listProducts(product);
                    System.out.println("Какую покупку хотите удалить? Введите номер или название:");
                    String delProduct = scanner.nextLine();
                    try {
                        int deleteNumber = Integer.parseInt(delProduct);
                        System.out.println("Покупка " + product.get(deleteNumber - 1) + " удалена, список покупок:");
                        product.remove(deleteNumber - 1);
                        listProducts(product);

                    } catch (NumberFormatException e) {
                        product.remove(delProduct);
                        System.out.println("Покупка " + delProduct + " удалена, список покупок: ");
                        listProducts(product);
                    }
                }
                break;
                case "4": {
                    System.out.println("Введите текст для поиска");
                    String search = scanner.nextLine();
                    String queryLower = search.toLowerCase();

                    for (int i = 0; i < product.size(); i++) {
                        String itemLower = product.get(i).toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println("Найдено: " + (i + 1) + ". " + product.get(i));
                        } else {
                            System.out.println("Покупок не найдено");
                        }
                    }
                }
                break;
            }
        }
    }
}