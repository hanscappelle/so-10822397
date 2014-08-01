package be.hcpl.android.so_10822397;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hcpl on 1/08/14.
 */
public class MySimpleArrayAdapter extends ArrayAdapter<String> {

    private final Context mContext;
    private final String[] mValues;

    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.list_item, values);
        mContext = context;
        mValues = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        //The convertView argument is essentially a "ScrapView" as described is Lucas post
        //http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
        //It will have a non-null value when ListView is asking you recycle the row layout.
        //So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            // well set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView.findViewById(R.id.label);
            viewHolder.timestamp = (TextView) convertView.findViewById(R.id.timestamp);
            // store the holder with the view.
            convertView.setTag(viewHolder);
        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // object item based on the position
        String label = mValues[position];
        // assign values if the object is not null
        if (label != null) {
            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            viewHolder.text.setText(label);
            viewHolder.timestamp.setText(String.valueOf(System.currentTimeMillis()));
        }


        // non optimal code but need to invoke the error with obfuscation
        // needed to invoce the error
        // FIXME comment these lines to see the app running perfectly including obfuscation
        viewHolder.layout.removeAllViews();
        TextView tView;
        for (final String text : new String[]{"een", "twee", "drie"}) {
            tView = new TextView(mContext);
            tView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            tView.setText(text);
            viewHolder.layout.addView(tView);
        }

        return convertView;
    }

    /**
     * for performance only
     */
    static class ViewHolder {
        TextView text;
        TextView timestamp;
        // this is the one we'll be using for dynamic view loading
        ViewGroup layout;
    }
}
