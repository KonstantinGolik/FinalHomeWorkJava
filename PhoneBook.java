import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhoneBook {
    static HashMap<String, ArrayList<Long>> phoneBook = new HashMap<>();


    public void addNumber(String name, Long phoneNum) {
        if (phoneBook.containsKey(name)) {
                ArrayList<Long> phones = phoneBook.get(name);
                phones.add(phoneNum);
        } else {
            ArrayList<Long> phones = new ArrayList<>();
            phones.add(phoneNum);
            phoneBook.put(name, phones);
        }
    }


    public void removeNumber(String name, Long phoneNum){
        if (!phoneBook.containsKey(name)) {
            System.out.println("Контакт с именем " + name + " не найден.");
            return;
        }

        ArrayList<Long> phones = phoneBook.get(name);
        if (!phones.contains(phoneNum)) {
            System.out.println("У контакта " + name + " нет номера " + phoneNum + " для удаления.");
            return;
        }

        phones.remove(phoneNum);
        System.out.println("Номер " + phoneNum + " успешно удален из контакта " + name);
        if (phones.isEmpty()) {
            phoneBook.remove(name);
        }
    }


    public void findNumberByName(String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println("Номера для контакта " + name + ": " + phoneBook.get(name));
        } else {
            System.out.println("Контакт с именем " + name + " не найден.");
        }
    }
    

    public void showContacts(){
        if (phoneBook.isEmpty()) {
            System.out.println("Телефонная книга пуста.");
            return;
        }
        List<Map.Entry<String, ArrayList<Long>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Long.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, ArrayList<Long>> entry : sortedEntries) {
            String name = entry.getKey();
            ArrayList<Long> phones = entry.getValue();
            System.out.println("Имя: " + name + ", Телефоны: " + phones);
        }
    }
}
