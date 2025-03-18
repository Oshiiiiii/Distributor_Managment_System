package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniquelabs.uniquedms.service.SalesReturnService;
import com.uniquelabs.uniquedms.shared.dto.SalesReturnDTO;
import com.uniquelabs.uniquedms.ui.model.request.SalesReturnRequest;
import com.uniquelabs.uniquedms.ui.model.response.SalesReturnRest;
import com.uniquelabs.uniquedms.ui.model.response.OperationStatusModel;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationName;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping("/SalesReturn")
public class SalesReturnController {

	@Autowired
	SalesReturnService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesReturnRest get(@PathVariable Long id) {
		SalesReturnDTO dto = service.get(id);
		return modelMapper.map(dto, SalesReturnRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesReturnRest create(@RequestBody SalesReturnRequest request) throws Exception {

		SalesReturnDTO dto = modelMapper.map(request, SalesReturnDTO.class);
		SalesReturnDTO storage = service.save(dto);

		return modelMapper.map(storage, SalesReturnRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<SalesReturnRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<SalesReturnDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<SalesReturnRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public SalesReturnRest update(@PathVariable Long id, @RequestBody SalesReturnRequest request) {

		SalesReturnDTO dto = modelMapper.map(request, SalesReturnDTO.class);

		SalesReturnDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, SalesReturnRest.class);
	}

	@DeleteMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel delete(@PathVariable Long id) {
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.DELETE.name());

		service.delete(id);

		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return returnValue;
	}

}
