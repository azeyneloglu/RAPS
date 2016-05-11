package sp2016.cs310.com.raps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CustomerInteractionActivity extends AppCompatActivity {

    TextView TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_interaction);

        Bundle b = getIntent().getExtras();
        String Information = b.getString("RestInfo");

        TV = (TextView) findViewById(R.id.tvRestaurantName);

        TV.setText(Information);



    }





}
