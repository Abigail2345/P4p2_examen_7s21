package mx.edu.isc.tesoem.arz.p4p2_examen_7s21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import DatosExamen.EstructuraDatos;

public class PrincipalActivity extends AppCompatActivity {

    TextView txtpregunta;
    RadioButton r1, r2, r3;

    Button btnant, btnsig, btncal;

    int rastrear = 0; // Agrega esta variable para rastrear el índice de la pregunta actual
    int puntaje = 0;
    int respuestasCorrectas = 0;
    ArrayList<EstructuraDatos> listadatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtpregunta = findViewById(R.id.txtpregunta);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);

        btnant = findViewById(R.id.btnant);
        btnsig = findViewById(R.id.btnsig);
        btncal = findViewById(R.id.btncal);

        EstructuraDatos ed = new EstructuraDatos();

        ed.setPregunta("1.- ¿Quién escribió Romeo y Julieta?");
        ed.setR1("A) Charles Dickens");
        ed.setR2("B) Jane Austen");
        ed.setR3("C) William Shakespeare");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("2.- ¿Cuál es el metal líquido a temperatura ambiente?");
        ed.setR1("A)  Mercurio");
        ed.setR2("B)  Hierro");
        ed.setR3("C)  Aluminio");
        ed.setRc("A");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("3.- ¿En qué continente se encuentra el desierto del Sahara?");
        ed.setR1("A)  América del Norte");
        ed.setR2("B)  África");
        ed.setR3("C) Asia");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("4.- ¿Cuál es la capital de Francia?");
        ed.setR1("A) París");
        ed.setR2("B) Madrid");
        ed.setR3("C) Roma");
        ed.setRc("A");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("5.- ¿Cuál es el proceso de conversión de la comida en energía en el cuerpo?");
        ed.setR1("A)  Respiración");
        ed.setR2("B) Fotosíntesis");
        ed.setR3("C) Digestión");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("6.- ¿Cuál es el planeta más cercano al Sol?");
        ed.setR1("A) Marte");
        ed.setR2("B) Venus");
        ed.setR3("C) Mercurio");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("7.- ¿Quién pintó La noche estrellada?");
        ed.setR1("A) Pablo Picasso");
        ed.setR2("B)  Salvador Dalí");
        ed.setR3("C) Vincent van Gogh");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("8.- ¿Cuál es la montaña más alta del mundo?");
        ed.setR1("A) Monte Kilimanjaro");
        ed.setR2("B) Monte Everest");
        ed.setR3("C) Montaña del Himalaya");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("9.- ¿Quién fue el primer presidente de los Estados Unidos?");
        ed.setR1("A) Thomas Jefferson");
        ed.setR2("B) George Washington");
        ed.setR3("C) John Adams");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("10.- ¿Cuál es el río que atraviesa Egipto?");
        ed.setR1("A) Río Amazonas");
        ed.setR2("B) Río Danubio");
        ed.setR3("C) Río Nilo");
        ed.setRc("C");
        listadatos.add(ed);
        EstructuraDatos edm = listadatos.get(0);
        //Log.i("informacion", "valor: " + edm.getPregunta());
        txtpregunta.setText(edm.getPregunta());
        r1.setText(edm.getR1());
        r2.setText(edm.getR2());
        r3.setText(edm.getR3());

        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si se ha seleccionado una respuesta antes de avanzar
                String respuestaSeleccionada = obtenerRespuesta();
                if (respuestaSeleccionada != null) {
                    listadatos.get(rastrear).setRespuestaSeleccionada(respuestaSeleccionada);
                }

                rastrear++;

                if (rastrear< listadatos.size()) {
                    EstructuraDatos nextQuestion = listadatos.get(rastrear);
                    txtpregunta.setText(nextQuestion.getPregunta());
                    r1.setText(nextQuestion.getR1());
                    r2.setText(nextQuestion.getR2());
                    r3.setText(nextQuestion.getR3());

                    // Limpia la selección de respuestas
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                }
            }
        });

        btnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rastrear--;

                if (rastrear >= 0 && rastrear < listadatos.size()) {
                    EstructuraDatos previousQuestion = listadatos.get(rastrear);
                    txtpregunta.setText(previousQuestion.getPregunta());
                    r1.setText(previousQuestion.getR1());
                    r2.setText(previousQuestion.getR2());
                    r3.setText(previousQuestion.getR3());

                    // Limpia la selección de respuestas
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                }
            }
        });


        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Califica la pregunta actual si se ha seleccionado una respuesta
                if (rastrear >= 0 && rastrear < listadatos.size()) {
                    EstructuraDatos preguntaActual = listadatos.get(rastrear);
                    String respuestaSeleccionada = obtenerRespuesta();

                    if (respuestaSeleccionada != null) {
                        preguntaActual.setRespuestaSeleccionada(respuestaSeleccionada);
                    }
                }
                puntaje = 0; // Reinicia el puntaje cada vez que se califica
                respuestasCorrectas = 0; // Reinicia el contador de respuestas correctas

                // Califica todas las preguntas y cuenta las respuestas correctas
                for (EstructuraDatos pregunta : listadatos) {
                    String respuestaSeleccionadaPregunta = pregunta.getRespuestaSeleccionada();

                    if (respuestaSeleccionadaPregunta != null) {
                        if (respuestaSeleccionadaPregunta.equals(pregunta.getRc())) {
                            // Respuesta correcta
                            puntaje++; // Aumenta el puntaje
                            respuestasCorrectas++;
                        }
                    }
                }
                Toast.makeText(PrincipalActivity.this, "Puntaje total: " + puntaje + " de 10 preguntas. Respuestas correctas: " + respuestasCorrectas, Toast.LENGTH_LONG).show();
            }
        });
    }

    private String obtenerRespuesta() {
        if (r1.isChecked()) {
            return "A";
        } else if (r2.isChecked()) {
            return "B";
        } else if (r3.isChecked()) {
            return "C";
        } else {
            return null; // Ninguna respuesta seleccionada
        }
    }

}