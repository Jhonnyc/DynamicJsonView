package com.viewengine.old.logic.modal;

import static com.viewengine.STATS.LAYOUT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

import com.viewengine.old.logic.global.Orientation;
import com.viewengine.old.logic.utils.Utils;

public class TreeViewParser {

	// Class Variables
	private boolean mIsOk = false;
	private Context mContext;
	private ViewGroup mMainView;
	private String mViewTreeAsJson;
	private String mNumberToDial;
	private Map<String, String> mParametersMap;
	private List<View> mViewsList;

	public TreeViewParser(Context context, ViewGroup mainView, String jsonViewTree, String number) {
		mContext = context;
		mMainView = mainView;
		mViewTreeAsJson = jsonViewTree;
		mNumberToDial = number;
		init();
	}

	public List<View> getViewsList() {
		return mViewsList;
	}

	private void init() {
		mParametersMap = new HashMap<String, String>();
		mViewsList = new ArrayList<View>();
		List<Layout> layouts = Utils.getLayoutList(LAYOUT);
		initViewsList(mMainView, layouts);
	}

	private void initViewsList(ViewGroup mainView, List<Layout> layouts) {
		
		for (Layout layout : layouts) {
			View view = layout.getViewByType(mContext);
			if (view instanceof Button) {
				setButtonParams((Button)view, layout);
			}
			if (layout.hasChildrens()) {
				int orientation = layout.getOrientation().equals(
						Orientation.HORIZONTAL) ? LinearLayout.HORIZONTAL
						: LinearLayout.VERTICAL;
				((LinearLayout) view).setOrientation(orientation);
				initViewsList(((ViewGroup)view), layout.getLayoutChildrens());
			}
			LayoutParams mLayoutParams = new LayoutParams(layout.getWidth(),
					layout.getHeight(), layout.getWeight());
			view.setLayoutParams(mLayoutParams);
			view.setBackgroundColor(layout.getColor());
			mainView.addView(view);
			mainView.invalidate();
		}
	}
	
	private void setButtonParams(Button button, Layout layout) {
		button.setText(layout.getText());
		button.setOnClickListener(toastClickListener);
	}
	
	private OnClickListener toastClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(mContext, "Button Clicked",
					Toast.LENGTH_LONG).show();
			Intent intent = new Intent(Intent.ACTION_CALL);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
			intent.setData(Uri.parse("tel:" + mNumberToDial));
			mContext.startActivity(intent);
//			mContext.finish();
		}
	};


}
