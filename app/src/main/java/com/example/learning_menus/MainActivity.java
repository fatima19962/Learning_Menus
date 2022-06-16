package com.example.learning_menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = (Button)findViewById(R.id.testbutton);
        registerForContextMenu(myButton);
    }
//    inflate :convert xml file to view

    public void popupclicklistener(View v){
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId =item.getItemId();
                switch (itemId){
                    case R.id.comedy:
                        Toast.makeText(MainActivity.this,"comedy clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.theatre:
                        Toast.makeText(MainActivity.this,"theatre clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.movie:
                        Toast.makeText(MainActivity.this,"movie clicked",Toast.LENGTH_LONG).show();
                         break;
                }
                return true;
            }
        });

        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"open");
        menu.add(1,1,1,"Exit");
        menu.add(2,2,2,"Hide");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case 0:
                Toast.makeText(this,"open clicked",Toast.LENGTH_LONG).show();
                break;
            case 1:
                finish();
                break;
            case 2:
                Toast.makeText(this,"Hide clicked",Toast.LENGTH_LONG).show();
                break;

        }
        return super.onContextItemSelected(item);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        menu.add(0,0,0,"Quit").setIcon(R.drawable.ic_launcher_background);
        menu.add(1,1,1,"Tools").setIcon(R.drawable.ic_baseline_pan_tool_24);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
//        if (id==R.id.action_settings){
//            return true;
//        }
//        if(id == R.id.action_exit){
//             finish();
//        }
        switch (id){
            case R.id.action_settings:
                break;
            case  R.id.action_exit:
            case 0:
                finish();
            case  1:
                break;

        }
        return  super.onOptionsItemSelected(item);
    }
}