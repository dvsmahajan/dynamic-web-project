package com.pritesh.userapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritesh.userapp.dto.UserDTO;
import com.pritesh.userapp.model.UserEntity;
import com.pritesh.userapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository; 
	
	public UserDTO saveUser(UserDTO dto) {
		try {
			UserEntity entity = new UserEntity();
			BeanUtils.copyProperties(dto, entity);
			entity =repository.save(entity);
			if(entity!=null) {
				BeanUtils.copyProperties(entity, dto);
				return dto;
			}
			return null;
		} catch (Exception e) {
			System.out.println("Exception occured while saving data.\nException is "+e);
			return null;
		}
	}

	public UserDTO getUserById(Integer userId) {
		UserEntity entity = repository.getUserById(userId); 
		if(entity!=null) {
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return null;
	}

}
