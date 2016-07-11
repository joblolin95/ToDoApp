package olin.blaine.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textView = (EditText)findViewById(R.id.myEditText);
        ListView listView = (ListView)findViewById(R.id.myListView);

        final ArrayList<String> toDoItems = new ArrayList<>();
        final ArrayAdapter<String> toDoItemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toDoItems);

        listView.setAdapter(toDoItemsAdapter);

        textView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    toDoItems.add(0, textView.getText().toString());
                    toDoItemsAdapter.notifyDataSetChanged();
                    textView.setText("");
                    return true;
                }
                return false;
            }

        });

    }
}
