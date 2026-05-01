package model;

public class ProgramMain {

	public static void main(String[] args) {
		// admin-ul se loghează
        Admin admin = new Admin(1, "AdminSiteOWNER", "#yola_owner554", "magazin_bijuteriiYOLA@gmail.ro", "Rux", "Hammond");
        admin.login();
        
        // admin-ul introduce produse pe stoc
        Product p1 = new Product(101, NumeProd.Bratara, 52.0f, 10);
        Product p2 = new Product(102, NumeProd.Lantisor, 125.0f, 5);
        Product p3 = new Product(103, NumeProd.Cercei, 84.0f, 8);
        
        admin.addProduct(p1); 
        admin.addProduct(p2); 
        admin.addProduct(p3);
        
        System.out.println();
        System.out.println("Stoc inițial: " + p1.getProductDetails() + "\n" + p2.getProductDetails() + "\n" + p3.getProductDetails());
        System.out.println("...............................................");

        // clienții se loghează
        Customer c1 = new Customer(2, "MariaTuluca18", "maria#190000", "maria.tuluca@gmail.com", "Maria", "Tuluca", "Calarasi, Str. Florilor, nr.5", "0722111222");
        Customer c2 = new Customer(3, "MadalinaPalade04", "madaa#05%8", "mada_palade@gmail.com", "Madalina", "Palade", "Pitesti, Bd. Unirii 10", "0733444555");
        
        c1.login();
        c2.login();

        // clienții creează comenzile dorite
        Order o1 = new Order(1001);
        o1.addProduct(p1, 2); 
        o1.addProduct(p2, 1);
        
        Order o2 = new Order(1002);
        o2.addProduct(p3, 1);
        o2.addProduct(p2, 2);
        
        System.out.println("\nDetalii Comandă 1:\n" + o1.getOrderDetails());
        System.out.println("\nDetalii Comandă 2:\n" + o2.getOrderDetails());
        System.out.println("...............................................");

        // admin-ul pregătește comenzile
        admin.prepareOrder();

        // curierii se loghează
        Courier curier1 = new Courier(4, "curier_vasile", "vasilepopa#787", "vasipopa@fast.ro", "Vasile", "Popa", "0766000111");
        Courier curier2 = new Courier(5, "curier_mihai", "mihaiionescu%829928", "mihai_ionescu@fast.ro", "Mihai", "Ionescu", "0766000222");
        
        curier1.login();
        curier2.login();

        // procesul de livrare
        System.out.println("\n..... Proces de Livrare .....");
        curier1.takeOrder(o1, c1);
        System.out.println("\nDetaliile curierului:\n" + curier1.getCourierDetails());
        curier1.deliverAndCollectPayment(o1);
        o1.setStatus("Delivered");

        curier2.takeOrder(o2, c2);
        System.out.println("\nDetaliile curierului:\n" + curier2.getCourierDetails());
        System.out.println();
        curier2.deliverAndCollectPayment(o2);
        o2.setStatus("Delivered");

        System.out.println("\nStatus final comanda 1: " + o1.getStatus());
        System.out.println("Status final comanda 2: " + o2.getStatus());
        System.out.println();
        
        // stoc-ul final
        System.out.println("Stoc final: " + p1.getProductDetails() + "\n" + p2.getProductDetails() + "\n" + p3.getProductDetails());
        System.out.println("...............................................");
        
        // delogări
        curier1.logout();
        curier2.logout();
        admin.logout();
        c1.logout();
        c2.logout();

	}

}
