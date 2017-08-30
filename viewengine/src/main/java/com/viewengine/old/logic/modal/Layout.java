package com.viewengine.old.logic.modal;

import static com.viewengine.old.logic.global.Constants.FIELD_CHILDS;
import static com.viewengine.old.logic.global.Constants.FIELD_COLOR;
import static com.viewengine.old.logic.global.Constants.FIELD_HEIGHT;
import static com.viewengine.old.logic.global.Constants.FIELD_INDEX;
import static com.viewengine.old.logic.global.Constants.FIELD_ORIENTATION;
import static com.viewengine.old.logic.global.Constants.FIELD_TEXT;
import static com.viewengine.old.logic.global.Constants.FIELD_TYPE;
import static com.viewengine.old.logic.global.Constants.FIELD_WEIGHT;
import static com.viewengine.old.logic.global.Constants.FIELD_WIDTH;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.viewengine.old.logic.global.LayoutType;
import com.viewengine.old.logic.global.Orientation;

public class Layout {

	private static final int ERROR = -1785692;

	// Class Variables
	@SerializedName(FIELD_TYPE)
	private String mType;
	private LayoutType mLayoutType = LayoutType.NONE;

	@SerializedName(FIELD_INDEX)
	private String mIndex;
	private int mLayoutIndex = ERROR;

	@SerializedName(FIELD_WIDTH)
	private String mWidth;
	private int mLayoutWidth = ERROR;

	@SerializedName(FIELD_HEIGHT)
	private String mHeight;
	private int mLayoutHeight = ERROR;

	@SerializedName(FIELD_WEIGHT)
	private String mWeight;
	private float mLayoutWeight = ERROR;

	@SerializedName(FIELD_ORIENTATION)
	private String mOrientation;
	private Orientation mLayoutOrientation = Orientation.NONE;

	@SerializedName(FIELD_CHILDS)
	private ArrayList<Layout> mChildViews;
	private List<Layout> mLayoutChildrens;

	@SerializedName(FIELD_COLOR)
	private String mColor;
	private int mLayoutColor;

	@SerializedName(FIELD_TEXT)
	private String mText;

	private JsonObject mLayoutAsJson;

	public LayoutType getType() {
		if (mLayoutType.equals(LayoutType.NONE)) {
			mLayoutType = LayoutType.getByName(mType);
		}

		return mLayoutType;
	}

	public int getIndex() {
		if (mLayoutIndex == ERROR) {
			try {
				mLayoutIndex = Integer.parseInt(mIndex);
			} catch (Exception e) {
				mLayoutIndex = 0;
			}
		}

		return mLayoutIndex;
	}

	public int getWidth() {
		if (mLayoutWidth == ERROR) {
			try {
				mLayoutWidth = Integer.parseInt(mWidth);
			} catch (Exception e) {
				mLayoutWidth = 0;
			}
		}

		return mLayoutWidth;
	}

	public int getHeight() {
		if (mLayoutHeight == ERROR) {
			try {
				mLayoutHeight = Integer.parseInt(mHeight);
			} catch (Exception e) {
				mLayoutHeight = 0;
			}
		}

		return mLayoutHeight;
	}

	public float getWeight() {
		if (mLayoutWeight == ERROR) {
			try {
				mLayoutWeight = (float) Integer.parseInt(mWeight);
			} catch (Exception e) {
				mLayoutWeight = 0;
			}
		}

		return mLayoutWeight;
	}

	public Orientation getOrientation() {
		if (mLayoutOrientation.equals(Orientation.NONE)) {
			mLayoutOrientation = Orientation.getByName(mOrientation);
		}

		return mLayoutOrientation;
	}

	public int getColor() {
		if ((mColor == null) || (mColor.trim().length() <= 0)) {
			mLayoutColor = Color.WHITE;
		} else {
			mLayoutColor = Color.parseColor(mColor);
		}

		return mLayoutColor;
	}

	public String getText() {
		if ((mText == null) || (mText.trim().length() <= 0)) {
			mText = "None";
		}

		return mText;
	}

	public void setJsonObject(JsonObject jsonObject) {
		mLayoutAsJson = jsonObject;
	}

	public JsonObject getJsonObject() {
		return mLayoutAsJson;
	}

	public View getViewByType(Context context) {
		View result = null;
		LayoutType type = getType();
		switch (type) {
		case LINEAR_LAYOUT:
			result = new LinearLayout(context);
			break;
		case IMAGE_VIEW:
			result = new ImageView(context);
			break;
		case BUTTON:
			result = new Button(context);
			break;
		case TEXT_VIEW:
			result = new TextView(context);
			break;
		}
		return result;
	}

	public List<Layout> getLayoutChildrens() {
		return mChildViews;
	}
	
	public boolean hasChildrens() {
		return ( (mChildViews != null) && (mChildViews.size() > 0) );
	}
}
