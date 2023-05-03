package prueba.algoritmo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

import prueba.algoritmo.dtos.ProductDTO;
import prueba.algoritmo.service.AlgoritmoService;


@RestController
@RequestMapping("/api/")
@Configurable
public class AlgoritmoController {

    @Autowired  
    private AlgoritmoService algoritmoService;


    final Logger logObject = Logger.getLogger("AlgoritmoController");

    @GetMapping("/algoritmo")
    public ResponseEntity<List<Integer>> algoritmoOrden(){
        logObject.log(Level.INFO, "Accediendo al algoritmo");
        try{
            //se cargan productos a partir de ficheros csv
            List<ProductDTO> listaProductos = algoritmoService.cargarProductos();

            listaProductos = algoritmoService.algoritmo(listaProductos);
            List<Integer> response = algoritmoService.ordenarProductos(listaProductos);

            return new ResponseEntity<List<Integer>>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            logObject.log(Level.SEVERE, "Se ha producido un error en la aplicación");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
