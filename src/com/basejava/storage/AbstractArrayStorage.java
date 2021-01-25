package com.basejava.storage;

import com.basejava.exception.ExistStorageException;
import com.basejava.exception.NotExistStorageException;
import com.basejava.exception.StorageException;
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
            throw new NotExistStorageException(r.getUuid());//System.out.println("Resume" + r.toString() + "not found!");
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
            throw new ExistStorageException(r.getUuid());
        } else if(size == STORAGE_LIMIT){
            throw new StorageException("Storage overflow!!!", r.getUuid());
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
            throw new NotExistStorageException(uuid);
        }else{
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }



    public Resume get(String uuid){
        int index = getIndex(uuid);
        if(index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[getIndex(uuid)];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

}

//finish him...