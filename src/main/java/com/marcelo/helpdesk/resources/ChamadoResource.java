package com.marcelo.helpdesk.resources;

import com.marcelo.helpdesk.domain.Chamado;
import com.marcelo.helpdesk.domain.dtos.ChamadoDTO;
import com.marcelo.helpdesk.services.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {
    @Autowired
    private ChamadoService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id){
        Chamado obj = service.findById(id);
        return ResponseEntity.ok().body(new ChamadoDTO(obj));
    }
    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll(){
        List<Chamado> list = service.findAll();
        List<ChamadoDTO> listDTO = list.stream().map(ChamadoDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoDTO objDTO){
        Chamado obj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
