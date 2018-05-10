// Mccormick Robert
// JAV1 - MDV3810-O 01
// MainActivity.java


package com.example.robertmccormick.mccormickrob_ce05;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.robertmccormick.mccormickrob_ce05.DataList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] FirstnameList = {"First name 1", "First name 2", "First name 3", "First name 4", "First name 5",
            "First name 6", "First name 7", "First name 8", "First name 9", "First name 10", "First name 11"};

    String[] LastnameList = {"Last name 1", "Last name 2", "Last name 3", "Last name 4", "Last name 5",
            "Last name 6", "Last name 7", "Last name 8", "Last name 9", "Last name 10", "Last name 11"};

    String[] BrithdayList = {"1201/2009", "12/01/2010", "12/01/2011", "12/02/2009", "12/03/2009", "12/04/2009",
            "12/05/2009", "12/01/2014", "12/01/2015", "12/01/2004", "12/01/2002"};

    int[] ImageList = {R.drawable.bee, R.drawable.buffalo, R.drawable.bull, R.drawable.butterfly, R.drawable.cow,
            R.drawable.dolphin, R.drawable.duck, R.drawable.firefly, R.drawable.fish, R.drawable.giraffe, R.drawable.horse};

    private String description = "Lorem ipsum dolor sit amet, est cu quod elitr consetetur, at nec quod facilisis, eu sit fugit persius sensibus. Omnes everti ei mei, has ad iisque prompta, in prima causae vix. Quo tota debet nostrud cu, omnes eruditi tractatos ea per. Ei vix possim expetendis.\n" +
            "\n" +
            "Nec at errem veniam inermis, has ea omnis eruditi dignissim. Eius complectitur pri ea. Id verear dolores cotidieque cum. Pro nullam feugait contentiones ei.";
    private ImageView data_image;
    private TextView data_Id;
    private TextView data_Name;
    private TextView data_Date;
    private TextView data_Desciption;
    private ListView listview;
    //====
    private Spinner mSpinner;
    private Context mContext;
    private CustomAdapter mCustomAdapter;
    private SpinercustomAdapter mSpinercustomAdapter;
    private ArrayList<DataList> allDataLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main_land);
        }

        mContext = this;
        initUi();
    }

    public void initUi() {

        dataCollection();
        showUi();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orient = getResources().getConfiguration().orientation;
        switch (orient) {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main_land);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;
        }
        showUi();
    }

    public void showUi() {

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == 1) {

            listview = (ListView) this.findViewById(R.id.listview);

            mCustomAdapter = new CustomAdapter(mContext, allDataLists);
            data_image = (ImageView) this.findViewById(R.id.data_image);
            data_Id = (TextView) this.findViewById(R.id.data_Id);
            data_Name = (TextView) this.findViewById(R.id.data_Name);
            data_Date = (TextView) this.findViewById(R.id.data_Date);
            data_Desciption = (TextView) this.findViewById(R.id.data_Desciption);
            listview.setAdapter(mCustomAdapter);
            mCustomAdapter.notifyDataSetChanged();
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    selectedData(i);
                }
            });
            selectedData(1);

        } else if (orientation == 2) {

            mSpinercustomAdapter = new SpinercustomAdapter(mContext, R.layout.row_list, allDataLists);
            mSpinner = (Spinner) this.findViewById(R.id.view_spinner);
            data_image = (ImageView) this.findViewById(R.id.data_image_2);
            data_Id = (TextView) this.findViewById(R.id.data_Id);
            data_Name = (TextView) this.findViewById(R.id.data_Name);
            data_Date = (TextView) this.findViewById(R.id.data_Date);
            data_Desciption = (TextView) this.findViewById(R.id.data_Desciption);

            mSpinner.setAdapter(mSpinercustomAdapter);
            mSpinercustomAdapter.notifyDataSetChanged();
            mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    selectedData(mSpinner.getSelectedItemPosition());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            selectedData(mSpinner.getSelectedItemPosition());
        }
    }

    public void selectedData(int position) {
        DataList mDataList = allDataLists.get(position);
        data_image.setImageResource(mDataList.getImage());
        data_Id.setText(mDataList.getId());
        data_Name.setText(mDataList.getName());
        data_Date.setText(mDataList.getDate());
        data_Desciption.setText(mDataList.getDescriptio());
    }

    public void dataCollection() {
        allDataLists.clear();
        for (int index = 0; index < FirstnameList.length; index++) {
            DataList mDataList = new DataList();
            mDataList.setId("00000" + (index + 1));
            mDataList.setName(FirstnameList[index] + " " + LastnameList[index]);
            mDataList.setDate(BrithdayList[index]);
            mDataList.setImage(ImageList[index]);
            mDataList.setDescriptio(description);
            allDataLists.add(mDataList);
        }
    }
}
