package com.yonikal.viewengine;

import android.app.Application;
import android.content.Context;

/**
 * Created by yoni on 31/08/2017.
 */

public class ViewEngine {
    private static Application sContext;
    private static ViewEngine sInstance;

    private ViewEngine() {}

    public void init(Application context) {
        sContext = context;
    }

    public static ViewEngine getInstance() {
        return sInstance;
    }

    public Context getContext() {
        return sContext;
    }
}
