package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Admin;
import model.Courier;
import model.Customer;
import model.Order;
import model.Product;
import model.NumeProd;

class DeliveringOrderTest {

	@Test
	void testSuccessfulDelivery() {
	    Admin admin = new Admin(1, "maria_ionescu", "123", "mariaion@gmail.com", "Maria", "Ionescu", null);
	    Courier courier = new Courier(2, "curier_vasile", "vasilepopa#787", "vasipopa@yahoo.ro", "Vasile", "Popa", "0766000111", null);
	    Customer customer = new Customer(3, "MariaTuluca18", "maria#190000", "maria.tuluca@gmail.com", "Maria", "Tuluca", "Calarasi, Str. Florilor, nr.5", "0722111222", null);
	    Product p = new Product(101, NumeProd.Bratara, 100.0f, 10);

	    Order o = new Order(1001);
	    
	    // ssignarea comenzii catre admin si client
	    o.setCustomer(customer);
	    o.setAdmin(admin);
	    o.addProduct(p, 2);
	    
	    // adminul proceseaza comanda
	    boolean isProcessed = admin.processOrder(o, p, 2);
	    assertTrue(isProcessed);
	   
	    // actualizare status comanda
	    o.setStatus("Ready to ship");
	    assertEquals("Ready to ship", o.getStatus());
	            
	    // asignare catre curier
	    o.setCourier(courier); 
	    courier.takeOrder(o, customer);
	    o.setStatus("Transporting order");
	    assertEquals("Transporting order", o.getStatus());
	    
	    // scenariu 1: clientul este disponibil pentru a primi comanda
	    customer.setStatus("available", o);
	    assertEquals("available", customer.getStatus());

	    // finalizare livrare
	    o.setStatus("Finish delivery");
	    assertEquals("Finish delivery", o.getStatus());
	    
	    // incasare si procesare plata
	    courier.deliverAndCollectPayment(o);
	    o.setStatus("Taking payment");
	    assertEquals("Taking payment", o.getStatus());

	    admin.receivePayment(o);
	    assertEquals("Delivered", o.getStatus());
	    
	    // scenariu 2: clientul nu este disponibil pentru a primi comanda
	    o.setStatus("Transporting order");
	    assertEquals("Transporting order", o.getStatus());
	    
	    customer.setStatus("not home", o);
	    assertEquals("not home", customer.getStatus());
	    
	    // scenariu 3: clientul refuza primirea comenzii
	    o.setStatus("Transporting order");
	    assertEquals("Transporting order", o.getStatus());
	    
	    customer.setStatus("rejects order", o);
	    assertEquals("rejects order", customer.getStatus());
	  
	}

	@Test
	void testRescheduleDelivery() {
		Admin admin = new Admin(1, "maria_ionescu", "123", "mariaion@gmail.com", "Maria", "Ionescu", null);
		Courier courier = new Courier(2, "curier_vasile", "vasilepopa#787", "vasipopa@yahoo.ro", "Vasile", "Popa", "0766000111", null);
	    Customer customer = new Customer(3, "MariaTuluca18", "maria#190000", "maria.tuluca@gmail.com", "Maria", "Tuluca", "Calarasi, Str. Florilor, nr.5", "0722111222", null);
	    Product p = new Product(101, NumeProd.Bratara, 100.0f, 10);

	    Order o = new Order(1001);
	    o.setCustomer(customer);
	    o.setCourier(courier);
	    o.setAdmin(admin);
	    o.addProduct(p, 2);

	    // procesam comanda pentru a scadea stocul si a o valida
	    boolean isProcessed = admin.processOrder(o, p, 2);
	    assertTrue(isProcessed);

	    // clientul nu este disponibil 
	    o.setStatus("Giving order");
	    assertEquals("Giving order", o.getStatus());

	    courier.takeOrder(o, customer);
	    o.setStatus("Transporting order");
	    assertEquals("Transporting order", o.getStatus());

	    // setam statusul clientului pentru ca acesta nu este acasa
	    customer.setStatus("not home", o);
	    assertEquals("not home", customer.getStatus());

	    // trecem comanda in starea de reprogramare
	    o.setStatus("Rescheduling delivery");
	    assertEquals("Rescheduling delivery", o.getStatus());
	}
}