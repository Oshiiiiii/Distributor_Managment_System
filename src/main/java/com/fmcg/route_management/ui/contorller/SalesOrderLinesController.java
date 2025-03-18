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

import com.uniquelabs.uniquedms.io.entity.SalesOrderLines;
import com.uniquelabs.uniquedms.service.SalesOrderLinesService;
import com.uniquelabs.uniquedms.shared.dto.SalesOrderLinesDTO;
import com.uniquelabs.uniquedms.ui.model.request.SalesOrderLinesRequest;
import com.uniquelabs.uniquedms.ui.model.response.OperationStatusModel;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationName;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationStatus;
import com.uniquelabs.uniquedms.ui.model.response.SalesOrderLinesRest;


@RestController
@RequestMapping("/SalesOrderLines")
public class SalesOrderLinesController {

	@Autowired
	SalesOrderLinesService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesOrderLinesRest get(@PathVariable Long id) {
		SalesOrderLinesDTO dto = service.get(id);
		return modelMapper.map(dto, SalesOrderLinesRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesOrderLinesRest create(@RequestBody SalesOrderLinesRequest request) throws Exception {

		SalesOrderLinesDTO dto = modelMapper.map(request, SalesOrderLinesDTO.class);
		SalesOrderLinesDTO storage = service.save(dto);

		return modelMapper.map(storage, SalesOrderLinesRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<SalesOrderLines> getTax(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<SalesOrderLinesDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<SalesOrderLinesRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public SalesOrderLinesRest update(@PathVariable Long id, @RequestBody SalesOrderLinesRequest request) {

		SalesOrderLinesDTO dto = modelMapper.map(request, SalesOrderLinesDTO.class);

		SalesOrderLinesDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, SalesOrderLinesRest.class);
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
