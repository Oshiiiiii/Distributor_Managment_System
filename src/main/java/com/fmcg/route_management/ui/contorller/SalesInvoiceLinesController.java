package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.io.entity.SalesInvoiceLines;
import com.fmcg.route_management.service.SalesInvoiceLinesService;
import com.fmcg.route_management.shared.dto.SalesInvoiceLinesDTO;
import com.fmcg.route_management.ui.model.request.SalesInvoiceLinesRequest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
import com.fmcg.route_management.ui.model.response.RequestOperationName;
import com.fmcg.route_management.ui.model.response.RequestOperationStatus;
import com.fmcg.route_management.ui.model.response.SalesInvoiceLinesRest;
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
@RequestMapping("/SalesInvoiceLines")
public class SalesInvoiceLinesController {

	@Autowired
	SalesInvoiceLinesService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesInvoiceLinesRest get(@PathVariable Long id) {
		SalesInvoiceLinesDTO dto = service.get(id);
		return modelMapper.map(dto, SalesInvoiceLinesRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesInvoiceLinesRest create(@RequestBody SalesInvoiceLinesRequest request) throws Exception {

		SalesInvoiceLinesDTO dto = modelMapper.map(request, SalesInvoiceLinesDTO.class);
		SalesInvoiceLinesDTO storage = service.save(dto);

		return modelMapper.map(storage, SalesInvoiceLinesRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<SalesInvoiceLines> getTax(@RequestParam(value = "page", defaultValue = "0") int page,
										  @RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<SalesInvoiceLinesDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<SalesInvoiceLinesRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public SalesInvoiceLinesRest update(@PathVariable Long id, @RequestBody SalesInvoiceLinesRequest request) {

		SalesInvoiceLinesDTO dto = modelMapper.map(request, SalesInvoiceLinesDTO.class);

		SalesInvoiceLinesDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, SalesInvoiceLinesRest.class);
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
