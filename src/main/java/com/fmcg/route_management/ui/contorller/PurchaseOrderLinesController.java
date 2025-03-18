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
import com.uniquelabs.uniquedms.service.PurchaseOrderLinesService;
import com.uniquelabs.uniquedms.shared.dto.PurchaseOrderLinesDTO;
import com.uniquelabs.uniquedms.ui.model.request.PurchaseOrderLinesRequest;
import com.uniquelabs.uniquedms.ui.model.response.PurchaseOrderLinesRest;
import com.uniquelabs.uniquedms.ui.model.response.OperationStatusModel;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationName;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping("/PurchaseOrderLinesLines")
public class PurchaseOrderLinesController {

	@Autowired
	PurchaseOrderLinesService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseOrderLinesRest get(@PathVariable Long id) {
		PurchaseOrderLinesDTO dto = service.get(id);
		return modelMapper.map(dto, PurchaseOrderLinesRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseOrderLinesRest create(@RequestBody PurchaseOrderLinesRequest request) throws Exception {

		PurchaseOrderLinesDTO dto = modelMapper.map(request, PurchaseOrderLinesDTO.class);
		PurchaseOrderLinesDTO storage = service.save(dto);

		return modelMapper.map(storage, PurchaseOrderLinesRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<PurchaseOrderLinesRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<PurchaseOrderLinesDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<PurchaseOrderLinesRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public PurchaseOrderLinesRest update(@PathVariable Long id, @RequestBody PurchaseOrderLinesRequest request) {

		PurchaseOrderLinesDTO dto = modelMapper.map(request, PurchaseOrderLinesDTO.class);

		PurchaseOrderLinesDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, PurchaseOrderLinesRest.class);
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
