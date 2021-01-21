package com.basejava.storage;

import com.basejava.model.Resume;

public class ArrayStorage {
    private Resume[] storage = new Resume[1000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r){
        int index = getIndex(r.toString());
        if(index == -1){
            System.out.println("Resume" + r.toString() + "not found!");
        }else{
            storage[index] = r;
        }
    }

    public void save(Resume uuid){
        if(getIndex(uuid.toString())!= -1)
        {
            System.out.println("Resume" + uuid.toString() + "already exist!");
        }else{
            storage[size] = uuid;
            size++;
        }

    }

    public Resume get(String uuid){
        if(getIndex(uuid.toString()) == -1) {
            System.out.println("Resume" + uuid + "not found!");
            return null;
        }
        return storage[getIndex(uuid)];
    }

    public void delete(String uuid){
        for(int i = 0; i < 1000; i++) {
            if (uuid == storage[i].toString()) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    public int size(){
        return size;
    }


    public void getAll(){
        for (int i = 0; i < 1000; i++) {
            if(storage[i] != null) {
                System.out.println(storage[i].toString());
            }
            else{
                break;
            }
        }

    }

    public int getIndex(String uuid){
        for (int i = 0; i < size; i++) {
            if(uuid == (storage[i].toString())) {
                return i;
            }
        }
        return -1;
    }
}

//finish him...