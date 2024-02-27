import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            
            System.out.println("\nВыберите задачу:");
            System.out.println("1. Добавить номер");
            System.out.println("2. Удалить номер");
            System.out.println("3. Найти номер по имени");
            System.out.println("4. Отобразить телефонную книгу");
            System.out.println("5. Выйти");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    System.out.println("Введите имя: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.println("Введите номер  телефона: ");
                    long numberToAdd = scanner.nextLong();
                    phoneBook.addNumber(nameToAdd, numberToAdd);
                    break;
                case 2:
                if (phoneBook.phoneBook.isEmpty()) {
                        System.out.println("Телефонная книга пуста.");
                        break;
                    }

                    System.out.println("Выберите имя для удаления номера:");
                    ArrayList<String> names = new ArrayList<>(phoneBook.phoneBook.keySet());
                    for (int i = 0; i < names.size(); i++) {
                        System.out.println((i + 1) + ". " + names.get(i));
                    }
                    int nameChoice = scanner.nextInt();
                    scanner.nextLine(); 

                    if (nameChoice <= 0 || nameChoice > names.size()) {
                        System.out.println("Некорректный выбор имени.");
                        break;
                    }

                    String selectedName = names.get(nameChoice - 1);
                    ArrayList<Long> numbers = phoneBook.phoneBook.get(selectedName);

                    if (numbers.isEmpty()) {
                        System.out.println("У контакта " + selectedName + " нет номеров для удаления.");
                        break;
                    }

                    System.out.println("Выберите номер для удаления:");
                    for (int i = 0; i < numbers.size(); i++) {
                        System.out.println((i + 1) + ". " + numbers.get(i));
                    }
                    int numberChoice = scanner.nextInt();
                    if (numberChoice <= 0 || numberChoice > numbers.size()) {
                        System.out.println("Некорректный выбор номера.");
                        break;
                    }

                    long selectedNumber = numbers.get(numberChoice - 1);
                    phoneBook.removeNumber(selectedName, selectedNumber);
                    break;
                case 3:
                    if (phoneBook.phoneBook.isEmpty()) {
                        System.out.println("Телефонная книга пуста.");
                        break;
                    }
                    System.out.println("Введите имя для поиска:");
                    String searchName = scanner.nextLine();
                    phoneBook.findNumberByName(searchName);
                    break;
                case 4:
                    if (phoneBook.phoneBook.isEmpty()) {
                        System.out.println("Телефонная книга пуста.");
                        break;
                    }
                    System.out.println("Содержимое телефонной книги:");
                    phoneBook.showContacts();
                    break;
                case 5:
                    System.out.println("До свидания!");
                    System.exit(0);
                default:
                    System.out.println("Такой задачи нет. Пожалуйста, выберите существующую задачу.");
            }
        }
    }
}
