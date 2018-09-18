package com.example.exemplodialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.EditText;

public class MyEditDialog extends DialogFragment {

    EditText editText;
    OnTextListener listener;

    public static void show (FragmentManager fm , OnTextListener listener) {
        MyEditDialog dialog = new MyEditDialog();

        dialog.listener = listener;
        dialog.show(fm, "TextDialog");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Insira um texto aqui");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if ( listener != null ) {
                    String txt = editText.getText().toString();
                    listener.onSetText(txt);
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_my_edit,null);
        editText = view.findViewById(R.id.edt_text);
        builder.setView(view);
        return builder.create();
    }

    public interface OnTextListener {
        void onSetText(String text);
    }

}
