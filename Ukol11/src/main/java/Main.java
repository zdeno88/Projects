import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Item item = new Item();
        item.loadingListFromMySQL();
        System.out.println("Metoda1:\n" + item.loadItemById(1));
        item.deleteAllOutOfStockItems();
        System.out.println("Metoda3:");
        item.loadAllAvailableItems().forEach(System.out::println);
        item.saveItem(new Item());
        item.updatePrice(3, BigDecimal.valueOf(5));
        System.out.println("Konec");
//        Testovaci metoda
//        item.printAll();
    }
}
