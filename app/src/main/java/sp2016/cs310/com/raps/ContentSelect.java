package sp2016.cs310.com.raps;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 10.05.2016.
 */
 class ContentSelect extends AsyncTask<String,Void,List<String>> {

    public AsyncResponseSelect delegate = null;
    private Exception exception;
    public String response="";
    public ContentSelect(){

    }
    @Override
    protected void onPostExecute(List<String> result) {



        delegate.processFinish(result);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected List<String> doInBackground(String... params) {
        List<String> result=new ArrayList<String>();
        try {
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
            wr.write(input.toString());
            wr.flush();
            wr.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            urlConnection.disconnect();
            while ((line=reader.readLine()) != null) {
                result.add(line);
            }
        }catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {;
            e.printStackTrace();
        }
        return result;
    }
}
