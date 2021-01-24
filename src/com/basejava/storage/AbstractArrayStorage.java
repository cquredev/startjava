package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 1000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT]; //protected
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r){
        int index = getIndex(r.toString());
        if(index < 0){
            System.out.println("Resume" + r.toString() + "not found!");
        }else{
            storage[index] = r;
        }
    }

    public Resume[] getAll(){
        return Arrays.copyOfRange(storage,0, size);
    }

    public void save(Resume r){
        int index = getIndex(r.toString());
        if(index > 0)
        {
            System.out.println("Resume" + r.toString() + "already exist!");
        } else if(size == STORAGE_LIMIT){
            System.out.println("Storage overflow!!!");
        }
        else{
            insertElement(r, index);
            size++;
        }

    }



    public int size(){
        return size;
    }

    public void delete(String uuid){
        int index = getIndex(uuid);
        if(index < 0) {
            System.out.println("Resume " + uuid + " not exist");
        }else{
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }



    public Resume get(String uuid){
        int index = getIndex(uuid);
        if(index < 0) {
            System.out.println("Resume " + uuid + " not found!");
            return null;
        }
        return storage[getIndex(uuid)];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

}

//finish him...