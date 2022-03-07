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
    private int hauteurCase;
    private int largeurCase;
    private int nbLignes;
    private int nbColonnes;
    private List<PositionPiece> listePosPiece;

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

    //https://koor.fr/Java/Android/Sudoku.wp

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
    }

    //Dessine la grille de jeu
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //largeur de l'écran
        int width = getMeasuredWidth();
        //hauteur du l'écran
        int height = getMeasuredHeight();

        //largeur du canvas
       // int width = canvas.getWidth();
        //hauteur du canvas
      //  int height = getHeight();

        if(nbLignes <= 0 || nbColonnes <= 0) return;
        largeurCase = width/nbLignes;
        hauteurCase = height/nbColonnes;

       //Dessiner la grille
        //dessiner les colonnes :
        for (int i = 0; i < width; i += largeurCase) {
            canvas.drawLine(i, 0, i, height, mPaint);
        }
        //Dessiner les lignes :
        for (int j = 0; j < height; j += hauteurCase) {
            canvas.drawLine(0, j, width, j, mPaint);
        }

        //Dessiner la pièce
        for (PositionPiece position: listePosPiece) {
            canvas.drawRect(position.getX() * largeurCase, position.getY() * hauteurCase, position.getX() * largeurCase + largeurCase, position.getY() * hauteurCase + hauteurCase, mPaint);
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
                Color.blue(1);
                break;

            case 1:
                Color.red(1);
                break;

            case 2:
                Color.green(1);
                break;
        };


        mPaint.setColor(p);
        invalidate();
      //  requestLayout();
    }
}
