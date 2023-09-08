package com.example.helloworld.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Friend;

@Controller
public class FriendList {

	private List<Friend> friends = new ArrayList<>();

	@GetMapping("/index3")
	public String hello(Model model) {

		model.addAttribute("friends", friends);
		model.addAttribute("newFriend", new Friend());

		return "friendList";
	}

	@PostMapping("/index2")
	public String addFriend(@RequestParam String name) {
		// Add the submitted friend to the list
		friends.add(new Friend(name));

		return "redirect:/index3";

	}
}
