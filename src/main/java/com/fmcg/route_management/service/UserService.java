package com.fmcg.route_management.service;

import java.util.List;

import com.uniquelabs.uniquedms.shared.dto.UserDTO;

public interface UserService {

	UserDTO save(UserDTO dto);

	List<UserDTO> getList(int page, int limit);

	UserDTO get(Long id);

	void delete(Long id);

	UserDTO update(Long id, UserDTO dto);
}
