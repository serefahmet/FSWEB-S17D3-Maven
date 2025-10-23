package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    private final Map<Long, Kangaroo> kangaroos = new HashMap<>();

    @GetMapping
    public List<Kangaroo> getAll() {
        return new ArrayList<>(kangaroos.values());
    }

    @GetMapping("/{id}")
    public Kangaroo getById(@PathVariable Long id) {
        if (!kangaroos.containsKey(id)) throw new ZooException("Kangaroo not found", HttpStatus.NOT_FOUND);
        return kangaroos.get(id);
    }

    @PostMapping
    public Kangaroo add(@RequestBody Kangaroo kangaroo) {
        if (kangaroo.getId() == 0 || kangaroo.getName() == null) throw new ZooException("Invalid kangaroo data", HttpStatus.BAD_REQUEST);
        kangaroos.put((long) kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable Long id, @RequestBody Kangaroo kangaroo) {
        if (!kangaroos.containsKey(id)) throw new ZooException("Kangaroo not found", HttpStatus.NOT_FOUND);
        kangaroos.put(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable Long id) {
        if (!kangaroos.containsKey(id)) throw new ZooException("Kangaroo not found", HttpStatus.NOT_FOUND);
        return kangaroos.remove(id);
    }

}
