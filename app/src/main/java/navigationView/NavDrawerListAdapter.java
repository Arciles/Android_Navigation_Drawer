package navigationView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.arcileslab.arciles.drawerdeneme.R;

import java.util.ArrayList;

/**
 * Created by esattahaibis on 03.01.2015.
 */
public class NavDrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavDrawerItem> items;

    public NavDrawerListAdapter(Context context , ArrayList<NavDrawerItem> items) {

        this.context = context;
        this.items = items;

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.nav_drawer_list_item,parent,false);

        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.ivListimage);
        TextView title = (TextView) convertView.findViewById(R.id.textView);

        icon.setImageResource(items.get(position).getIcon());
        title.setText(items.get(position).getTitle());

        return convertView;
    }
}
