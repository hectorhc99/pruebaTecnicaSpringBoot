package prueba.algoritmo.service;

import java.util.List;

import prueba.algoritmo.dtos.ProductDTO;
import prueba.algoritmo.dtos.SizeDTO;
import prueba.algoritmo.dtos.StockDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;



import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import prueba.algoritmo.mappers.ProductEntityToDTOMapper;
import prueba.algoritmo.mappers.SizeEntityToDTOMapper;
import prueba.algoritmo.mappers.StockEntityToDTOMapper;

@Service("algoritmoService")
@ComponentScan
public class AlgoritmoServiceImpl implements AlgoritmoService {
    
    final Logger logObject = Logger.getLogger("AlgoritmoService");

    @Override
    public List<ProductDTO> cargarProductos (){
        logObject.log(Level.INFO, "Cargando datos desde fichero csv");
        List<ProductDTO> listaProductos = new ArrayList<ProductDTO>();
        BufferedReader brProducto = null;
        BufferedReader brSize = null;
        BufferedReader brStock = null;
        System.out.println(System.getProperty("user.dir"));
        try{
            brProducto = new BufferedReader(new FileReader("resources/product.csv"));
            brSize = new BufferedReader(new FileReader("resources/size.csv"));
            brStock = new BufferedReader(new FileReader("resources/stock.csv"));
            String productoCsv = brProducto.readLine();
            while(productoCsv != null){
                String[] producto = productoCsv.split(", ");
                String sizeCsv = brSize.readLine();
                List<SizeDTO> listaSize = new ArrayList<SizeDTO>();
                while(sizeCsv != null){
                    String[] size = sizeCsv.split(",");
                    if(size[1].equals(producto[0])){
                        //si hay tallas para ese producto
                        String stockCsv = brStock.readLine();
                        StockDTO stockDTO = new StockDTO();
                        while(stockCsv != null){
                            String[] stock = stockCsv.split(",");
                            if(stock[0].equals(size[0])){
                                //si hay una variable stock para esa talla
                                stockDTO = StockEntityToDTOMapper.mapStockCSVToDTO(stock);
                            }
                            stockCsv = brStock.readLine();
                        }
                        SizeDTO sizeDto = SizeEntityToDTOMapper.mapSizeCSVToEntity(size, stockDTO);
                        listaSize.add(sizeDto);
                    }
                    sizeCsv = brSize.readLine();
                }
                ProductDTO productoDTO = ProductEntityToDTOMapper.mapProductCSVToDTO(producto, listaSize);
                listaProductos.add(productoDTO);
                productoCsv = brProducto.readLine();
            }

        }catch(Exception e){
            logObject.log(Level.SEVERE, "Fallo en el archivo");
        }finally{
            if(brProducto != null && brSize != null && brStock != null){
                try {
                    brProducto.close();
                    brSize.close();
                    brStock.close();
                } catch (Exception e) {
                    logObject.log(Level.SEVERE, "Se ha producido un error en la aplicación");
                }
            }
        }

        return listaProductos;
    }
    @Override
    public List<ProductDTO> algoritmo(List<ProductDTO> listaProductos){
        List<ProductDTO> listaProductosDevolver = new ArrayList<ProductDTO>();
        
        for(ProductDTO producto : listaProductos){
            Boolean tallaEspecial = false;
            Boolean stockTallaEspecial = false;
            Boolean stockTallaNormal = false;
            if(producto.getSize() != null && !producto.getSize().isEmpty()){
                for(SizeDTO talla : producto.getSize()){
                    
                    if(talla.getSpecial()){
                        tallaEspecial = true;
                    }
                    //si la talla tiene stock o esta marcada como backsoon
                    if(talla.getStock().getQuantity() > 0 || talla.getBackSoon()){
                        if(talla.getSpecial()){
                            stockTallaEspecial = true;
                        }else{
                            stockTallaNormal = true;
                        }
                    }
                }
            }
            if((!tallaEspecial || stockTallaEspecial) && stockTallaNormal){
                listaProductosDevolver.add(producto);
            }
        }


        return listaProductosDevolver;
    }
    @Override
    public List<Integer> ordenarProductos(List<ProductDTO> listaProductos){
        List<Integer> listaIds = new ArrayList<Integer>();
        Collections.sort(listaProductos);
        
        listaProductos.forEach((producto -> listaIds.add(producto.getId())));
        return listaIds;
    
    }
    @Bean
    public AlgoritmoServiceImpl algoritmoServiceImpl() {
         return new AlgoritmoServiceImpl();
    }

    
    
    
   
}
