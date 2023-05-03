package prueba.algoritmo.dtos;

public class StockDTO{

    //se declaran el identificador de talla y las unidades disponibles
    private Integer sizeId;
    private Integer quantity;
    private SizeDTO size;

    public StockDTO(Integer sizeId, Integer quantity) {
        this.sizeId = sizeId;
        this.quantity = quantity;
    }
    public StockDTO(String sizeId, String quantity) {
        this.sizeId = Integer.valueOf(sizeId);
        this.quantity = Integer.valueOf(quantity);
    }
    public StockDTO() {
    }
    public Integer getSizeId() {
        return sizeId;
    }
    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public SizeDTO getSize() {
        return size;
    }
    public void setSize(SizeDTO size) {
        this.size = size;
    }
    
}