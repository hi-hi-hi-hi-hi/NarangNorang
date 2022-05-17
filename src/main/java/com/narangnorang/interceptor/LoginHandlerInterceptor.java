package com.narangnorang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.MemberDTO;

@Component("loginHandlerInterceptor")
public class LoginHandlerInterceptor implements HandlerInterceptor {

	// 로그인 여부 확인
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		if (memberDTO != null) {
			return true;
		}
		response.sendRedirect("/narangnorang/sessionInvalidate");
		return false;
	}

//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		HttpSession session = request.getSession();
//		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
//		session.setAttribute("login", memberDTO);
//	}

}
