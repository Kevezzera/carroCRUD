package com.example.carroCRUD.service;


import com.example.carroCRUD.entity.Carro;
import com.example.carroCRUD.entity.Marca;
import com.example.carroCRUD.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro){
        this.carroRepository.save(carro);
        return "Carro salvo no dba!";
    }

    public String update(Carro carro, long id){
        carro.setId(id);
        this.carroRepository.save(carro);
        return "Carro atualizado no dba";
    }

    public String delete(long id){
        this.carroRepository.deleteById(id);
        return "Carro deletado";
    }

    public List<Carro>findAll(){
        List<Carro> lista = this.carroRepository.findAll();
        return  lista;
    }

    public Carro findById(long id){
        Carro carro = this.carroRepository.findById(id).get();
        return carro;
    }

    public List<Carro> findByNome(String nome){
        return this.carroRepository.findByNome(nome);
    }

    public List<Carro> findByMarca(Long idMarca){
        Marca marca = new Marca();
        return this.carroRepository.findByMarca(marca);
    }

    public List<Carro> findAcimaAno(int ano){
        return this.carroRepository.findAcimaAno(ano);
    }

}
