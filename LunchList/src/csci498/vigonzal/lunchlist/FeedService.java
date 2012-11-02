package csci498.vigonzal.lunchlist;

import android.app.IntentService;
import android.content.Intent;

public class FeedService extends IntentService {
	public FeedService() {
		super("FeedService");
	}
	@Override
	public void onHandleIntent(Intent i) {
		// do something
	}
}