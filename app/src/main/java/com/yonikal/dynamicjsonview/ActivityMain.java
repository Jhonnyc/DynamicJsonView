package com.yonikal.dynamicjsonview;

import static com.viewengine.old.constants.STATS.LAYOUT;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.viewengine.old.logic.modal.TreeViewParser;
import com.viewengine.old.logic.utils.CallLogUtility;

public class ActivityMain extends Activity {

    // LogCat tag
    private static final String TAG = ActivityMain.class.getSimpleName();
    private ViewGroup mMainView;
    private TreeViewParser mTreeViewParser;
    private String mNumberToDial;
    private CallLogUtility mCallLogUtil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumberToDial = getIntent().getExtras().getString("p");
        initUi();
        initObjects();
    }

    private void initUi() {
        mMainView = (ViewGroup) findViewById(R.id.mainView);
    }

    private void initObjects() {
        mTreeViewParser = new TreeViewParser(this, mMainView, LAYOUT, mNumberToDial);
        // JSONArray jsonMainArr;
        // JSONObject obj;
        // try {
        // jsonMainArr = new JSONArray(LAYOUT);
        // obj = jsonMainArr.getJSONObject(0);
        // } catch(Exception e) {
        // e.getMessage();
        // }
        mCallLogUtil = new CallLogUtility();
//		List<Layout> layouts = Utils.getLayoutList(LAYOUT);
//		for (Layout layout : layouts) {
//			View v = layout.getViewByType(this);
//			LayoutParams mLayoutParams = new LayoutParams(layout.getWidth(),
//					layout.getHeight(), layout.getWeight());
//			if (layout.hasChildrens()) {
//				int orientation = layout.getOrientation().equals(
//						Orientation.HORIZONTAL) ? LinearLayout.HORIZONTAL
//						: LinearLayout.VERTICAL;
//				((LinearLayout) v).setOrientation(orientation);
//				List<Layout> layoutChilds = layout.getLayoutChildrens();
//				for (Layout layout2 : layoutChilds) {
//					View v2 = layout2.getViewByType(this);
//					if (v2 instanceof Button) {
//						setButtonParams(v2, layout);
//					}
//					LayoutParams dLayoutParams = new LayoutParams(
//							layout2.getWidth(), layout2.getHeight(),
//							layout2.getWeight());
//					v2.setLayoutParams(dLayoutParams);
//					v2.setBackgroundColor(layout2.getColor());
//					((LinearLayout) v).addView(v2);
//				}
//			}
//			v.setLayoutParams(mLayoutParams);
//			v.setBackgroundColor(layout.getColor());
//			mMainView.addView(v);
//		}


        mMainView.invalidate();
    }
}
