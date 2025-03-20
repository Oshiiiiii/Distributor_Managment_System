package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.PurchaseReturnLinesService;
import com.fmcg.route_management.shared.dto.PurchaseReturnLinesDTO;
import com.fmcg.route_management.ui.model.request.PurchaseReturnLinesRequest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
import com.fmcg.route_management.ui.model.response.PurchaseReturnLinesRest;
import com.fmcg.route_management.ui.model.response.RequestOperationName;
import com.fmcg.route_management.ui.model.response.RequestOperationStatus;
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
@RequestMapping("/PurchaseReturnLines")
public class PurchaseReturnLinesController {

	@Autowired
	PurchaseReturnLinesService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseReturnLinesRest get(@PathVariable Long id) {
		PurchaseReturnLinesDTO dto = service.get(id);
		return modelMapper.map(dto, PurchaseReturnLinesRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseReturnLinesRest create(@RequestBody PurchaseReturnLinesRequest request) throws Exception {

		PurchaseReturnLinesDTO dto = modelMapper.map(request, PurchaseReturnLinesDTO.class);
		PurchaseReturnLinesDTO storage = service.save(dto);

		return modelMapper.map(storage, PurchaseReturnLinesRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<PurchaseReturnLinesRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<PurchaseReturnLinesDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<PurchaseReturnLinesRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public PurchaseReturnLinesRest update(@PathVariable Long id, @RequestBody PurchaseReturnLinesRequest request) {

		PurchaseReturnLinesDTO dto = modelMapper.map(request, PurchaseReturnLinesDTO.class);

		PurchaseReturnLinesDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, PurchaseReturnLinesRest.class);
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
