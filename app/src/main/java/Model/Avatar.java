package Model;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Avatar
{
    private int image;
ConstraintLayout constraintLayout;

    public Avatar(int image) {
        this.image = image;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }

    public void setConstraintLayout(ConstraintLayout constraintLayout) {
        this.constraintLayout = constraintLayout;
    }
}
