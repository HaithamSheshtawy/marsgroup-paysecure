package com.paysecure.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjMapper extends ObjectMapper {

	private static final long serialVersionUID = 4137500612219963914L;
	private static ObjMapper shared;

	private ObjMapper() {
	}

	public static synchronized ObjMapper getInstance() {
		if (shared == null) {
			shared = new ObjMapper();
		}
		return shared;
	}

}
