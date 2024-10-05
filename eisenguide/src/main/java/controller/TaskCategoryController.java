package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import model.TaskCategory;

@RestController
@RequestMapping("/task-category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskCategoryController {

    // listar todas as categorias de tarefas
    @GetMapping
    public ResponseEntity<List<TaskCategory>> getAll() {
        // Retorna todas as categorias do enum TaskCategory
        return ResponseEntity.ok(Arrays.asList(TaskCategory.values()));
    }

    // obter uma categoria de tarefas por nome (enum name)
    @GetMapping("/{name}")
    public ResponseEntity<TaskCategory> getByName(@PathVariable String name) {
        try {
            // Tenta obter a categoria pelo nome do enum
            TaskCategory category = TaskCategory.valueOf(name.toUpperCase());
            return ResponseEntity.ok(category);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada.");
        }
    }

    //  buscar categorias de tarefas por nome parcial
    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<TaskCategory>> getByDescricao(@PathVariable String descricao) {
        // Filtra categorias que contêm a descrição, ignorando maiúsculas/minúsculas
        List<TaskCategory> matchingCategories = Arrays.stream(TaskCategory.values())
                .filter(category -> category.name().toLowerCase().contains(descricao.toLowerCase()))
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(matchingCategories);
    }
}
