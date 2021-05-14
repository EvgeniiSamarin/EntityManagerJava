package ru.kpfu.itis.samarin.test;

import org.postgresql.ds.PGSimpleDataSource;
import ru.kpfu.itis.samarin.entity.criteria.SQLWhere;
import ru.kpfu.itis.samarin.manager.OrmManager;
import ru.kpfu.itis.samarin.manager.OrmManagerImpl;
import ru.kpfu.itis.samarin.test.models.Customer;
import ru.kpfu.itis.samarin.test.models.Item;
import ru.kpfu.itis.samarin.test.models.Receipt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("poezdkr");
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");

        OrmManager ormManager = new OrmManagerImpl(dataSource);

    //    createInitData(ormManager);
        findAllCriteriaLike(ormManager);
        findAllCriteriaEqualAndLike(ormManager);
        findAllCriteriaIn(ormManager);
        findAllItemsWithLazyLoading(ormManager);
    }

    private static void createInitData(OrmManager ormManager) {
        System.out.println("createInitData");
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer("name" + i, "login" + i, "password" + i);
            customers.add(ormManager.create(customer));
        }
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Item item = new Item();
            item.setDescription("description" + i);
            item.setPrice(new Random().nextDouble());
            item.setTitle("title" + i);
            item.setSeller(customers.get(new Random().nextInt(customers.size())));
            items.add(ormManager.create(item));
        }
        for (int i = 0; i < 20; i++) {
            Receipt receipt = new Receipt();
            receipt.setAmount(new Random().nextInt(10));
            receipt.setItem(items.get(new Random().nextInt(items.size())));
            receipt.setPurchaser(customers.get(new Random().nextInt(customers.size())));
            ormManager.create(receipt);
        }

        for (Customer customer : ormManager.findAll(Customer.class)) {
            System.out.println(customer);
        }
        for (Item item : ormManager.findAll(Item.class)) {
            System.out.println(item);
        }
        for (Receipt receipt : ormManager.findAll(Receipt.class)) {
            System.out.println(receipt);
        }
    }

    private static void findAllCriteriaLike(OrmManager ormManager) {
        System.out.println("findAll like(\"full_name\", \"%4\")");
        for (Customer customer : ormManager.findAll(Customer.class, new SQLWhere().like("full_name", "%4"))) {
            System.out.println(customer);
        }
        System.out.println();
    }

    private static void findAllCriteriaEqualAndLike(OrmManager ormManager) {
        System.out.println("findAll equal(\"login\", \"login7\").and().like(\"password\", \"%7\")");
        for (Customer customer : ormManager.findAll(Customer.class, new SQLWhere().equal("login", "login7").and().like("password", "%7"))) {
            System.out.println(customer);
        }
        System.out.println();
    }

    private static void findAllCriteriaIn(OrmManager ormManager) {
        System.out.println("findAll in(\"ITEM_ID\", Arrays.asList(1,2,3))");
        for (Item item : ormManager.findAll(Item.class, new SQLWhere().in("ITEM_ID", Arrays.asList(1, 2, 3)))) {
            System.out.println(item);
        }
        System.out.println();
    }

    private static void findAllItemsWithLazyLoading(OrmManager ormManager) {
        for (Item item : ormManager.findAll(Item.class)) {
            System.out.println();
            System.out.println(item);
            System.out.println(item.getSeller());
            System.out.println(item);
        }
    }
}
