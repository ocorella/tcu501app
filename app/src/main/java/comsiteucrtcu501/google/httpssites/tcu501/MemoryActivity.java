package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.media.MediaPlayer;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Clase que maneja el juego "Memoria"
 *
 * @author Jonathan Fonseca V.
 * @author Francisco Zúñiga M.
 * */
public class MemoryActivity extends AppCompatActivity implements View.OnClickListener{
    private int numberOfElements;
    private MemoryButton[] memoryButtons;
    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;
    private int[] buttonSounds;
    private MemoryButton selectedButton1;
    private MemoryButton selectedButton2;
    private boolean isBusy = false;
    private int counter = 0;
    private int grade;
    private GridLayout gridLayout;
    private TextView phrase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        grade = getIntent().getExtras().getInt("grade");

        startGame();
    }

    /**
     * Establece la cantidad de cartas que se van a mostrar, selecciona las imágenes y sonidos
     * y los posiciona en la pantalla
     *
     * @author Jonathan Fonseca V.
     * @author Francisco Zúñiga M.
     * */
    protected void startGame()
    {
        gridLayout = (GridLayout)findViewById(R.id.grid_layout_4x4);

        int numRows = gridLayout.getRowCount();
        int numCols = gridLayout.getColumnCount();

        if(numRows == 3)
            numRows = numRows - 1;
        else
            numRows = numRows - 2;

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

    /**
     * Mezcla las posiciones de las cartas en donde van a quedar las parejas.
     *
     * @author Jonathan Fonseca V.
     * @author Francisco Zúñiga M.
     * */
    protected void shuffleButtonGraphics()
    {
        Random rand = new Random();

        // Asigna la ubicación de los botones de las tarjetas, tomando en cuenta
        // la cantidad de elementos que se van a mostrar. Se divide en dos partes
        // con los mismos números de ubicación porque son parejas.
        for(int i = 0; i < numberOfElements; i++)
        {
            buttonGraphicLocations[i] = i % (numberOfElements / 2);
        }

        // Mezcla las posiciones para que las parejas queden en diferentes posiciones.
        for(int i = 0; i < numberOfElements; i++)
        {
            int temp = buttonGraphicLocations[i];
            int swapIndex = rand.nextInt(16);

            buttonGraphicLocations[i] = buttonGraphicLocations[swapIndex];
            buttonGraphicLocations[swapIndex] = temp;
        }
    }

    /**
     * Se aleatorizan los arreglos de las imágenes y sonidos para luego seleccionar los elementos.
     *
     * que se van a mostrar
     * @author Jonathan Fonseca V.
     * @author Francisco Zúñiga M.
     * */
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

        // Se llena un arreglo temporal con todos los sonidos de la categoría escogida
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

        // Se escogen la mitad de los elementos a mostrar del arreglo temporal para agregarlos al
        // arreglo de botones.
        for(int i = 0; i < (numberOfElements / 2); i++)
        {
            buttonGraphics[i] = tempGraphics[i];
            buttonSounds[i] = tempSounds[i];
        }
    }

    @Override
    public void onClick(View v)
    {
        if(isBusy)
            return;

        MemoryButton memoryButton = (MemoryButton)v;

        if(memoryButton.isMatched)
            return;

        // Si no hay ninguna carta volteada, entonces se asigna esta como la primera para luego compararla.
        if(selectedButton1 == null)
        {
            selectedButton1 = memoryButton;
            selectedButton1.flip();
            selectedButton1.playSound();
            return;
        }

        // Si se selecciona una carta que ya está seleccionada, entonces no se hace nada.
        if(selectedButton1.getId() == memoryButton.getId())
            return;

        // Si la carta volteada es igual a la que ya estaba volteada, entonces se dejan volteadas y
        // se aumenta la cantidad de parejas encontradas.
        if(selectedButton1.getFrontDrawableId() == memoryButton.getFrontDrawableId())
        {
            int resourceId = selectedButton1.getFrontDrawableId();

            switch(grade)
            {
                case 2:
                    showObjectName(resourceId);
                    break;
                case 3:
                    showObjectPhrase(resourceId);
                    break;
                default: break;
            }

            memoryButton.flip();
            memoryButton.playSound();
            memoryButton.setMatched(true);
            selectedButton1.setMatched(true);

            selectedButton1.setEnabled(false);
            memoryButton.setEnabled(false);

            selectedButton1 = null;

            counter++;

            // Cuando ya se encontraron todas las parejas, entonces muestra el mensaje de felicitación
            // y además pregunta si quiere volver a jugar
            if(counter == (numberOfElements/2))
            {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.win);
                mp.start();
                AlertDialog alertDialogMessage = createMessage();
                alertDialogMessage.show();
            }

            return;
        }
        // Si las cartas que están volteadas no son iguales, entonces se voltean y se des-seleccionan
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

    /**
     * Crea el mensaje de felicitación y pregunta si quiere continuar jugando.
     *
     * @author Jonathan Fonseca V.
     * @author Francisco Zúñiga M.
     */
    protected AlertDialog createMessage()
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle(R.string.congrats_message_title);
        builder1.setMessage(R.string.congrats_message_body);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                R.string.yes_answer,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        limpiarVariables();
                        startGame();
                    }
                });

        builder1.setNegativeButton(
                R.string.no_answer,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //dialog.cancel();

                        switch (grade)
                        {
                            case 1:
                                goToFirstGradeActivity();
                                break;
                            case 2:
                                goToSecondGradeActivity();
                                break;
                            default:
                                break;
                        }

                    }
                });

        builder1.setNeutralButton(
                R.string.cancel_answer,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        //builder1.setCancelable(true);

        AlertDialog alert1 = builder1.create();

        return alert1;
    }

    /**
     * Limpia las variables para reiniciar el juego.
     *
     * @author Jonathan Fonseca V.
     * @author Francisco Zúñiga M.
     * */
    protected void limpiarVariables()
    {
        numberOfElements = 0;
        isBusy = false;
        counter = 0;
        /*memoryButtons = null;
        buttonGraphicLocations = null;
        buttonGraphics = null;
        buttonSounds = null;
        selectedButton1 = null;
        selectedButton2 = null;*/
        gridLayout.removeAllViewsInLayout();
    }

    /**
     * Redirige al menú de los juegos de primer grado
     *
     * @author Jonathan Fonseca V.
     * @author Francisco Zúñiga M.
     * */
    protected void goToFirstGradeActivity()
    {
        Intent startNewActivity = new Intent(this,FirstGradeActivity.class);
        startActivity(startNewActivity);
    }

    /**
     * Redirige al menú de los juegos de segundo grado.
     *
     * @author Jonathan Fonseca V.
     * @author Francisco Zúñiga M.
     * */
    protected void goToSecondGradeActivity()
    {
        Intent startNewActivity = new Intent(this,SecondGradeActivity.class);
        startActivity(startNewActivity);
    }

    /**
     * Muestra el nombre del objeto de la pareja que se acaba de encontrar.
     *
     * @author Jonathan Fonseca V.
     * @author Francisco Zúñiga M.
     * */
    protected void showObjectName(int resourceId)
    {
        String nameOfResource = getResources().getResourceEntryName(resourceId);
        TextView textView = new TextView(this);
        textView.setText("esto es una prueba para ver si funciona...");
        textView.setTextSize(20);
        textView.setHeight(80);
        textView.setTextColor(Color.BLACK);

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setGravity(Gravity.CENTER_HORIZONTAL);
        params.setMargins(10,15,10,0);

        textView.setLayoutParams(params);

        gridLayout.addView(textView);
    }

    protected void showObjectPhrase(int resourceId)
    {
        String nameOfResource = getResources().getResourceEntryName(resourceId);

        String[] predicates = new String[]
                {
                        " is happy.",
                        " is eating.",
                        " is playing with its friends.",
                        " is sleepy."
                };

        Random rand = new Random();
        int randomIndex = rand.nextInt(predicates.length);

        String phrase = "The " + nameOfResource + predicates[randomIndex];

        TextView textView = new TextView(this);
        textView.setText(phrase);
        textView.setTextSize(20);
        textView.setHeight(80);
        textView.setTextColor(Color.BLACK);

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setGravity(Gravity.CENTER_HORIZONTAL);
        params.setMargins(10, 15, 10, 0);

        textView.setLayoutParams(params);

        GridLayout.Spec rowSpan;
        GridLayout.Spec colspan;

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 2);
            colspan = GridLayout.spec(GridLayout.UNDEFINED, 8);
        }
        else
        {
            rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 4);
            colspan = GridLayout.spec(GridLayout.UNDEFINED, 4);
        }

        GridLayout.LayoutParams gridParam = new GridLayout.LayoutParams(rowSpan, colspan);
        gridLayout.addView(textView, gridParam);
    }
}