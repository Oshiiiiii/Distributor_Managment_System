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
import com.uniquelabs.uniquedms.io.entity.Tax;
import com.uniquelabs.uniquedms.io.repository.TaxRepository;
import com.uniquelabs.uniquedms.service.TaxService;
import com.uniquelabs.uniquedms.shared.dto.TaxDTO;


@Service
public class TaxServiceImpl implements TaxService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	TaxRepository repository;

	@Override
	public TaxDTO save(TaxDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		Tax entity = mapper.map(dto, Tax.class);
		Tax storage = repository.save(entity);

		return mapper.map(storage, TaxDTO.class);
	}

	@Override
	public List<TaxDTO> getList(int page, int limit) {
		List<TaxDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<Tax> resourcePage = repository.findAll(pageableRequest);
		List<Tax> resource = resourcePage.getContent();

		for (Tax entity : resource) {
			returnValue.add(mapper.map(entity, TaxDTO.class));
		}

		return returnValue;
	}

	@Override
	public TaxDTO get(Long id) {
		Optional<Tax> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), TaxDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested product Tax is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Tax> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Tax is not found.");
		}
	}

	@Override
	public TaxDTO update(Long id, TaxDTO dto) {

		Optional<Tax> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setTaxDescription(dto.getTaxDescription());
			entity.get().setTaxValue(dto.getTaxValue());
			entity.get().setStatus(dto.getStatus());
			Tax updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, TaxDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Tax is not found.");
		}

	}

}
