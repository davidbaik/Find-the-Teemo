package ca.cmpt276.as3.findtheteemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class WelcomeScreen extends Activity {
	private static final int DURATION_OF_ANIMATIONS = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_screen);
		
		setupSkipButton();

		displayWelcomeMessage();
		moveTeemo();
	}

	private void setupSkipButton() {
		Button btn = (Button)findViewById(R.id.skipSplashBtn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				deleteActivityAndOpenNext();
			}
		});
	}
	
	private void moveTeemo() {
		ImageView teemo = (ImageView)findViewById(R.id.teemo);
		
		DisplayMetrics display = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(display);
		BitmapDrawable teemoImage = (BitmapDrawable)this.getResources().getDrawable(R.drawable.welcome_teemo);
		
		int screenWidth = display.widthPixels;
		//int teemoImageWidth = teemoImage.getBitmap().getWidth();
		int distanceToMoveLeft = -(screenWidth /*- teemoImageWidth*/);
		
		TranslateAnimation translateLeftAnimation = new TranslateAnimation(0, distanceToMoveLeft, 0, 0);
		translateLeftAnimation.setDuration(DURATION_OF_ANIMATIONS);
		translateLeftAnimation.setFillAfter(true);
		teemo.startAnimation(translateLeftAnimation);
	}

	private void displayWelcomeMessage() {
		LinearLayout welcomeText = (LinearLayout)findViewById(R.id.linearLayout1);

		AlphaAnimation appearAnimation = new AlphaAnimation(0, 1);
		appearAnimation.setDuration(DURATION_OF_ANIMATIONS);
		appearAnimation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {		
			}
	
			@Override
			public void onAnimationRepeat(Animation animation) {	
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				deleteActivityAndOpenNext();
			}

		});

		welcomeText.startAnimation(appearAnimation);
	}

	private void deleteActivityAndOpenNext() {
		startActivity(new Intent(WelcomeScreen.this, MainActivity.class));
		finish();
	}
}
