package be.hcpl.android.so_10822397;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


/**
 * Created by hcpl on 1/08/14.
 */
public class MainActivity extends ListActivity {

    // This is the Adapter being used to display the list's data
    private MySimpleArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // some dummy data
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };

        // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()
        mAdapter = new MySimpleArrayAdapter(this, values);
        setListAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Do something when a list item is clicked
    }

}
