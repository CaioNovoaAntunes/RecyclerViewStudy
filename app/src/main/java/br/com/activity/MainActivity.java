package br.com.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.adapter.Adapter;
import br.com.model.Filme;
import br.com.recyclerviewstudy.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        criarFilmes();

        //Configurar o adapter
        Adapter adapter = new Adapter(listaFilmes);


        // Configurar o recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "item pressionado"+ filme.getTitulo(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                        getApplicationContext(),
                                        "Click Longo" + filme.getTitulo(),
                                        Toast.LENGTH_SHORT
                                ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )

        );

    }

    public void criarFilmes() {
        Filme ola = new Filme("Pica-Pau", "Desenho", "2013");
        this.listaFilmes.add(ola);
        Filme filme1 = new Filme("Arcane", "Games", "2022");
        this.listaFilmes.add(filme1);
        Filme filme2 = new Filme("007", "ação", "2001");
        this.listaFilmes.add(filme2);
        Filme filme3 = new Filme("abcdoamor", "Roamnce", "2007");
        this.listaFilmes.add(filme3);
        Filme filme4 = new Filme("Terabit", "Ação", "1980");
        this.listaFilmes.add(filme4);
    }
}