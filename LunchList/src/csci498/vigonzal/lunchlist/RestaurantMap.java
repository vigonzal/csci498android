package csci498.vigonzal.lunchlist;

import com.google.android.maps.MapActivity;
import android.os.Bundle;

public class RestaurantMap extends MapActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
	}
	
	protected boolean isRouteDisplayed() {
		return false;
	}
}
