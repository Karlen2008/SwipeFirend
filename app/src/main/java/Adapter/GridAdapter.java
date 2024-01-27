package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.swipefriend.R;

import java.util.List;

import Model.GridItem;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private List<GridItem> gridItems;

    public GridAdapter(Context context, List<GridItem> gridItems) {
        this.context = context;
        this.gridItems = gridItems;
    }

    @Override
    public int getCount() {
        return gridItems.size();
    }

    @Override
    public Object getItem(int position) {
        return gridItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.box_text, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView6);
        TextView textView = convertView.findViewById(R.id.textView4);

        GridItem gridItem = gridItems.get(position);


        textView.setText(gridItem.getItemName());

        return convertView;
    }
}
