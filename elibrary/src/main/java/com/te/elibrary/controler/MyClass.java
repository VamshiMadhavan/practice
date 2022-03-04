package com.te.elibrary.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.elibrary.model.Member;
import com.te.elibrary.model.MemberResponse;
import com.te.elibrary.service.MyService;

@RestController
public class MyClass {

	@Autowired
	MyService service;

	@PostMapping("/register")
	public ResponseEntity<MemberResponse> register(@RequestBody Member member) {
		Member register = service.register(member);
		MemberResponse response = new MemberResponse(false, register);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);

	}

	@GetMapping("/fetch")
	public ResponseEntity<MemberResponse> fetch(@RequestParam Integer memberId) {
		Member fetchById = service.fetchById(memberId);
		MemberResponse response = new MemberResponse(false, fetchById);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<MemberResponse> update(@RequestBody Member member) {
		Integer memberId = member.getMemberId();
		Member update = service.update(member, memberId);
		MemberResponse response = new MemberResponse(false, update);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/delete")
	public void delete(@RequestBody Member member) {
		service.delete(member);
	}

	@GetMapping("/fetchall")
	public ResponseEntity<MemberResponse> fetchAll() {
		List<Member> fetchAll = service.fetchAll();
		MemberResponse response = new MemberResponse(false, fetchAll);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);

	}

	@GetMapping("/validate")
	public ResponseEntity<MemberResponse> validate(@RequestBody Member member) {
		boolean validate = service.validate(member);
		MemberResponse response = new MemberResponse(false, validate);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);
	}
}
