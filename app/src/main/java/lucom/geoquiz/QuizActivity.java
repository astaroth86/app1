package lucom.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";

    private Button mBotonVerdadero;
    private Button mBotonFalso;
    private ImageButton mBotonSiguiente;
    private ImageButton mBotonAnterior;
    private TextView mTextoPregunta;

    private Pregunta mpreguntas[] = new Pregunta[]{
            new Pregunta(R.string.pregunta_Africa, false),
            new Pregunta(R.string.pregunta_America, false),
            new Pregunta(R.string.pregunta_Asia, false),
            new Pregunta(R.string.pregunta_europa, true),
            new Pregunta(R.string.pregunta_oceania, true),
            new Pregunta(R.string.pregunta_oceanos, false)
    };

    private int mPosicionPregunta = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        mTextoPregunta = (TextView) findViewById(R.id.txt_Quiz_pregunta);
        mTextoPregunta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mPosicionPregunta = (mPosicionPregunta + 1) % mpreguntas.length;
                actualizarPregunta();
            }
        });
        actualizarPregunta();

        mBotonVerdadero = (Button) findViewById(R.id.boton_verdadero);
        mBotonVerdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aquí su acción
                comprobarPregunta(true);
            }
        });

        mBotonFalso = (Button) findViewById(R.id.boton_falso);
        mBotonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aquí su acción
                comprobarPregunta(false);
            }
        });

        mBotonSiguiente = (ImageButton) findViewById(R.id.boton_siguiente);
        mBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aquí su acción
                mPosicionPregunta = (mPosicionPregunta + 1) % mpreguntas.length;
                actualizarPregunta();

            }
        });

        mBotonAnterior = (ImageButton) findViewById(R.id.boton_anterior);
        mBotonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aquí su acción
                if(mPosicionPregunta != 0){
                    mPosicionPregunta = (mPosicionPregunta - 1) % mpreguntas.length;
                    actualizarPregunta();
                }
            }
        });
    }

    private void actualizarPregunta(){
        int pregunta = mpreguntas[mPosicionPregunta].getTextResId();
        mTextoPregunta.setText(pregunta);
    }

    private void comprobarPregunta(boolean presionadoPorUsuario){
        boolean respuestaVerdadera = mpreguntas[mPosicionPregunta].isRespuestaVerdadera();

        int mensajeResId = 0;

        if(presionadoPorUsuario == respuestaVerdadera){
            mensajeResId = R.string.toast_correcto;
        } else {
            mensajeResId = R.string.toast_incorrecto;
        }
        Toast.makeText(QuizActivity.this, mensajeResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
