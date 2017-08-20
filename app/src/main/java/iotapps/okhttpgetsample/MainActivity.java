package iotapps.okhttpgetsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    //Point 3: declare variables (point 2 is adding two buttons in App)


    //OkHttpClient client;
   // MediaType JSON;

    Button htmlgetbutton;
    Button jsongetbutton;

    private static final String url = "http://www.google.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // making button on which request will be fired
        htmlgetbutton = (Button) findViewById(R.id.button1);
        jsongetbutton = (Button) findViewById(R.id.button2);



htmlgetbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      Log.d("sdsd","hhhh");

        try {
            doGetRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
});




    }



    void doGetRequest(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();
        //request object from okhttp NOT from other libs
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

              Log.d("Failure","happened");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.d("", response.toString());
                Log.d("",String.valueOf(response.code()));
                Log.d("hhhhhh","hhhh");

            }
        });


    }

}


















