package model1;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item {
    private String name;
    private int id;
    private int price;
    private List<Order> orderList;

}
