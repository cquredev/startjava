package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.Arrays;

public class ArrayStorage implements Storage {

    private static final int STORAGE_LIMIT = 1000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
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
        } else if(size == STORAGE_LIMIT){
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
        return Arrays.copyOfRange(storage,0, size);
    }

    private int getIndex(String uuid){
        for (int i = 0; i < size; i++) {
            if(uuid == (storage[i].toString())) {
                return i;
            }
        }
        return -1;
    }
}

//finish him...