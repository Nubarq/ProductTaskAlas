package com.alas.AlasProject2.controller;


import com.alas.AlasProject2.dto.Category.CategoryRequestDto;
import com.alas.AlasProject2.dto.Category.CategoryResponseDto;
import com.alas.AlasProject2.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryController {
    private CategoryService service;

    @PostMapping("/createCategory")
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto requestDto) {
        return service.createCategory(requestDto);
    }
    }
