package com.te.elibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberResponse {
	
	private Boolean error;
	private Object data;

}
