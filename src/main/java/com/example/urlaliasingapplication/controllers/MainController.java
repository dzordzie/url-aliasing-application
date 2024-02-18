package com.example.urlaliasingapplication.controllers;

import com.example.urlaliasingapplication.models.Alias;
import com.example.urlaliasingapplication.models.Link;
import com.example.urlaliasingapplication.services.AliasService;
import com.example.urlaliasingapplication.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MainController {

    private final AliasService aliasService;
    private final LinkService linkService;

    @Autowired
    public MainController(AliasService aliasService, LinkService linkService) {
        this.aliasService = aliasService;
        this.linkService = linkService;
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("aliases", aliasService.getAliases());
        return "index";
    }

    @GetMapping("/a/{alias}")
    public String hitTheCount(@PathVariable String alias) {
        Optional<Alias> foundAlias = aliasService.findByAlias(alias);
        if (foundAlias.isPresent()) {
            foundAlias.get().setHitCount(foundAlias.get().getHitCount() + 1);
            aliasService.saveAlias(foundAlias.get());
            return "redirect:" + foundAlias.get().getLink().getUrl();
        } else {
            return "redirect:/api/error";
        }
    }

    @PostMapping("/save-link")
    public String saveLink(@RequestParam String url, @RequestParam String alias, RedirectAttributes redirectAttributes) {
        Optional<Alias> foundAlias = aliasService.findByAlias(alias);
        Optional<Link> foundLink = linkService.findByUrl(url);
        String message = "";
        if (foundAlias.isPresent()) {
            message = "Failed";
            redirectAttributes.addFlashAttribute("message", message);
            redirectAttributes.addFlashAttribute("placedUrl", url);
            redirectAttributes.addFlashAttribute("placedAlias", alias);
        } else if (foundLink.isPresent() && !foundAlias.isPresent()){
            message = "Success";
            Link currentLink = foundLink.get();
            Alias newAlias = new Alias(alias);
            currentLink.getAliases().add(newAlias);
            newAlias.setLink(currentLink);
            linkService.saveLink(currentLink);
            redirectAttributes.addFlashAttribute("message", message);
            redirectAttributes.addFlashAttribute("currentAlias", newAlias);
        } else if (!foundLink.isPresent() && !foundAlias.isPresent()){
            message = "Success";
            Link newLink = new Link(url);
            Alias newAlias = new Alias(alias);
            newLink.getAliases().add(newAlias);
            newAlias.setLink(newLink);
            linkService.saveLink(newLink);
            redirectAttributes.addFlashAttribute("message", message);
            redirectAttributes.addFlashAttribute("currentAlias", newAlias);
        }
        return "redirect:/";
    }

}
