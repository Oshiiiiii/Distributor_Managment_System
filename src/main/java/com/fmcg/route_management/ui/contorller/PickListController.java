package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.PickListService;
import com.fmcg.route_management.shared.dto.PickListDTO;
import com.fmcg.route_management.ui.model.request.PickListRequest;
import com.fmcg.route_management.ui.model.response.*;
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

@RestController
@RequestMapping("/PickList")
public class PickListController {

	@Autowired
	PickListService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PickListRest get(@PathVariable Long id) {
		PickListDTO dto = service.get(id);
		return modelMapper.map(dto, PickListRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public TaxRest create(@RequestBody PickListRequest request) throws Exception {

		PickListDTO dto = modelMapper.map(request, PickListDTO.class);
		PickListDTO storage = service.save(dto);

		return modelMapper.map(storage, TaxRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<PickListRest> getTax(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<PickListDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<PickListRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public PickListRest update(@PathVariable Long id, @RequestBody PickListRequest request) {

		PickListDTO dto = modelMapper.map(request, PickListDTO.class);

		PickListDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, PickListRest.class);
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
