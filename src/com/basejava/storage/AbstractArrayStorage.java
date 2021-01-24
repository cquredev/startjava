package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 1000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT]; //protected
    protected int size = 0;

    public int size(){
        return size;
    }

    public Resume get(String uuid){
        if(getIndex(uuid.toString()) == -1) {
            System.out.println("Resume " + uuid + " not found!");
            return null;
        }
        return storage[getIndex(uuid)];
    }

    protected abstract int getIndex(String uuid);

}

//finish him...