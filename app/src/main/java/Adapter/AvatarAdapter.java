package Adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swipefriend.R;

import java.util.List;

import Model.Avatar;

public  class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.CategoryViewHandle>
{
        List<Avatar> Avatars;
    Context context;
    int selectedPosition = RecyclerView.NO_POSITION;

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public AvatarAdapter(List<Avatar> Avatars, Context context) {
        this.Avatars = Avatars;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHandle onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.avatar_item, parent, false);

        return new CategoryViewHandle(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHandle holder, int position) {
        holder.Image.setImageResource(Avatars.get(position).getImage());

        int backgroundColor = (selectedPosition == position) ? Color.parseColor("#69A6FF") : Color.TRANSPARENT;
        holder.constraintLayout.setBackgroundColor(backgroundColor);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int previousSelectedPosition = selectedPosition;
                selectedPosition = holder.getAdapterPosition();

              
                notifyItemChanged(previousSelectedPosition);

            
                notifyItemChanged(selectedPosition);
            }
        });


    }


    @Override
    public int getItemCount() {
        return Avatars.size();
    }


    public class CategoryViewHandle extends RecyclerView.ViewHolder
    {
    ImageView Image;
    ConstraintLayout constraintLayout;

        public CategoryViewHandle(@NonNull View itemView) {

            super(itemView);
             Image =itemView.findViewById(R.id.imageView15);
             constraintLayout = itemView.findViewById(R.id.constrain_o);

        }

    }

}
