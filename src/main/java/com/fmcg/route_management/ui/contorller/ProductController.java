package com.fmcg.route_management.ui.contorller;

import java.lang.reflect.Type;
import java.util.List;

import com.fmcg.route_management.service.ProductService;
import com.fmcg.route_management.shared.dto.ProductDTO;
import com.fmcg.route_management.ui.model.request.ProductRequest;
import com.fmcg.route_management.ui.model.response.OperationStatusModel;
import com.fmcg.route_management.ui.model.response.ProductRest;
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
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	ProductService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ProductRest get(@PathVariable Long id) {
		ProductDTO dto = service.get(id);
		return modelMapper.map(dto, ProductRest.class);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ProductRest create(@RequestBody ProductRequest request) throws Exception {

		ProductDTO dto = modelMapper.map(request, ProductDTO.class);
		ProductDTO storage = service.save(dto);

		return modelMapper.map(storage, ProductRest.class);
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<ProductRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "2") int limit) {

		List<ProductDTO> dtoList = service.getList(page, limit);

		Type listType = new TypeToken<List<ProductRest>>() {
		}.getType();

		return new ModelMapper().map(dtoList, listType);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ProductRest update(@PathVariable Long id, @RequestBody ProductRequest request) {

		ProductDTO dto = modelMapper.map(request, ProductDTO.class);

		ProductDTO updatedResource = service.update(id, dto);

		return modelMapper.map(updatedResource, ProductRest.class);
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
