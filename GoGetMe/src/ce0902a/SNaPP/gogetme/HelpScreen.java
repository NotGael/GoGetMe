package ce0902a.SNaPP.gogetme;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpScreen extends Activity {
	
	// VARIABLES
	
	private static final String DEBUG_TAG = null;
	
	// END OF VARIABLES
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.helpmain);
		
		Bundle extras = getIntent().getExtras();
		String heading = extras.getString("ScreenName");
		TextView helpHeading = (TextView) findViewById(R.id.txtHelpItem2Screen);
		helpHeading.setText(heading);
		
		
		// Read the raw text file into string and populate TextView
		if(helpHeading.getText().toString().equals("Main Screen"))
		{
			InputStream iFile = getResources().openRawResource(R.raw.mainscreenhelp);
			try {
				TextView helpText = (TextView) findViewById(R.id.txtvHelpItem2);
				String strFile = inputStreamToString(iFile);
				helpText.setText(strFile);
			} catch (Exception e){
				Log.e(DEBUG_TAG, "InputStreamToString failure", e);
			}
		}
		if(helpHeading.getText().toString().equals("Add Location"))
		{
			InputStream iFile = getResources().openRawResource(R.raw.addlocationhelp);
			try {
				TextView helpText = (TextView) findViewById(R.id.txtvHelpItem2);
				String strFile = inputStreamToString(iFile);
				helpText.setText(strFile);
			} catch (Exception e){
				Log.e(DEBUG_TAG, "InputStreamToString failure", e);
			}
		}
		if(helpHeading.getText().toString().equals("Delete Location"))
		{
			InputStream iFile = getResources().openRawResource(R.raw.deletelocationhelp);
			try {
				TextView helpText = (TextView) findViewById(R.id.txtvHelpItem2);
				String strFile = inputStreamToString(iFile);
				helpText.setText(strFile);
			} catch (Exception e){
				Log.e(DEBUG_TAG, "InputStreamToString failure", e);
			}
		}
		if(helpHeading.getText().toString().equals("Select Location"))
		{
			InputStream iFile = getResources().openRawResource(R.raw.selectlocationhelp);
			try {
				TextView helpText = (TextView) findViewById(R.id.txtvHelpItem2);
				String strFile = inputStreamToString(iFile);
				helpText.setText(strFile);
			} catch (Exception e){
				Log.e(DEBUG_TAG, "InputStreamToString failure", e);
			}
		}
		
		
		((Button) findViewById(R.id.btnBack)).setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				finish();

			}
		});
		
	} // end of onCreate method
	
	/* Converts an input stream to a string */
	@SuppressWarnings("deprecation")
	public String inputStreamToString(InputStream is) throws IOException{
		StringBuffer sBuffer = new StringBuffer();
		DataInputStream dataIO = new DataInputStream(is);
		String strLine = null;
		while ((strLine = dataIO.readLine()) != null){
			sBuffer.append(strLine + "\n");
		}
		
		dataIO.close();
		is.close();
		
		return sBuffer.toString();
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item){
		super.onOptionsItemSelected(item);
		startActivity(item.getIntent());
        return true;    
        
    } // end of onOptionsItemSelected method
	
	
	public void onPause()
	{
		super.onPause();
		finish();
		
	}

} // end of HelpItem1Activity class
