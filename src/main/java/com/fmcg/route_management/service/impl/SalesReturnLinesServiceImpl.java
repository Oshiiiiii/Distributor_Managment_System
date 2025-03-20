package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.Product;
import com.fmcg.route_management.io.entity.SalesReturn;
import com.fmcg.route_management.io.entity.SalesReturnLines;
import com.fmcg.route_management.io.repository.ProductRepository;
import com.fmcg.route_management.io.repository.SalesReturnLinesRepository;
import com.fmcg.route_management.io.repository.SalesReturnRepository;
import com.fmcg.route_management.service.SalesReturnLinesService;
import com.fmcg.route_management.shared.dto.SalesReturnLinesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SalesReturnLinesServiceImpl implements SalesReturnLinesService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	SalesReturnLinesRepository repository;
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SalesReturnRepository salesReturnRepository;

	@Override
	public SalesReturnLinesDTO save(SalesReturnLinesDTO dto) {

		if (repository.findById(dto.getId()).isPresent())
			throw new ResourceAlreadyExistsException("Record already exists");

		SalesReturnLines entity = mapper.map(dto, SalesReturnLines.class);
		SalesReturnLines storage = repository.save(entity);

		return mapper.map(storage, SalesReturnLinesDTO.class);
	}

	@Override
	public List<SalesReturnLinesDTO> getList(int page, int limit) {
		List<SalesReturnLinesDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<SalesReturnLines> resourcePage = repository.findAll(pageableRequest);
		List<SalesReturnLines> resource = resourcePage.getContent();

		for (SalesReturnLines entity : resource) {
			returnValue.add(mapper.map(entity, SalesReturnLinesDTO.class));
		}

		return returnValue;
	}

	@Override
	public SalesReturnLinesDTO get(Long id) {
		Optional<SalesReturnLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), SalesReturnLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Sales Return Line is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<SalesReturnLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Sales Return Line is not found.");
		}
	}

	@Override
	public SalesReturnLinesDTO update(Long id, SalesReturnLinesDTO dto) {

		Optional<SalesReturnLines> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setProductReturnQty(dto.getProductReturnQty());
			Optional<Product> product = productRepository.findById(id);
			if (product.isPresent()) {
				entity.get().product(product.get());
			} else {
				throw new ResourceNotFoundException("Selected product is not found.");
			}
			
			Optional<SalesReturn> salesReturn = salesReturnRepository.findById(id);
			if (salesReturn.isPresent()) {
				entity.get().setSalesReturn(salesReturn.get());
			} else {
				throw new ResourceNotFoundException("Selected Sales return no is not found.");
			}
			
			SalesReturnLines updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, SalesReturnLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Sales Return Line is not found.");
		}

	}

}
