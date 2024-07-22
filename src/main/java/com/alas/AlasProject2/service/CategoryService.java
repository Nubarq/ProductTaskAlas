package com.alas.AlasProject2.service;

//import com.alas.task1.dto.Category.CategoryRequestDto;
//import com.alas.task1.dto.Category.CategoryResponseDto;

import com.alas.AlasProject2.dto.Category.CategoryRequestDto;
import com.alas.AlasProject2.dto.Category.CategoryResponseDto;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto requestDto);
}
