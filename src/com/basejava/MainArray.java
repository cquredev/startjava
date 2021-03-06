package com.basejava;

import com.basejava.model.Resume;
import com.basejava.storage.ArrayStorage;
import com.basejava.storage.Storage;


public class MainArray {
    private final static Storage ARRAY_STORAGE = new ArrayStorage(); //Storage

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1");
        //r1.setUuid("uuid1");
        final Resume r2 = new Resume("uuid2");
        //r2.setUuid("uuid2");
        final Resume r3 = new Resume("uuid3");
        //r3.setUuid("uuid3");

        System.out.println(r1 == r2);

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1 " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        //System.out.println("Index of r2: " + Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r2));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size " + ARRAY_STORAGE.size());
    }

    static void printAll(){
        System.out.println("\nGet ALL!");
        for(Resume r : ARRAY_STORAGE.getAll()){
            System.out.println(r);
        }
    }
}
