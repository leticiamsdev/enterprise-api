package com.example.labpi1.funcionario;

import com.example.labpi1.departamento.Departamento;
import com.example.labpi1.departamento.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final DepartamentoRepository departamentoRepository;
    private final FuncionarioRepository funcionarioRepository;
    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository, DepartamentoRepository departamentoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.departamentoRepository = departamentoRepository;
    }

    public Optional<Funcionario> getFuncionarioById(Long id){
        return funcionarioRepository.findById(id);
    }

    public void addNewFuncionario(Long id, Funcionario funcionario){
        Departamento dep = departamentoRepository.findById(id).orElseThrow(() -> new IllegalStateException("Departamento não encontrado"));


        funcionario.setDepartamento(dep);
        funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> getFuncionariosPorDepartamento(Long depId){
        return funcionarioRepository.findByDepartamentoId(depId);
    }
}
