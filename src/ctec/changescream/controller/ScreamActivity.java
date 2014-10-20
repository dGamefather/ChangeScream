package ctec.changescream.controller;

import java.util.ArrayList;

import ctec.changescream.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ScreamActivity extends Activity
{
	private Button firstButton;
	private Button secondButton;
	private RelativeLayout appLayout;
	private ArrayList<Integer> colorsList;
	
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
		setContentView(R.layout.activity_scream);
		
		firstButton = (Button) findViewById(R.id.firstScreenButton);
		secondButton = (Button) findViewById(R.id.firstScreenSwap);
		appLayout = (RelativeLayout) findViewById(R.id.appLayout);
		
		colorsList = new ArrayList<Integer>();
		
		fillTheColors();
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
				appLayout.setBackgroundResource(colorsList.get(randomPosition));
			}
		});
		
		secondButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				Intent myIntent = new Intent(currentView.getContext(), ShoutActivity.class);
				startActivityForResult(myIntent, 0);
				
			}
		});
	}
}
