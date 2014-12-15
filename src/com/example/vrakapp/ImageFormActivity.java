package com.example.vrakapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImageFormActivity extends Activity{

	Button button;
	EditText header;
	EditText comment;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.image_form);
		
		header = (EditText) findViewById(R.id.editText1);
		comment = (EditText) findViewById(R.id.editText2);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(saveFormButtonListener());
	}

	private OnClickListener saveFormButtonListener() {
		return new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (header.getText().toString().matches("")) {
					Toast.makeText(getBaseContext(), "Please enter picture header", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getBaseContext(), header.getText(), Toast.LENGTH_SHORT).show();
				}
			}
		};
	}
}
