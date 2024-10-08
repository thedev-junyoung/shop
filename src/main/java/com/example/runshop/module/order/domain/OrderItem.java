package com.example.runshop.module.order.domain;

import com.example.runshop.model.entity.Product;
import com.example.runshop.model.vo.orderitem.OrderQuantity;
import com.example.runshop.model.vo.product.ProductName;
import com.example.runshop.module.payment.domain.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.runshop.module.payment.domain.PaymentStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;
    // 주문 상품의 수량
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "quantity"))
    })
    private OrderQuantity quantity;
    // 주문에 포함된 상품의 이름 (Product 엔티티의 필드에 직접 접근)
    @Transient // 데이터베이스에 저장되지 않도록 설정
    @Embedded
    private ProductName productName;


    @PrePersist
    protected void onCreate() {
        paymentDate = LocalDateTime.now();
    }

    // - **OrderItem** N : 1 **Order**
    // (여러 상품이 하나의 주문에 포함될 수 있음)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;


    // - **OrderItem** N : 1 **Product**
    // (한 상품이 여러 주문에 포함될 수 있음)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
