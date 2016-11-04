package com.example.and.drawer;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {
    private MyDialogFragment myListener;

    public interface MyDialogListener{
        public void myCallback(String cityName);
    }
    public MyDialogFragment() {
        // Required empty public constructor
    }
    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        try {

           myListener = (MyDialogFragment)getTargetFragment();

        } catch (ClassCastException e) {

            throw new ClassCastException();

        }

    }


    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        LayoutInflater inflater = getActivity().getLayoutInflater();


        builder.setView(inflater.inflate(R.layout.dialog_layout, null))

                .setPositiveButton("확인", new DialogInterface.OnClickListener() {


                    @Override

                    public void onClick(DialogInterface dialog, int id) {

                      //  EditText edCityName = (EditText)getDialog().findViewById(R.id.city_name);

                      //  String cityName = edCityName.getText().toString();


                      // myListener.myCallback(cityName);

                    }

                });


        return builder.create();

    }



}
