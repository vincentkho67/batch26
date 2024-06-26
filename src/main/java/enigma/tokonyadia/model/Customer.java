package enigma.tokonyadia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// MVC -> Model View Controller
// MVC + Service + Repository => Clean Architecture
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    // -> attributes / fields /properties
    // .getAll() -> SELECT * FROM customers;
    // Select id,name from Customers;
    // SELECT id,name FROM customers WHERE name="Randy";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String birthPlace;
    // saldo
    // nomor rekening

    // query
    // SELECT * FROM customers c
    // JOIN transactions t ON c.id = t.customer_id
    // =============================================================
    // id, name, birthPlace, transaction.id, transaction.customer_id
    // 1, siti, solo, 1, 1
    // 1, siti, solo, 2, 1
    // 1, siti, solo, 3, 1
    // 1, siti, solo, 4, 1
    // 1, siti, solo, 5, 1
    // 2, randy, jakarta

    // SELECT * FROM transactions
    // id, customer_id
    // 1, 1
    // 2, 1
    // 3, 1

    // SELECT t.id, c.name FROM transactions t
    // JOIN customers c ON t.customer_id = c.id
    // t.id, c.name
    // 1, siti
    // 2, siti
    // 3, siti
}
