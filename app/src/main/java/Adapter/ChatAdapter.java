package Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swipefriend.Avatargetter;
import com.example.swipefriend.R;

import java.util.List;

import Model.ChatItemModel;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.CategoryViewHandle>
{
    List<ChatItemModel> Chats ;
    Context context;

    public ChatAdapter(List<ChatItemModel> chats, Context context) {
        Chats = chats;
        this.context = context;
    }



    @NonNull
    @Override
    public CategoryViewHandle onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_item, parent, false);
        return new CategoryViewHandle(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHandle holder, int position)
    {
        Avatargetter avatargetter = new Avatargetter();
          holder.Name.setText(Chats.get(position).getName());
        holder.LastMessage.setText(Chats.get(position).getLastMessage());
        holder.image.setImageResource(avatargetter.getAvatarbyindex(Chats.get(position).getImageindex()).getImage());
    }

    @Override
    public int getItemCount()
    {
        return Chats.size();
    }
    public class CategoryViewHandle extends RecyclerView.ViewHolder
    {

        ImageView image;
       TextView Name, LastMessage;

        public CategoryViewHandle(@NonNull View itemView) {
            super(itemView);
            image =   itemView.findViewById(R.id.chatImage);
            Name = itemView.findViewById(R.id.chat_name);
            LastMessage = itemView.findViewById(R.id.chat_time);

        }
    }
}
