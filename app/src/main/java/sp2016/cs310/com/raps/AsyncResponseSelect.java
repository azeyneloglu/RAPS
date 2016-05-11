package sp2016.cs310.com.raps;

import java.util.List;

/**
 * Created by asus on 10.05.2016.
 */
public interface AsyncResponseSelect {
    void processFinish(List<String> result);


    ContentSelect createAsyncTask();
}
