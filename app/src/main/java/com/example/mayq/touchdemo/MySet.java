package com.example.mayq.touchdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by mayq on 2016/12/2.
 */

public class MySet {
    private HashMap<Integer, Finger> map = new HashMap<>();

    public void add(Finger obj) {
        if (!map.containsKey(obj.getId()))
            map.put(obj.getId(), obj);
    }

    public void update(int id, float x, float y) {
        map.remove(id);
        map.put(id, new Finger(id, x, y));
    }

    public void remove(int id) {
        map.remove(id);
    }

    public List<Finger> getAll() {
        List<Finger> result = new ArrayList<>();

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            result.add((Finger) pair.getValue());
        }

        return result;
    }
}
