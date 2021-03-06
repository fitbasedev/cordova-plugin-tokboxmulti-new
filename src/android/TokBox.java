package com.fitbase.TokBox;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;


/**
 * @Author Karunakar , Anshul.
 */
public class TokBox extends CordovaPlugin {
	public void StartStream(final String params) {
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Intent in = new Intent(cordova.getActivity().getWindow().getContext(), LiveVideoActivity.class);
				in.putExtra("tokbox_obj",params);
				cordova.getActivity().getWindow().getContext().startActivity(in);
			}
		});
	}

    @Override
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext)throws JSONException {
		final String params = "null".equals(args.getString(0)) ? null : args.getString(0);
        if (action.equals("startStream")){
        	StartStream(params);
            callbackContext.success("okay");
            return true;
        }
        return false;
    }
}
