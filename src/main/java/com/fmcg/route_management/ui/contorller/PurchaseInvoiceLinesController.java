package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.PurchaseInvoiceLinesService;
import com.fmcg.route_management.shared.dto.PurchaseInvoiceLinesDTO;
import com.fmcg.route_management.ui.model.request.PurchaseInvoiceLinesRequest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
import com.fmcg.route_management.ui.model.response.PurchaseInvoiceLinesRest;
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
@RequestMapping("/PurchaseInvoiceLines")
public class PurchaseInvoiceLinesController {

	@Autowired
	PurchaseInvoiceLinesService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseInvoiceLinesRest get(@PathVariable Long id) {
		PurchaseInvoiceLinesDTO dto = service.get(id);
		return modelMapper.map(dto, PurchaseInvoiceLinesRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseInvoiceLinesRest create(@RequestBody PurchaseInvoiceLinesRequest request) throws Exception {

		PurchaseInvoiceLinesDTO dto = modelMapper.map(request, PurchaseInvoiceLinesDTO.class);
		PurchaseInvoiceLinesDTO storage = service.save(dto);

		return modelMapper.map(storage, PurchaseInvoiceLinesRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<PurchaseInvoiceLinesRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<PurchaseInvoiceLinesDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<PurchaseInvoiceLinesRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public PurchaseInvoiceLinesRest update(@PathVariable Long id, @RequestBody PurchaseInvoiceLinesRequest request) {

		PurchaseInvoiceLinesDTO dto = modelMapper.map(request, PurchaseInvoiceLinesDTO.class);

		PurchaseInvoiceLinesDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, PurchaseInvoiceLinesRest.class);
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
