package ca.cmpt276.as3.findtheteemo;


//import ca.cmpt276.as3.findtheteemo.R;
//import ca.cmpt276.as3.findtheteemo.R.layout;
//import ca.cmpt276.as3.findtheteemo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupHelpButton();
        setupPlayButton();
        setupOptionsButton();
    }

	private void setupOptionsButton() {
		Button btn = (Button)findViewById(R.id.optionsBtn);
        btn.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View arg0) {
        		startActivity(new Intent(MainActivity.this, OptionsActivity.class));
        	}
        });
	}

	private void setupPlayButton() {
		Button btn = (Button)findViewById(R.id.playBtn);
        btn.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View arg0) {
        		startActivity(new Intent(MainActivity.this, GameActivity.class));
        	}
        });
	}

	private void setupHelpButton() {
		Button btn = (Button)findViewById(R.id.helpBtn);
        btn.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View arg0) {
        		startActivity(new Intent(MainActivity.this, HelpActivity.class));
        	}
        });
	}
}
