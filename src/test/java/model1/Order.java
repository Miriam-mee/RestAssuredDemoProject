package model1;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    private int orderId;
    private String orderName;
    private List<Item> itemList;
}
