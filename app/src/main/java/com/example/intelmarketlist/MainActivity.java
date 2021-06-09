package com.example.intelmarketlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActiorBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.actionbar_title);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7729E6")));

        // RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // recyclerView.setHasFixedSize(true);

        //Compras e Adapter
        List<Compras> compras = Compras.getCompras();
        recyclerView.setAdapter(new CompraAdapter(this, compras, onClickCompra()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private CompraAdapter.CompraOnClickListener onClickCompra(){
        return new CompraAdapter.CompraOnClickListener() {
            @Override
            public void onClickCompra(CompraAdapter.ComprasViewHolder holder, int idx){
                List<Compras> compras = Compras.getCompras();
                Compras c = compras.get(idx);
                Toast.makeText(getBaseContext(), "Compras: "+c.nome, Toast.LENGTH_SHORT).show();
            }
        };
    }

    private Activity getActivity() { return this; }


   /* public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
    }*/
}