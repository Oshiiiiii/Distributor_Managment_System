package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.SalesInvoice;
import com.fmcg.route_management.io.repository.SalesInvoiceRepository;
import com.fmcg.route_management.service.SalesInvoiceService;
import com.fmcg.route_management.shared.dto.SalesInvoiceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SalesInvoiceServiceImpl implements SalesInvoiceService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	SalesInvoiceRepository repository;

	@Override
	public SalesInvoiceDTO save(SalesInvoiceDTO dto) {

		if (repository.findBySiNumber(dto.getSiNumber()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		SalesInvoice entity = mapper.map(dto, SalesInvoice.class);
		SalesInvoice storage = repository.save(entity);

		return mapper.map(storage, SalesInvoiceDTO.class);
	}

	@Override
	public List<SalesInvoiceDTO> getList(int page, int limit) {
		List<SalesInvoiceDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<SalesInvoice> resourcePage = repository.findAll(pageableRequest);
		List<SalesInvoice> resource = resourcePage.getContent();

		for (SalesInvoice entity : resource) {
			returnValue.add(mapper.map(entity, SalesInvoiceDTO.class));
		}

		return returnValue;
	}

	@Override
	public SalesInvoiceDTO get(Long id) {
		Optional<SalesInvoice> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), SalesInvoiceDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested SalesInvoice is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<SalesInvoice> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested SalesInvoice  is not found.");
		}
	}

	@Override
	public SalesInvoiceDTO update(Long id, SalesInvoiceDTO dto) {

		Optional<SalesInvoice> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setSiNumber(dto.getSiNumber());
			entity.get().setSiDate(dto.getSiDate());
			entity.get().setDeliveryDate(dto.getDeliveryDate());
			entity.get().setTotalValueExluded(dto.getTotalValueExluded());
			entity.get().setTotalValueIncluded(dto.getTotalValueIncluded());
			entity.get().setRemarks(dto.getRemarks());
			entity.get().setStatus(dto.getStatus());
			entity.get().setPickListReference(dto.getPickListReference());
			SalesInvoice updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, SalesInvoiceDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested SalesInvoice is not found.");
		}

	}

}
