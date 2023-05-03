package prueba.algoritmo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "size")
public class Size{

    //se declaran el identificador de talla
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    //identificador de producto
    
    private Integer productId;
    //true si la talla es back soon o false en caso contrario
    private Boolean backSoon;
    //true si la talla es especial o false en caso contrario
    private Boolean special;

    @OneToOne(mappedBy = "size")
    private Stock stock;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
    
    public Size(Integer id, Integer productId, Boolean backSoon, Boolean special) {
        this.id = id;
        this.productId = productId;
        this.backSoon = backSoon;
        this.special = special;
    }

    public Size(String id, String productId, String backSoon, String special) {
        this.id = Integer.valueOf(id);
        this.productId = Integer.valueOf(productId);
        this.backSoon = Boolean.parseBoolean(backSoon);
        this.special = Boolean.parseBoolean(special);
    }
    
    public Size() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Boolean getBackSoon() {
        return backSoon;
    }
    public void setBackSoon(Boolean backSoon) {
        this.backSoon = backSoon;
    }
    public Boolean getSpecial() {
        return special;
    }
    public void setSpecial(Boolean special) {
        this.special = special;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
}