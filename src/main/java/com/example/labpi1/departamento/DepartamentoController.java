package com.example.labpi1.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService, DepartamentoRepository departamentoRepository) {
        this.departamentoService = departamentoService;

    }

    @GetMapping
    public List<Departamento> getDepartamentos(){
        return departamentoService.getDepartamentos();
    }

    @PostMapping
    public void registerNewDepartamento(@RequestBody Departamento departamento){
        departamentoService.addNewDepartamento(departamento);
    }

    @GetMapping(path= "{depId}")
    public Optional<Departamento> getById(@PathVariable("depId") Long id){
        return departamentoService.getById(id);
    }

    @DeleteMapping(path= "{depId}")
    public void deleteDepartamento(@PathVariable("depId") Long id){
        departamentoService.deleteDepartamento(id);
    }

}
