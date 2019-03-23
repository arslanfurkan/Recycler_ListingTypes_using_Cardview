package com.arslanfurkan.a14_material_recycler_list_sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransitionImpl;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomRWAdapter extends RecyclerView.Adapter<MyCustomRWAdapter.MyViewHolder> {
    ArrayList<Fruit> mDataList ;
    LayoutInflater inflater;
    Context context;
    public MyCustomRWAdapter(Context context, ArrayList<Fruit> mDataList){
        this.context=context;
        //inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater=LayoutInflater.from(this.context);
        this.mDataList=mDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Elle yapılan başlangıç Inflate işlemleri burda otomatik yapılır. VBu da RecyclerViewin güzel yanlarından!
        Log.e("Furkan","onCreateViewHolder cagrildi!");
        View v = inflater.inflate(R.layout.list_item_cardview,viewGroup,false);
        MyViewHolder holder= new MyViewHolder(v);

        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Log.e("Furkan","onBindViewHolder cagrildi!");
                Fruit nextObj= mDataList.get(i);
                myViewHolder.setData(nextObj,i);

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    public void deleteItem (int position){
        mDataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mDataList.size());//DEMEZSEK elemanlarin pozisyon değerleri hep sabit kalacaktır.
        // Aşağıdaki metod yukardaki 2 satır kodun yaptığı işleri yapar fakat çok kaynak tüketir ve animasyon göstermez!(silme animasyonu falan)
        //notifyDataSetChanged(); // Bütün değişikleri kontrol eder ama çok maliyetli bir işlem yapar
    }
    public void copyItem (int position, Fruit copiedItem){
        mDataList.add(position,copiedItem);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,mDataList.size());//DEMEZSEK elemanlarin pozisyon değerleri hep sabit kalacaktır.
    }

    //INNER CLASS VIEWHOLDER
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImage,mDelete,mCopy;
        TextView mTitle;
        TextView mDesc;
        int activeItemPosition=0;
        Fruit copyOfActiveItem;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle= itemView.findViewById(R.id.text1);
            mDesc= itemView.findViewById(R.id.text2);
            mImage= itemView.findViewById(R.id.imageFruit);
            mDelete= itemView.findViewById(R.id.delete);
            mCopy = itemView.findViewById(R.id.copy);

            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d("Furkan","Silmeden önceki position:"+activeItemPosition+" Eleman sayisi"+mDataList.size());
                        deleteItem(activeItemPosition);
                    Log.d("Furkan","Silmeden sonraki position:"+activeItemPosition+" Eleman sayisi"+mDataList.size());
                }
            });
            mCopy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Furkan","Kopyalamdan önceki position:"+activeItemPosition+" Eleman sayisi"+mDataList.size());
                        copyItem(activeItemPosition,copyOfActiveItem);
                    Log.d("Furkan","Kopyalamdan sonraki position:"+activeItemPosition+" Eleman sayisi"+mDataList.size());
                }
            });
        }

        public void setData(Fruit obj, int position){
            mTitle.setText(obj.getTitle());
            mDesc.setText(obj.getDesc());
            mImage.setImageResource(obj.getImageID());
            this.activeItemPosition=position;
            copyOfActiveItem=obj;
        }
    }
}

