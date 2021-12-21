import java.math.BigDecimal;
import java.util.List;

public interface GoodsMethods {

    /**
     * This method loads an item with given id
     *
     * @param id - id of the item which we want to load
     * @return
     */
    Item loadItemById(Integer id);

    /**
     * This method deletes all items that are not in stock
     */
    void deleteAllOutOfStockItems();

    /**
     * This method loads all items that are in stock
     *
     * @return
     */
    List<Item> loadAllAvailableItems();

    /**
     * This method saves the given item
     *
     * @param item - item to be saved
     */
    void saveItem(Item item);

    /**
     * This method updates a price of an item
     *
     * @param id       - id of an item which price is to be updated
     * @param newPrice - new price
     */
    void updatePrice(Integer id, BigDecimal newPrice);

}