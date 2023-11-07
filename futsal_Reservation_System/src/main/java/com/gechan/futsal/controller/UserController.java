package com.gechan.futsal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gechan.futsal.models.UserDto;
import com.gechan.futsal.service.UserService;

@Controller
public class UserController {

	protected final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/whojoin-page", method = RequestMethod.GET)
	public String whojoin(String div, Model model) {
		model.addAttribute("BODY", "WHOJOIN");
		return "index";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String ceojoin(String div, Model model, UserDto dto) {

		dto = new UserDto();

		if (div.equals("1")) {
			dto.setU_div("사업자");
			model.addAttribute("JOIN", "CEOJOIN");
			model.addAttribute("DTO", dto);
		} else if (div.equals("2")) {
			dto.setU_div("일반사용자");
			model.addAttribute("JOIN", "USERJOIN");
			model.addAttribute("DTO", dto);
		}
		model.addAttribute("BODY", "JOIN");

		return "index";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserDto userDto) {

		userService.insert(userDto);
		return "redirect:/";
	}

	@RequestMapping(value = "/login-page", method = RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("BODY", "LOGIN");
		model.addAttribute("ERROR", error);
		return "index";
	}

	@RequestMapping(value = "/login-page", method = RequestMethod.POST)
	public String login(UserDto userDto, HttpSession httpSession, Model model) {

		String result = userService.login(userDto);
		if (result.equals("OK")) {
			UserDto loginUser = userService.findById(userDto.getU_id());
			httpSession.setAttribute("LOGINUSER", loginUser);
			if(loginUser.getU_div().equals("사업자")) {
				
				return "redirect:/ceo/ceopage";
			} else {
				return "redirect:/";
			}
		} else {
			return "redirect:/login-page?error=" + result;
		}

	}

	@RequestMapping(value = "/logout-page", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {

		httpSession.removeAttribute("LOGINUSER");

		return "redirect:/";
	}

	@RequestMapping(value = "my-page", method = RequestMethod.GET)
	public String mypage(HttpSession httpSession, Model model) {

		UserDto userDto = (UserDto) httpSession.getAttribute("LOGINUSER");
		String result = userService.mypage(userDto);

		if (result.equals("OKSESSION")) {
			model.addAttribute("BODY", "MYPAGE");
			model.addAttribute("USER", userDto);
			if (userDto.getU_div().equals("일반사용자")) {
				model.addAttribute("DIV", "USER");
			} else {
				model.addAttribute("DIV", "CEO");
			}
			return "index";
		} else {
			return "redirect:/login-page";
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id, HttpSession httpSession) {
		int result = userService.delete(id);
		if (result > 0) {
			httpSession.removeAttribute("LOGINUSER");
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model model, HttpSession httpSession) {
		if(httpSession.getAttribute("LOGINUSER") == null) {
			return "redirect:/login-page";
		}
		UserDto updateDto = userService.findById(id);
		model.addAttribute("DTO", updateDto);
		model.addAttribute("BODY", "UPDATE");

		return "index";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(UserDto userDto, HttpSession httpSession) {
		int result = userService.update(userDto);
		if(result > 0) {
			httpSession.removeAttribute("LOGINUSER");
			UserDto dto = userService.findById(userDto.getU_id());
			httpSession.setAttribute("LOGINUSER", dto);
		}
		return "redirect:/my-page";
	}
}
