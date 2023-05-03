package prueba.algoritmo.mappers;

import java.util.List;

import prueba.algoritmo.dtos.ProductDTO;
import prueba.algoritmo.dtos.SizeDTO;
import prueba.algoritmo.entities.Product;

/**
 * Metodo para parsear productos entidades a DTOs
 * 
 * @see Product
 * @see ProductDTO
 */
public class ProductEntityToDTOMapper {
    /**
     * @param entity
     * @return ProductDTO dto
     */
    public static ProductDTO mapProductDTOToProduct(Product entity){
        ProductDTO dto = new ProductDTO();

        dto.setId(entity.getId());
        dto.setSequence(entity.getSequence());
        return dto;
    }
    public static ProductDTO mapProductCSVToDTO(String[] producto, List<SizeDTO> size){
        ProductDTO dto = new ProductDTO();
        dto.setId(Integer.valueOf(producto[0]));
        dto.setSequence(Integer.valueOf(producto[1]));
        dto.setSize(size);
        return dto;
    }
}