package com.API.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PokemonSV {
    @Autowired
    PokemonRepo pokemonRepo;

    public ArrayList<PokemonEntity> obtenerPokemons(){
        return (ArrayList<PokemonEntity>) pokemonRepo.findAll();
    }

    public PokemonEntity guardarPokemon(PokemonEntity pokemon) {
        return pokemonRepo.save(pokemon);
    }

    public Optional<PokemonEntity> obtenerPorId(Long id){
        return pokemonRepo.findById(id);
    }

    public ArrayList<PokemonEntity> obtenerPorGen(Integer gen){
        return pokemonRepo.findByGen(gen);
    }

    public ArrayList<PokemonEntity> obtenerPorTipo(String tipo){
        return pokemonRepo.findByTipo(tipo);
    }

    public ArrayList<PokemonEntity> obtenerPorNombre(String nombre){
        return pokemonRepo.findByNombre(nombre);
    }

    public boolean eliminarPokemon(Long id) {
        try{
            pokemonRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
