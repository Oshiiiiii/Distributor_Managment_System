package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.ProductCategoeryService;
import com.fmcg.route_management.shared.dto.ProductCategoeryDTO;
import com.fmcg.route_management.ui.model.request.ProductCategoeryRequest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
import com.fmcg.route_management.ui.model.response.ProductCategoeryRest;
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
@RequestMapping("/ProductCategoery")
public class ProductCategoeryController {

	@Autowired
	ProductCategoeryService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ProductCategoeryRest get(@PathVariable Long id) {
		ProductCategoeryDTO dto = service.get(id);
		return modelMapper.map(dto, ProductCategoeryRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ProductCategoeryRest create(@RequestBody ProductCategoeryRequest request) throws Exception {

		ProductCategoeryDTO dto = modelMapper.map(request, ProductCategoeryDTO.class);
		ProductCategoeryDTO storage = service.save(dto);

		return modelMapper.map(storage, ProductCategoeryRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<ProductCategoeryRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<ProductCategoeryDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<ProductCategoeryRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ProductCategoeryRest update(@PathVariable Long id, @RequestBody ProductCategoeryRequest request) {

		ProductCategoeryDTO dto = modelMapper.map(request, ProductCategoeryDTO.class);

		ProductCategoeryDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, ProductCategoeryRest.class);
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
