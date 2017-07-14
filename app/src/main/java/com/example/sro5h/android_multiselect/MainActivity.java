package com.example.sro5h.android_multiselect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsById();

        String[] fruit = getResources().getStringArray(R.array.fruit_array);
        CustomAdapter adapter = new CustomAdapter(this, fruit);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                List<String> selected = getSelectedItems();
                String logString = "Selcted items: " + TextUtils.join(", ", selected);

                Log.d("MainActivity", logString);
                Toast.makeText(this, logString, Toast.LENGTH_SHORT).show();

                break;
        }
    }

    private void findViewsById() {
        listView = (ListView) findViewById(R.id.list);
        button = (Button) findViewById(R.id.button);
    }

    private List<String> getSelectedItems() {
        List<String> result = new ArrayList<>();
        SparseBooleanArray checkedItems = listView.getCheckedItemPositions();

        for (int i = 0; i < listView.getCount(); ++i) {
            if (checkedItems.valueAt(i)) {
                result.add((String) listView.getItemAtPosition(checkedItems.keyAt(i)));
            }
        }

        return result;
    }
}
