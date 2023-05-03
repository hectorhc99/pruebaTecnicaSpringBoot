package prueba.algoritmo.mappers;

import prueba.algoritmo.dtos.ProductDTO;
import prueba.algoritmo.entities.Product;

/**
 * Metodo para parsear productos DTO a entidades
 * 
 * @see Product
 * @see ProductDTO
 */
public class ProductDTOToEntityMapper {
    /**
     * @param productDTO
     * @return Product Entidad
     */
    public static Product mapProductDTOToProduct(ProductDTO productDTO){
        Product entity = new Product();

        entity.setId(productDTO.getId());
        entity.setSequence(productDTO.getSequence());
        
        return entity;
    }
}
