package com.alas.AlasProject2.mapper;

//import com.alas.task1.dto.Category.CategoryRequestDto;
//import com.alas.task1.dto.Category.CategoryResponseDto;
//import com.alas.task1.model.Category;
//import org.mapstruct.Mapper;
//import org.mapstruct.ReportingPolicy;

import com.alas.AlasProject2.dto.Category.CategoryRequestDto;
import com.alas.AlasProject2.dto.Category.CategoryResponseDto;
import com.alas.AlasProject2.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    Category mapCategoryRequestToEntity(CategoryRequestDto requestDto);

    CategoryResponseDto mapEntityToCategoryResponse(Category category);
}
