package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {











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



    protected int getIndex(String uuid){
        for (int i = 0; i < size; i++) {
            if(uuid.equals(storage[i].toString())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertElement(Resume r, int index) {
        storage[size] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }
}

//finish him...