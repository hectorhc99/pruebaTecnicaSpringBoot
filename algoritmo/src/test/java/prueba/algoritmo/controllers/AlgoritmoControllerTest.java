package prueba.algoritmo.controllers;



import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@WebMvcTest(AlgoritmoController.class)
public class AlgoritmoControllerTest {

    @InjectMocks
    private AlgoritmoController algoritmoController;

    

    @Test
    void testAlgoritmo() {
        ResponseEntity<List<Integer>> respuesta = algoritmoController.algoritmoOrden();
        assertEquals(HttpStatus.ACCEPTED.toString(),respuesta.getStatusCode().toString());
    }

}
