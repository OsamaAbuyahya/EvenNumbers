package os.abuyahya.testproj2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtStartNum, edtEndNum;
    TextView txtLabelResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtStartNum = findViewById(R.id.edt_stat_num);
        edtEndNum = findViewById(R.id.edt_end_num);
        txtLabelResult = findViewById(R.id.txt_label_result);

        edtStartNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (edtEndNum.getText().toString().isEmpty()){
                    txtLabelResult.setText("Please, Enter End Number");
                }
            }
        });

        edtEndNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!edtEndNum.getText().toString().isEmpty() && !edtStartNum.getText().toString().isEmpty()){
                    int startNum = Integer.parseInt(edtStartNum.getText().toString());
                    int endNum = Integer.parseInt(edtEndNum.getText().toString());

                    if (startNum < endNum)
                        txtLabelResult.setText("The Number of Even is =" + evenNumber(startNum, endNum));
                    else
                        txtLabelResult.setText("Note: start number should be smaller");
                }

            }
        });

    }

    private int evenNumber(int start, int end) {
        return ( end - start + 2 -( start % 2 ) ) / 2;
    }
}
