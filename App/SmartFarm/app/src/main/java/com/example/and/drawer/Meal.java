package com.example.and.drawer;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Meal extends Fragment {

    private static final int ALL_CHECK_BUTTON=0;
    private CheckBox[] mCheckBoxs;
    private CheckBox[] mCheckBoxs2;
    int temp;
    private Dialog mMainDialog;
    private Dialog mMainDialog2;
    final CharSequence[] items={"Red","Green","Blue"};
    public Meal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ArrayList<String> list = new ArrayList<String>();
        final List<String> list2 = new ArrayList<String>();
        final List<String> list3 = new ArrayList<String>();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meal, container, false);

       Button button2=(Button)view.findViewById(R.id.second);
        Button button5 = (Button)view.findViewById(R.id.date);
        Button walk = (Button)view.findViewById(R.id.walk);
        Button plus = (Button)view.findViewById(R.id.plus);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{"아침식사","점심식사","저녁식사"};

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("식사")
                        .setMultiChoiceItems(
                                items,
                                new boolean[]{false, false, false}
                                , new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked) {
                                            list.add(items[which]);
                                        } else {
                                            list.remove(items[which]);
                                        }
                                    }
                                })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String selectedItem = "";
                                for (String item : list) {
                                    selectedItem += item + ", ";
                                }
                               // Toast.makeText(getActivity(),selectedItem,Toast.LENGTH_SHORT).show();
                                final String[] item = new String[]{"쌀밥", "김치", "된장찌개", "우엉조림", "양배추찜","부추전","현미잡곡밥","낙지젓갈","스팸"
                                        ,"치킨","맥주","오이","오이고추","잡채","잡곡밥"};

                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setTitle("식사")
                                        .setMultiChoiceItems(
                                                item,
                                                new boolean[]{false, false, false,false,false,false,false,false,false,false,false,false,false,false,false}
                                                , new DialogInterface.OnMultiChoiceClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                                        if (isChecked) {
                                                            list3.add(item[which]);
                                                        } else {
                                                            list3.remove(item[which]);
                                                        }
                                                    }
                                                })
                                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                String selectedItem = "";
                                                for (String item : list3) {
                                                    selectedItem += item + ", ";
                                                }
                                                Toast.makeText(getActivity(),selectedItem,Toast.LENGTH_SHORT).show();

                                            }
                                        }).setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                        .create().show();
                            }
                        }).setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                        .create().show();

            }


        });

        walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("오늘 걸음수")
                       .setMessage("0걸음 걸으셨습니다.")
                        .setPositiveButton("닫기",null).create().show();
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String str[] = {"운동","체중기록","혈압측정","혈당측정"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("추가 기록")
                         .setPositiveButton("선택", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 if(str[temp].equals("운동")){
                                     AlertDialog.Builder builder2
                                             = new AlertDialog.Builder(getActivity());
                                     final String str2[]={"걷기","런닝머신에서 걷기","달리기","자전거","실내 자전거","에어로빅","배드민턴"};
                                     builder2.setTitle("운동")
                                             .setPositiveButton("완료",null)
                                             .setSingleChoiceItems(
                                                     str2, -1,
                                                     new DialogInterface.OnClickListener() {
                                                         @Override
                                                         public void onClick(DialogInterface dialog, int which) {

                                                         }
                                                     }
                                             ).setNegativeButton("닫기",null)
                                             .create().show();

                                 }
                                 else if(str[temp].equals("체중기록")){
                                     AlertDialog.Builder builder4
                                             = new AlertDialog.Builder(getActivity());
                                     builder4.setTitle("체중기록");
                                     final EditText input = new EditText(getActivity());
                                     builder4.setView(input);
                                     builder4.setPositiveButton("확인",
                                             new DialogInterface.OnClickListener() {
                                                 @Override
                                                 public void onClick(DialogInterface dialog, int which) {
                                                     String value
                                                             = input.getText().toString();
                                                     value.toString();
                                                 }
                                             }).create().show();
                                 }
                                 else if(str[temp].equals("혈압측정")){
                                     AlertDialog.Builder builder5
                                             = new AlertDialog.Builder(getActivity());
                                     builder5.setTitle("혈압기록");
                                     builder5.setView(R.layout.blood);
                                     builder5.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialog, int which) {

                                         }
                                     }).setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialog, int which) {

                                         }
                                     }).create().show();


                                 }
                                 else if(str[temp].equals("혈당측정")){
                                     AlertDialog.Builder builder5
                                             = new AlertDialog.Builder(getActivity());
                                     builder5.setTitle("혈당기록");
                                     builder5.setView(R.layout.bloodsugar);
                                     builder5.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialog, int which) {

                                         }
                                     }).setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialog, int which) {

                                         }
                                     }).create().show();

                                 }
                             }
                         }).setNegativeButton("닫기",null)
                        .setSingleChoiceItems(
                                str, -1,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        temp=which;
                                    }
                                }
                        ).create().show();
                        //.setItems(str,null).create().show();

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             DatePickerDialog dialog = new DatePickerDialog(getActivity(),android.R.style.Theme_Holo_Dialog,listener,2016,10,26);
                dialog.show();

            }


        });
        return view;
    }
   private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
           //Toast.makeText(getActivity(), year + "년" + month + "월" + dayOfMonth +"일으로 설정하셨습니다", Toast.LENGTH_SHORT).show();
        }
    };


        }



