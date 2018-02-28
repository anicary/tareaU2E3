package mx.edu.ittepic.tdm_u2_e3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Carolina Mondragon on 27/02/2018.
 */

public class AdaptadorVista extends RecyclerView.Adapter<AdaptadorVista.ViewHolderUsuarios> {
    ArrayList<Usuario> listaUsuarioss;

    Context context;

    public AdaptadorVista(ArrayList<Usuario> listaUsuarioss, Context context) {
        this.listaUsuarioss = listaUsuarioss;
        this.context = context;
    }
    public void onBindViewHolder(ViewHolderUsuarios holder, int position) {
     holder.id.setText(""+listaUsuarioss.get(position).getId());
     holder.nombre.setText(listaUsuarioss.get(position).getNombre());
     holder.login.setText(listaUsuarioss.get(position).getLogin());
     holder.proy.setText(listaUsuarioss.get(position).getProy());

    }
    public ViewHolderUsuarios onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=R.layout.vista;
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        return new ViewHolderUsuarios(view);

    }
    public int getItemCount() {
        return listaUsuarioss.size();
    }

    /*Con esta parte e codigo se crea elemtnos configurados*/
    public class ViewHolderUsuarios extends RecyclerView.ViewHolder{
        TextView id,nombre,login,proy;

        public ViewHolderUsuarios(View itemView) {
            super(itemView);
            id= (TextView) itemView.findViewById(R.id.identificador);
            nombre =(TextView) itemView.findViewById(R.id.nombre);
            login =(TextView) itemView.findViewById(R.id.login);
            proy =(TextView) itemView.findViewById(R.id.proyecto);
        }
    }

}
