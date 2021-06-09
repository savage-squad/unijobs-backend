package com.uniamerica.unijobsbackend.controllers;

import com.uniamerica.unijobsbackend.dto.input.NovoServicoDTO;
import com.uniamerica.unijobsbackend.dto.ServicoDTO;
import com.uniamerica.unijobsbackend.models.Servico;
import com.uniamerica.unijobsbackend.services.ServicoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@OpenAPIDefinition
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/servicos")
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Page<ServicoDTO>> findAll(Pageable pageable){
        Page<ServicoDTO> lista = servicoService.findAll(pageable);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico cadastrar(@Valid @RequestBody NovoServicoDTO servico){
        return servicoService.store(servico.converteModelo());
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Servico atualizar(@Valid @RequestBody NovoServicoDTO novoServico, @PathVariable("id") Integer id){
        return servicoService.update( id, novoServico.converteModelo());
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletar(@PathVariable("id") Integer id){
        return servicoService.destroy(id);
    }
}
