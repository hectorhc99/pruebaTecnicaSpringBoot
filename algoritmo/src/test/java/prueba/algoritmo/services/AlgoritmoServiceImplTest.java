package prueba.algoritmo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import prueba.algoritmo.dtos.ProductDTO;
import prueba.algoritmo.dtos.SizeDTO;
import prueba.algoritmo.dtos.StockDTO;

import prueba.algoritmo.service.AlgoritmoService;
import prueba.algoritmo.service.AlgoritmoServiceImpl;

@WebMvcTest(AlgoritmoService.class)
public class AlgoritmoServiceImplTest {

    @InjectMocks
    private AlgoritmoServiceImpl algoritmoService;

    
    @Test
    void testAlgoritmo() {
        // producto con stock
        StockDTO stock1 = new StockDTO(39, 1); 
        SizeDTO size1 = new SizeDTO(39, 1, false, false);
        ProductDTO product1 = new ProductDTO(1, 10);
        size1.setStock(stock1);
        List<SizeDTO> lista = new ArrayList<SizeDTO>();
        Collections.addAll(lista = new ArrayList<SizeDTO>(), size1);
        product1.setSize(lista);

        // producto sin stock
        StockDTO stock2 = new StockDTO(34, 0); 
        SizeDTO size2 = new SizeDTO(34, 2, true, true);
        StockDTO stock21 = new StockDTO(38, 0); 
        SizeDTO size21 = new SizeDTO(38, 2, true, false);
        ProductDTO product2 = new ProductDTO(2, 10);
        size2.setStock(stock2);
        size21.setStock(stock21);
        List<SizeDTO> lista2 = new ArrayList<SizeDTO>();
        Collections.addAll(lista2 = new ArrayList<SizeDTO>(), size2, size21);
        product2.setSize(lista2);

        
        List<ProductDTO> listaProduct = new ArrayList<ProductDTO>();
        Collections.addAll(listaProduct = new ArrayList<ProductDTO>(), product1, product2);
        List<ProductDTO> respuesta = algoritmoService.algoritmo(listaProduct);
        assertEquals(2,respuesta.size());

    }

    @Test
    void testCargarProductos() {
        List<ProductDTO> lista =  algoritmoService.cargarProductos();
        assertEquals(5, lista.size());
    }


    @Test
    void testOrdenarProductos() {
        List<ProductDTO> listaProductos = new ArrayList<>();
        ProductDTO producto1 = new ProductDTO(1, 10);
        ProductDTO producto2 = new ProductDTO(2, 12);
        ProductDTO producto3 = new ProductDTO(3, 5);
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        List<Integer> respuesta = algoritmoService.ordenarProductos(listaProductos);
        List<Integer> respuestaEsperada = new ArrayList<Integer>();
        respuestaEsperada.add(3);
        respuestaEsperada.add(1);
        respuestaEsperada.add(2);
        assertEquals(respuestaEsperada,  respuesta);
    }
}
