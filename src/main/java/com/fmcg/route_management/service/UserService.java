package com.fmcg.route_management.service;

import com.fmcg.route_management.shared.dto.UserDTO;

import java.util.List;


public interface UserService {

	UserDTO save(UserDTO dto);

	List<UserDTO> getList(int page, int limit);

	UserDTO get(Long id);

	void delete(Long id);

	UserDTO update(Long id, UserDTO dto);
}
