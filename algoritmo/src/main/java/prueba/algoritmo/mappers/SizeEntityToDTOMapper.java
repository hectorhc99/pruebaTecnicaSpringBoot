package prueba.algoritmo.mappers;
import prueba.algoritmo.dtos.SizeDTO;
import prueba.algoritmo.dtos.StockDTO;
import prueba.algoritmo.entities.Size;

/**
 * Metodo para parsear size entidades a DTO
 * 
 * @see Size
 * @see SizeDTO
 */
public class SizeEntityToDTOMapper {
    
    
    /**
     * @param entity
     * @return dto
     */
    public static SizeDTO mapSizeDTOToEntity(Size entity){
        SizeDTO dto = new SizeDTO();
        dto.setId(entity.getId());
        dto.setProductId(entity.getProductId());
        dto.setBackSoon(entity.getBackSoon());
        dto.setSpecial(entity.getSpecial());
        return dto;
    }

    public static SizeDTO mapSizeCSVToEntity(String[] size, StockDTO stock){
        SizeDTO dto = new SizeDTO();
        dto.setId(Integer.valueOf(size[0]));
        dto.setProductId(Integer.valueOf(size[1]));
        dto.setBackSoon(Boolean.parseBoolean(size[2]));
        dto.setSpecial(Boolean.parseBoolean(size[3]));
        dto.setStock(stock);
        return dto;
    }
}
