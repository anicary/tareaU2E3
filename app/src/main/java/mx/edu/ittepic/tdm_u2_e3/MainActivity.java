package mx.edu.ittepic.tdm_u2_e3;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Base baseinterna;
    Button agregar;
    ArrayList<Usuario> listaAlumnos;
    RecyclerView listaObjetos;
    private RecyclerView.LayoutManager mLayoutManager;
     AdaptadorVista adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregar = findViewById(R.id.agregar);
        listaObjetos= findViewById(R.id.rec);
        listaObjetos.setLayoutManager(new LinearLayoutManager(this));
        listaAlumnos=new ArrayList<>();

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(MainActivity.this,AddActivity.class);
                        startActivity(siguiente);
            }
        });


        baseinterna = new Base(MainActivity.this, "baseinterna", null, 1);


        try {
            Cursor cursor_datos;
            SQLiteDatabase base = baseinterna.getReadableDatabase();
            String query1 = "select * from usuarios;";
            cursor_datos=base.rawQuery(query1,null);
            while (cursor_datos.moveToNext())
            {
                listaAlumnos.add(new Usuario(cursor_datos.getInt(0),cursor_datos.getString(1),cursor_datos.getString(2),cursor_datos.getString(3)));
            }

        } catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        adapter = new AdaptadorVista(listaAlumnos,getApplicationContext());
        listaObjetos.setAdapter(adapter);


    }
}
