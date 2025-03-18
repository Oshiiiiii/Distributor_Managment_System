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
import com.uniquelabs.uniquedms.io.entity.PickList;
import com.uniquelabs.uniquedms.io.repository.PickListRepository;
import com.uniquelabs.uniquedms.service.PickListService;
import com.uniquelabs.uniquedms.shared.dto.PickListDTO;


@Service
public class PickListServiceImpl implements PickListService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	PickListRepository repository;

	@Override
	public PickListDTO save(PickListDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		PickList entity = mapper.map(dto, PickList.class);
		PickList storage = repository.save(entity);

		return mapper.map(storage, PickListDTO.class);
	}

	@Override
	public List<PickListDTO> getList(int page, int limit) {
		List<PickListDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<PickList> resourcePage = repository.findAll(pageableRequest);
		List<PickList> resource = resourcePage.getContent();

		for (PickList entity : resource) {
			returnValue.add(mapper.map(entity, PickListDTO.class));
		}

		return returnValue;
	}

	@Override
	public PickListDTO get(Long id) {
		Optional<PickList> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), PickListDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Pick List is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<PickList> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Pick List is not found.");
		}
	}

	@Override
	public PickListDTO update(Long id, PickListDTO dto) {

		Optional<PickList> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setStatus(dto.getStatus());
			PickList updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, PickListDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Pick List is not found.");
		}

	}

}
