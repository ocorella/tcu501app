package comsiteucrtcu501.google.httpssites.tcu501;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
import android.widget.GridLayout;

/**
 * Created by Jonathan on 15/10/2016.
 * Código basado en los siguientes videos:
 *  https://www.youtube.com/watch?v=xj8GrGGWU-8
 *  https://www.youtube.com/watch?v=0TX3hxcGIAM
 *  https://www.youtube.com/watch?v=ChrWz8ZMyOU
 */

public class MemoryButton extends Button {
    protected int row;
    protected int column;
    protected int frontDrawableId;
    protected int soundId;
    protected boolean isFlipped;
    protected boolean isMatched;
    protected Drawable front;
    protected Drawable back;
    protected MediaPlayer sound;

    /**
     * Jonathan Fonseca V.
     * 15/oct/2016
     * Método constructor
     */
    public MemoryButton(Context context, int r, int c, int frontImageDrawableId, int soundRawId)
    {
        super(context);

        row = r;
        column = c;
        frontDrawableId = frontImageDrawableId;
        soundId = soundRawId;

        front = AppCompatDrawableManager.get().getDrawable(context, frontImageDrawableId);
        back = AppCompatDrawableManager.get().getDrawable(context, R.drawable.card);
        sound = MediaPlayer.create(context, soundId);

        setBackground(back);

        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(r), GridLayout.spec(c));
        tempParams.width = (int)getResources().getDisplayMetrics().density * 70;
        tempParams.height = (int)getResources().getDisplayMetrics().density * 100;
        tempParams.setMargins(20,20,20,20);

        setLayoutParams(tempParams);
    }

    public boolean isMatched()
    {
        return isMatched;
    }

    public boolean isFlipped() { return isFlipped; }

    public void setMatched(boolean matched)
    {
        isMatched = matched;
    }

    public int getFrontDrawableId()
    {
        return frontDrawableId;
    }

    public void flip()
    {
        if(isMatched())
            return;

        if(isFlipped())
        {
            setBackground(back);
            isFlipped = false;
        }
        else
        {
            setBackground(front);
            isFlipped = true;
        }
    }

    public void playSound()
    {
        sound.start();
    }
}
