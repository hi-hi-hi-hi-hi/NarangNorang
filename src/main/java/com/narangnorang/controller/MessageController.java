package com.narangnorang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.MessageDTO;
import com.narangnorang.service.MessageService;


@Controller
public class MessageController {

	@Autowired
	MessageService messageService;

	@GetMapping("/message")
	@ModelAttribute("messageList")
	public ModelAndView selectMessageList(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		ModelAndView mav = new ModelAndView();
		
		if (memberDTO != null) {
			int userId = memberDTO.getId();
			mav.setViewName("message");

			List<MessageDTO> messageList = messageService.selectMessageList(userId);
			Iterator<MessageDTO> iter = messageList.iterator();
			List<Integer> otherUsers = new ArrayList<Integer>();
			
			while (iter.hasNext()) {
				MessageDTO messageDTO = iter.next();
				// 만약 이미 대화방이 표시된 사용자면 제거
				if (otherUsers.contains(messageDTO.getSenderId()) || otherUsers.contains(messageDTO.getRecieverId())) {
					iter.remove();
				} else {
					// sender/reciever가 본인이 아닌 경우 리스트 추가
					if (userId != messageDTO.getSenderId()) {
						otherUsers.add(messageDTO.getSenderId());
					}
					if (userId != messageDTO.getRecieverId()) {
						otherUsers.add(messageDTO.getRecieverId());
					}
				}
			}
			mav.addObject("messageList", messageList);
			mav.addObject("userId", userId);
		} else {
			mav.setViewName("common/sessionInvalidate");
		}
		return mav;
	}

	@GetMapping("/message/counsel")
	public ModelAndView popupMessageForm(@RequestParam Map<String, String> counselor) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/message/messageForm");
		mav.addObject("counselor", counselor);
		return mav;
	}

	@PostMapping("/message/counsel")
	public String sendMessageToCounselor(HttpSession session, @RequestParam Map<String, Object> messageInfo)
			throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		messageInfo.put("senderId", memberDTO.getId());
		messageInfo.put("senderName", memberDTO.getName());
		messageInfo.put("senderPrivilege", memberDTO.getPrivilege());
		messageService.sendMessage(messageInfo);
		return "home";
	}
	
	@GetMapping("/message/chats/{otherId}")
	public ModelAndView popupChats(HttpSession session, @PathVariable @ModelAttribute String otherId) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int userId = memberDTO.getId();
		
		map.put("userId", userId);
		map.put("otherId", otherId);
		
		mav.setViewName("/message/chats");
		mav.addObject("chats", messageService.getChats(map));
		return mav;
	}
	
	@ResponseBody
	@PostMapping("/message/send")
	public Map<String, Object> sendMessage(@RequestBody Map<String, Object> messageInfo) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		int sended = messageService.sendMessage(messageInfo);
		
		if(sended == 1) {
			result.put("result", "ok");
		}
		return result;
	}
	
	@GetMapping("/message/unread")
	@ResponseBody
	public Map<String, Object> countUnread(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int userId = memberDTO.getId();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("unreadCounts", messageService.countUnread(userId));
		return result;
	}
}
