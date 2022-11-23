package tests.db;

import baseEntities.BaseApiTest;
import dbEntities.CustomersTable;
import dbServices.CustomerService;
import models.Customer;
import models.CustomerBuilder;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SimpleDBTest extends BaseApiTest {

    @Test
    public void simpleDBTest() {
        CustomersTable customersTable = new CustomersTable(dataBaseService);
        customersTable.dropTable();
        customersTable.createCustomersTable();

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstname("Иван")
                .lastName("Иванов")
                .email("iviv@test.com")
                .age(32)
                .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstname("Петр")
                .lastName("Петров")
                .email("pepe@test.com")
                .age(28)
                .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstname("Марина")
                .lastName("Стасевич")
                .email("ms@test.com")
                .age(23)
                .build());

        ResultSet rs = customersTable.getCustomers();

        try {
            while (rs.next()) {
                String userid = rs.getString("ID");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("Lastname");
                int age = rs.getInt("age");

                System.out.println(userid);
                System.out.println(firstname);
                System.out.println(lastname);
                System.out.println(age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void hibernateTest() {
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer("Ivan", "Grigoriev", "grtest@test.com", 30);

        customerService.saveUser(customer);

        List<Customer> customerList = customerService.findAllUsers();
        for (Customer user : customerList) {
            System.out.println(user.toString());
        }
    }
}
