/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.visualengines.mira.cordova;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.visualengines.mira.sdk.activities.SimpleScanAndRecognize;

import android.content.Intent;

public class ScanListenerPlugin extends CordovaPlugin {
	
	public static final String ACTION = "scanlistener"; 

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {

		try {
			if (ACTION.equals(action)) {
			JSONObject arg_object = args.getJSONObject(0);
			Intent myStarterIntent = new Intent(cordova.getActivity(),
					SimpleScanAndRecognize.class);
			myStarterIntent.putExtra("customerID",
					arg_object.getString("customerID"));
			myStarterIntent.putExtra("appID",
					arg_object.getString("appID"));
			boolean isContinuous = arg_object.getBoolean("isContinuous");
			myStarterIntent.putExtra("isContinuous", isContinuous);

			this.cordova.getActivity().startActivity(myStarterIntent);
			callbackContext.success();
			return true;
			}
		    callbackContext.error("Invalid action");
		    return false;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}
	}

}
