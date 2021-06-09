package com.example.intelmarketlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CompraAdapter extends RecyclerView.Adapter<CompraAdapter.ComprasViewHolder> {
    private final List<Compras> compras;
    private final Context context;
    private final CompraOnClickListener onclickListener;

    public interface CompraOnClickListener {
        void onClickCompra(ComprasViewHolder view, int idx);
    }

    public CompraAdapter(Context context, List<Compras> compras, CompraOnClickListener onclickListener){
        this.context = context;
        this.compras = compras;
        this.onclickListener = onclickListener;
    }

    @Override
    public ComprasViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_compra, viewGroup, false);

        return new ComprasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ComprasViewHolder holder, final int position){
        Compras c = compras.get(position);

        holder.tNome.setText(c.nome);
        holder.tValor.setText(c.getValor());

        if(onclickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    onclickListener.onClickCompra(holder, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.compras != null ? this.compras.size() : 0;
    }

    public static class ComprasViewHolder extends RecyclerView.ViewHolder {
        public TextView tNome;
        public TextView tValor;
        private View view;

        public ComprasViewHolder(View view){
            super(view);
            this.view = view;
            tNome = view.findViewById(R.id.tNome);
            tValor = view.findViewById(R.id.tValor);
        }
    }
}
