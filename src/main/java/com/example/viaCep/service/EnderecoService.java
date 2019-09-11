package com.example.viaCep.service;

import com.example.viaCep.dto.EnderecoDTO;
import com.example.viaCep.utils.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@FeignClient(url = Path.URL_VIACEP, name = "viaCep")
public interface EnderecoService {

    @GetMapping(value = Path.CEP_JSON)
    Optional<EnderecoDTO> getAddress(@PathVariable("cep") String cep);

}
