package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.PurchaseReturnService;
import com.fmcg.route_management.shared.dto.PurchaseReturnDTO;
import com.fmcg.route_management.ui.model.request.PurchaseReturnRequest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
import com.fmcg.route_management.ui.model.response.PurchaseReturnRest;
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
@RequestMapping("/PurchaseReturn")
public class PurchaseReturnController {

	@Autowired
	PurchaseReturnService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseReturnRest get(@PathVariable Long id) {
		PurchaseReturnDTO dto = service.get(id);
		return modelMapper.map(dto, PurchaseReturnRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseReturnRest create(@RequestBody PurchaseReturnRequest request) throws Exception {

		PurchaseReturnDTO dto = modelMapper.map(request, PurchaseReturnDTO.class);
		PurchaseReturnDTO storage = service.save(dto);

		return modelMapper.map(storage, PurchaseReturnRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<PurchaseReturnRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<PurchaseReturnDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<PurchaseReturnRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public PurchaseReturnRest update(@PathVariable Long id, @RequestBody PurchaseReturnRequest request) {

		PurchaseReturnDTO dto = modelMapper.map(request, PurchaseReturnDTO.class);

		PurchaseReturnDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, PurchaseReturnRest.class);
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
