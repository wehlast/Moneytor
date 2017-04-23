package moneytor.moneytor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class Expenses extends Fragment {

    EditText expty;
    EditText expnr;
    Button submit_exp;
    ListView listView_exp;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    int expenses = 0;

    public Expenses() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expenses, container, false);

        expty = (EditText) view.findViewById(R.id.expfield);
        expnr = (EditText) view.findViewById(R.id.expfieldnr);
        submit_exp = (Button) view.findViewById(R.id.subexp);
        listView_exp = (ListView) view.findViewById(R.id.listveiw_exp);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        listView_exp.setAdapter(adapter);

        onBtnClick();

        return view;
    }

    public void onBtnClick(){
        submit_exp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String result = expty.getText().toString();
                Integer num = Integer.valueOf(expnr.getText().toString());
                adapter.notifyDataSetChanged();
                arrayList.add(result);
                arrayList.add(num.toString());
                expenses = expenses + num;
            }
        });
    }


}
