package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.UserTypeDTO;

import java.util.List;

public interface UserTypeService {

	UserTypeDTO save(UserTypeDTO dto);

	List<UserTypeDTO> getList(int page, int limit);

	UserTypeDTO get(Long id);

	void delete(Long id);

	UserTypeDTO update(Long id, UserTypeDTO dto);
}
