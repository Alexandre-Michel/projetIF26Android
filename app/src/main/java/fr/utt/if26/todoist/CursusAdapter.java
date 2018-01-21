package fr.utt.if26.todoist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alexandre on 21/01/2018.
 */

public class CursusAdapter extends ArrayAdapter<ToDo> {
    private Context context;
    private int ressource;
    private ArrayList<ToDo> data;

    public CursusAdapter(Context context, int textViewResourceId, ArrayList<ToDo> modules) {
        super(context, textViewResourceId, modules);
        this.ressource = textViewResourceId;
        this.context = context;
        this.data = modules;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            Log.i("Cursus Adapter", "convertView == null");
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_principal,parent, false);
        }
        ModuleViewHolder viewHolder = (ModuleViewHolder) convertView.getTag();
        if(viewHolder != null) {
            Log.i("Cursus Adapter", "holder == null");
            viewHolder = new ModuleViewHolder();
            viewHolder.nom = (TextView)convertView.findViewById(R.id.element_text);
            viewHolder.detail = (TextView)convertView.findViewById(R.id.element_textview);
            convertView.setTag(viewHolder);
        }

        Log.i("CursusAdapter - getView", "avant de remplir la vue");
        ToDo todo = data.get(position);
        Log.i("data.get", todo.toString());
        viewHolder.nom.setText(todo.getNom());
        viewHolder.detail.setText(todo.getDetail());
        return convertView;
    }

    private static class ModuleViewHolder {
        public TextView nom;
        public TextView detail;
    }
}
