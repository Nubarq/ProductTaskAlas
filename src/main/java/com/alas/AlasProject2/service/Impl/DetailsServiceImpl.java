package com.alas.AlasProject2.service.Impl;


import com.alas.AlasProject2.dto.ProductDetails.ProductDetailsRequestDto;
import com.alas.AlasProject2.dto.ProductDetails.ProductDetailsResponseDto;
import com.alas.AlasProject2.exeption.CustomException;
import com.alas.AlasProject2.mapper.DetailsMapper;
import com.alas.AlasProject2.model.Product;
import com.alas.AlasProject2.model.ProductDetails;
import com.alas.AlasProject2.repository.DetailsRepository;
import com.alas.AlasProject2.repository.ProductRepository;
import com.alas.AlasProject2.service.DetailsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DetailsServiceImpl implements DetailsService {
    DetailsMapper mapper;
    DetailsRepository detailsRepository;
    ProductRepository productRepository;

    @Override
    public ProductDetailsResponseDto createProductDetails(ProductDetailsRequestDto detailsRequestDto, Integer productId) {
        ProductDetails details = mapper.mapProductDetailsRequestToEntity(detailsRequestDto);
        Product product = productRepository.findById(productId).orElseThrow(() -> new CustomException("not found"));
        details.setProduct(product);
        return mapper.mapEntityToProductDetailsResponse(detailsRepository.save(details));
    }

    @Override
    public void delete(Integer id) {
        detailsRepository.deleteById(id);
    }

}
