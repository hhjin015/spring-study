package com.github;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PoolTest {

    List<Resource> pool = new ArrayList<>();

    @Test
    void name() {
        pool.add(new Resource());
        pool.add(new Resource());
        pool.add(new Resource());
        pool.add(new Resource());
        pool.add(new Resource());
        pool.add(new Resource());

        //
        Resource resource = pool.get(selectNoUsing());
        // todo done
        resource.plus(1);
        resource.markAsFree();
        // stateless

        Resource resource1 = pool.get(selectNoUsing());
    }

    private int selectNoUsing() {
        // TODO ..
        return 0;
    }
}

class Resource {


    private boolean isFree;

    public void markAsFree() {
        this.isFree = true;
    }

    public void plus(int i) {
    }
}