package com.pankaj.phase3project.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pankaj.phase3project.global.GlobalData;
import com.pankaj.phase3project.model.Role;
import com.pankaj.phase3project.model.User;
import com.pankaj.phase3project.repository.RoleRepository;
import com.pankaj.phase3project.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@GetMapping("/login")
	public String login() {
		GlobalData.cart.clear();
		return "login";
	}

	@GetMapping("/register")
	public String registerGet() {
		return "register";

	}

	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		userRepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";

	}

	@GetMapping("/forgotPassword")
	public String updatePasswordGet()// (@RequestParam("email") String email
	{
		System.out.println();
		return "forgotPassword";

	}

	@PostMapping("/forgotPassword")
	public String updatePasswordPost(@ModelAttribute("user") User user, @RequestParam("email") String email,
			@RequestParam("password") String password) {

		User foundUser = userRepository.findUserByEmail(email).get();
		System.out.println("User is " + foundUser);
		foundUser.setPassword(bCryptPasswordEncoder.encode(password));

		return "redirect:/login";

	}

}