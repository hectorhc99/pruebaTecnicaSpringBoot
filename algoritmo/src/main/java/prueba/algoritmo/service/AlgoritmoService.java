package prueba.algoritmo.service;

import java.util.List;


import prueba.algoritmo.dtos.ProductDTO;


public interface AlgoritmoService {
    public List<ProductDTO> cargarProductos();
    public List<ProductDTO> algoritmo(List<ProductDTO> listaProductos);
    public List<Integer> ordenarProductos(List<ProductDTO> listaProductos);
    

}
