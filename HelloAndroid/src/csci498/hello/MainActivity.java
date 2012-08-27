package csci498.hello;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener{
	Button btn;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        btn= new Button(this);
        btn.setOnClickListener(this);
        updateTime();
        setContentView(btn);
    }

    private void updateTime() {
		// TODO Auto-generated method stub
    	btn.setText(new Date().toString());
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		updateTime();
	}

    
}
