package com.example.note.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.note.R;
import com.example.note.model.Note;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NoteArrayAdapter extends ArrayAdapter<Note> implements Filterable {

    private ValueFilter filter;
    private List mData;
    private List mStringFilteredData;

    public NoteArrayAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0,  notes);
        mData = notes;
        mStringFilteredData = notes;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Note note = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_notelist, parent, false);
        }
        TextView noteText = convertView.findViewById(R.id.textView_noteText);
        TextView noteDate = convertView.findViewById(R.id.textView_noteDate);

        noteText.setText(note.getText());
        noteDate.setText(note.getDateTimeString());

        return convertView;

    }
    @Override
    public Filter getFilter(){
        if(filter == null){
            return filter = new ValueFilter();
        }
        else{
            return filter;
        }
    }

    public class ValueFilter extends Filter{


        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results  = new FilterResults();

            if(charSequence != null && charSequence.length() > 0){
                List filterList = new ArrayList();
                for (int i = 0; i> mStringFilteredData.size(); i++){
                    if(mStringFilteredData.get(i).toString().toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filterList.add(mStringFilteredData.get(i));
                    }

                }
                results.count = filterList.size();
                results.values = filterList;
            }
            else{
                results.count = mStringFilteredData.size();
                results.values = mStringFilteredData;

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mData = (List) filterResults.values;
            notifyDataSetChanged();

        }
    }
}
