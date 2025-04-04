package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.GoodReceivedNoteLinesService;
import com.fmcg.route_management.shared.dto.GoodReceivedNoteLinesDTO;
import com.fmcg.route_management.ui.model.request.GoodReceivedNoteLinesRequest;
import com.fmcg.route_management.ui.model.response.GoodReceivedNoteLinesRest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
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
@RequestMapping("/GoodReceiveNoteLines")
public class GoodReceivedNoteLinesController {

	@Autowired
	GoodReceivedNoteLinesService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public GoodReceivedNoteLinesRest get(@PathVariable Long id) {
		GoodReceivedNoteLinesDTO dto = service.get(id);
		return modelMapper.map(dto, GoodReceivedNoteLinesRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public GoodReceivedNoteLinesRest create(@RequestBody GoodReceivedNoteLinesRequest request) throws Exception {

		GoodReceivedNoteLinesDTO dto = modelMapper.map(request, GoodReceivedNoteLinesDTO.class);
		GoodReceivedNoteLinesDTO storage = service.save(dto);

		return modelMapper.map(storage, GoodReceivedNoteLinesRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<GoodReceivedNoteLinesRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<GoodReceivedNoteLinesDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<GoodReceivedNoteLinesRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public GoodReceivedNoteLinesRest update(@PathVariable Long id, @RequestBody GoodReceivedNoteLinesRequest request) {

		GoodReceivedNoteLinesDTO dto = modelMapper.map(request, GoodReceivedNoteLinesDTO.class);

		GoodReceivedNoteLinesDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, GoodReceivedNoteLinesRest.class);
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
