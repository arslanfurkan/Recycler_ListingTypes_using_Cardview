package com.arslanfurkan.a14_material_recycler_list_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;

   // UYARI BU RECYCLERVIEW VE CARDVIEW kütüphanelerini implemente etmen gerekir!!!!!!!!!!!!!!!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerview);
        MyCustomRWAdapter adapter= new MyCustomRWAdapter(this,Fruit.getDataArrayList());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager llmanager= new LinearLayoutManager(this);
        llmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llmanager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.linearViewHorizontal:
                LinearLayoutManager manager1= new LinearLayoutManager(this);
                manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(manager1);
                break;
            case R.id.linearViewVertical:
                LinearLayoutManager manager2= new LinearLayoutManager(this);
                manager2.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager2);
                break;
            case R.id.gridView:
                GridLayoutManager manager3= new GridLayoutManager(this,3);
                recyclerView.setLayoutManager(manager3);
                break;
            case R.id.staggeredViewHorizontal:
                StaggeredGridLayoutManager manager4= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(manager4);
                break;
            case R.id.staggeredViewVertical:
                StaggeredGridLayoutManager manager5= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager5);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
