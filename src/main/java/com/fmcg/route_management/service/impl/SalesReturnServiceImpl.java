package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.SalesInvoice;
import com.fmcg.route_management.io.entity.SalesReturn;
import com.fmcg.route_management.io.repository.SalesInvoiceRepository;
import com.fmcg.route_management.io.repository.SalesReturnRepository;
import com.fmcg.route_management.service.SalesReturnService;
import com.fmcg.route_management.shared.dto.SalesReturnDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SalesReturnServiceImpl implements SalesReturnService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	SalesReturnRepository repository;

	SalesInvoiceRepository salesInvoiceRepository;

	@Override
	public SalesReturnDTO save(SalesReturnDTO dto) {

		if (repository.findBySalesReturnCode(dto.getSrNumber()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		SalesReturn entity = mapper.map(dto, SalesReturn.class);
		SalesReturn storage = repository.save(entity);

		return mapper.map(storage, SalesReturnDTO.class);
	}

	@Override
	public List<SalesReturnDTO> getList(int page, int limit) {
		List<SalesReturnDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<SalesReturn> resourcePage = repository.findAll(pageableRequest);
		List<SalesReturn> resource = resourcePage.getContent();

		for (SalesReturn entity : resource) {
			returnValue.add(mapper.map(entity, SalesReturnDTO.class));
		}

		return returnValue;
	}

	@Override
	public SalesReturnDTO get(Long id) {
		Optional<SalesReturn> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), SalesReturnDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested SalesReturn is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<SalesReturn> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested SalesReturn  is not found.");
		}
	}

	@Override
	public SalesReturnDTO update(Long id, SalesReturnDTO dto) {

		Optional<SalesReturn> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setSrNumber(dto.getSrNumber());
			entity.get().setSrDate(dto.getSrDate());
			entity.get().setTotalReturnValueExluded(dto.getTotalReturnValueExluded());
			entity.get().setTotalReturnValueIncluded(dto.getTotalReturnValueIncluded());
			entity.get().setRemarks(dto.getRemarks());
			entity.get().setStatus(dto.getStatus());

			Optional<SalesInvoice> salesInvoice = salesInvoiceRepository.findById(dto.getSalesInvoiceId());

			if (salesInvoice.isPresent()) {
				entity.get().setSalesInvoice(salesInvoice.get());
			} else {
				throw new ResourceNotFoundException("Selected sales invoice is not found.");
			}

			SalesReturn updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, SalesReturnDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested SalesReturn is not found.");
		}

	}

}
