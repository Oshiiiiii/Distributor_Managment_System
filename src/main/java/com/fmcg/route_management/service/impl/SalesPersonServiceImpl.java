package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.SalesPerson;
import com.fmcg.route_management.io.repository.SalesPersonRepository;
import com.fmcg.route_management.service.SalesPersonService;
import com.fmcg.route_management.shared.dto.SalesPersonDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SalesPersonServiceImpl implements SalesPersonService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	SalesPersonRepository repository;

	@Override
	public SalesPersonDTO save(SalesPersonDTO dto) {

		//Sales Person code is missing from the SalesPersonDTO and SalesPerson entity check update to resolve this error.
		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		if (repository.findBySalesmanName(dto.getSalesmanName()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");
		SalesPerson entity = mapper.map(dto, SalesPerson.class);
		SalesPerson storage = repository.save(entity);

		return mapper.map(storage, SalesPersonDTO.class);
	}

	@Override
	public List<SalesPersonDTO> getList(int page, int limit) {
		List<SalesPersonDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<SalesPerson> resourcePage = repository.findAll(pageableRequest);
		List<SalesPerson> resource = resourcePage.getContent();

		for (SalesPerson entity : resource) {
			returnValue.add(mapper.map(entity, SalesPersonDTO.class));
		}

		return returnValue;
	}

	@Override
	public SalesPersonDTO get(Long id) {
		Optional<SalesPerson> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), SalesPersonDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Sales Person is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<SalesPerson> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Sales Person  is not found.");
		}
	}

	@Override
	public SalesPersonDTO update(Long id, SalesPersonDTO dto) {

		Optional<SalesPerson> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setSalesmanName(dto.getSalesmanName());
			entity.get().setContactNo(dto.getContactNo());
			entity.get().setEmail(dto.getEmail());
			entity.get().setStatus(dto.getStatus());
			SalesPerson updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, SalesPersonDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Sales Persons is not found.");
		}

	}

}
