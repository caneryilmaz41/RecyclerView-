package com.caneryilmaz.recyclervievkulanimi;

import java.util.ArrayList;

public class Meyveler {
    private String name;
    private int kalori;
    private int mImage;

    public Meyveler(){}

    public Meyveler(String name, int kalori, int mImage) {
        this.name = name;
        this.kalori = kalori;
        this.mImage = mImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKalori() {
        return kalori;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
    static public ArrayList<Meyveler> getData(){
        ArrayList<Meyveler>meyvelerList=new ArrayList<Meyveler>();
        String[] meyveler={"Çilek","Muz","Karpuz","Nar"};
        int[] kalori={15,60,10,40};
        int[]resimler={R.drawable.cilek,R.drawable.muz,R.drawable.karpuz,R.drawable.nar};
        for (int i =0;i<meyveler.length;i++ ){
            Meyveler meyve=new Meyveler();
            meyve.setName(meyveler[i]);
            meyve.setKalori(kalori[i]);
            meyve.setmImage(resimler[i]);
            meyvelerList.add(meyve);

        }
        return meyvelerList;

    }





}
