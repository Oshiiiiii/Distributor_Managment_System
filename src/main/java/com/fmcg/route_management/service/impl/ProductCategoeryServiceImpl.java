package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.ProductCategoery;
import com.fmcg.route_management.io.repository.ProductCategoeryRepository;
import com.fmcg.route_management.service.ProductCategoeryService;
import com.fmcg.route_management.shared.dto.ProductCategoeryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductCategoeryServiceImpl implements ProductCategoeryService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	ProductCategoeryRepository repository;

	@Override
	public ProductCategoeryDTO save(ProductCategoeryDTO dto) {

		if (repository.findByProductCategoryCode(dto.getProductCategoryCode()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		ProductCategoery entity = mapper.map(dto, ProductCategoery.class);
		ProductCategoery storage = repository.save(entity);

		return mapper.map(storage, ProductCategoeryDTO.class);
	}

	@Override
	public List<ProductCategoeryDTO> getList(int page, int limit) {
		List<ProductCategoeryDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<ProductCategoery> resourcePage = repository.findAll(pageableRequest);
		List<ProductCategoery> resource = resourcePage.getContent();

		for (ProductCategoery entity : resource) {
			returnValue.add(mapper.map(entity, ProductCategoeryDTO.class));
		}

		return returnValue;
	}

	@Override
	public ProductCategoeryDTO get(Long id) {
		Optional<ProductCategoery> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), ProductCategoeryDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested product categoery is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<ProductCategoery> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested product categoery is not found.");
		}
	}

	@Override
	public ProductCategoeryDTO update(Long id, ProductCategoeryDTO dto) {

		Optional<ProductCategoery> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setProductCategoryName(dto.getProductCategoryName());
			entity.get().setDescription(dto.getDescription());
			entity.get().setStatus(dto.getStatus());
			ProductCategoery updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, ProductCategoeryDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested product categoery is not found.");
		}

	}

}
