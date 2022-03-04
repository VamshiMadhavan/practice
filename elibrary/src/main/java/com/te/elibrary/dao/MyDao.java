package com.te.elibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.elibrary.model.Member;

@Repository
public interface MyDao extends JpaRepository<Member, Integer> {
	
	Member findMemberByMemberId(Integer memberId);

}
