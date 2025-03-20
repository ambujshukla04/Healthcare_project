package com.example.healthcareproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Goa", "Exp : 5yrs", "Mobile No:9898989898","600"},
                    {"Doctor Name : Prasad pawar", "Hospital Address : Nagpur", "Exp : 15yrs", "Mobile No:7878787878","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898","300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:7898989898","500"},
                    {"Doctor Name : Ambuj Shukla", "Hospital Address : Kanpur", "Exp : 7yrs", "Mobile No:7798989898","800"}
            };

    private String[][] doctor_details2=
            {
                    {"Doctor Name : Jit Saste", "Hospital Address : Nagpur", "Exp : 5yrs", "Mobile No:9898989898","600"},
                    {"Doctor Name : Deshmukh pawar", "Hospital Address : Goa", "Exp : 15yrs", "Mobile No:7878787878","900"},
                    {"Doctor Name : Swapnil Prasad", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898","300"},
                    {"Doctor Name : pakar Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:7898989898","500"},
                    {"Doctor Name : Alok Shukla", "Hospital Address : Kanpur", "Exp : 7yrs", "Mobile No:7798989898","800"}
            };

    private String[][] doctor_details3=
            {
                    {"Doctor Name : Piyush Saste", "Hospital Address : Nagpur", "Exp : 4yrs", "Mobile No:9898989898","600"},
                    {"Doctor Name : Prasad shukla", "Hospital Address : Kanpur", "Exp : 15yrs", "Mobile No:7878787878","900"},
                    {"Doctor Name : Monish Jain", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898","300"},
                    {"Doctor Name : Vishal Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:7898989898","500"},
                    {"Doctor Name : Shrikant Panda", "Hospital Address : Kanpur", "Exp : 7yrs", "Mobile No:7798989898","800"}
            };

    private String[][] doctor_details4=
            {
                    {"Doctor Name : Seema Patil", "Hospital Address : Goa", "Exp : 5yrs", "Mobile No:9898989898","600"},
                    {"Doctor Name : Pranjal pawar", "Hospital Address : Nagpur", "Exp : 15yrs", "Mobile No:7878787878","900"},
                    {"Doctor Name : Swapnil Jain", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898","300"},
                    {"Doctor Name : Deepa Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:7898989898","500"},
                    {"Doctor Name : kale Shukla", "Hospital Address : Kanpur", "Exp : 7yrs", "Mobile No:7798989898","800"}
            };

    private String[][] doctor_details5=
            {
                    {"Doctor Name : Aryan Saste", "Hospital Address : Kanpur", "Exp : 5yrs", "Mobile No:9898989898","600"},
                    {"Doctor Name : Sanda pawar", "Hospital Address : Jaipur", "Exp : 15yrs", "Mobile No:7878787878","900"},
                    {"Doctor Name : Nile Kalegu", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898","300"},
                    {"Doctor Name : Deepika Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:7898989898","500"},
                    {"Doctor Name : Ambuj Shukla", "Hospital Address : Kanpur", "Exp : 7yrs", "Mobile No:7798989898","800"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewHADTitle);
        btn = findViewById(R.id.buttonHADBack);

        Intent it =getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
            if(title.compareTo("Dentist")==0)
        doctor_details = doctor_details3;
        else
            if(title.compareTo("Surgeon")==0)
                doctor_details = doctor_details4;
            else
                doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, Find_Doctor_Activity.class));
            }
        });

            list = new ArrayList();
            for(int i=0;i<doctor_details.length;i++){
                item = new HashMap<String, String>();
                item.put("line1", doctor_details[i][0]);
                item.put("line1", doctor_details[i][1]);
                item.put("line1", doctor_details[i][2]);
                item.put("line1", doctor_details[i][3]);
                item.put("line5", "Cons Fess:"+doctor_details[i][4]+"/-");
                list.add(item);
            }
            sa = new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
            );
        ListView lst = findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}