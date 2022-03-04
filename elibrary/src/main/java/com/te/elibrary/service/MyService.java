package com.te.elibrary.service;

import java.util.List;

import com.te.elibrary.model.Member;

public interface MyService {
	
	Member register(Member member);
	
	Member fetchById(Integer memberId);
	
	Member update(Member member,Integer memberId);
	
	void delete(Member member);
	
	List<Member> fetchAll();
	
	boolean validate(Member member);

}
