package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniquelabs.uniquedms.exceptions.ResourceAlreadyExistsException;
import com.uniquelabs.uniquedms.exceptions.ResourceNotFoundException;
import com.uniquelabs.uniquedms.io.entity.Distributor;
import com.uniquelabs.uniquedms.io.repository.DistributorRepository;
import com.uniquelabs.uniquedms.service.DistributorService;
import com.uniquelabs.uniquedms.shared.dto.DistributorDTO;



@Service
public class DistributorServiceImpl implements DistributorService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	DistributorRepository repository;

	@Override
	public DistributorDTO save(DistributorDTO dto) {

		if (repository.findByDistributorCode(dto.getDistributorCode()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		Distributor entity = mapper.map(dto, Distributor.class);
		Distributor storage = repository.save(entity);

		return mapper.map(storage, DistributorDTO.class);
	}

	@Override
	public List<DistributorDTO> getList(int page, int limit) {
		List<DistributorDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<Distributor> resourcePage = repository.findAll(pageableRequest);
		List<Distributor> resource = resourcePage.getContent();

		for (Distributor entity : resource) {
			returnValue.add(mapper.map(entity, DistributorDTO.class));
		}

		return returnValue;
	}

	@Override
	public DistributorDTO get(Long id) {
		Optional<Distributor> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), DistributorDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Distributor is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Distributor> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Distributor  is not found.");
		}
	}

	@Override
	public DistributorDTO update(Long id, DistributorDTO dto) {

		Optional<Distributor> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setDistributorCode(dto.getDistributorCode());
			entity.get().setDistributorName(dto.getDistributorName());
			entity.get().setAddress(dto.getAddress());
			entity.get().setContactNumber(dto.getContactNumber());
			entity.get().setTaxStatus(dto.getTaxStatus());
			entity.get().setVatNumber(dto.getVatNumber());
			entity.get().setStatus(dto.getStatus());
			Distributor updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, DistributorDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Distributor is not found.");
		}

	}

}
