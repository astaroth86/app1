package lucom.geoquiz;

/**
 * Created by astaroth on 19/01/16.
 */
public class Pregunta {
    private int mTextResId;
    private boolean mRespuestaVerdadera;

    public Pregunta(int textResId, boolean respuestaVerdadera){
        mTextResId = textResId;
        mRespuestaVerdadera = respuestaVerdadera;
    }

    public boolean isRespuestaVerdadera() {
        return mRespuestaVerdadera;
    }

    public void setRespuestaVerdadera(boolean respuestaVerdadera) {
        mRespuestaVerdadera = respuestaVerdadera;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }
}
