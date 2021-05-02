package co.edu.uniquindio.reciclapp.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.edu.uniquindio.reciclapp.R;
import co.edu.uniquindio.reciclapp.model.Retiro;

public class ListRetiroAdapter extends RecyclerView.Adapter<ListRetiroAdapter.ViewHolder> {
    private  List<Retiro> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListRetiroAdapter(List<Retiro> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public ListRetiroAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListRetiroAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ListRetiroAdapter.ViewHolder holder, int position) {
        holder.binData(mData.get(position));
    }

    public void setItems(List<Retiro> items) { mData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView fecha, hora, material;

        ViewHolder(View itemView){
            super(itemView);
            fecha = itemView.findViewById(R.id.txtListElementFecha);
            hora = itemView.findViewById(R.id.txtListElementHora);
            material = itemView.findViewById(R.id.txtListElementTotal);
        }

        void binData(final Retiro item){
            fecha.setText(item.getFecha().toString());
            hora.setText(item.getHora());
            material.setText(item.getTotalMaterial() +"");
        }
    }


    @Override
    public int getItemCount() { return mData.size(); }
}
