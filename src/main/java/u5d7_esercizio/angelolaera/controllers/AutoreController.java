package u5d7_esercizio.angelolaera.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import u5d7_esercizio.angelolaera.entities.Autore;


@RestController
@RequestMapping("/autore")

public class AutoreController {

    // 1. GET http://localhost:3001/autore
    @GetMapping
    private String getAllAutori(){
        return "Ecco tutti gli autori!";
    }

    // 2. GET http://localhost:3001/autore{autoreid}
    @GetMapping("/{autoreid}")
    private String getAutoreById(@PathVariable int autoreId){
        return "Ecco l'autore creato!";
    }

    // 3. POST http://localhost:3001/(+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private String createAutore(@RequestBody Autore body){
        return "Autore creato!";
    }

    // 4. PUT http://localhost:3001/{autoreId}(+body)
    @PutMapping("/{autoreId}")
    private String findAutoreByIdAndUpdate(@PathVariable int autoreId,@RequestBody Autore body){
        return "Hai modificato l'autore!";
    }


    // 5. DELETE http://localhost:3001/{autoreId}
    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private String deleteAutore(@PathVariable int autoreId){
        return "Hai eliminato l'autore!";
    }
}
