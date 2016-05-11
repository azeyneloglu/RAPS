package sp2016.cs310.com.raps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


    }


    public void openLoginPage(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public  void openSigninPage(View view)
    {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }





}
