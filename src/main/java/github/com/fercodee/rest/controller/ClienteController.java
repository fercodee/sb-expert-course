package github.com.fercodee.rest.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import github.com.fercodee.domain.entity.Cliente;
import github.com.fercodee.domain.repositories.Clientes;

@Controller
public class ClienteController {
    
    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }
    
    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> fetClienteById( @PathVariable Integer id ) {
        Optional<Cliente> cliente = clientes.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    

}

/*
 *  consumes = { "application/json", "application/xml" }
 *  produces = { "application/json", "application/xml" }  
 */