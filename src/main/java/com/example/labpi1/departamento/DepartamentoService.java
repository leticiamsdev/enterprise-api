package com.example.labpi1.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    @Autowired // Force a anotação para garantir
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        if (departamentoRepository == null) {
            throw new RuntimeException("ERRO CRÍTICO: O Spring passou um repositório nulo!");
        }
        this.departamentoRepository = departamentoRepository;
    }
    public List<Departamento> getDepartamentos(){
        return departamentoRepository.findAll();
    }

    public void addNewDepartamento(Departamento departamento){
        departamentoRepository.save(departamento);
    }

    public  Optional<Departamento> getById(Long id){
        Optional<Departamento>  departamento = departamentoRepository.findById(id);
        return departamento;
    }

    public void deleteDepartamento(Long id){
        boolean exists =  departamentoRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("departamento nao existe");
        }

        departamentoRepository.deleteById(id);


    }


}
