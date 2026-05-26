package com.example.labpi1.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamento/{depId}/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("{funcId}")
    public Optional<Funcionario> getFuncionarioById(@PathVariable("funcId") Long id){
        return funcionarioService.getFuncionarioById(id);
    }

//    @DeleteMapping("{funcId}")
//    public Optional<Funcionario> getFuncionarioById(@PathVariable("funcId") Long id){
//        return funcionarioService.getFuncionarioById(id);
//    }

    @PostMapping
    public void registerNewFuncionario(@PathVariable("depId") Long id,@RequestBody Funcionario funcionario){
        funcionarioService.addNewFuncionario(id,funcionario);
    }

    @GetMapping
    public List<Funcionario> getFuncionariosByDepartamento(@PathVariable("depId") Long depId) {
        return funcionarioService.getFuncionariosPorDepartamento(depId);
    }

}
