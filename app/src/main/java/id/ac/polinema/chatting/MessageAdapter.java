package id.ac.polinema.chatting;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<id.ac.polinema.chatting.Chat> {
    private Activity activity;
    private List<id.ac.polinema.chatting.Chat> messages;

    public MessageAdapter(Activity context, int resource, List<id.ac.polinema.chatting.Chat> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.messages = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        int layoutResource = 0; // determined by view type
        id.ac.polinema.chatting.Chat Chat = getItem(position);
        int viewType = getItemViewType(position);

        if (Chat.myMessage()) {
            layoutResource = R.layout.right_chat;
        } else {
            layoutResource = R.layout.left_chat;
        }

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        //set message content
        holder.msg.setText(Chat.getContent());

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    private class ViewHolder {
        private TextView msg;

        public ViewHolder(View v) {

            msg = (TextView) v.findViewById(R.id.text_message_body);
        }
    }
}
