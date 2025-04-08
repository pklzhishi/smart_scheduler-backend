package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public List<Object> search(@RequestParam String keyword) {
        return searchService.search(keyword);
    }
}
