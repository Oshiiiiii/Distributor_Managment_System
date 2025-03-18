package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniquelabs.uniquedms.exceptions.ResourceAlreadyExistsException;
import com.uniquelabs.uniquedms.exceptions.ResourceNotFoundException;
import com.uniquelabs.uniquedms.io.entity.Product;
import com.uniquelabs.uniquedms.io.repository.ProductRepository;
import com.uniquelabs.uniquedms.service.ProductService;
import com.uniquelabs.uniquedms.shared.dto.ProductDTO;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	ProductRepository repository;

	@Override
	public ProductDTO save(ProductDTO dto) {

		if (repository.findByProductCode(dto.getProductCode()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		Product entity = mapper.map(dto, Product.class);
		Product storage = repository.save(entity);

		return mapper.map(storage, ProductDTO.class);
	}

	@Override
	public List<ProductDTO> getList(int page, int limit) {
		List<ProductDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<Product> resourcePage = repository.findAll(pageableRequest);
		List<Product> resource = resourcePage.getContent();

		for (Product entity : resource) {
			returnValue.add(mapper.map(entity, ProductDTO.class));
		}

		return returnValue;
	}

	@Override
	public ProductDTO get(Long id) {
		Optional<Product> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), ProductDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested product is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Product> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested product  is not found.");
		}
	}

	@Override
	public ProductDTO update(Long id, ProductDTO dto) {

		Optional<Product> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setProductCode(dto.getProductCode());
			entity.get().setProductName(dto.getProductName());
			entity.get().setTaxValue(dto.getTaxValue());
			entity.get().setDescription(dto.getDescription());
			entity.get().setPrimaryPrice(dto.getPrimaryPrice());
			entity.get().setRetailerPrice(dto.getRetailerPrice());
			entity.get().setConsumerPrice(dto.getConsumerPrice());
			entity.get().setStatus(dto.getStatus());
			Product updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, ProductDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested product is not found.");
		}

	}

}
