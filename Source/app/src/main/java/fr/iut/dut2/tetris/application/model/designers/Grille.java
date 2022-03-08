package fr.iut.dut2.tetris.application.model.designers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.PieceBase;

public class Grille extends View implements Designer {
    private Paint mPaint;
    private Partie partie;
    private int tailleCase;
    private int nbLignes;
    private int nbColonnes;
    private List<PositionPiece> listePosPiece;
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

    /*
   public Designer(View view) {
       // super(view);
    }
     */
    @Override
    public void dessinerGrille(@NonNull Partie p) { //, Text Score
        partie = p;
        nbLignes = partie.getNbLignes();
        nbColonnes = partie.getNbColonnes();
        listePosPiece = new ArrayList<>();
        tailleCase = 0;
    }

    //Dessine la grille de jeu
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //largeur de l'écran
        int width = getMeasuredWidth();
        //hauteur du l'écran
        int height = getMeasuredHeight();

        //On prend en référence le plus petit, donc ici la largeur
        //largeur du canvas
        // int width = canvas.getWidth();
        //hauteur du canvas
        //  int height = getHeight();
        mPaint.setColor(Color.BLACK);

        if(nbLignes <= 0 || nbColonnes <= 0) return;

        if(width<height){
            tailleCase = width/nbLignes;
        }else{
            tailleCase = height/nbColonnes;
        }

        //Dessiner la grille
        //dessiner les colonnes :
        /*
        for (int i = 0; i < width; i += tailleCase) { //largeurCase
            canvas.drawLine(i, 0, i, height, mPaint);
        }
        //Dessiner les lignes :
        for (int j = 0; j < height; j += tailleCase) { // hauteurCase
            canvas.drawLine(0, j, width, j, mPaint);
        }


         for (int i = 0; i < nbLignes; i += 1) { //largeurCase
            canvas.drawLine(i * tailleCase, 0, i * tailleCase, height, mPaint);
        }

        for (int j = 0; j < nbColonnes; j += 1) {
            canvas.drawLine(0, j * tailleCase, width, j * tailleCase, mPaint);
        }

         */

        for (int y = 0; y <= nbLignes; y += 1) {
            for (int x = 1; x <= nbColonnes; x += 1) {
                canvas.drawLine(y * tailleCase, x, y * tailleCase, x * tailleCase, mPaint);
            }
        }

        for (int j = 0; j <= nbColonnes; j += 1) {
            canvas.drawLine(0, j * tailleCase, width, j * tailleCase, mPaint);
        }

        /*
        for (int i = 1; i <= nbLignes; i += 1) {
            for (int j = 1; j <= nbColonnes; j += 1) {
                canvas.drawLine(j, i * tailleCase , i * tailleCase + tailleCase, i * tailleCase, mPaint);
            }
        }
         */


        mPaint.setColor(color);
        //Dessiner la pièce
        for (PositionPiece position: listePosPiece) {
            //canvas.drawRect(position.getX() * largeurCase, position.getY() * hauteurCase, position.getX() * largeurCase + largeurCase, position.getY() * hauteurCase + hauteurCase, mPaint);
            canvas.drawRect(position.getX() * tailleCase, position.getY() * tailleCase, position.getX() * tailleCase + tailleCase, position.getY() * tailleCase + tailleCase, mPaint);
        }
    }

    @Override
    public void dessinerPiece(int p, List<PositionPiece> listeRectanglesPiece) {
        if(listeRectanglesPiece == null) return;
        for (PositionPiece position : listeRectanglesPiece) {
            this.listePosPiece.add(position);
        }

        switch (p){
            case 0:
                color = Color.BLUE;
                break;

            case 1:
                color = Color.RED;
                break;

            case 2:
                color = Color.GREEN;
                break;
        };

        mPaint.setColor(p);
        invalidate();
      //  requestLayout();
    }
}
