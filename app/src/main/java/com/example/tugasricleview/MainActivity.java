package com.example.tugasricleview;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListbuah;
    RecyclerView rvListjenis;
    HewanAdapter adapter;
    BuahAdapter adapter1;

    String[] namaBuahnyaa={"semangka","anggur","apel","strobery","jeruk","melon"};
    String[] jenisbuahnya={"biji 6","biji 5","biji 4","biji 3","biji 2","biji satu"};
    int[] gambarbuahnya={R.drawable.watermelon,R.drawable.icon,R.drawable.apple,R.drawable.strawberry,R.drawable.orange,R.drawable.melon};
    int[] gambarjenisnya={R.drawable.coffee,R.drawable.hazelnut,R.drawable.seed,R.drawable.nuts,R.drawable.seeds,R.drawable.biji};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new HewanAdapter();
        adapter1 = new BuahAdapter();
        rvListjenis = findViewById(R.id.rv_jenis);
        rvListbuah = findViewById(R.id.rv_buah);
        rvListbuah.setAdapter(adapter);
        rvListjenis.setAdapter(adapter1);
        rvListjenis.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        rvListbuah.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private class HewanAdapter extends  RecyclerView.Adapter<HewanAdapter.MyViewHolder>{
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.buahnya, viewGroup, false);



            return new MyViewHolder(view);
        }



        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
           myViewHolder.txtBuah.setText(namaBuahnyaa[position]);
           myViewHolder.imgBuah.setImageResource(gambarbuahnya[position]);
           myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(MainActivity.this, "Kamu memilih " + namaBuahnyaa[position], Toast.LENGTH_SHORT).show();
               }
           });
        }

        @Override
        public int getItemCount() {

            return namaBuahnyaa.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imgBuah;
            TextView txtBuah;

            public MyViewHolder(@NonNull View itemView) {


                super(itemView);



                imgBuah = itemView.findViewById(R.id.img_buah);
                txtBuah = itemView.findViewById(R.id.txt_buah);

            }


        }
    }

    private class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.MyBuahView> {
        @NonNull
        @Override
        public MyBuahView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.jenis_buah, viewGroup, false);

            return new MyBuahView(view1);
        }

        @Override
        public void onBindViewHolder(@NonNull MyBuahView myBuahView, final int position1) {
            myBuahView.imgJenisnya.setImageResource(gambarjenisnya[position1]);
            myBuahView.txtJenisnya.setText(jenisbuahnya[position1]);
            myBuahView.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "ini Jenis" + jenisbuahnya[position1], Toast.LENGTH_SHORT).show();
                }
            });



        }

        @Override
        public int getItemCount() {
            return namaBuahnyaa.length;
        }

        public class MyBuahView extends RecyclerView.ViewHolder {

            ImageView imgJenisnya;
            TextView txtJenisnya;

            public MyBuahView(@NonNull View itemView) {

                super(itemView);

                imgJenisnya = itemView.findViewById(R.id.img_jenis);
                txtJenisnya = itemView.findViewById(R.id.txt_jenis);

            }
        }
    }
}
