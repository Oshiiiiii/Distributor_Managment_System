package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.GoodReceivedNoteService;
import com.fmcg.route_management.shared.dto.GoodReceivedNoteDTO;
import com.fmcg.route_management.ui.model.request.GoodReceivedNoteRequest;
import com.fmcg.route_management.ui.model.response.GoodReceivedNoteRest;
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
@RequestMapping("/GoodReceiveNote")
public class GoodReceivedNoteController {

	@Autowired
	GoodReceivedNoteService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public GoodReceivedNoteRest get(@PathVariable Long id) {
		GoodReceivedNoteDTO dto = service.get(id);
		return modelMapper.map(dto, GoodReceivedNoteRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public GoodReceivedNoteRest create(@RequestBody GoodReceivedNoteRequest request) throws Exception {

		GoodReceivedNoteDTO dto = modelMapper.map(request, GoodReceivedNoteDTO.class);
		GoodReceivedNoteDTO storage = service.save(dto);

		return modelMapper.map(storage, GoodReceivedNoteRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<GoodReceivedNoteRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<GoodReceivedNoteDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<GoodReceivedNoteRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public GoodReceivedNoteRest update(@PathVariable Long id, @RequestBody GoodReceivedNoteRequest request) {

		GoodReceivedNoteDTO dto = modelMapper.map(request, GoodReceivedNoteDTO.class);

		GoodReceivedNoteDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, GoodReceivedNoteRest.class);
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
