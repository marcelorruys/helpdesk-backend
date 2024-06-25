package com.marcelo.helpdesk.resources;

import com.marcelo.helpdesk.domain.Chamado;
import com.marcelo.helpdesk.domain.dtos.ChamadoDTO;
import com.marcelo.helpdesk.domain.dtos.ClienteDTO;
import com.marcelo.helpdesk.services.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
