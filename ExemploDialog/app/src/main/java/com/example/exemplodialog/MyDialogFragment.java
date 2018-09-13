package com.example.exemplodialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class MyDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Pergunta")
                .setMessage("Voce entendeu como funciona o dialog?")
                .setPositiveButton("Sim",this)
                .setNegativeButton("Nao", this);
        return builder.create();

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        String msg = null;

        if ( i == dialogInterface.BUTTON_NEGATIVE ) {
            msg = "Voce escolheu NAO";
        } else if ( i == dialogInterface.BUTTON_POSITIVE){
            msg = "Voce escolheu SIM";
        }

        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();

    }
}
