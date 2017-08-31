package com.yonikal.viewengine.utils;

import android.text.TextUtils;
import android.util.Log;

import com.yonikal.viewengine.ViewEngine;

import org.json.JSONObject;

/**
 * Created by yoni on 31/08/2017.
 */
public class JsonDataLoader {

    private final static String TAG = JsonDataLoader.class.getSimpleName();

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

    /**
     * Get the static android json file, in case of success save it as a file for future backup
     * In case of failure first try to read the last copy of the file and in case that fails
     * use the local copy
     */
    public void getStaticFile() {
        loadLocalStaticFile();
    }

    private void loadLocalStaticFile() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject jsonView = null;
                try {
                    String data = FileUtils.getFileData(ViewEngine.getInstance().getContext(), StaticFileName.View.getName());
                    if (!TextUtils.isEmpty(data)) {
                        jsonView = new JSONObject(data);
                        Log.e(TAG, "Android static data loaded from cache");
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }

                try {
                    if (jsonView == null) {
                        Log.e(TAG, "Android static data loaded from local file");
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    Log.e(TAG, "Android static data did not load");
                }
            }
        }).start();
    }
}
