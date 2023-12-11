package application;

import shop.controllers.MainController;
import shop.controllers.ProductController;
import shop.repositories.CommonProductRepository;
import shop.repositories.interfaces.ProductRepository;
import shop.service.CommonProductService;
import shop.service.interfaces.ProductService;


import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // 2 слой - репозитории
        ProductRepository repository = new CommonProductRepository();

        // 3 слой - сервисы
        ProductService service = new CommonProductService(repository);

        // 4 слой - контроллеры
        ProductController productController = new ProductController(service);
        MainController mainController = new MainController(productController);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите объект:\n" +
                    "1. Продукт.\n" +
                    "2. Покупатель.\n" +
                    "0. Завершение работы.");

            try {
                int objectNum = Integer.parseInt(scanner.nextLine());

                switch (objectNum) {
                    case 1:
                        System.out.println("Выберите операцию:\n" +
                                "1. Сохранение нового продукта.\n" +
                                "2. Получение списка всех продуктов.\n" +
                                "3. remove product");

                        int operationNum = Integer.parseInt(scanner.nextLine());

                        mainController.sendRequest(objectNum + " " + operationNum)
                                .forEach(System.out::println);
                        break;
                    case 2:
                        // Ветка для работы с покупателем
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Некорректный ввод.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректный ввод.");
            }
        }
    }
}