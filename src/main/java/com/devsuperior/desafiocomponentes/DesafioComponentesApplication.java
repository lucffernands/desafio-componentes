package com.devsuperior.desafiocomponentes;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class DesafioComponentesApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(DesafioComponentesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Integer code = sc.nextInt();
		Double basic = sc.nextDouble();
		Double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);
		double total = orderService.total(order);

		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", total);

		sc.close();
	}
}
