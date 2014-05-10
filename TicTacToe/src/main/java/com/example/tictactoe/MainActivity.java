package com.example.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,restartButton;
    ImageView currentPlayerImage;
    boolean isCircle = true, weHaveAWinner = false;
    int CIRCLE = R.drawable.circle;
    int CROSS = R.drawable.cross;
    int currentImage,totalCellsFilled = 0;
    List<Integer> cellValues = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        restartButton = (Button) findViewById(R.id.restartButton);
        currentPlayerImage = (ImageView)findViewById(R.id.currentPlayerImage);

        currentPlayerImage.setBackgroundResource(CIRCLE);
        currentImage = CIRCLE;

        for (int i=0; i<=9; i++) {
            cellValues.add(i,-9+i);
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCellsFilled++;
                button1.setEnabled(false);
                button1.setBackgroundResource(currentImage);
                cellValues.set(1,currentImage);
                checkWinner();
                toggleImage();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCellsFilled++;
                button2.setEnabled(false);
                button2.setBackgroundResource(currentImage);
                cellValues.set(2,currentImage);
                checkWinner();
                toggleImage();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCellsFilled++;
                button3.setEnabled(false);
                button3.setBackgroundResource(currentImage);
                cellValues.set(3,currentImage);
                checkWinner();
                toggleImage();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCellsFilled++;
                button4.setEnabled(false);
                button4.setBackgroundResource(currentImage);
                cellValues.set(4,currentImage);
                checkWinner();
                toggleImage();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCellsFilled++;
                button5.setEnabled(false);
                button5.setBackgroundResource(currentImage);
                cellValues.set(5,currentImage);
                checkWinner();
                toggleImage();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCellsFilled++;
                button6.setEnabled(false);
                button6.setBackgroundResource(currentImage);
                cellValues.set(6,currentImage);
                checkWinner();
                toggleImage();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCellsFilled++;
                button7.setEnabled(false);
                button7.setBackgroundResource(currentImage);
                cellValues.set(7,currentImage);
                checkWinner();
                toggleImage();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCellsFilled++;
                button8.setEnabled(false);
                button8.setBackgroundResource(currentImage);
                cellValues.set(8,currentImage);
                checkWinner();
                toggleImage();
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalCellsFilled++;
                button9.setEnabled(false);
                button9.setBackgroundResource(currentImage);
                cellValues.set(9,currentImage);
                checkWinner();
                toggleImage();
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPlayerImage.setBackgroundResource(CIRCLE);
                currentImage = CIRCLE;
                isCircle = true;
                totalCellsFilled = 0;
                weHaveAWinner = false;

                for (int i=0; i<=9; i++) {
                    cellValues.set(i,-9+i);
                }

                button1.setBackgroundColor(Color.WHITE);
                button2.setBackgroundColor(Color.WHITE);
                button3.setBackgroundColor(Color.WHITE);
                button4.setBackgroundColor(Color.WHITE);
                button5.setBackgroundColor(Color.WHITE);
                button6.setBackgroundColor(Color.WHITE);
                button7.setBackgroundColor(Color.WHITE);
                button8.setBackgroundColor(Color.WHITE);
                button9.setBackgroundColor(Color.WHITE);

                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                button9.setEnabled(true);

                restartButton.setVisibility(View.INVISIBLE);
                restartButton.setEnabled(false);
            }
        });
    }

    private void checkWinner() {
        if (!weHaveAWinner) {
            checkRows();
        }
        if (!weHaveAWinner) {
            checkColumns();
        }
        if (!weHaveAWinner) {
            checkDiagonals();
        }
        if (!weHaveAWinner && totalCellsFilled == 9) {
            Toast.makeText(getApplicationContext(),"It's a draw!", Toast.LENGTH_LONG).show();
            finishGame();
        }
    }

    private void checkRows() {
        if (cellValues.get(1).compareTo(cellValues.get(2)) == 0 &&
                cellValues.get(2).compareTo(cellValues.get(3)) == 0) {
            weHaveAWinner = true;
            int [] buttonArray = new int[3];
            buttonArray[0] = 1;
            buttonArray[1] = 2;
            buttonArray[2] = 3;

            changeImages(buttonArray);
            finishGame();
        } else if (cellValues.get(4).compareTo(cellValues.get(5)) == 0 &&
                cellValues.get(5).compareTo(cellValues.get(6)) == 0) {

            weHaveAWinner = true;
            int [] buttonArray = new int[3];
            buttonArray[0] = 4;
            buttonArray[1] = 5;
            buttonArray[2] = 6;

            changeImages(buttonArray);
            finishGame();
        } else if (cellValues.get(7).compareTo(cellValues.get(8)) == 0 &&
                cellValues.get(8).compareTo(cellValues.get(9)) == 0) {

            weHaveAWinner = true;
            int [] buttonArray = new int[3];
            buttonArray[0] = 7;
            buttonArray[1] = 8;
            buttonArray[2] = 9;

            changeImages(buttonArray);
            finishGame();
        }
    }

    private void checkColumns() {
        if (cellValues.get(1).compareTo(cellValues.get(4)) == 0 &&
                cellValues.get(4).compareTo(cellValues.get(7)) == 0) {

            weHaveAWinner = true;
            int [] buttonArray = new int[3];
            buttonArray[0] = 1;
            buttonArray[1] = 4;
            buttonArray[2] = 7;

            changeImages(buttonArray);
            finishGame();
        } else if (cellValues.get(2).compareTo(cellValues.get(5)) == 0 &&
                cellValues.get(5).compareTo(cellValues.get(8)) == 0) {

            weHaveAWinner = true;
            int [] buttonArray = new int[3];
            buttonArray[0] = 2;
            buttonArray[1] = 5;
            buttonArray[2] = 8;

            changeImages(buttonArray);
            finishGame();
        } else if (cellValues.get(3).compareTo(cellValues.get(6)) == 0 &&
                cellValues.get(6).compareTo(cellValues.get(9)) == 0) {

            weHaveAWinner = true;
            int [] buttonArray = new int[3];
            buttonArray[0] = 3;
            buttonArray[1] = 6;
            buttonArray[2] = 9;

            changeImages(buttonArray);
            finishGame();
        }
    }

    private void checkDiagonals() {
        if (cellValues.get(1).compareTo(cellValues.get(5)) == 0 &&
        cellValues.get(5).compareTo(cellValues.get(9)) == 0) {

            weHaveAWinner = true;
            int [] buttonArray = new int[3];
            buttonArray[0] = 1;
            buttonArray[1] = 5;
            buttonArray[2] = 9;

            changeImages(buttonArray);
            finishGame();
        } else if (cellValues.get(3).compareTo(cellValues.get(5)) == 0 &&
                cellValues.get(5).compareTo(cellValues.get(7)) == 0) {

            weHaveAWinner = true;
            int [] buttonArray = new int[3];
            buttonArray[0] = 3;
            buttonArray[1] = 5;
            buttonArray[2] = 7;

            changeImages(buttonArray);
            finishGame();
        }

    }

    private void finishGame() {

        restartButton.setVisibility(View.VISIBLE);
        restartButton.setEnabled(true);

    }

    private void changeImages(int [] buttonArray) {
        int winImage;
        if (cellValues.get(buttonArray[0]).equals(CIRCLE)) {
            winImage = R.drawable.circlewin;
        } else {
            winImage = R.drawable.crosswin;
        }

        for (int i : buttonArray) {
            switch(i) {
                case 1:
                    button1.setBackgroundResource(winImage);
                    break;
                case 2:
                    button2.setBackgroundResource(winImage);
                    break;
                case 3:
                    button3.setBackgroundResource(winImage);
                    break;
                case 4:
                    button4.setBackgroundResource(winImage);
                    break;
                case 5:
                    button5.setBackgroundResource(winImage);
                    break;
                case 6:
                    button6.setBackgroundResource(winImage);
                    break;
                case 7:
                    button7.setBackgroundResource(winImage);
                    break;
                case 8:
                    button8.setBackgroundResource(winImage);
                    break;
                case 9:
                    button9.setBackgroundResource(winImage);
                    break;
                default:
                    break;
            }
        }
    }

    private void toggleImage() {
        if (isCircle) {
           currentImage = CROSS;
            isCircle = false;
        } else {
            currentImage = CIRCLE;
            isCircle = true;
        }
        currentPlayerImage.setBackgroundResource(currentImage);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
