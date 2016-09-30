package br.com.devmaker.picasso;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import br.com.devmaker.picasso.util.Constants;
import br.com.devmaker.picasso.util.ImageWarehouse;

public class MainActivity extends AppCompatActivity {

    public  String URL = "http://amovitrine.devmaker.com.br/files/lojas/122/loja2016042557.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView image = (ImageView) findViewById(R.id.imageView);

        Picasso
                .with(this)
                .load("http://amovitrine.devmaker.com.br/files/lojas/122/loja2016042557.jpg")
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(image, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        // Try again online if cache failed
                        Picasso.with(getBaseContext())
                                .load(Uri.parse("http://amovitrine.devmaker.com.br/files/lojas/122/loja2016042557.jpg"))
                                .placeholder(R.drawable.placeholder)
                                .error(R.drawable.placeholder)
                                .into(image);
                    }
                    });

    }

}
