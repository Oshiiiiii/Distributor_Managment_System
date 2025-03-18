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
import com.uniquelabs.uniquedms.io.entity.PurchaseInvoiceLines;
import com.uniquelabs.uniquedms.io.repository.PurchaseInvoiceLinesRepository;
import com.uniquelabs.uniquedms.service.PurchaseInvoiceLinesService;
import com.uniquelabs.uniquedms.shared.dto.PurchaseInvoiceLinesDTO;




@Service
public class PurchaseInvoiceLinesServiceImpl implements PurchaseInvoiceLinesService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	PurchaseInvoiceLinesRepository repository;

	@Override
	public PurchaseInvoiceLinesDTO save(PurchaseInvoiceLinesDTO dto) {

		if (repository.findByPurchaseInvoiceLinesCode(dto.getPurchaseInvoiceId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		PurchaseInvoiceLines entity = mapper.map(dto, PurchaseInvoiceLines.class);
		PurchaseInvoiceLines storage = repository.save(entity);

		return mapper.map(storage, PurchaseInvoiceLinesDTO.class);
	}

	@Override
	public List<PurchaseInvoiceLinesDTO> getList(int page, int limit) {
		List<PurchaseInvoiceLinesDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<PurchaseInvoiceLines> resourcePage = repository.findAll(pageableRequest);
		List<PurchaseInvoiceLines> resource = resourcePage.getContent();

		for (PurchaseInvoiceLines entity : resource) {
			returnValue.add(mapper.map(entity, PurchaseInvoiceLinesDTO.class));
		}

		return returnValue;
	}

	@Override
	public PurchaseInvoiceLinesDTO get(Long id) {
		Optional<PurchaseInvoiceLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), PurchaseInvoiceLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseInvoiceLines is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<PurchaseInvoiceLines> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested PurchaseInvoiceLines  is not found.");
		}
	}

	@Override
	public PurchaseInvoiceLinesDTO update(Long id, PurchaseInvoiceLinesDTO dto) {

		Optional<PurchaseInvoiceLines> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setProductInvoiceQty(dto.getProductInvoiceQty());
			PurchaseInvoiceLines updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, PurchaseInvoiceLinesDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseInvoice is not found.");
		}

	}

}
