package com.nyc.whatismyaddress.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nyc.whatismyaddress.R;
import com.nyc.whatismyaddress.model.RecyclerModel;

/**
 * Created by c4q on 11/21/17.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    private TextView emailText;
    private View item;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        emailText = (TextView) itemView.findViewById(R.id.email_text);
        item = itemView;
    }

    public void onBind(RecyclerModel recyclerModel) {
        emailText.setText(recyclerModel.getEmail());
    }

    public View getItem() {
        return item;
    }
}
