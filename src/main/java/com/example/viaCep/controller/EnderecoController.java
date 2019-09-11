package com.example.viaCep.controller;

import com.example.viaCep.dto.EnderecoDTO;
import com.example.viaCep.exception.ErrorException;
import com.example.viaCep.service.EnderecoService;
import com.example.viaCep.utils.Path;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping
@Slf4j
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = Path.ENDPOINT_CEP)
    public ResponseEntity buscaEndereco(@PathVariable("cep")  String cep){
        if(cep.length()!=8){
            return new ResponseEntity(String.format(ErrorException.BAD_REQUEST.getMessage(),"cep", "8", "8", "%s"), HttpStatus.BAD_REQUEST);
        }
        Optional<EnderecoDTO> enderecoDTO = enderecoService.getAddress(cep);
        if(enderecoDTO.get().getCep() == null){
            return new ResponseEntity<>(String.format(ErrorException.RESOURCE_NOT_FOUND.getMessage(), cep.substring(0,5)+"-"+cep.substring(5,8),"%s"),
                    HttpStatus.NOT_FOUND);
        }
        log.info("Endereco encontrado: "+enderecoDTO.get().toString());
        return ResponseEntity.ok(enderecoDTO.get());
    }
}