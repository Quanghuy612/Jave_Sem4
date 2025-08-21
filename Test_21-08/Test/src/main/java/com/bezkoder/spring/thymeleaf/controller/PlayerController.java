package com.bezkoder.spring.thymeleaf.controller;

import com.bezkoder.spring.thymeleaf.entity.Indexer;
import com.bezkoder.spring.thymeleaf.entity.Player;
import com.bezkoder.spring.thymeleaf.repository.IndexerRepository;
import com.bezkoder.spring.thymeleaf.repository.PlayerRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final IndexerRepository indexerRepository;

    public PlayerController(PlayerRepository playerRepository, IndexerRepository indexerRepository) {
        this.playerRepository = playerRepository;
        this.indexerRepository = indexerRepository;
    }

    // 3. List all players
    @GetMapping
    public String listPlayers(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "player/list";
    }

    // 2. Show form to add new player
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("indexers", indexerRepository.findAll());
        return "player/add";
    }

    // 2. Save new player with validation
    @PostMapping("/add")
    public String addPlayer(@Valid @ModelAttribute Player player, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("indexers", indexerRepository.findAll());
            return "player/add";
        }

        // Convert indexerId to Indexer entity
        Indexer indexer = indexerRepository.findById(player.getIndexerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid indexer ID"));
        player.setIndexer(indexer);

        playerRepository.save(player);
        return "redirect:/player";
    }

    // 4. Show form to edit player
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Player player = playerRepository.findById(id).orElseThrow();
        model.addAttribute("player", player);
        model.addAttribute("indexers", indexerRepository.findAll());
        return "player/edit";
    }

    // 4 & 6. Update player with validation
    @PostMapping("/edit")
    public String updatePlayer(@Valid @ModelAttribute Player player, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("indexers", indexerRepository.findAll());
            return "player/edit";
        }

        // Map indexerId to Indexer entity
        Indexer indexer = indexerRepository.findById(player.getIndexerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid indexer ID"));
        player.setIndexer(indexer);

        playerRepository.save(player);
        return "redirect:/player";
    }

    // 5. Delete player
    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable("id") Integer id) {
        playerRepository.deleteById(id);
        return "redirect:/player";
    }
}
