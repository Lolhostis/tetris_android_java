package fr.iut.dut2.tetris.application.model.designers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.GameOverWindow;
import fr.iut.dut2.tetris.application.views.GrilleWindowActivity;

public class Grille extends View implements Designer {
    private Paint mPaint;
    private Partie partie;
    private int tailleCase;
    private int nbLignes;
    private int nbColonnes;

    private int largeurCase;
    private int hauteurCase;

    public Grille(Context context) {
        super(context);
        init(context);
//        canvas = new Canvas(); //ne doit jamais apparaître
    }

    public Grille(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Grille(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Grille(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        setWillNotDraw(false);
    }

    @Override
    public void dessinerGrille(@NonNull Partie p) { //, Text Score
        partie = p;
        nbLignes = partie.getNbLignes();
        nbColonnes = partie.getNbColonnes();
        tailleCase = 0;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        largeurCase = getMeasuredWidth()/nbColonnes;
        hauteurCase = getMeasuredHeight()/nbLignes;
    }

    //Dessine la grille de jeu (partie.grille)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(nbLignes <= 0 || nbColonnes <= 0) return;

        int typePiece;

        //Dessiner la grille
        for (int y = 0; y < nbLignes; y += 1) {
            for (int x = 0; x < nbColonnes; x += 1) {
                //Dessiner les pieces
                typePiece = partie.getGrille().grille[y][x];
               // mPaint.setColor(paintColor(typePiece));
                changePaintColor(typePiece);
                canvas.drawRect(x * largeurCase, y * hauteurCase, x * largeurCase + largeurCase, y * hauteurCase + hauteurCase, mPaint);

                //Dessiner la grille
                //lignes
                mPaint.setColor(Color.WHITE);
                canvas.drawLine(x * largeurCase, y * hauteurCase, x * largeurCase + largeurCase, y * hauteurCase, mPaint);

                //colones
                canvas.drawLine(x * largeurCase, y * hauteurCase, x * largeurCase, y * hauteurCase + hauteurCase, mPaint);
            }
        }

     //   canvas.drawRect(5 * largeurCase, 10 * hauteurCase, 5 * largeurCase + largeurCase, 10 * hauteurCase + hauteurCase, mPaint);
    }

    public void changePaintColor(int p) {
        int color;
        //pour chaque type p (représenté par un chiffre), on fait correspondre une couleur
        switch (p){
            case 0:
                color = Color.GRAY;
                break;

            case 1:
                color = Color.RED;
                break;

            case 2:
                color = Color.GREEN;
                break;

            case 3:
                color = Color.YELLOW;
                break;

            case 4:
                color = Color.MAGENTA;
                break;

            case 5:
                color = Color.BLUE;
                break;


            // J'ai rajouté ces deux cases (c'est pour ça que les pièces ne s'affichaient pas
            case 6:
                color = Color.CYAN;
                break;

            case 7:
                color = Color.rgb(255,0,128);
                break;

            default:
                color = Color.DKGRAY;
                break;
        };

        mPaint.setColor(color);
        invalidate();
        // requestLayout();
    }
}
