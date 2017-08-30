package com.viewengine.old.logic.global;

import java.util.HashMap;
import java.util.Map;

public enum LayoutType {
	NONE("none"),
	LINEAR_LAYOUT("LinearLayout"),
	BUTTON("Button"),
	TEXT_VIEW("TextView"),
	IMAGE_VIEW("ImageView");

    private final String mName;
    private static Map<String, LayoutType> mMap = new HashMap<String, LayoutType>();
    static {
    	for (LayoutType type : LayoutType.values()) {
    		mMap.put(type.mName, type);
    	}
    }
    
    private LayoutType(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
    
    public static LayoutType getByName(String name) {
        return mMap.get(name);
    }
}
