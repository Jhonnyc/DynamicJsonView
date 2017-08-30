package com.viewengine.old.logic.global;

import java.util.HashMap;
import java.util.Map;

public enum LayoutParam {
	NONE("none"),
	ZERO("0"),
	WRAP_CONTENT("wrap_content"),
	MATCH_PARENT("match_parent");
	
    private final String mName;
    private static Map<String, LayoutParam> mMap = new HashMap<String, LayoutParam>();
    static {
    	for (LayoutParam param : LayoutParam.values()) {
    		mMap.put(param.mName, param);
    	}
    }
    
    private LayoutParam(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
    
    public static LayoutParam getByName(String name) {
        return mMap.get(name);
    }
}
