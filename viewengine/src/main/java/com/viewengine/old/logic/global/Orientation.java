package com.viewengine.old.logic.global;

import java.util.HashMap;
import java.util.Map;

public enum Orientation {
	NONE("none"),
	HORIZONTAL("horizontal"),
	VERTICAL("vertical");

    private final String mName;
    private static Map<String, Orientation> mMap = new HashMap<String, Orientation>();
    static {
    	for (Orientation type : Orientation.values()) {
    		mMap.put(type.mName, type);
    	}
    }
    
    private Orientation(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
    
    public static Orientation getByName(String name) {
        return mMap.get(name);
    }
}
