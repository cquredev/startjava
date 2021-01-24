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

    public void save(Resume r){
        if(getIndex(r.toString())!= -1)
        {
            System.out.println("Resume" + r.toString() + "already exist!");
        } else if(size == storage.length){
            System.out.println("Storage overflow!!!");
        }
        else{
            storage[size] = r;
            size++;
        }

    }

    public Resume get(String uuid){
        if(getIndex(uuid.toString()) == -1) {
            System.out.println("Resume " + uuid + " not found!");
            return null;
        }
        return storage[getIndex(uuid)];
    }

    public void delete(String uuid){
        if(getIndex(uuid) == -1) {
            System.out.println("Resume " + uuid + " not exist");
        }else{
            storage[getIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public int size(){
        return size;
    }


    /*public void printAll(){
        for (int i = 0; i < 1000; i++) {
            if(storage[i] != null) {
                System.out.println(storage[i].toString());
            }
            else{
                break;
            }
        }

    }*/

    public Resume[] getAll(){
        Resume[] result = new Resume[size];
        for(int i = 0; i < size; i++)
        {
            result[i] = storage[i];
        }
        return result;
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