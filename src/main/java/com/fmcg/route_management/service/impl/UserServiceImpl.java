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
import com.uniquelabs.uniquedms.io.entity.User;
import com.uniquelabs.uniquedms.io.repository.UserRepository;
import com.uniquelabs.uniquedms.service.UserService;
import com.uniquelabs.uniquedms.shared.dto.UserDTO;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	UserRepository repository;

	@Override
	public UserDTO save(UserDTO dto) {

		if (repository.findById(dto.getId()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		User entity = mapper.map(dto, User.class);
		User storage = repository.save(entity);

		return mapper.map(storage, UserDTO.class);
	}

	@Override
	public List<UserDTO> getList(int page, int limit) {
		List<UserDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<User> resourcePage = repository.findAll(pageableRequest);
		List<User> resource = resourcePage.getContent();

		for (User entity : resource) {
			returnValue.add(mapper.map(entity, UserDTO.class));
		}

		return returnValue;
	}

	@Override
	public UserDTO get(Long id) {
		Optional<User> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), UserDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested User is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<User> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested User  is not found.");
		}
	}

	@Override
	public UserDTO update(Long id, UserDTO dto) {

		Optional<User> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setLogin(dto.getLogin());
			entity.get().setPassword(dto.getFirstName());
			entity.get().setFirstName(dto.getFirstName());
			entity.get().setLastName(dto.getLastName());
			entity.get().setEmail(dto.getEmail());
			entity.get().setImageUrl(dto.getImageUrl());
			entity.get().setActivated(dto.isActivated());
			entity.get().setLangKey(dto.getLangKey());
			entity.get().setActivationKey(dto.getCreatedBy());
			User updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, UserDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested User is not found.");
		}

	}

}
