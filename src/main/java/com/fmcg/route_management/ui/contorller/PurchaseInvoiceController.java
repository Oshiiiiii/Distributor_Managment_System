package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.PurchaseInvoiceService;
import com.fmcg.route_management.shared.dto.PurchaseInvoiceDTO;
import com.fmcg.route_management.ui.model.request.PurchaseInvoiceRequest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
import com.fmcg.route_management.ui.model.response.PurchaseInvoiceRest;
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
@RequestMapping("/PurchaseInvoice")
public class PurchaseInvoiceController {

	@Autowired
	PurchaseInvoiceService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseInvoiceRest get(@PathVariable Long id) {
		PurchaseInvoiceDTO dto = service.get(id);
		return modelMapper.map(dto, PurchaseInvoiceRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public PurchaseInvoiceRest create(@RequestBody PurchaseInvoiceRequest request) throws Exception {

		PurchaseInvoiceDTO dto = modelMapper.map(request, PurchaseInvoiceDTO.class);
		PurchaseInvoiceDTO storage = service.save(dto);

		return modelMapper.map(storage, PurchaseInvoiceRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<PurchaseInvoiceRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<PurchaseInvoiceDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<PurchaseInvoiceRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public PurchaseInvoiceRest update(@PathVariable Long id, @RequestBody PurchaseInvoiceRequest request) {

		PurchaseInvoiceDTO dto = modelMapper.map(request, PurchaseInvoiceDTO.class);

		PurchaseInvoiceDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, PurchaseInvoiceRest.class);
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
