package fr.iut.dut2.tetris.application.model.designers;

import android.content.Context;
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

public class Grille extends View implements Designer {
    private Paint mPaint;
    private Partie partie;
    private int tailleCase;
    private int nbLignes;
    private int nbColonnes;
    private List<Coordonates> listePosPiece;
    private int color;

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
        listePosPiece = new ArrayList<>();
        tailleCase = 0;
        //System.out.println();
    }

    //Dessine la grille de jeu (partie.grille)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //largeur de l'écran
        int width = getMeasuredWidth();
        //hauteur du l'écran
        int height = getMeasuredHeight();

        int largeurCase;
        int hauteurCase;

        //On prend en référence le plus petit, donc ici la largeur
        //largeur du canvas
        // int width = canvas.getWidth();
        //hauteur du canvas
        //  int height = getHeight();
        mPaint.setColor(Color.BLACK);

        if(nbLignes <= 0 || nbColonnes <= 0) return;

        largeurCase = width/nbLignes;
        hauteurCase = height/nbColonnes;

        //pour faire des carrés :
        /*
        if(width<height){
            tailleCase = width/nbLignes;
        }else{
            tailleCase = height/nbColonnes;
        }
         */

        int typePiece;

        //Dessiner la grille
        for (int x = 0; x < nbLignes; x += 1) {
            for (int y = 0; y < nbColonnes; y += 1) {
                //Dessiner la grille
                //lignes
                canvas.drawLine(x * largeurCase, y * hauteurCase, x * largeurCase + largeurCase, y * hauteurCase, mPaint);

                //colones
                canvas.drawLine(x * largeurCase, y * hauteurCase, x * largeurCase, y * hauteurCase + hauteurCase, mPaint);

                //Dessiner les pieces

                typePiece = partie.getGrille().grille[x][y];
                paintColor(typePiece);
            //    mPaint.setColor(color);
                canvas.drawRect(x * largeurCase, y * hauteurCase, x * largeurCase + largeurCase, y * hauteurCase + hauteurCase, mPaint);
            }
        }
    }

    public void paintColor(int p) {
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

            default:
                color = Color.DKGRAY;
                break;
        };

        mPaint.setColor(p);
        invalidate();
        //  requestLayout();
    }
}
