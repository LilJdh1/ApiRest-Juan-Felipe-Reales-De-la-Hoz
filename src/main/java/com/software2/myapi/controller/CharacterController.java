package com.software2.myapi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import com.software2.myapi.model.Character;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/myapi/characters")

public class CharacterController {
    private List<Character> characters;

    public CharacterController(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Character[] charactersArray = objectMapper.readValue(new ClassPathResource("characters.json").getFile(),Character[].class);
            characters = new ArrayList<>(Arrays.asList(charactersArray));
        }catch (IOException e){
            e.printStackTrace();
            characters = new ArrayList<>();
        }
    }

    @GetMapping
    public List<Character> getAllCharacters()
    {
        return characters;
    }

    @GetMapping("/{id}")
    public Character getUserById(@PathVariable Long id) {
        return characters.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character){
        characters.add(character);
        return character;
    }

    @PutMapping
    public Character updateCharacter (@PathVariable Long id, @RequestBody Character updateCharacter){
        Character character = getUserById(id);
        if (character != null){
            character.setName(updateCharacter.getName());
            character.setPower(updateCharacter.getPower());
            return character;
        }
        return null;
    }

    @DeleteMapping
    public void deleteCharacter(@PathVariable Long id){
        characters.removeIf(Character -> Character.getId().equals(id));
    }

}
