package prueba.algoritmo.dtos;

import java.util.List;

public class ProductDTO implements Comparable<ProductDTO>{

    //se declaran el identificador de producto y la posición del producto
    private Integer id;
    private Integer sequence;
    List<SizeDTO> size;
    
    public ProductDTO(Integer id, Integer sequence) {
        this.id = id;
        this.sequence = sequence;
    }
    public ProductDTO(String id, String sequence) {
        this.id = Integer.valueOf(id);
        this.sequence = Integer.valueOf(sequence);
    }
    
    public ProductDTO() {
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

    @Override
    public int compareTo(ProductDTO product){
        return (int)(this.sequence - product.getSequence());
    }
    public List<SizeDTO> getSize() {
        return size;
    }
    public void setSize(List<SizeDTO> size) {
        this.size = size;
    }
}