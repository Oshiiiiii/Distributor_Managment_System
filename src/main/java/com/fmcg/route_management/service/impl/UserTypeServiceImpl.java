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
import com.uniquelabs.uniquedms.io.entity.UserType;
import com.uniquelabs.uniquedms.io.repository.UserTypeRepository;
import com.uniquelabs.uniquedms.service.UserTypeService;
import com.uniquelabs.uniquedms.shared.dto.UserTypeDTO;



@Service
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	UserTypeRepository repository;

	@Override
	public UserTypeDTO save(UserTypeDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		UserType entity = mapper.map(dto, UserType.class);
		UserType storage = repository.save(entity);

		return mapper.map(storage, UserTypeDTO.class);
	}

	@Override
	public List<UserTypeDTO> getList(int page, int limit) {
		List<UserTypeDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<UserType> resourcePage = repository.findAll(pageableRequest);
		List<UserType> resource = resourcePage.getContent();

		for (UserType entity : resource) {
			returnValue.add(mapper.map(entity, UserTypeDTO.class));
		}

		return returnValue;
	}

	@Override
	public UserTypeDTO get(Long id) {
		Optional<UserType> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), UserTypeDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested UserType is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<UserType> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested UserType  is not found.");
		}
	}

	@Override
	public UserTypeDTO update(Long id, UserTypeDTO dto) {

		Optional<UserType> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setUserTypeName(dto.getUserTypeName());
			entity.get().setStatus(dto.getStatus());
			UserType updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, UserTypeDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested UserType is not found.");
		}

	}

}
