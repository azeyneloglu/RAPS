package sp2016.cs310.com.raps;

/**
 * Created by asus on 10.05.2016.
 */
public interface AsyncResponseInsert {
    void processFinish(Boolean result);


    ContentInsert createAsyncTask();
}
