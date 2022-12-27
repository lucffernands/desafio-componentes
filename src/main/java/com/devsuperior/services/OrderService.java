package com.devsuperior.services;

import com.devsuperior.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        if (shippingService.shipment(order) < 100.0) {
            return shippingService.shipment(order) + 20.0;
        }
        else if (shippingService.shipment(order) >= 100.0 && shippingService.shipment(order) <= 200.0) {
            return shippingService.shipment(order) + 12.0;
        }
        else {
            return shippingService.shipment(order);
        }

    }

}
