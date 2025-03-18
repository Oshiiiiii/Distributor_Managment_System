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

import com.uniquelabs.uniquedms.service.InventoryService;
import com.uniquelabs.uniquedms.shared.dto.InventoryDTO;
import com.uniquelabs.uniquedms.ui.model.request.InventoryRequest;
import com.uniquelabs.uniquedms.ui.model.response.InventoryRest;
import com.uniquelabs.uniquedms.ui.model.response.OperationStatusModel;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationName;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping("/Inventory")
public class InventoryController {

	@Autowired
	InventoryService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public InventoryRest get(@PathVariable Long id) {
		InventoryDTO dto = service.get(id);
		return modelMapper.map(dto, InventoryRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public InventoryRest create(@RequestBody InventoryRequest request) throws Exception {

		InventoryDTO dto = modelMapper.map(request, InventoryDTO.class);
		InventoryDTO storage = service.save(dto);

		return modelMapper.map(storage, InventoryRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<InventoryRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<InventoryDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<InventoryRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public InventoryRest update(@PathVariable Long id, @RequestBody InventoryRequest request) {

		InventoryDTO dto = modelMapper.map(request, InventoryDTO.class);

		InventoryDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, InventoryRest.class);
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
