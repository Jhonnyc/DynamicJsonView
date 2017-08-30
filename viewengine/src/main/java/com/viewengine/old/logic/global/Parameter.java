package com.viewengine.old.logic.global;

public enum Parameter {
	TYPE("type"),
	WIDTH("width"),
	HEIGHT("height"),
	WEIGHT("weight"),
	ORIENTATION("orientation"),
	SRC_URL("src_url"),
	BACKGROUND_URL("background_url"),
	TEXT("text");
	
	private String mName;
	
	private Parameter(String name) {
		mName = name;
	}

	public String getPropertyName() {
		return mName;
	}
}
