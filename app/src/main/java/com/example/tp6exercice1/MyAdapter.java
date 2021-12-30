package com.example.tp6exercice1;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>

{
    Context context;
    List<Contact> contactList;

    public MyAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    public MyAdapter() {}

    public void removeItem(int position) {
        contactList.remove(position);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Contact c = contactList.get(position);

        holder.textViewNom.setText(c.getNom());
        holder.textViewTel.setText(c.getTel());
        holder.img.setImageResource(c.getImg());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void editItem(int groupId) {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        ImageView img;
        TextView textViewNom , textViewTel;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imageView);
            textViewNom=itemView.findViewById(R.id.textViewNom);
            textViewTel=itemView.findViewById(R.id.textViewTel);
             itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Gerer Contacts");
            contextMenu.add(this.getAdapterPosition(),121,100,"Call");
            contextMenu.add(this.getAdapterPosition(),122,101,"SMS");
            contextMenu.add(this.getAdapterPosition(),123,102,"Edit");
            contextMenu.add(this.getAdapterPosition(),124,103,"Delete");


        }


    }
}
