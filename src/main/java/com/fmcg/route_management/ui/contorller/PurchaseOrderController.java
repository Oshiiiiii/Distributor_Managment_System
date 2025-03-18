package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

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

import com.uniquelabs.uniquedms.service.PurchaseOrderService;
import com.uniquelabs.uniquedms.shared.dto.PurchaseOrderDTO;
import com.uniquelabs.uniquedms.ui.model.request.PurchaseOrderRequest;
import com.uniquelabs.uniquedms.ui.model.response.PurchaseOrderRest;
import com.uniquelabs.uniquedms.ui.model.response.OperationStatusModel;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationName;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping("/PurchaseOrder")
public class PurchaseOrderController {

	@Autowired
	PurchaseOrderService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseOrderRest get(@PathVariable Long id) {
		PurchaseOrderDTO dto = service.get(id);
		return modelMapper.map(dto, PurchaseOrderRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseOrderRest create(@Valid @RequestBody PurchaseOrderRequest request) throws Exception {

		PurchaseOrderDTO dto = modelMapper.map(request, PurchaseOrderDTO.class);
		PurchaseOrderDTO storage = service.save(dto);

		return modelMapper.map(storage, PurchaseOrderRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<PurchaseOrderRest> getList(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit) {

		List<PurchaseOrderDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<PurchaseOrderRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public PurchaseOrderRest update(@PathVariable Long id, @RequestBody PurchaseOrderRequest request) {

		PurchaseOrderDTO dto = modelMapper.map(request, PurchaseOrderDTO.class);

		PurchaseOrderDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, PurchaseOrderRest.class);
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
