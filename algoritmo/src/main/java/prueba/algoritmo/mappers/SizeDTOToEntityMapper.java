package prueba.algoritmo.mappers;

import prueba.algoritmo.dtos.SizeDTO;
import prueba.algoritmo.entities.Size;

/**
 * Metodo para parsear size DTO a entidades
 * 
 * @see Size
 * @see SizeDTO
 */
public class SizeDTOToEntityMapper {
    /**
     * @param sizeDto
     * @return Size entity
     */
    public static Size mapSizeDTOToEntity(SizeDTO sizeDto){
        Size entity = new Size();
        entity.setId(sizeDto.getId());
        entity.setProductId(sizeDto.getProductId());
        entity.setBackSoon(sizeDto.getBackSoon());
        entity.setSpecial(sizeDto.getSpecial());
        return entity;
    }
}
