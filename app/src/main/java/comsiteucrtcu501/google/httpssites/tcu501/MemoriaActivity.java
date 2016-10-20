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
import android.widget.Toast;


import java.util.Random;

public class MemoriaActivity extends AppCompatActivity implements View.OnClickListener{
    private int numberOfElements;
    private MemoryButton[] memoryButtons;
    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;
    private int[] buttonSounds;
    private MemoryButton selectedButton1;
    private MemoryButton selectedButton2;
    private boolean isBusy = false;
    private int counter = 0;


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
        buttonSounds = new int[numberOfElements];
        shuffleAndSelectGraphics();

        buttonGraphicLocations = new int[numberOfElements];

        shuffleButtonGraphics();

        for(int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {
                MemoryButton tempButton = new MemoryButton(this, r, c, buttonGraphics[buttonGraphicLocations[r*numCols+c]], buttonSounds[buttonGraphicLocations[r*numCols+c]]);
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

    protected void shuffleAndSelectGraphics()
    {
        // Se llena un arreglo temporal con todas las imágenes de la categoría escogida
        int[] tempGraphics = new int[]
                {
                        R.drawable.bear,        R.drawable.beaver,
                        R.drawable.cat,         R.drawable.chicken,
                        R.drawable.cow,         R.drawable.dog,
                        R.drawable.elephant,    R.drawable.giraffe,
                        R.drawable.gnu,         R.drawable.goat,
                        R.drawable.hippo,       R.drawable.kangaroo,
                        R.drawable.monkey,      R.drawable.moose,
                        R.drawable.mouse,       R.drawable.owl,
                        R.drawable.penguin,     R.drawable.pig,
                        R.drawable.sheep,       R.drawable.squirrel,
                        R.drawable.zebra
                };

        int[] tempSounds = new int[]
                {
                        R.raw.bear,        R.raw.beaver,
                        R.raw.cat,         R.raw.chicken,
                        R.raw.cow,         R.raw.dog,
                        R.raw.elephant,    R.raw.giraffe,
                        R.raw.gnu,         R.raw.goat,
                        R.raw.hippo,       R.raw.kangaroo,
                        R.raw.monkey,      R.raw.moose,
                        R.raw.mouse,       R.raw.owl,
                        R.raw.penguin,     R.raw.pig,
                        R.raw.sheep,       R.raw.squirrel,
                        R.raw.zebra
                };

        // Se aleatorizan los arreglos temporales
        Random rand = new Random();
        for(int i = 0; i < tempGraphics.length - 1; i++)
        {
            int tempG = tempGraphics[i];
            int tempS = tempSounds[i];
            int swapIndex = rand.nextInt(tempGraphics.length);

            tempGraphics[i] = tempGraphics[swapIndex];
            tempGraphics[swapIndex] = tempG;

            tempSounds[i] = tempSounds[swapIndex];
            tempSounds[swapIndex] = tempS;
        }

        // Se escogen los primeros 8 elementos del arreglo temporal para agregarlos al
        // arreglo de botones.
        for(int i = 0; i < (numberOfElements / 2); i++)
        {
            buttonGraphics[i] = tempGraphics[i];
            buttonSounds[i] = tempSounds[i];
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
            selectedButton1.playSound();
            return;
        }

        if(selectedButton1.getId() == memoryButton.getId())
            return;

        if(selectedButton1.getFrontDrawableId() == memoryButton.getFrontDrawableId())
        {
            memoryButton.flip();
            memoryButton.playSound();
            memoryButton.setMatched(true);
            selectedButton1.setMatched(true);

            selectedButton1.setEnabled(false);
            memoryButton.setEnabled(false);

            selectedButton1 = null;

            counter++;
            if(counter == (numberOfElements/2))
            {
                Toast toast = Toast.makeText(this, "Ganaste!", Toast.LENGTH_SHORT);
                toast.show();
            }

            return;
        }
        else
        {
            selectedButton2 = memoryButton;
            selectedButton2.flip();
            selectedButton2.playSound();
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
