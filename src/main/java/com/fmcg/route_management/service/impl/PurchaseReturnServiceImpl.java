package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.PurchaseInvoice;
import com.fmcg.route_management.io.entity.PurchaseReturn;
import com.fmcg.route_management.io.repository.PurchaseInvoiceRepository;
import com.fmcg.route_management.io.repository.PurchaseReturnRepository;
import com.fmcg.route_management.service.PurchaseReturnService;
import com.fmcg.route_management.shared.dto.PurchaseReturnDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PurchaseReturnServiceImpl implements PurchaseReturnService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	PurchaseReturnRepository repository;
	
	@Autowired
	PurchaseInvoiceRepository purchaseInvoiceRepository;

	@Override
	public PurchaseReturnDTO save(PurchaseReturnDTO dto) {

		if (repository.findByPrNumber(dto.getPrNumber()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		PurchaseReturn entity = mapper.map(dto, PurchaseReturn.class);
		PurchaseReturn storage = repository.save(entity);

		return mapper.map(storage, PurchaseReturnDTO.class);
	}

	@Override
	public List<PurchaseReturnDTO> getList(int page, int limit) {
		List<PurchaseReturnDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<PurchaseReturn> resourcePage = repository.findAll(pageableRequest);
		List<PurchaseReturn> resource = resourcePage.getContent();

		for (PurchaseReturn entity : resource) {
			returnValue.add(mapper.map(entity, PurchaseReturnDTO.class));
		}

		return returnValue;
	}

	@Override
	public PurchaseReturnDTO get(Long id) {
		Optional<PurchaseReturn> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), PurchaseReturnDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseReturn is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<PurchaseReturn> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested PurchaseReturn  is not found.");
		}
	}

	@Override
	public PurchaseReturnDTO update(Long id, PurchaseReturnDTO dto) {

		Optional<PurchaseReturn> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setPrNumber(dto.getPrNumber());
			entity.get().setPrDate(dto.getPrDate());
			entity.get().setTotalReturnValueExluded(dto.getTotalReturnValueExluded());
			entity.get().setTotalReturnValueIncluded(dto.getTotalReturnValueIncluded());
			entity.get().setRemarks(dto.getRemarks());
			entity.get().setStatus(dto.getStatus());
			
			Optional<PurchaseInvoice> purchaseOrder = purchaseInvoiceRepository.findById(id);
			if (purchaseOrder.isPresent()) {
				entity.get().setPurchaseInvoice(purchaseOrder.get());
			} else {
				throw new ResourceNotFoundException("Selected Purchase Invoice no is not found.");
			}
			
			PurchaseReturn updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, PurchaseReturnDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested PurchaseReturn is not found.");
		}

	}

}
