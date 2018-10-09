package com.example.androidbti.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PlanetAdapter extends BaseAdapter {

    private List<Planet> planets;
    private OnItemClickListener listener;

    public PlanetAdapter (Context context, OnItemClickListener listener) {
        planets = Planet.buildPlanets(context);
        this.listener = listener;
    }




    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int position) {
        return planets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        final Planet planet = planets.get(position);

        if (view == null) {
            LayoutInflater li = LayoutInflater.from(parent.getContext());
            view = li.inflate(R.layout.drawer_list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textView = view.findViewById(R.id.text1);
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(planet);
                }
            });
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(planet.getName());
        return view;
    }


    public interface OnItemClickListener {
        public void onClick (Planet planet);
    }

    private static class ViewHolder {
        public TextView textView;
    }



}
