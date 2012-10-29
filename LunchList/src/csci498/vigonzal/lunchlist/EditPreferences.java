package csci498.vigonzal.lunchlist;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class EditPreferences extends PreferenceActivity{

		@SuppressWarnings("deprecation")
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			addPreferencesFromResource(R.xml.preferences);
	}
}