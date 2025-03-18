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
import com.uniquelabs.uniquedms.io.entity.Distributor;
import com.uniquelabs.uniquedms.io.entity.Retailer;
import com.uniquelabs.uniquedms.io.entity.SalesPerson;
import com.uniquelabs.uniquedms.io.repository.DistributorRepository;
import com.uniquelabs.uniquedms.io.repository.RetailerRepository;
import com.uniquelabs.uniquedms.io.repository.SalesPersonRepository;
import com.uniquelabs.uniquedms.service.RetailerService;
import com.uniquelabs.uniquedms.shared.dto.RetailerDTO;



@Service
public class RetailerServiceImpl implements RetailerService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	RetailerRepository repository;
	
	@Autowired
	SalesPersonRepository salesPersonRepository;
	
	
	@Autowired
	DistributorRepository distributorRepository;

	@Override
	public RetailerDTO save(RetailerDTO dto) {

		if (repository.findByRetailerCode(dto.getRetailerCode()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		Retailer entity = mapper.map(dto, Retailer.class);
		Retailer storage = repository.save(entity);

		return mapper.map(storage, RetailerDTO.class);
	}

	@Override
	public List<RetailerDTO> getList(int page, int limit) {
		List<RetailerDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<Retailer> resourcePage = repository.findAll(pageableRequest);
		List<Retailer> resource = resourcePage.getContent();

		for (Retailer entity : resource) {
			returnValue.add(mapper.map(entity, RetailerDTO.class));
		}

		return returnValue;
	}

	@Override
	public RetailerDTO get(Long id) {
		Optional<Retailer> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), RetailerDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Retailer is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Retailer> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Retailer  is not found.");
		}
	}

	@Override
	public RetailerDTO update(Long id, RetailerDTO dto) {

		Optional<Retailer> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setRetailerCode(dto.getRetailerCode());
			entity.get().setRetailerName(dto.getRetailerName());
			entity.get().setAddress(dto.getAddress());
			entity.get().setContactNo(dto.getContactNo());
			entity.get().setVatStatus(dto.getVatStatus());
			entity.get().setVatNumber(dto.getVatNumber());
			entity.get().setLattitude(dto.getLattitude());
			entity.get().setLongitude(dto.getLongitude());
			entity.get().setStatus(dto.getStatus());
			
			Optional<SalesPerson>salesPerson = salesPersonRepository.findById(id);
			if (salesPerson.isPresent()) {
				entity.get().setSalesPerson(salesPerson.get());
			} else {
				throw new ResourceNotFoundException("Selected Sales order no is not found.");
			}
			
			Optional<Distributor> distributor = distributorRepository.findById(id);
			if (distributor.isPresent()) {
				entity.get().setDistributor(distributor.get());
			} else {
				throw new ResourceNotFoundException("Selected Sales order no is not found.");
			}
			
			Retailer updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, RetailerDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Retailer is not found.");
		}

	}

}
