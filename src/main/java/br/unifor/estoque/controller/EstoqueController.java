package br.unifor.estoque.controller;


import br.unifor.estoque.model.Estoque;
import br.unifor.estoque.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private Estoque estoqueService;

    @GetMapping("/")
    public String home() {
        return "Bem-vindo à aplicação!";
    }

    @GetMapping("/autor/{autor}")
    public List<Livro> buscarPorAutor(@PathVariable String autor) {
        return estoqueService.buscarPorAutor(autor);
    }

    @GetMapping("/titulo/{titulo}")
    public List<Livro> buscarPorTitulo(@PathVariable String titulo) {
        return estoqueService.buscarPorTitulo(titulo);
    }

    @GetMapping("/ano/{ano}")
    public List<Livro> buscarPorAno(@PathVariable int ano) {
        return estoqueService.buscarPorAno(ano);
    }
    @GetMapping("/todos")
    public List<Livro> buscarTodos(@PathVariable int ano) {
        return estoqueService.buscarTodos();
    }

    @GetMapping("/genero/{genero}")
    public List<Livro> buscarPorGenero(@PathVariable String genero) {
        return estoqueService.buscarPorGenero(genero);
    }
    @PostMapping("/add")
    public String addLivro(@RequestBody  Livro livro) {
        estoqueService.addLivro(livro);

        return "1";
    }

    @DeleteMapping("/remover/{id}")
    public void removerLivro(@PathVariable Long id) {
        estoqueService.removerLivro(id);
    }

    @PostMapping("/vender/{id}")
    public void darBaixa(@PathVariable Long id) {
        estoqueService.darBaixa(id);
    }

}

