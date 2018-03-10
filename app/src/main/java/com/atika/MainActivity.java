package com.atika;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText msg;
    URL url;
    HttpURLConnection con;
    TextView dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = new URL("http://")
        con = (HttpURLConnection) url.openConnection();
        msg = (EditText) findViewById(R.id.messege);
        b = (Button) findViewById(R.id.send);
        dis = (TextView) findViewById(R.id.);
        try {
            InputStream in = getAssets().open("strings.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(in);
            Element element = doc.getDocumentElement();
            element.normalize();
            TextView t = (TextView) doc.getElementsById("display");
            in=new BufferedInputStream(con.getInputStream());
            String rv=in.read();
            dis.setText(t.getText() + "\nSERVER: " +rv);
            b.setOnClickListener(new View.OnClickListener()) {
                public void onClick(View v){
                    String st = msg.getText().toString();
                    byte[] b = st.getBytes();
                    OutputStream out = new BufferedOutputStream(con.getOutputStream());
                    out.write(b);
                    dis.setText(t.getText() + "\nCLIENT: " +st);
                }
            }
        }
    }catch(Exception e){e.printStackTrace();}
     catch(IOException e){(e.printStackTrace();)}
}