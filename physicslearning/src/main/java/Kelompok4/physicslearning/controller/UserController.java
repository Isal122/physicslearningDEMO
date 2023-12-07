package Kelompok4.physicslearning.controller;

import Kelompok4.physicslearning.dto.UserDto;
import Kelompok4.physicslearning.model.User;
import Kelompok4.physicslearning.repositories.UserRepository;
import Kelompok4.physicslearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		List<User> userList = userRepository.findAll();
		model.addAttribute("users", userList);
		return "admin";
	}

	@GetMapping("/materi")
	public String materi() {
		return "materi";
	}

	@GetMapping("/semester")
	public String semester() {
		return "semester";
	}

	@GetMapping("/semesterj")
	public String semesterj() {
		return "semesterJ";
	}

	@GetMapping("/error")
	public String error () {return "error";}

	@GetMapping("about-us")
	public String abousUs () {return "aboutUs";}

	@GetMapping("matkulsem1")
	public String matkulSem1 () {return "matkulsem1";}

	@GetMapping("matkulsem2")
	public String matkulSem2 () {return "matkulsem2";}

	@GetMapping("matkulsem3")
	public String matkulSem3 () {return "matkulsem3";}

	@GetMapping("matkulsem4")
	public String matkulSem4 () {return "matkulsem4";}

	@GetMapping("matkulsem5")
	public String matkulSem5 () {return "matkulsem5";}

	@GetMapping("matkulsem1j")
	public String matkulSem1j () {return "matkulsem1j";}

	@GetMapping("matkulsem2j")
	public String matkulSem2j () {return "matkulsem2j";}

	@GetMapping("matkulsem3j")
	public String matkulSem3j () {return "matkulsem3j";}

	@GetMapping("matkulsem4j")
	public String matkulSem4j () {return "matkulsem4j";}

	@GetMapping("matkulsem5j")
	public String matkulSem5j () {return "matkulsem5j";}

	@GetMapping("donasi")
	public String donasi () {return "donasi";}

	@GetMapping("ebook")
	public String ebook () {return "ebook";}






}
