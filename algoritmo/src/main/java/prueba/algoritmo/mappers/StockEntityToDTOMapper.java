package prueba.algoritmo.mappers;

import prueba.algoritmo.dtos.StockDTO;
import prueba.algoritmo.entities.Stock;

/**
 * Clase encargada de parsear stock entidad a dto
 * 
 * @see Stock
 * @see StockDTO
 */
public class StockEntityToDTOMapper {
    /**
     * @param entity
     * @return StockDto dto
     */
    public static StockDTO mapStockDtoToEntity(Stock entity){
        StockDTO dto = new StockDTO();
        dto.setQuantity(entity.getQuantity());
        dto.setSize(SizeEntityToDTOMapper.mapSizeDTOToEntity(entity.getSize()));
        return dto;
    }
    public static StockDTO mapStockCSVToDTO(String[] stock){
        StockDTO dto = new StockDTO();
        dto.setQuantity(Integer.valueOf(stock[1]));
        dto.setSizeId(Integer.valueOf(stock[0]));
        return dto;
    }

}
