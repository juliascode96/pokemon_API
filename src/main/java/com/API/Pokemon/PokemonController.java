package com.API.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    PokemonSV pokemonSV;

    @GetMapping
    public ArrayList<PokemonEntity> obtenerPokemons(){
        return pokemonSV.obtenerPokemons();
    }

    @PostMapping
    public PokemonEntity guardarPokemon(@RequestBody PokemonEntity pokemon){
        return pokemonSV.guardarPokemon(pokemon);
    }

    @GetMapping( path = "/{id}")
    public Optional<PokemonEntity> obtenerPokemonId(@PathVariable("id") Long id) {
        return this.pokemonSV.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<PokemonEntity> obtenerPokemonGen(@RequestParam("gen") Integer gen) {
        return this.pokemonSV.obtenerPorGen(gen);
    }

    @GetMapping("/query1")
    public ArrayList<PokemonEntity> obtenerPokemonTipo(@RequestParam("tipo") String tipo) {
        return this.pokemonSV.obtenerPorTipo(tipo);
    }

    @GetMapping("/query2")
    public ArrayList<PokemonEntity> obtenerPokemonNombre(@RequestParam("nombre") String nombre) {
        return this.pokemonSV.obtenerPorNombre(nombre);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPokemonId(@PathVariable("id") Long id) {
        boolean ok = this.pokemonSV.eliminarPokemon(id);
        if(ok){
            return id + " eliminado";
        } else {
            return "Imposible eliminar " + id;
        }
    }

}
