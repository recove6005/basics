package com.example.springproject.test;

import java.util.*;

public class MyCollection {
    private ArrayList<Integer> arrayList;
    private Set<Integer> hashSet;
    private Map<String, Integer> hashMap;
    private Properties properties;

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public Set<Integer> getHashSet() {
        return hashSet;
    }

    public Map<String, Integer> getHashMap() {
        return hashMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public void setHashSet(Set<Integer> hashSet) {
        this.hashSet = hashSet;
    }

    public void setHashMap(Map<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
