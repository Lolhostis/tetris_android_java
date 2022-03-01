package fr.iut.dut2.tetris.application.model.designers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

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
//        canvas = new Canvas();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
    }

    //https://koor.fr/Java/Android/Sudoku.wp

    /*
   public Designer(View view) {
       // super(view);
    }
     */
    @Override
    public void dessinerGrille(@NonNull Partie p, Text Score) {
        partie = p;
        nbLignes = partie.getNbLignes();
        nbColonnes = partie.getNbColonnes();
    }

    //Dessine la grille de jeu
    @Override
    protected void onDraw(Canvas canvas) {
        // this.canvas = canvas;
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        //2. pour chqaue object du modele, le dessiner
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
            canvas.drawRect(position.getX() * largeurCase, position.getY() * hauteurCase, largeurCase, hauteurCase, mPaint);
        }
    }

    @Override
    public void dessinerPiece(int p, List<PositionPiece> listeRectanglesPiece) {
        for (PositionPiece position : listeRectanglesPiece) {
            this.listePosPiece.add(position);
        }
        /*
        Color c = switch (p) {
            case 0 -> Color.GRAY;
            case 1 -> Color.RED;
            case 2 -> Color.GREEN;
            case 3 -> Color.YELLOW;
            case 4 -> Color.MAGENTA;
            case 5 -> Color.BLUE;
            default -> Color.BLACK;
        };
         */

        mPaint.setColor(p);
        invalidate();

    }
}
