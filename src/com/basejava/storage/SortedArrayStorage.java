package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {



    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        //searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertElement(Resume r, int index) {
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if(numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
        /*for(int i = index; i < size(); i++) {
            storage[i] = storage[i + 1];
        }*/
    }
}
