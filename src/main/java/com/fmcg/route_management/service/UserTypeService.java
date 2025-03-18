package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.UserTypeDTO;

public interface UserTypeService {

	UserTypeDTO save(UserTypeDTO dto);

	List<UserTypeDTO> getList(int page, int limit);

	UserTypeDTO get(Long id);

	void delete(Long id);

	UserTypeDTO update(Long id, UserTypeDTO dto);
}
