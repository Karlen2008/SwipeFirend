package com.example.swipefriend;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import Model.Avatar;

public class Avatargetter
{
  private  List<Avatar> avatars = new ArrayList<>();
    public Avatargetter() {
        avatars.add(new Avatar(R.drawable.avatar_3));
        avatars.add(new Avatar(R.drawable.avatar_4));
        avatars.add(new Avatar(R.drawable.avatar_5));
        avatars.add(new Avatar(R.drawable.avatar_6));
        avatars.add(new Avatar(R.drawable.avatar_7));
        avatars.add(new Avatar(R.drawable.avatar_8));
        avatars.add(new Avatar(R.drawable.avatar_9));
    }
    public Avatar getAvatarbyindex(int index)
    {
        return  avatars.get(index);
    }
    public List<Avatar> getAvatars()
    {
        return  avatars;
    }

}
