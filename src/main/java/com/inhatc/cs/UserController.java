package com.inhatc.cs;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inhatc.domain.UserVO;
import com.inhatc.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@Inject
	private BCryptPasswordEncoder pwdEncoder;
	
<<<<<<< HEAD
	// īī�� �α��� POST (������ ȸ��)
=======
	// īī�� �α��� POST
>>>>>>> 3db5309ae2011ccd0a1ad459af9ca5c1ff62d3ac
	@ResponseBody
	@RequestMapping(value="/kakaoLogin.do", method=RequestMethod.POST)
	public int kakaoLogin(UserVO vo, HttpSession session) throws Exception {
		if (service.idCheck(vo) == 1) {		// ȸ�����Ե� ���̵�
			try {
				session.setAttribute("userID", vo.getUserID());
				session.setAttribute("userName", vo.getUserName());
<<<<<<< HEAD
				session.setAttribute("user_type", "ȸ��");
=======
>>>>>>> 3db5309ae2011ccd0a1ad459af9ca5c1ff62d3ac
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 1;
		} else {							// ȸ�����Ե��� ���� ���̵�
			service.join(vo,"īī��");
			try {
				session.setAttribute("userID", vo.getUserID());
				session.setAttribute("userName", vo.getUserName());
<<<<<<< HEAD
				session.setAttribute("user_type", "ȸ��");
=======
>>>>>>> 3db5309ae2011ccd0a1ad459af9ca5c1ff62d3ac
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	// īī�� �Ҽ� �α��� �� �˷��� Ÿ�� ���� ������ GET
	@RequestMapping(value="/setAllergyType.do", method=RequestMethod.GET)
	public void setAllergyTypeGET(Model model, HttpSession session) throws Exception {
		logger.info("setAllergyType GET.............");
		
		String userID = (String)session.getAttribute("userID");
		String[] allergies = service.getAllergy(userID);
		
		model.addAttribute("allergyTypes", allergies);
	}
	
	// īī�� �Ҽ� �α��� �� �˷��� Ÿ�� ���� ������ POST
	@RequestMapping(value="/setAllergyType.do", method=RequestMethod.POST)
	public String setAllergyTypePOST(UserVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("setAllergyType POST........");
		
		if (service.updateAllergy(vo) == 1) {
			rttr.addFlashAttribute("msg", 1);
		} else {
			rttr.addFlashAttribute("msg", -1);
		}
		return "redirect:/main.do";
	}
	
	// �α��� GET
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public void loginGET(Model model, HttpSession session) throws Exception {
		logger.info("LOGIN GET...........");
	}
	
	// �α��� POST
	@RequestMapping(value="/login.do", method=RequestMethod.POST, produces="text/html; charset=UTF-8")
	public String loginPOST(UserVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
		UserVO userVO = service.login(vo);
		
		if (userVO == null) {
			rttr.addFlashAttribute("msg", 0);
			return "redirect:/user/login.do";
		}
		
		boolean pwdMatch = pwdEncoder.matches(vo.getUserPassword(), userVO.getUserPassword());
		
		if (userVO != null && pwdMatch == true) {
			try {
				session.setAttribute("userID", userVO.getUserID());
				session.setAttribute("userName", userVO.getUserName());
<<<<<<< HEAD
				session.setAttribute("user_type", userVO.getUser_type());
=======
>>>>>>> 3db5309ae2011ccd0a1ad459af9ca5c1ff62d3ac
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/main.do";
		} else {
			rttr.addFlashAttribute("msg", 0);
			return "redirect:/user/login.do";
		}
	}
	
	// �α׾ƿ� GET
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(Model model, HttpSession session) throws Exception {
		
		session.setAttribute("userID", null);			// ���� ��ȿȭ
		session.setAttribute("userName", null);
		return "redirect:/main.do";
	}
	
	// ȸ������ GET
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public void joinGET(Model model, HttpSession session) throws Exception {
		logger.info("JOIN GET.............");
	}
	
	// ȸ������ POST
	@RequestMapping(value="/join.do", method=RequestMethod.POST, produces="text/html; charset=UTF-8")
	public String joinPOST(UserVO userVO, HttpSession session, RedirectAttributes rttr) throws Exception {
		logger.info("ȸ������ POST");
		
		// ��й�ȣ ��ȣȭ�Ͽ� userVO�� userPassword�� �־��ֱ�
		String inputPW = userVO.getUserPassword();
		String pwd = pwdEncoder.encode(inputPW);
		userVO.setUserPassword(pwd);
		
		service.join(userVO,"�Ϲ�");
		rttr.addFlashAttribute("msg", 1);
		return "redirect:/user/login.do";
	}
	
	// ���̵� �ߺ� Ȯ�� POST
	@ResponseBody
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	public int idCheck(UserVO userVO) throws Exception {
		int result = service.idCheck(userVO);
		return result;
	}
	
	// �г��� �ߺ� Ȯ�� POST
	@ResponseBody
	@RequestMapping(value="/nameCheck.do", method=RequestMethod.POST)
	public int nameCheck(UserVO userVO) throws Exception {
		int result = service.nameCheck(userVO);
		return result;
	}
	
	// īī�� �Ҽ� �α��� �� �˷��� Ÿ�� ���� ������ GET
	@RequestMapping(value="/setUserName.do", method=RequestMethod.GET)
	public void setUserNameGET(Model model, HttpSession session) throws Exception {
		logger.info("setAllergyType GET.............");
	}
	
	// īī�� �Ҽ� �α��� �� �˷��� Ÿ�� ���� ������ POST
	@RequestMapping(value="/setUserName.do", method=RequestMethod.POST)
	public String setUserNamePOST(UserVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
		logger.info("setAllergyType POST........");
		
		if (service.updateUserName(vo) == 1) {
			rttr.addFlashAttribute("msg", 2);
			session.setAttribute("userName", vo.getUserName());
		} else {
			rttr.addFlashAttribute("msg", -1);
		}
		return "redirect:/main.do";
	}
}
