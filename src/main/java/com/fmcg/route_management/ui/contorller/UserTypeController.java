package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.UserTypeService;
import com.fmcg.route_management.shared.dto.UserTypeDTO;
import com.fmcg.route_management.ui.model.request.UserTypeRequest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
import com.fmcg.route_management.ui.model.response.RequestOperationName;
import com.fmcg.route_management.ui.model.response.RequestOperationStatus;
import com.fmcg.route_management.ui.model.response.UserTypeRest;
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
@RequestMapping("/UserType")
public class UserTypeController {

	@Autowired
	UserTypeService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserTypeRest get(@PathVariable Long id) {
		UserTypeDTO dto = service.get(id);
		return modelMapper.map(dto, UserTypeRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserTypeRest create(@RequestBody UserTypeRequest request) throws Exception {

		UserTypeDTO dto = modelMapper.map(request, UserTypeDTO.class);
		UserTypeDTO storage = service.save(dto);

		return modelMapper.map(storage, UserTypeRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserTypeRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<UserTypeDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<UserTypeRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserTypeRest update(@PathVariable Long id, @RequestBody UserTypeRequest request) {

		UserTypeDTO dto = modelMapper.map(request, UserTypeDTO.class);

		UserTypeDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, UserTypeRest.class);
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
