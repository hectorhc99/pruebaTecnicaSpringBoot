package prueba.algoritmo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    //se declaran el identificador de producto y la posición del producto
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sequence")
    private Integer sequence;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Size> size;

    public Product(Integer id, Integer sequence, List<Size> size) {
        this.id = id;
        this.sequence = sequence;
        this.size = size;
    }
    public Product(String id, String sequence,List<Size> size) {
        this.id = Integer.valueOf(id);
        this.sequence = Integer.valueOf(sequence);
        this.size = size;
    }
    
    public Product() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSequence() {
        return sequence;
    }
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    public List<Size> getSize() {
        return size;
    }
    public void setSize(List<Size> size) {
        this.size = size;
    }

}