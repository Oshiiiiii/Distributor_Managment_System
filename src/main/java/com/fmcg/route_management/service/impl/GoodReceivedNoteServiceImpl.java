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
import com.uniquelabs.uniquedms.io.entity.GoodReceivedNote;
import com.uniquelabs.uniquedms.io.entity.PurchaseInvoice;
import com.uniquelabs.uniquedms.io.repository.GoodReceivedNoteRepository;
import com.uniquelabs.uniquedms.io.repository.PurchaseInvoiceRepository;
import com.uniquelabs.uniquedms.service.GoodReceivedNoteService;
import com.uniquelabs.uniquedms.shared.dto.GoodReceivedNoteDTO;

@Service
public class GoodReceivedNoteServiceImpl implements GoodReceivedNoteService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	GoodReceivedNoteRepository repository;

	@Autowired
	PurchaseInvoiceRepository purchaseInvoiceRepository;

	@Override
	public GoodReceivedNoteDTO save(GoodReceivedNoteDTO dto) {

		if (repository.findBygrnNumber(dto.getGrnNumber()) != null)
			throw new ResourceAlreadyExistsException("Record already exists");

		GoodReceivedNote entity = mapper.map(dto, GoodReceivedNote.class);
		GoodReceivedNote storage = repository.save(entity);

		return mapper.map(storage, GoodReceivedNoteDTO.class);
	}

	@Override
	public List<GoodReceivedNoteDTO> getList(int page, int limit) {
		List<GoodReceivedNoteDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<GoodReceivedNote> resourcePage = repository.findAll(pageableRequest);
		List<GoodReceivedNote> resource = resourcePage.getContent();

		for (GoodReceivedNote entity : resource) {
			returnValue.add(mapper.map(entity, GoodReceivedNoteDTO.class));
		}

		return returnValue;
	}

	@Override
	public GoodReceivedNoteDTO get(Long id) {
		Optional<GoodReceivedNote> entity = repository.findById(id);

		if (entity.isPresent()) {
			return mapper.map(entity.get(), GoodReceivedNoteDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested GoodReceivedNote is not found.");
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		Optional<GoodReceivedNote> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.delete(entity.get());
		} else {
			throw new ResourceNotFoundException("Requested GoodReceivedNote  is not found.");
		}
	}

	@Override
	public GoodReceivedNoteDTO update(Long id, GoodReceivedNoteDTO dto) {

		Optional<GoodReceivedNote> entity = repository.findById(id);
		if (entity.isPresent()) {
			entity.get().setGrnNumber(dto.getGrnNumber());
			entity.get().setGrnDate(dto.getGrnDate());
			entity.get().setTotalValueExluded(dto.getTotalValueExluded());
			entity.get().setTotalValueIncluded(dto.getTotalValueIncluded());
			entity.get().setRemarks(dto.getRemarks());
			entity.get().setStatus(dto.getStatus());

			Optional<PurchaseInvoice> purchaseInvoice = purchaseInvoiceRepository.findById(id);
			if (purchaseInvoice.isPresent()) {
				entity.get().setPurchaseInvoice(purchaseInvoice.get());
			} else {
				throw new ResourceNotFoundException("Selected purchase invoice is not found.");
			}

			GoodReceivedNote updatedResources = repository.save(entity.get());
			return mapper.map(updatedResources, GoodReceivedNoteDTO.class);
		} else {
			throw new ResourceNotFoundException("Requested GoodReceivedNote is not found.");
		}

	}

}
