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


public class Income extends Fragment {

    EditText inty;
    EditText innr;
    Button submit_in;
    ListView listView_in;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    int income = 0;


    public Income() {
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
        View veiw = inflater.inflate(R.layout.fragment_income, container, false);

        inty = (EditText) veiw.findViewById(R.id.infield);
        innr = (EditText) veiw.findViewById(R.id.infieldnr);
        submit_in = (Button) veiw.findViewById(R.id.subincome);
        listView_in = (ListView) veiw.findViewById(R.id.listveiw_in);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        listView_in.setAdapter(adapter);

        onBtnClick();

        return veiw;
    }

    public void onBtnClick(){
        submit_in.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String result = inty.getText().toString();
                Integer num = Integer.valueOf(innr.getText().toString());
                adapter.notifyDataSetChanged();
                arrayList.add(result);
                arrayList.add(num.toString());
                income = income + num;
            }
        });
    }
}
