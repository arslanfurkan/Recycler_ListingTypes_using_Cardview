package com.arslanfurkan.a14_material_recycler_list_sample;

import java.util.ArrayList;

public class Fruit {

    private int imageID;
    private String title;
    private String desc;


    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public  String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ArrayList<Fruit> getDataArrayList(){
        ArrayList<Fruit> arrayList= new ArrayList<Fruit>();

        int [] images ={ R.drawable.armut,R.drawable.avokado,R.drawable.coconut,R.drawable.elma,R.drawable.erik,
                R.drawable.greyfurt,R.drawable.karpuz,R.drawable.kiraz,R.drawable.limon,R.drawable.muz,R.drawable.uzum };

        for (int i=0 ; i < images.length;i++){
            Fruit tempData= new Fruit();
            tempData.setImageID(images[i]);
            tempData.setTitle("Fruit "+i);
            tempData.setDesc("Description "+i);
            arrayList.add(tempData);
        }
        return arrayList;
    }


}
