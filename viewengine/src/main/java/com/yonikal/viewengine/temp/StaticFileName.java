package com.yonikal.viewengine.temp;

/**
 * Created by Yoni on 31/08/2017.
 */
public enum StaticFileName {
    View("view");

    String mName;

    StaticFileName(String name) {
        mName = name;

    }

    public String getName() {
        return mName;
    }

}
