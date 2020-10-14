package com.example.ambienteconfinato.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ambienteconfinato.R;
import com.example.ambienteconfinato.model.Model;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.*;
import static com.example.ambienteconfinato.R.id.card_view;
import static com.example.ambienteconfinato.R.id.desc;
import static com.example.ambienteconfinato.R.id.green;
import static com.example.ambienteconfinato.R.id.image;

public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Model> models;
    private ArrayList<String> itemColors;

    public Adapter(Context context, ArrayList<Model> models, ArrayList<String> itemColors) {
        this.context = context;
        this.models = models;
        this.itemColors = itemColors;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView=View.inflate(context, R.layout.list_view, null);
        }


        ImageView images = (ImageView) convertView.findViewById(R.id.CardimageView);
        images.setVisibility(View.GONE);
        TextView title = (TextView) convertView.findViewById(R.id.name);
        TextView desc = (TextView) convertView.findViewById(R.id.desc);
        androidx.cardview.widget.CardView  Card = (androidx.cardview.widget.CardView) convertView.findViewById(R.id.card_view);

        Model model = models.get(position);
        if (itemColors != null) {
            if (itemColors.contains(model.getTitle())) {
                //convertView.setBackgroundColor(Color.GREEN);
                Card.setCardBackgroundColor(Color.parseColor("#3CA140"));
                images.setVisibility(View.VISIBLE);

            }
        }
        //if (itemColors != null) {
        //    for (String s : itemColors) {
        //       if (s.equals(model.getTitle())) {
        //            convertView.setBackgroundColor(Color.GREEN);
        //       }
        //    }
        //}
        images.setImageResource(model.getImageId());
        title.setText(model.getTitle());
        desc.setText(model.getDesc());

        return convertView;
    }
}
