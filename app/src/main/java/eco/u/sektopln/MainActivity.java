package eco.u.sektopln;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final float conversion = 0.41906f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input = (EditText) findViewById(R.id.sek_input);

        TextWatcher inputTextWatcher = new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    TextView output = (TextView) findViewById(R.id.pln_output);

                    float sek =  Float.valueOf(s.toString());
                    output.setText(String.valueOf(sek*conversion));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        input.addTextChangedListener(inputTextWatcher);
    }
}
