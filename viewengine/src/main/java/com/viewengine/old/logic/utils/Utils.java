package com.viewengine.old.logic.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.viewengine.old.logic.global.LayoutType;
import com.viewengine.old.logic.global.Parameter;
import com.viewengine.old.logic.modal.Layout;

public class Utils {
	
	public static boolean hasRequiredParameters(JsonObject jsonObject, Parameter[] parameters) {
		// Method variables
		boolean pass = true;
		try {
			for(Parameter parameter : parameters) {
				JsonElement member = jsonObject.get(parameter.getPropertyName());
				if(member == null) {
					pass = false;
					break;
				}
			}
		} catch (Exception e) {
			pass = false;
			e.printStackTrace();
		}

		return pass;
	}

	public static Parameter[] getRequiredParametersForLayout(LayoutType layout) {
		Parameter[] params = new Parameter[]{};
		switch (layout) {
		case NONE:
			break;
		case BUTTON:
			params = new Parameter[]{ Parameter.HEIGHT, Parameter.WIDTH, Parameter.TEXT };
			break;
		case IMAGE_VIEW:
			params = new Parameter[]{ Parameter.HEIGHT, Parameter.WIDTH, Parameter.SRC_URL };
			break;
		case TEXT_VIEW:
			params = new Parameter[]{ Parameter.HEIGHT, Parameter.WIDTH, Parameter.TEXT };
			break;
		case LINEAR_LAYOUT:
			// Consider also add orientation - tops we will not use it
			params = new Parameter[]{ Parameter.HEIGHT, Parameter.WIDTH, Parameter.WEIGHT };
			break;
		default:
			break;
		}
		
		return params;
	}
	
	public static List<Layout> getLayoutList(String jsonObject) {
		JsonArray jsonArray;
		Gson gson = new Gson();
		List<Layout> layoutList = new ArrayList<Layout>();
		JsonParser parser = new JsonParser();
//		Type collectionType;
//		Collection<Layout> layouts;

		try {
			 JSONArray jsonMainArr;
			 JSONObject obj11;
			 try {
			 jsonMainArr = new JSONArray(jsonObject);
			 obj11 = jsonMainArr.getJSONObject(0);
			 } catch(Exception e) {
			 e.getMessage();
			 }
			
//			collectionType = new TypeToken<Collection<Layout>>(){}.getType();
//			layouts = gson.fromJson(jsonObject, collectionType);
			jsonArray = parser.parse(jsonObject).getAsJsonArray();
			for (JsonElement obj : jsonArray) {
				Layout layout = gson.fromJson(obj, Layout.class);
				layout.setJsonObject(obj.getAsJsonObject());
				layoutList.add(layout);
			}
		} catch (Exception  ex) {
			layoutList = new ArrayList<Layout>();
		}
		
		return layoutList;
	}
}
