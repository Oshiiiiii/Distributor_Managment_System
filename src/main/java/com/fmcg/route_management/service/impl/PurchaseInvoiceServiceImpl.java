package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.PurchaseInvoice;
import com.fmcg.route_management.io.repository.PurchaseInvoiceRepository;
import com.fmcg.route_management.service.PurchaseInvoiceService;
import com.fmcg.route_management.shared.dto.PurchaseInvoiceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class PurchaseInvoiceServiceImpl implements PurchaseInvoiceService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	PurchaseInvoiceRepository repository;

	@Override
	public PurchaseInvoiceDTO save(PurchaseInvoiceDTO dto) {

		if (repository.findByPiNumber(dto.getPiNumber()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		PurchaseInvoice entity = mapper.map(dto, PurchaseInvoice.class);
		PurchaseInvoice storage = repository.save(entity);

		return mapper.map(storage, PurchaseInvoiceDTO.class);
	}

	@Override
	public List<PurchaseInvoiceDTO> getList(int page, int limit) {
		List<PurchaseInvoiceDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<PurchaseInvoice> resourcePage = repository.findAll(pageableRequest);
		List<PurchaseInvoice> resource = resourcePage.getContent();

		for (PurchaseInvoice entity : resource) {
			returnValue.add(mapper.map(entity, PurchaseInvoiceDTO.class));
		}

		return returnValue;
	}

	@Override
	public PurchaseInvoiceDTO get(Long id) {
		Optional<PurchaseInvoice> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), PurchaseInvoiceDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseInvoice is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<PurchaseInvoice> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested PurchaseInvoice  is not found.");
		}
	}

	@Override
	public PurchaseInvoiceDTO update(Long id, PurchaseInvoiceDTO dto) {

		Optional<PurchaseInvoice> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setPiNumber(dto.getPiNumber());
			entity.get().setPiDate(dto.getPiDate());
			entity.get().setDeliveryDate(dto.getDeliveryDate());
			entity.get().setTotalValueExcluded(dto.getTotalValueExcluded());
			entity.get().setTotalValueIncluded(dto.getTotalValueIncluded());
			entity.get().setRemarks(dto.getRemarks());
			entity.get().setStatus(dto.getStatus());
			PurchaseInvoice updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, PurchaseInvoiceDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseInvoice is not found.");
		}

	}

}
