package com.example.SecondWeb.controllers;

import com.example.SecondWeb.models.Post;
import com.example.SecondWeb.models.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private PostRepo postRepo;

    @GetMapping("/")
    public String blogMain(Model model){
        Iterable<Post> post=postRepo.findAll();
        model.addAttribute("post", post);
        return "home";
    }

    @PostMapping("/")
    public  String blogPostAdd(@RequestParam String full_text, Model model){
        Post post = new Post(full_text);
        postRepo.save(post);
        return "redirect:/";
    }
    @PostMapping("{id}/remove")
    public  String blogPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post1 = postRepo.findById(id).orElseThrow();
        postRepo.delete(post1);
        return "redirect:/";
    }
}