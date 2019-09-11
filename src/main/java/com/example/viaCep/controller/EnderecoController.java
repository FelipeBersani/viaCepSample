package com.example.viaCep.controller;

import com.example.viaCep.dto.EnderecoDTO;
import com.example.viaCep.service.EnderecoService;
import com.example.viaCep.utils.Path;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = Path.ENDPOINT_CEP)
    public ResponseEntity<EnderecoDTO> buscaEndereco(@PathVariable("cep") String cep){
        System.out.println(cep);
        EnderecoDTO enderecoDTO = enderecoService.getAddress(cep);
        System.out.println(enderecoDTO.toString());
        return ResponseEntity.ok(enderecoDTO);
    }

}