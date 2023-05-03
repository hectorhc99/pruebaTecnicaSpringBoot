package prueba.algoritmo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "stock")
public class Stock{

    //se declaran el identificador de talla y las unidades disponibles
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sizeId", referencedColumnName = "id")
    private Size size;
    private Integer quantity;

    

    public Stock(Integer sizeId, Integer quantity) {
        this.size.setId(sizeId); 
        this.quantity = quantity;
    }
    public Stock(String sizeId, String quantity) {
        this.size.setId(Integer.valueOf(sizeId));  
        this.quantity = Integer.valueOf(quantity);
    }
    public Stock() {
    }
    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}