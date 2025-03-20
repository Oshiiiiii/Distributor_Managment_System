package com.fmcg.route_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.fmcg.route_management.exceptions.ResourceAlreadyExistsException;
import com.fmcg.route_management.exceptions.ResourceNotFoundException;
import com.fmcg.route_management.io.entity.Van;
import com.fmcg.route_management.io.repository.VanRepository;
import com.fmcg.route_management.service.VanService;
import com.fmcg.route_management.shared.dto.VanDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class VanServiceImpl implements VanService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	VanRepository repository;

	@Override
	public VanDTO save(VanDTO dto) {

		if (repository.findByVanCode(dto.getVanCode()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		Van entity = mapper.map(dto, Van.class);
		Van storage = repository.save(entity);

		return mapper.map(storage, VanDTO.class);
	}

	@Override
	public List<VanDTO> getList(int page, int limit) {
		List<VanDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<Van> resourcePage = repository.findAll(pageableRequest);
		List<Van> resource = resourcePage.getContent();

		for (Van entity : resource) {
			returnValue.add(mapper.map(entity, VanDTO.class));
		}

		return returnValue;
	}

	@Override
	public VanDTO get(Long id) {
		Optional<Van> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), VanDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Van is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<Van> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested Van  is not found.");
		}
	}

	@Override
	public VanDTO update(Long id, VanDTO dto) {

		Optional<Van> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setVanCode(dto.getVanCode());
			entity.get().setVanName(dto.getVanName());
			entity.get().setStatus(dto.getStatus());
			Van updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, VanDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested Van is not found.");
		}

	}

}
