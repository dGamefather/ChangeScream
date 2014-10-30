package ctec.changescream.controller;

import java.util.ArrayList;

import ctec.changescream.R;
import ctec.changescream.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShoutActivity extends Activity
{
	private Button firstButton;
	private Button secondButton;
	private TextView appText;
	private RelativeLayout appLayout;
	private ArrayList<Integer> colorsList;
	private ArrayList<Integer> soundsList;
	
	/**
	 * Creates the app screen.
	 * 
	 * @param onCreate
	 *            The creation of the app screen.
	 * @version 1.0 10/20/2014
	 * @author Brennan Litster
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shout);
		
		firstButton = (Button) findViewById(R.id.secondScreenButton);
		secondButton = (Button) findViewById(R.id.secondScreenSwap);
		appLayout = (RelativeLayout) findViewById(R.id.appLayout);
		appText = (TextView) findViewById(R.id.someTextStuffSecond);
		
		colorsList = new ArrayList<Integer>();
		soundsList = new ArrayList<Integer>();
		
		fillTheColors();
		hearTheSounds();
		setupListeners();
	}
	
	/**
	 * Creates the list of colors to change the screen background.
	 * 
	 * @param fillTheColors()
	 *            The list of colors.
	 * @version 1.0 10/20/2014
	 * @author Brennan Litster
	 */
	private void fillTheColors()
	{
		colorsList.add(R.color.tardisBlue);
		colorsList.add(R.color.kerriganPurple);
		colorsList.add(R.color.raynorBlack);
		colorsList.add(R.color.annoyingOrange);
		colorsList.add(R.color.linkTunicGreen);
		colorsList.add(R.color.dominionRed);
	}
	
	/**
	 * Creates the list of texts.
	 * 
	 * @param hearTheSounds()
	 *            The list of text.
	 * @version 1.1 10/14/2014
	 * @author Brennan Litster
	 */
	private void hearTheSounds()
	{
		soundsList.add(R.string.sarcasticText);
		soundsList.add(R.string.soundsText);
		soundsList.add(R.string.funnyText);
	}
	
	/**
	 * Gives functionality to the buttons.
	 * 
	 * @param setupListeners()
	 *            Allows buttons to do something.
	 * @version 1.0 10/20/2014
	 * @author Brennan Litster
	 */
	private void setupListeners()
	{
		firstButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				int randomPosition = (int) (Math.random() * colorsList.size());
				int randomBeep = (int) (Math.random() * soundsList.size());
				appLayout.setBackgroundResource(colorsList.get(randomPosition));
				appText.setText(soundsList.get(randomBeep));
				appText.setVisibility(0);
			}
		});
		
		secondButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent currentIntent = new Intent();
				setResult(RESULT_OK, currentIntent);
				finish();
				
			}
		});
	}
}
