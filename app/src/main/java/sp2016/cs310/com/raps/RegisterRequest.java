package sp2016.cs310.com.raps;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;


public class RegisterRequest extends StringRequest {

    //private static final String REGISTER_REQUEST_URL ="http://raps.byethost7.com/register.php";
    private static final String REGISTER_REQUEST_URL ="http://10.50.100.248/app/register.php";
    //private static final String REGISTER_REQUEST_URL ="http://10.32.8.17/app/register.php";
    //private static final String REGISTER_REQUEST_URL ="http:///app/register.php";



    private Map<String,String> params;



    public RegisterRequest(String name, String last_name,
                           String e_mail,String password, Response.Listener<String> listener )
    {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("last_name",last_name);
        params.put("e_mail",e_mail);
        params.put("password",password);
    }


    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
