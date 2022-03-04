package com.te.elibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.elibrary.dao.MyDao;
import com.te.elibrary.model.Member;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	MyDao dao;

	@Override
	public Member register(Member member) {
		if (member != null) {
			return dao.save(member);
		}
		throw new RuntimeException("Invalid");
	}

	@Override
	public Member fetchById(Integer memberId) {
		return dao.findMemberByMemberId(memberId);

	}

	@Override
	public Member update(Member member, Integer memberId) {
		Member memberFound = dao.findMemberByMemberId(memberId);
		
		if(memberFound!=null) {
			return dao.save(member);
		}
		throw new RuntimeException("invalid");

	}

	@Override
	public void delete(Member member) {
		if(member!=null) {
			dao.delete(member);
		}
	}

	@Override
	public List<Member> fetchAll() {
		
		return dao.findAll();
	}

	@Override
	public boolean validate(Member member) {
		Integer memberId = member.getMemberId();
		Member findMemberByMemberId = dao.findMemberByMemberId(memberId);
		if(member.equals(findMemberByMemberId)) {
			return true;
		}
		else {
			return false;
		}
	}

}
