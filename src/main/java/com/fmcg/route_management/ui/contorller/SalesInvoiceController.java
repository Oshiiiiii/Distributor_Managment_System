package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.SalesInvoiceService;
import com.fmcg.route_management.shared.dto.SalesInvoiceDTO;
import com.fmcg.route_management.ui.model.request.SalesInvoiceRequest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
import com.fmcg.route_management.ui.model.response.RequestOperationName;
import com.fmcg.route_management.ui.model.response.RequestOperationStatus;
import com.fmcg.route_management.ui.model.response.SalesInvoiceRest;
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
@RequestMapping("/SalesInvoice")
public class SalesInvoiceController {

	@Autowired
	SalesInvoiceService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesInvoiceRest get(@PathVariable Long id) {
		SalesInvoiceDTO dto = service.get(id);
		return modelMapper.map(dto, SalesInvoiceRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesInvoiceRest create(@RequestBody SalesInvoiceRequest request) throws Exception {

		SalesInvoiceDTO dto = modelMapper.map(request, SalesInvoiceDTO.class);
		SalesInvoiceDTO storage = service.save(dto);

		return modelMapper.map(storage, SalesInvoiceRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<SalesInvoiceRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<SalesInvoiceDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<SalesInvoiceRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public SalesInvoiceRest update(@PathVariable Long id, @RequestBody SalesInvoiceRequest request) {

		SalesInvoiceDTO dto = modelMapper.map(request, SalesInvoiceDTO.class);

		SalesInvoiceDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, SalesInvoiceRest.class);
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
