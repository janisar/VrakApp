package com.example.vrakapp;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


@SuppressLint("NewApi") 
public class MainActivity extends ActionBarActivity {

	private static final int CAMERA_REQUEST = 1888; 
	private Button imageButton; 
	private ImageView imageView;
	private LinearLayout buttonsLayout;
	private GridView gridView;
	private Adapter gridAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        
        gridAdapter = new Adapter(this);
        
        imageView = (ImageView) findViewById(R.id.imageView1);
        buttonsLayout = (LinearLayout) findViewById(R.id.linearLayout);
        imageButton = (Button) findViewById(R.id.capture_button);
        buttonsLayout.setOrientation(LinearLayout.VERTICAL);
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(gridAdapter);
        
        final LinearLayout row = new LinearLayout(this);
        row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        imageButton.setOnClickListener(Listener(row));
    }
    
	private OnClickListener Listener(final LinearLayout row) {
		return new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                startActivityForResult(cameraIntent, CAMERA_REQUEST); 
                Button saveButton = new Button(getApplicationContext());
                saveButton.setText("Save image");
                saveButton.setOnClickListener(saveButtonListener());
                Button cancelButton = new Button(getApplicationContext());
                cancelButton.setText("Forget this image");
                row.addView(saveButton);
                row.addView(cancelButton);
                buttonsLayout.addView(row);
			}
		};
	}
	
    protected OnClickListener saveButtonListener() {
    	return new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			Context context = MainActivity.this;
    			final ImageAddForm relativeLayout = new ImageAddForm(context);

    			AlertDialog alertDialog = new AlertDialog.Builder(context).create();
    			alertDialog.setView(relativeLayout);
    			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Salvesta", new DialogInterface.OnClickListener() {
                    
    				public void onClick(DialogInterface dialog, int which) {
    					Toast.makeText(MainActivity.this, 
    							relativeLayout.getHeader().getText() 
    								+ "  " + relativeLayout.getComment().getText(), 
    								Toast.LENGTH_SHORT).show();
                    }
                });
    			alertDialog.show();
    		}
    	};
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
    	if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
    		Bitmap photo = (Bitmap) data.getExtras().get("data"); 
    		imageView.setImageBitmap(photo);
    	}  
    } 


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    }

}
