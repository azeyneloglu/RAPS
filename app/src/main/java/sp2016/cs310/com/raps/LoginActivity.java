package sp2016.cs310.com.raps;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements AsyncResponseSelect {


    String e_mailtoNewActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //final ContentSelect r=new ContentSelect();
        //r.delegate=this;


        final EditText ETpassword = (EditText) findViewById(R.id.login_pw);
        final EditText ETe_mail = (EditText) findViewById(R.id.login_e_mail);
        final Button bLogin = (Button) findViewById(R.id.loginButton);
        final TextView registerLink = (TextView) findViewById(R.id.registerLink);





        bLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final String e_mail = ETe_mail.getText().toString();
                final String password = ETpassword.getText().toString();

                e_mailtoNewActivity= e_mail;
                ContentSelect r = createAsyncTask();
                r.execute("login.php","e_mail", e_mail, "password",password);


            }
        });
    }
    public void processFinish(List<String> result){

        if(!result.isEmpty())
        {
            Intent intent= new Intent(LoginActivity.this, CustomerAreaActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("e_mail", e_mailtoNewActivity);
            intent.putExtras(bundle);
            startActivity(intent);

            //LoginActivity.this.startActivity(intent);
        }
        else
        {
            AlertDialog.Builder builder =new AlertDialog.Builder(LoginActivity.this);
            builder.setMessage("Login Failed").setNegativeButton("Retry",null).create().show();
        }
    }

    @Override
    public ContentSelect createAsyncTask()
    {
        ContentSelect tmp =  new ContentSelect();
        tmp.delegate=this;
        return  tmp;
    }



}
