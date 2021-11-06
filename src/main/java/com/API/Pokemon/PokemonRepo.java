package com.API.Pokemon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PokemonRepo extends CrudRepository<PokemonEntity, Long> {
    public abstract ArrayList<PokemonEntity> findByGen(Integer gen);

    public abstract ArrayList<PokemonEntity> findByTipo(String tipo);

    public abstract ArrayList<PokemonEntity> findByNombre(String nombre);
}
