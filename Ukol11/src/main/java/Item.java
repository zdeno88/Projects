import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item implements GoodsMethods {

    private Integer id;
    private String partNo;
    private String serialNo;
    private String name;
    private String description;
    private Integer numberInStock;
    private BigDecimal price;
    List<Item> itemList = new ArrayList<>();

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", partNo='" + partNo + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberInStock=" + numberInStock +
                ", price=" + price +
                '}';
    }

    public void addToList(Item item) {
        itemList.add(item);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {
        this.numberInStock = numberInStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void loadingListFromMySQL() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ukol11", "root", "MySQL53861*")) {
            String prikaz = "SELECT * FROM ukol11.item";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prikaz);
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setPartNo(resultSet.getNString(2));
                item.setSerialNo(resultSet.getNString(3));
                item.setName(resultSet.getNString(4));
                item.setDescription(resultSet.getNString(5));
                item.setNumberInStock(resultSet.getInt(6));
                item.setPrice(resultSet.getBigDecimal(7));
                addToList(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printAll() {
        itemList.forEach(System.out::println);
    }

    @Override
    public Item loadItemById(Integer id) {
        Item item = new Item();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ukol11", "root", "MySQL53861*")) {
            String prikaz = "SELECT * FROM ukol11.item where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(prikaz);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                item.setId(resultSet.getInt(1));
                item.setPartNo(resultSet.getNString(2));
                item.setSerialNo(resultSet.getNString(3));
                item.setName(resultSet.getNString(4));
                item.setDescription(resultSet.getNString(5));
                item.setNumberInStock(resultSet.getInt(6));
                item.setPrice(resultSet.getBigDecimal(7));
            }
            return item;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (Item item:itemList) {
//            if (Objects.equals(item.getId(), id))
//                return item;
//        }
//        return null;
        return item;
    }

    @Override
    public void deleteAllOutOfStockItems() {
        itemList.removeIf(item -> item.getNumberInStock() == 0);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ukol11", "root", "MySQL53861*")) {
            String prikaz = "delete from ukol11.item where numberInStock=0;";
            Statement statement = connection.createStatement();
            statement.execute(prikaz);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Item> loadAllAvailableItems() {
        deleteAllOutOfStockItems();
        return itemList;
    }

    @Override
    public void saveItem(Item item) {
        addToList(item);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ukol11", "root", "MySQL53861*")) {
            String prikaz = "INSERT INTO item (id, partNo, serialNo, name, description, numberInStock, price) VALUES (?,?,?,?,?,?,?);";
//            Statement statement= connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(prikaz);
            preparedStatement.setInt(1, 8);
            preparedStatement.setString(2, "hj");
            preparedStatement.setString(3, "asd");
            preparedStatement.setString(4, "asd");
            preparedStatement.setString(5, "asd");
            preparedStatement.setInt(6, 8);
            preparedStatement.setInt(7, 8);
            preparedStatement.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePrice(Integer id, BigDecimal newPrice) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ukol11", "root", "MySQL53861*")) {
            String prikaz = "UPDATE ukol11.item SET price = ? WHERE id = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(prikaz);
            preparedStatement.setBigDecimal(1, newPrice);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Item item : itemList) {
            if (Objects.equals(item.getId(), id))
                item.setPrice(newPrice);
        }

    }
}
