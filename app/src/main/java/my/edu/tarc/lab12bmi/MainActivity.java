package my.edu.tarc.lab12bmi;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult, textViewImage;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);
        textViewImage = (TextView)findViewById(R.id.textViewImage);
    }

    public void calculateBMI(View view){
        double height = Double.parseDouble(editTextHeight.getText().toString());
        double weight = Double.parseDouble(editTextWeight.getText().toString());
        height /= 100;
        double BMI = (weight / (height * height));
        textViewResult.setText(String.format("BMI : %.2f", BMI));
        if (BMI <= 18.5){
            imageViewResult.setImageResource(R.drawable.under);
            textViewImage.setText("Under Weight");
        }
        else if (BMI >= 25){
            imageViewResult.setImageResource(R.drawable.over);
            textViewImage.setText("Over Weight");
        }
        else{
            imageViewResult.setImageResource(R.drawable.normal);
            textViewImage.setText("Normal Weight");
        }
    }

    public void resetView(View view){
        editTextWeight.setText("");
        editTextHeight.setText("");
        textViewResult.setText("BMI :");
        imageViewResult.setImageResource(R.drawable.empty);
        textViewImage.setText("");
    }
}
