package comsiteucrtcu501.google.httpssites.tcu501;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Random;

public class MemoriaActivity extends AppCompatActivity implements View.OnClickListener{
    private int numberOfElements;
    private MemoryButton[] memoryButtons;
    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;
    private MemoryButton selectedButton1;
    private MemoryButton selectedButton2;
    private boolean isBusy = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria);

        GridLayout gridLayout = (GridLayout)findViewById(R.id.grid_layout_4x4);

        int numRows = gridLayout.getRowCount();
        int numCols = gridLayout.getColumnCount();

        numberOfElements = numRows * numCols;

        memoryButtons = new MemoryButton[numberOfElements];
        buttonGraphics = new int[numberOfElements];

        // Todos los elementos o dibujos
        buttonGraphics[0] = R.drawable.bear;
        buttonGraphics[1] = R.drawable.beaver;
        buttonGraphics[2] = R.drawable.cat;
        buttonGraphics[3] = R.drawable.chicken;
        buttonGraphics[4] = R.drawable.cow;
        buttonGraphics[5] = R.drawable.dog;
        buttonGraphics[6] = R.drawable.elephant;
        buttonGraphics[7] = R.drawable.giraffe;

        buttonGraphicLocations = new int[numberOfElements];

        shuffleButtonGraphics();

        for(int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {
                MemoryButton tempButton = new MemoryButton(this, r, c, buttonGraphics[buttonGraphicLocations[r*numCols+c]]);
                tempButton.setId(View.generateViewId());
                tempButton.setOnClickListener(this);
                memoryButtons[r * numCols + c] = tempButton;
                gridLayout.addView(tempButton);
            }
        }
    }

    protected void shuffleButtonGraphics()
    {
        Random rand = new Random();

        for(int i = 0; i < numberOfElements; i++)
        {
            buttonGraphicLocations[i] = i % (numberOfElements / 2);
        }

        for(int i = 0; i < numberOfElements; i++)
        {
            int temp = buttonGraphicLocations[i];
            int swapIndex = rand.nextInt(16);

            buttonGraphicLocations[i] = buttonGraphicLocations[swapIndex];
            buttonGraphicLocations[swapIndex] = temp;
        }
    }

    @Override
    public void onClick(View v) {
        if(isBusy)
            return;

        MemoryButton memoryButton = (MemoryButton)v;

        if(memoryButton.isMatched)
            return;

        if(selectedButton1 == null)
        {
            selectedButton1 = memoryButton;
            selectedButton1.flip();
            return;
        }

        if(selectedButton1.getId() == memoryButton.getId())
            return;

        if(selectedButton1.getFrontDrawableId() == memoryButton.getFrontDrawableId())
        {
            memoryButton.flip();
            memoryButton.setMatched(true);
            selectedButton1.setMatched(true);

            selectedButton1.setEnabled(false);
            memoryButton.setEnabled(false);

            selectedButton1 = null;

            return;
        }
        else
        {
            selectedButton2 = memoryButton;
            selectedButton2.flip();
            isBusy = true;

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    selectedButton2.flip();
                    selectedButton1.flip();
                    selectedButton1 = null;
                    selectedButton2 = null;
                    isBusy = false;
                }
            }, 500);
        }
    }
}
