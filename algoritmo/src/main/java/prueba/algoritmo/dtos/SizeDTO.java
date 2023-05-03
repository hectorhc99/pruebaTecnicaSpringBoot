package prueba.algoritmo.dtos;

public class SizeDTO{

    //se declaran el identificador de talla
    private Integer id;
    //identificador de producto
    private Integer productId;
    //true si la talla es back soon o false en caso contrario
    private Boolean backSoon;
    //true si la talla es especial o false en caso contrario
    private Boolean special;

    private ProductDTO product;
    private StockDTO stock;

    public SizeDTO(Integer id, Integer productId, Boolean backSoon, Boolean special) {
        this.id = id;
        this.productId = productId;
        this.backSoon = backSoon;
        this.special = special;
    }

    public SizeDTO(String id, String productId, String backSoon, String special) {
        this.id = Integer.valueOf(id);
        this.productId = Integer.valueOf(productId);
        this.backSoon = Boolean.parseBoolean(backSoon);
        this.special = Boolean.parseBoolean(special);
    }
    
    public SizeDTO() {
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

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public StockDTO getStock() {
        return stock;
    }

    public void setStock(StockDTO stock) {
        this.stock = stock;
    }

    
}