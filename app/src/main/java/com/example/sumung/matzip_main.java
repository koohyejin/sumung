package com.example.sumung;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class matzip_main extends AppCompatActivity {

    static int count=0;
    ListView listView;
    static boolean btnIsChoosed = false;
    EditText et;
    ArrayList<matzip> matzip_list = new ArrayList<>();


    matzipadapter adapter;

    int REQUEST_MSG_CODE = 1;
    int REQUEST_MSG_CODE2= 2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matzip_main);
        setListView();
        listView = (ListView)findViewById(R.id.listview);
        et = (EditText)findViewById(R.id.editText);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String search = s.toString();
                if(search.length() > 0) {
                    listView.setFilterText(search);
                }
                else {
                    listView.clearTextFilter();
                }
            }
        });
    }

    public void onClick(View v){
        if(v.getId() == R.id.btnAddMatzip) {
            Intent intent = new Intent(this, matzip_main2.class);
            matzip matzip = new matzip("", "", 0, "", "", "", "", "");

            intent.putExtra("msg_matzip", matzip);

            startActivityForResult(intent, REQUEST_MSG_CODE);
            getSavedStateRegistry();

        }
        else if(v.getId() == R.id.btnName) {
            Comparator<matzip> dataAsc = new Comparator<matzip>() {
                @Override
                public int compare(matzip o1, matzip o2) {
                    return o1.name.compareTo(o2.name);
                }
            };

            Collections.sort(matzip_list,dataAsc);
            adapter.notifyDataSetChanged();
        }
        else if(v.getId() == R.id. btnKind) {
            Comparator<matzip> dataKindAsc = new Comparator<matzip>() {
                @Override
                public int compare(matzip o1, matzip o2) {
                    return o1.menu_kind > o2.menu_kind ? 1 : -1 ;
                }
            };
            Collections.sort(matzip_list,dataKindAsc);
            adapter.notifyDataSetChanged();
        }

        else if(v.getId()==R.id.btnChoose) {
//            LinearLayout list_layout = (LinearLayout) View.inflate(MainActivity.this, R.layout.list_layout, null);
            final Button button = (Button) findViewById(R.id.btnChoose);
            CheckBox cb = (CheckBox) findViewById(R.id.checkBox);



            if(btnIsChoosed == false) {

                if( adapter.isEmpty() == true) return;
                adapter.setCheckBoxVisible();

                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                button.setText("삭제");
                btnIsChoosed = true;
            }
            else {
                if( adapter.isEmpty() == true) return;


                AlertDialog.Builder dlg = new AlertDialog.Builder(matzip_main.this);
                dlg.setTitle("삭제확인");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMessage("선택한 맛집정보를 삭제하시겠습니까?");
                dlg.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        CheckBox cb;
                        for (int i = matzip_list.size() - 1 ; i >=0 ; i--) {
                            cb = (CheckBox)( listView.getChildAt(i).findViewById(R.id.checkBox) );
                            if ( cb.isChecked() == true ) {
                                cb.setChecked(false);
                                matzip_list.remove(i);
                            }
                            listView.clearChoices();
                            adapter.notifyDataSetChanged();
                            adapter.setCheckBoxGone();
                            listView.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
                            button.setText("선택");
                            btnIsChoosed = false;
                        }


                    }
                });
                dlg.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.notifyDataSetChanged();
                        adapter.setCheckBoxGone();
                        listView.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
                        button.setText("선택");
                        btnIsChoosed = false;
                    }
                });

                dlg.show();

            }


        }
    }



    public void setListView(){
        final Intent intent = new Intent(this, matzip_main3.class);

        listView = (ListView)findViewById(R.id.listview);
        adapter = new matzipadapter(matzip_list,this);

//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LinearLayout list_view = (LinearLayout) inflater.inflate(R.layout.list_layout,null);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                intent.putExtra( "msg_matzip_data", matzip_list.get(position) );
                startActivityForResult(intent,REQUEST_MSG_CODE2);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                ListView listView = (ListView) parent;
                AlertDialog.Builder dlg = new AlertDialog.Builder(matzip_main.this);
                dlg.setTitle("삭제확인");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMessage("등록된 맛집정보를 삭제하시겠습니까?");
                dlg.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        matzip_list.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                dlg.setPositiveButton("취소", null);
                dlg.show();
                return true;
            }
        });


    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_MSG_CODE) {
            if (resultCode == RESULT_OK) {
                matzip m;
                m = data.getParcelableExtra("remakemsg");
                matzip_list.add(m);
                int size = matzip_list.size();

                adapter.notifyDataSetChanged();
            }

        }
    }
}