package sp2016.cs310.com.raps;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignupActivity extends AppCompatActivity implements AsyncResponseInsert {



    String e_mailtoNewActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);



        final EditText ETname = (EditText) findViewById(R.id.name);
        final EditText ETlast_name = (EditText) findViewById(R.id.last_name);
        final EditText ETe_mail = (EditText) findViewById(R.id.e_mail);
        final EditText ETpassword = (EditText) findViewById(R.id.password);

        final Button bSignup = (Button) findViewById(R.id.signupButton);


        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = ETname.getText().toString();
                final String last_name = ETlast_name.getText().toString();
                final String e_mail = ETe_mail.getText().toString();
                final String password = ETpassword.getText().toString();

                e_mailtoNewActivity=e_mail;

                ContentInsert r = createAsyncTask();
                r.execute("register.php","name", name, "last_name",last_name,
                          "e_mail",e_mail,"password",password);

            }
        });



    }
    public void processFinish(Boolean result){
        if(result)
        {
            Intent intent= new Intent(SignupActivity.this, CustomerAreaActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("e_mail", e_mailtoNewActivity);
            intent.putExtras(bundle);
            startActivity(intent);

        }
        else
        {
            AlertDialog.Builder builder =new AlertDialog.Builder(SignupActivity.this);
            builder.setMessage("Register Failed").setNegativeButton("Retry",null).create().show();
        }
    }

    @Override
    public ContentInsert createAsyncTask()
    {
        ContentInsert tmp =  new ContentInsert();
        tmp.delegate=this;
        return  tmp;
    }




}
