package prueba.algoritmo.mappers;

import prueba.algoritmo.dtos.StockDTO;
import prueba.algoritmo.entities.Stock;

/**
 * Clase encargada de parsear stock dto a entidad
 * 
 * @see Stock
 * @see StockDTO
 */
public class StockDTOToEntityMapper {
    /**
     * @param dto
     * @return Stock entity
     */
    public static Stock mapStockDtoToEntity(StockDTO dto){
        Stock entity = new Stock();
        
        entity.setSize(SizeDTOToEntityMapper.mapSizeDTOToEntity(dto.getSize()));
        entity.setQuantity(dto.getQuantity());
        return entity;
    }
}
