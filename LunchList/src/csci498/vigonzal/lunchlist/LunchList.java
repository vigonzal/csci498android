package csci498.vigonzal.lunchlist;

import java.util.ArrayList;
import java.util.List;

import csci498.vigonzal.lunchlist.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class LunchList extends Activity {
	
	List<Restaurant> model=new ArrayList<Restaurant>();
	ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
	ArrayAdapter<Restaurant> RestaurantAdapter=null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_lunch_list);
		Button save = (Button)findViewById(R.id.save);
		save.setOnClickListener(onSave);
		Spinner list = (Spinner)findViewById(R.id.restaurants);
		
		RestaurantAdapter=new ArrayAdapter<Restaurant>(this,
				android.R.layout.simple_list_item_1,
				model);
		
		list.setAdapter(RestaurantAdapter);
		
	}
	private View.OnClickListener onSave=new View.OnClickListener() {
		
		public void onClick(View v) {
		
			Restaurant r = new Restaurant();
			
			EditText name = (EditText)findViewById(R.id.name);
			EditText address = (EditText)findViewById(R.id.addr);
			
			r.setName(name.getText().toString());
			r.setAddress(address.getText().toString());
			
			RadioGroup types = (RadioGroup)findViewById(R.id.types);
			
			switch (types.getCheckedRadioButtonId()) {
			case R.id.sit_down:
				r.setType("sit_down");
				break;
			case R.id.take_out:
				r.setType("take_out");
				break;
			case R.id.delivery:
				r.setType("delivery");
				break;

			}
			
			RestaurantAdapter.add(r);
			
		}
		
	};
	
	class RestaurantAdapter extends ArrayAdapter<Restaurant> {
		private static final int ROW_TYPE_DELIVERY = 0;
		private static final int ROW_TYPE_TAKE_OUT = 1;
		private static final int ROW_TYPE_SIT_DOWN = 2;
		
		public RestaurantAdapter() {
		
			super(LunchList.this, android.R.layout.simple_list_item_1, model);
			
		}
		public View getView(int position, View convertView, ViewGroup parent){
			
			View row = convertView;
			RestaurantHolder holder = null;

			if (row == null) {
				
				LayoutInflater inflater = getLayoutInflater();
				
				row = inflater.inflate(R.layout.row, parent, false);
				holder = new RestaurantHolder(row);
				row.setTag(holder);
				
			}
			else {
				holder = (RestaurantHolder)row.getTag();
			}
			
			holder.populateFrom(model.get(position));
			
			return(row);

		}
		public int getItemViewType(int position){
			
			String type = restaurants.get(position).getType();
			
			if (type == "delivery") {
				return ROW_TYPE_DELIVERY;
			} else if (type == "take_out") {
				return ROW_TYPE_TAKE_OUT;
			} else {
				return ROW_TYPE_SIT_DOWN;
			}
			
		}
		public int getViewTypeCount(){
			return 3;
		}
		
	}
	static class RestaurantHolder{
		
		private TextView name = null; 
		private TextView address = null;
		private ImageView icon = null;
		
		public RestaurantHolder(View row) {
			name = (TextView)row.findViewById(R.id.title);
			address = (TextView)row.findViewById(R.id.address);
			icon = (ImageView)row.findViewById(R.id.icon);
		}
		
		void populateFrom(Restaurant r){
			
			name.setText(r.getName());
			address.setText(r.getAddress());
			
			if(r.getType().equals("sit_down")){
				icon.setImageResource(R.drawable.ball_red);
				name.setTextColor(Color.RED);
			}
			else if (r.getType().equals("take_out")) {
				icon.setImageResource(R.drawable.ball_yellow);
				name.setTextColor(Color.BLUE);
			}
			else {
				icon.setImageResource(R.drawable.ball_green);
				name.setTextColor(Color.GREEN);
			}
			
		}
		
	}
	
}
