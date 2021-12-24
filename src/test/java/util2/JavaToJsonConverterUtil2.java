package util2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.College;
import model.Course;
import model.Department;
import model.Student;
import model1.Customer;
import model1.Item;
import model1.Order;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class JavaToJsonConverterUtil2 {
    Customer c1,c2,c3;
    Item t1, t2, t3;
    Order o1, o2, o3;


    @Test
    public void test1() throws JsonProcessingException {
        o1 = Order.builder().orderId(1).orderName("Burger").build();
        o2= Order.builder().orderId(2).orderName("Mac and Cheese").build();
        o3= Order.builder().orderId(3).orderName("Chicken and Chips").build();
        List<Order> orderList1 = Arrays.asList(o1,o2,o3);
        List<Order> orderList2 = Arrays.asList(o2, o3);
        List<Order> orderList3 = Arrays.asList(o1, o3);
        t1= Item.builder().orderList(orderList1).name("Chris").id(001).price(300).build();
        t2= Item.builder().orderList(orderList2).name("Yoti").id(002).price(340).build();
        t3= Item.builder().orderList(orderList3).name("Yels").id(003).price(500).build();
        List<Item> itemList1= Arrays.asList(t1,t2,t3);
        List<Item> itemList2= Arrays.asList(t2,t3);
        List<Item> itemList3= Arrays.asList(t1,t2);
        c1= Customer.builder().customerName("Milkshake").name("Mims").address("Nigeria").customerId(1).build();
        c2= Customer.builder().customerName("Juice").name("Joy").address("UK").customerId(2).build();
        c3= Customer.builder().customerName("Meat").name("Mark").address("USA").customerId(3).build();
        o1=Order.builder().itemList(itemList1).build();
        o2=Order.builder().itemList(itemList2).build();
        o3=Order.builder().itemList(itemList3).build();
        List<Order> o = Arrays.asList(o1, o2, o3);
//        start here
        Customer c = Customer.builder().customerName("Mimi").orderList(o).build();
        ObjectMapper mapper = new ObjectMapper();
        String s4 = mapper.writeValueAsString(c);
        System.out.println(s4);
        c.setOrderList(o);

    }
}
