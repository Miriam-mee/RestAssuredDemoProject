package model1;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
    private String customerName;
    private int customerId;
    private String name;
    private String address;
    private List<Order> orderList;
}
