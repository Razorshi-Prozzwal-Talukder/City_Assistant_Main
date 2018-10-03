package com.example.user.androideatit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceSelection extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    TextView place;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_selection);

        place = findViewById(R.id.placeId);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Amelia Script.otf");
        place.setTypeface(face);
    }

    public void sylhetPlace(View view) {
        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.sylhet_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        if(menuItem.getItemId()==R.id.item1){

            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","jaflong");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item2){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","lalakhal");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item3){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","ratargul");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item4){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","khadim");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item5){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","bichanakandi");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item6){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","bholagonj");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item7){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","tanguwarhawor");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item8){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","jadukata");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item9){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","dolura");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item10){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","madhobkundo");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item11){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","lawachora");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item12){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","rema");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item13){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","srimongol");
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.item14){
            intent = new Intent(PlaceSelection.this,PlaceProfile.class);
            intent.putExtra("name","shatchori");
            startActivity(intent);
        }
        return false;
    }


    public void sunamgonjPlace(View view) {
        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.sunamgonj_menu);
        popup.show();
    }

    public void moulvibazarPlace(View view) {
        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.moulvibazar_menu);
        popup.show();
    }

    public void hobigonjPlace(View view) {
        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.hobigonj_menu);
        popup.show();
    }
}
