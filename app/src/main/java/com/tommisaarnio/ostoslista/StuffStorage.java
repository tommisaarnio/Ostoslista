package com.tommisaarnio.ostoslista;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StuffStorage {
    ArrayList<Stuff> stuffList = new ArrayList<>();

    private static StuffStorage stuffStorage = null;

    private StuffStorage(){
    }

    public static StuffStorage getInstance() {
        if (stuffStorage == null) {
            stuffStorage = new StuffStorage();
        }
        return stuffStorage;
    }

    public void addStuff(Stuff stuff){
        stuffList.add(stuff);
    }

    public void saveStuff(Context context){
        try{
            StuffStorage.getInstance().getStuffList();
            ObjectOutputStream stuffWriter = new ObjectOutputStream(context.openFileOutput("item.data", Context.MODE_PRIVATE));
            stuffWriter.writeObject(stuffList);
            stuffWriter.close();
        } catch (IOException e) {
            System.out.println("Ostoksen lisääminen ei onnistunut");
        }
    }

    public ArrayList<Stuff> getStuffList() {
        return stuffList;
    }

    public void removeItem(String name) {
        int i = 0;
        for (Stuff s : stuffList) {
            if (s.getName().equals(name)) {
                break;
            }
            i++;
        }
        stuffList.remove(i);

    }

    public Stuff getStuffByName(int id){
        return stuffList.get(id);
    }

    public void loadStuff(Context context){
        try {
            ObjectInputStream stuffReader = new ObjectInputStream(context.openFileInput("item.data"));
            stuffList = (ArrayList<Stuff>) stuffReader.readObject();
            stuffReader.close();
        } catch (IOException e) {
            System.out.println("Ei onnistu");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
