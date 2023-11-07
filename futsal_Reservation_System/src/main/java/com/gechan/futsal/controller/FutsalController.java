package com.gechan.futsal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gechan.futsal.dao.FileDao;
import com.gechan.futsal.models.FieldDto;
import com.gechan.futsal.models.FileDto;
import com.gechan.futsal.models.ReservationDto;
import com.gechan.futsal.models.UserDto;
import com.gechan.futsal.service.FieldService;
import com.gechan.futsal.service.FileService;

@Controller
public class FutsalController {

	private final FileService fileService;
	private final FieldService fieldService;
	private final FileDao fileDao;

	public FutsalController(FileService fileService, FieldService fieldService, FileDao fileDao) {
		this.fileService = fileService;
		this.fieldService = fieldService;
		this.fileDao = fileDao;
	}

	@RequestMapping(value = "ceo/ceopage", method = RequestMethod.GET)
	public String ceopage(HttpSession httpSession, Model model) {

		UserDto userDto = (UserDto) httpSession.getAttribute("LOGINUSER");

		if (userDto == null) {
			return "redirect:/";
		}

		FieldDto fieldDto = fieldService.findByName(userDto.getU_id());
		if (fieldDto != null) {
			model.addAttribute("MAINFIELD", fieldDto);
			List<ReservationDto> reservationList = fieldService.ReservationList(fieldDto.getF_name());
			if(!reservationList.isEmpty()) {
				model.addAttribute("RESERVLIST", reservationList);				
			}
		}
		model.addAttribute("CEO", userDto);

		return "ceo/ceopage";
	}

	@RequestMapping(value = "ceo/field-admin", method = RequestMethod.GET)
	public String regField(String id, Model model) {

		model.addAttribute("CEOBODY", "REG");

		return "ceo/ceopage";
	}

	@RequestMapping(value = "ceo/field-admin", method = RequestMethod.POST)
	public String regField(FieldDto fieldDto, @RequestParam(value = "f_image") MultipartFile f_image,
			MultipartHttpServletRequest f_images, Model model, HttpSession httpSession) {

		UserDto userDto = (UserDto) httpSession.getAttribute("LOGINUSER");

		String fileName = null;

		try {

			if (!f_image.getOriginalFilename().isEmpty()) {
				fileName = fileService.fileUp(f_image);

				fieldDto.setF_main_image(fileName);

			}
			fieldDto.setF_uid(userDto.getU_id());
			int result = fieldService.insert(fieldDto);

			if (f_images.getFile("f_images").getSize() > 0) {
				List<FileDto> files = fileService.filesUp(f_images);
				fileDao.insert(files, fieldDto.getF_cnumber());
			}
			return "redirect:/ceo/ceopage"; // 체크해야함
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "ceo/ceopage";
	}

	@RequestMapping(value = "/reservation-page", method = RequestMethod.GET)
	public String revField(Model model) {

		List<FieldDto> fieldList = fieldService.selectAll();
		for(FieldDto dto : fieldList) {
			System.out.println(dto.toString());
		}

		model.addAttribute("FIELDS", fieldList);
		model.addAttribute("BODY", "RESERV");
		return "index";
	}

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(String field, HttpSession httpSession, Model model) {
		UserDto userDto = (UserDto) httpSession.getAttribute("LOGINUSER");
		if (userDto == null) {
			// model.addAttribute("BODY", "LOGIN");
			return "redirect:/login-page";
		}

		int result = fieldService.fieldReservation(field, userDto);

		return "redirect:/";
	}

	@RequestMapping(value = "/ceo/matchfinish", method = RequestMethod.GET)
	public String mathFinish(String seq) {
		
		int intSeq = Integer.parseInt(seq);
		
		int result = fieldService.finishMatch(intSeq);

		return "redirect:/ceo/ceopage";
	}
}
