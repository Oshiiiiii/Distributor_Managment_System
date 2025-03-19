package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.SalesInvoiceLines;
import com.fmcg.route_management.io.repository.SalesInvoiceLinesRepository;
import com.fmcg.route_management.service.SalesInvoiceLinesService;
import com.fmcg.route_management.shared.dto.SalesInvoiceLinesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SalesInvoiceLinesServiceImpl implements SalesInvoiceLinesService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	SalesInvoiceLinesRepository repository;

	@Override
	public SalesInvoiceLinesDTO save(SalesInvoiceLinesDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		SalesInvoiceLines entity = mapper.map(dto, SalesInvoiceLines.class);
		SalesInvoiceLines storage = repository.save(entity);

		return mapper.map(storage, SalesInvoiceLinesDTO.class);
	}

	@Override
	public List<SalesInvoiceLinesDTO> getList(int page, int limit) {
		List<SalesInvoiceLinesDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<SalesInvoiceLines> resourcePage = repository.findAll(pageableRequest);
		List<SalesInvoiceLines> resource = resourcePage.getContent();

		for (SalesInvoiceLines entity : resource) {
			returnValue.add(mapper.map(entity, SalesInvoiceLinesDTO.class));
		}

		return returnValue;
	}

	@Override
	public SalesInvoiceLinesDTO get(Long id) {
		Optional<SalesInvoiceLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), SalesInvoiceLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Sales Invoice Line is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<SalesInvoiceLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Sales Invoice Line is not found.");
		}
	}

	@Override
	public SalesInvoiceLinesDTO update(Long id, SalesInvoiceLinesDTO dto) {

		Optional<SalesInvoiceLines> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setProductInvoiceQty(dto.getProductInvoiceQty());
			SalesInvoiceLines updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, SalesInvoiceLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Sales Invoice Line is not found.");
		}

	}

}
