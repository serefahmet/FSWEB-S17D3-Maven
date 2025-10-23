package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private final Map<Long, Koala> koalas = new HashMap<>();

    @GetMapping
    public List<Koala> getAll() {
        return new ArrayList<>(koalas.values());
    }

    @GetMapping("/{id}")
    public Koala getById(@PathVariable Long id) {
        if (!koalas.containsKey(id)) throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        return koalas.get(id);
    }

    @PostMapping
    public Koala add(@RequestBody Koala koala) {
        if (koala.getId() == 0 || koala.getName() == null) throw new ZooException("Invalid koala data", HttpStatus.BAD_REQUEST);
        koalas.put((long) koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable Long id, @RequestBody Koala koala) {
        if (!koalas.containsKey(id)) throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        koalas.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        if (!koalas.containsKey(id)) throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        koalas.remove(id);
        return "Koala deleted successfully";
    }
}
