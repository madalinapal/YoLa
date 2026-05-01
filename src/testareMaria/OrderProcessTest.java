package testareMaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Admin;
import model.NumeProd;
import model.Order;
import model.Product;

class OrderProcessTest {

	@Test
	void testProcessOrder() {
		Admin admin = new Admin(1, "admin_test", "123", "a@test.com", "Maria", "Ionescu");
	    Product p = new Product(101, NumeProd.Bratara, 100, 10);
	    Order o = new Order(500);

	    // Scenariul 1: stocul este suficient
	    assertTrue(admin.processOrder(o, p, 5)); 
	    assertEquals("Finished", o.getStatus());

	    // Scenariul 2: stocul nu este suficient
	    assertFalse(admin.processOrder(o, p, 20)); 
	    assertEquals("Cancelled - Notify Customer", o.getStatus());
	    
	    // Scenariu 3: cumpăr tot stocul (au mai rămas 5 brățări în stoc)
	    assertTrue(admin.processOrder(o, p, 5));
	    assertEquals(0, p.getStockQuantity());
	}

	@Test
	void testComplexOrderFlow() {
	    Admin admin = new Admin(1, "admin_maria", "pass", "admin@test.ro", "Maria", "Ionescu");
	    
	    // creez mai multe produse pentru a verifica buclele din calculateTotal
	    Product p1 = new Product(101, NumeProd.Bratara, 45.50f, 20);
	    Product p2 = new Product(102, NumeProd.Lantisor, 150.0f, 5);
	    Product p3 = new Product(103, NumeProd.Cercei, 79.99f, 0); 
	    
	    Order order = new Order(2001);

	    // Scenariul de adăugare multiplă și calculul total
	    order.addProduct(p1, 2); // 91
	    order.addProduct(p2, 1); // 150
	    assertEquals(241.0f, order.calculateTotal(), "Calculul total pentru mai multe produse a eșuat."); 

	    // Scenariul de eroare: stoc insuficient pentru un produs din listă
	    boolean result = admin.processOrder(order, p3, 1);
	    assertFalse(result, "Adminul nu ar trebui să poată finaliza comanda dacă un produs are stoc zero.");
	    assertEquals("Cancelled - Notify Customer", order.getStatus()); 

	    // Scenariul de cumpărare exact cât a rămas în stoc pentru p2 (au rămas 4 bucăți)
	    assertTrue(admin.processOrder(new Order(7002), p2, 4));
	    assertEquals(0, p2.getStockQuantity(), "Stocul ar fi trebuit să ajungă la zero exact.");
	}
}
