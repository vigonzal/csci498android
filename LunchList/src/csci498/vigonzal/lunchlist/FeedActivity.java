package csci498.vigonzal.lunchlist;

import java.util.Properties;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.mcsoxford.rss.RSSFeed;
import org.mcsoxford.rss.RSSReader;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.util.Log;

public class FeedActivity extends ListActivity {
	private static class FeedTask extends AsyncTask<String, Void, RSSFeed> {
		private RSSReader reader = new RSSReader();
		private Exception e = null;
		private FeedActivity activity = null;
		FeedTask(FeedActivity activity) {
			attach(activity);
		}
		void attach(FeedActivity activity) {
			this.activity = activity;
		}
		void detach() {
			this.activity = null;
		}
		@Override
		public RSSFeed doInBackground(String... urls) {
			RSSFeed result = null;
			try {
				result = reader.load(urls[0]);
			}
			catch (Exception e) {
				this.e = e;
			}
			return result;
		}
		@Override
		public void onPostExecute(RSSFeed feed) {
			if (e == null) {
				activity.setFeed(feed);
			}
			else {
				Log.e("LunchList", "Exception parsing feed", e);
				activity.goBlooey(e);
			}
		}
	}

	private void goBlooey(Throwable t) {
	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	builder
	.setTitle("Exception!")
	.setMessage(t.toString())
	.setPositiveButton("OK", null)
	.show();
}

}
