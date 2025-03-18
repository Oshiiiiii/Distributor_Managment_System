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

import com.uniquelabs.uniquedms.service.WarehouseTypeService;
import com.uniquelabs.uniquedms.shared.dto.WarehouseTypeDTO;
import com.uniquelabs.uniquedms.ui.model.request.WarehouseTypeRequest;
import com.uniquelabs.uniquedms.ui.model.response.OperationStatusModel;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationName;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationStatus;
import com.uniquelabs.uniquedms.ui.model.response.WarehouseTypeRest;

@RestController
@RequestMapping("/WarehouseType")
public class WarehouseTypeController {

	@Autowired
	WarehouseTypeService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public WarehouseTypeRest get(@PathVariable Long id) {
		WarehouseTypeDTO dto = service.get(id);
		return modelMapper.map(dto, WarehouseTypeRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public WarehouseTypeRest create(@RequestBody WarehouseTypeRequest request) throws Exception {

		WarehouseTypeDTO dto = modelMapper.map(request, WarehouseTypeDTO.class);
		WarehouseTypeDTO storage = service.save(dto);

		return modelMapper.map(storage, WarehouseTypeRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<WarehouseTypeRest> getWarehouseType(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<WarehouseTypeDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<WarehouseTypeRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public WarehouseTypeRest update(@PathVariable Long id, @RequestBody WarehouseTypeRequest request) {

		WarehouseTypeDTO dto = modelMapper.map(request, WarehouseTypeDTO.class);

		WarehouseTypeDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, WarehouseTypeRest.class);
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
