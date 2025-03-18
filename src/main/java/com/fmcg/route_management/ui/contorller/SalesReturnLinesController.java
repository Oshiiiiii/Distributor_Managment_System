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

import com.uniquelabs.uniquedms.io.entity.SalesReturnLines;
import com.uniquelabs.uniquedms.service.SalesReturnLinesService;
import com.uniquelabs.uniquedms.shared.dto.SalesReturnLinesDTO;
import com.uniquelabs.uniquedms.ui.model.request.SalesReturnLinesRequest;
import com.uniquelabs.uniquedms.ui.model.response.OperationStatusModel;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationName;
import com.uniquelabs.uniquedms.ui.model.response.RequestOperationStatus;
import com.uniquelabs.uniquedms.ui.model.response.SalesReturnLinesRest;



@RestController
@RequestMapping("/SalesReturnLines")
public class SalesReturnLinesController {

	@Autowired
	SalesReturnLinesService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesReturnLinesRest get(@PathVariable Long id) {
		SalesReturnLinesDTO dto = service.get(id);
		return modelMapper.map(dto, SalesReturnLinesRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SalesReturnLinesRest create(@RequestBody SalesReturnLinesRequest request) throws Exception {

		SalesReturnLinesDTO dto = modelMapper.map(request, SalesReturnLinesDTO.class);
		SalesReturnLinesDTO storage = service.save(dto);

		return modelMapper.map(storage, SalesReturnLinesRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<SalesReturnLines> getTax(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<SalesReturnLinesDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<SalesReturnLinesRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public SalesReturnLinesRest update(@PathVariable Long id, @RequestBody SalesReturnLinesRequest request) {

		SalesReturnLinesDTO dto = modelMapper.map(request, SalesReturnLinesDTO.class);

		SalesReturnLinesDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, SalesReturnLinesRest.class);
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
