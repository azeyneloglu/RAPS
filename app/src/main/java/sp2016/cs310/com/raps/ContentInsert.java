package sp2016.cs310.com.raps;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by asus on 9.05.2016.
 */
class ContentInsert extends AsyncTask<String,Void,Boolean> {

    public AsyncResponseInsert delegate = null;

    @Override
    protected void onPostExecute(Boolean result) {
        delegate.processFinish(result);
    }
    private Exception exception;
    public String response="";
    public ContentInsert(){

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        Integer response =0;
        try {
            //159.20.89.206
            URL url1 = new URL("http://159.20.89.206:80/scripts/"+params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConnection.connect();



            StringBuilder input =new StringBuilder();
            input.append(params[1] + "=" + params[2]);
            for (int i=3; i<= params.length-2 ; i=i+2)
            {
                input.append("&"+params[i]+ "=" + params[i+1]);
            }


            OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
            //String name=  URLEncoder.encode(params[0], "UTF-8");
            //String last_name=  URLEncoder.encode(params[1], "UTF-8");
           // String e_mail=  URLEncoder.encode(params[2], "UTF-8");
           // String password=  URLEncoder.encode(params[3], "UTF-8");


            wr.write(input.toString());
            wr.flush();
            //BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            response = urlConnection.getResponseCode();






            urlConnection.disconnect();
        }catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {;
            e.printStackTrace();
        }

        if (response.equals(200))
            return true;
        else return false;

    }






}