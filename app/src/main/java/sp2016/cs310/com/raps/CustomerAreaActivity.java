package sp2016.cs310.com.raps;

import android.content.ClipData;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;


public class CustomerAreaActivity extends AppCompatActivity  implements AsyncResponseSelect{


    //SearchView SV;
    EditText ET;
    ListView LV;

    ArrayAdapter<String> AA;
    String searchString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_area);
        Bundle b = getIntent().getExtras();
        String e_mail = b.getString("e_mail");

        //SV = (SearchView) findViewById(R.id.searchView);


        ET = (EditText) findViewById(R.id.editTextSearch);

/*
        final ContentSelect r = new ContentSelect();
        r.delegate=this;

*/

        TextView tvE_mail = (TextView) findViewById(R.id.textView2);
        TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);

        welcomeMessage.setText("Welcome");
        tvE_mail.setText(e_mail);
        Button BT = (Button) findViewById(R.id.button_search);


        /*
        SV.setOnSearchClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                final String searchString = SV.toString();
                r.execute("search.php","name",searchString);

            }
        });*/

        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                searchString = ET.getText().toString();
                ContentSelect r = createAsyncTask();
                r.execute("search.php", "name", searchString);


            }
        });



    }


    @Override
    public ContentSelect createAsyncTask()
    {
        ContentSelect tmp =  new ContentSelect();
        tmp.delegate=this;
        return  tmp;
    }


    @Override
    public void processFinish(final List<String> result) {

        LV = (ListView) findViewById(R.id.listView);
        AA = new ArrayAdapter<String>  (this, android.R.layout.simple_list_item_1,result);
        LV.setAdapter(AA);




        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CustomerAreaActivity.this,CustomerInteractionActivity.class);
                Bundle bundle = new Bundle();

                Object o= LV.getItemAtPosition(position);
                String s = o.toString();
                bundle.putString("RestInfo",s);

                intent.putExtras(bundle);
                startActivity(intent);




            }
        });

    }







}
