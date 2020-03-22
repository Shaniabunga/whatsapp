package id.ac.polinema.chatting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private View btnSend;
    private EditText editText;
    boolean myMessage = true;
    private List<id.ac.polinema.chatting.Chat> Chats;
    private ArrayAdapter<id.ac.polinema.chatting.Chat> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chats = new ArrayList<>();

        listView = (ListView) findViewById(R.id.message_list);
        btnSend = findViewById(R.id.btn_send_chat);
        editText = (EditText) findViewById(R.id.enter_msg);

        //set ListView adapter first
        adapter = new MessageAdapter(this, R.layout.left_chat, Chats);
        listView.setAdapter(adapter);

        //event for button SEND
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Input your message, pls!", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list
                    id.ac.polinema.chatting.Chat Chat = new  id.ac.polinema.chatting.Chat(editText.getText().toString(), true);
                    Chats.add(Chat);

                    id.ac.polinema.chatting.Chat Chat2 = new  id.ac.polinema.chatting.Chat("OKE SAYANGKU", false );
                    Chats.add(Chat2);

                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    if (myMessage) {
                        myMessage = false;
                    } else {
                        myMessage = true;
                    }
                }
            }
        });
    }
}
