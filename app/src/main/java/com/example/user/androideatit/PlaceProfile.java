package com.example.user.androideatit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceProfile extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_profile);

        imageView = findViewById(R.id.placeImageId);
        textView = findViewById(R.id.placetextId);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            String placeName = bundle.getString("name");
            showDetails(placeName);
        }
    }

    private void showDetails(String placeName) {
        if(placeName.equals("jaflong")){
            imageView.setImageResource(R.drawable.jaflong);
            textView.setText(R.string.jaflong);
        }

        if(placeName.equals("lalakhal")){
            imageView.setImageResource(R.drawable.lalakhal);
            textView.setText(R.string.lalakhal);
        }

        if(placeName.equals("ratargul")){
            imageView.setImageResource(R.drawable.ratargul);
            textView.setText(R.string.ratargul);
        }

        if(placeName.equals("khadim")){
            imageView.setImageResource(R.drawable.khadim);
            textView.setText(R.string.khadim);
        }

        if(placeName.equals("bichanakandi")){
            imageView.setImageResource(R.drawable.bichanakandi);
            textView.setText(R.string.bichanakandi);
        }

        if(placeName.equals("bholagonj")){
            imageView.setImageResource(R.drawable.bholagonj);
            textView.setText(R.string.bholagonj);
        }

        if(placeName.equals("tanguwarhawor")){
            imageView.setImageResource(R.drawable.tanguwarhawor);
            textView.setText(R.string.tanguwarhawor);
        }

        if(placeName.equals("jadukata")){
            imageView.setImageResource(R.drawable.jadukata);
            textView.setText(R.string.jadukata);
        }

        if(placeName.equals("dolura")){
            imageView.setImageResource(R.drawable.dolura);
            textView.setText(R.string.dolura);
        }

        if(placeName.equals("shatchori")){
            imageView.setImageResource(R.drawable.shatchori);
            textView.setText(R.string.shatchori);
        }

        if(placeName.equals("madhobkundo")){
            imageView.setImageResource(R.drawable.madhobkundo);
            textView.setText(R.string.madhobkundo);
        }

        if(placeName.equals("lawachora")){
            imageView.setImageResource(R.drawable.lawachora);
            textView.setText(R.string.lawachora);
        }

        if(placeName.equals("rema")){
            imageView.setImageResource(R.drawable.rema);
            textView.setText(R.string.rema);
        }

        if(placeName.equals("srimongol")){
            imageView.setImageResource(R.drawable.srimongol);
            textView.setText(R.string.srimongol);
        }


//        if(placeName.equals("dibirhawor")){
//            imageView.setImageResource(R.drawable.dibirhawor);
//            textView.setText(R.string.dibirhawor);
//        }
        if(placeName.equals("humhum")){
            imageView.setImageResource(R.drawable.humhum);
            textView.setText(R.string.humhum);
        }
        if(placeName.equals("madhobpurlake")){
            imageView.setImageResource(R.drawable.madhobpurlake);
            textView.setText(R.string.madhobpurlake);
        }
//        if(placeName.equals("komolarani")){
//            imageView.setImageResource(R.drawable.komolarani);
//            textView.setText(R.string.komolarani);
//        }
        if(placeName.equals("sankarpasha")){
            imageView.setImageResource(R.drawable.songkorpasha);
            textView.setText(R.string.sankarpasha);
        }
        if(placeName.equals("simulbagan")){
            imageView.setImageResource(R.drawable.simulbagan);
            textView.setText(R.string.simulbagan);
        }
        if(placeName.equals("hasonraja")){
            imageView.setImageResource(R.drawable.hasonraja);
            textView.setText(R.string.hasonraja);
        }
        if(placeName.equals("barikka")){
            imageView.setImageResource(R.drawable.barikka);
            textView.setText(R.string.barikka);
        }
        if(placeName.equals("niladri")){
            imageView.setImageResource(R.drawable.niladri);
            textView.setText(R.string.niladri);
        }
    }
}
