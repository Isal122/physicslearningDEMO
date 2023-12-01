package Kelompok4.physicslearning.service;

import Kelompok4.physicslearning.dto.UserDto;
import Kelompok4.physicslearning.model.User;
import Kelompok4.physicslearning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , "USER", userDto.getFullname());
		return userRepository.save(user);
	}

}
