package shop.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {

    private ProductController productController;
    // Здесь ещё был бы контроллер покупателей

    public MainController(ProductController productController) {
        this.productController = productController;
    }

    public List<Object> sendRequest(String query) {
        Scanner scanner = new Scanner(System.in);
        try {
            // "2 3"
            String[] parts = query.split(" "); // "2 3" -> ["2", "3"]
            if (parts.length == 2) {  // Исправление: Исправьте условие для проверки наличия 2 частей

                int objectNum = Integer.parseInt(parts[0]); // ["2", "3"] -> "2" -> 2
                int operationNum = Integer.parseInt(parts[1]); // ["2", "3"] -> "3" -> 3

                List<Object> result = new ArrayList<>();

                switch (objectNum) {
                    case 1: // Эта ветка для работы с продуктами
                        switch (operationNum) {
                            case 1: // Эта ветка для операции сохранения
                                productController.addProduct();
                                break;
                            case 2: // Эта ветка для операции возврата всех продуктов из БД
                                result.addAll(productController.getAllProducts());
                                break;
                            case 3:
                                System.out.println("Введите ID продукта для удаления:");
                                int idToRemove = scanner.nextInt();
                                productController.removeProduct(idToRemove);  // Исправление: Передайте правильный параметр
                                break;

                            default:
                                System.out.println("Некорректный ввод!");
                                break;
                        }
                        break;  // Исправление: Добавьте оператор break после case 1
                    case 2: // Эта ветка для работы с покупателями
                        // Здесь мы бы вызывали контроллер покупателя
                        break;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }

                return result;
            } else {
                System.out.println("Некорректный ввод!");
                return new ArrayList<>();
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка в главном контроллере!");
            throw new RuntimeException(e);
        }
    }
}