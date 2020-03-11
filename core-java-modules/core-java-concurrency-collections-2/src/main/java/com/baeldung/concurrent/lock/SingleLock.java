package com.baeldung.concurrent.lock;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.base.Supplier;

public class SingleLock extends ConcurrentAccessExperiment {
    ReentrantLock lock;

    public SingleLock() {
        lock = new ReentrantLock();
    }

    protected synchronized Supplier<?> putSupplier(Map<String,String> map, int key) {
        return (()-> {
            try {
                lock.lock();
                map.put("key" + key, "value" + key);
            } catch (Exception e) {
                this.putSupplier(map, key);
            } finally {
                try {
                    lock.unlock();
                } catch (Exception e) {}            }
            return null;
        });
    }

    protected synchronized Supplier<?> getSupplier(Map<String,String> map, int key) {
        return (()-> {
            try {
                lock.lock();
                map.get("key" + key);
            } catch (Exception e) {
                this.getSupplier(map, key);
            } finally {
                try {
                    lock.unlock();
                } catch (Exception e) {}            }
            return null;
        });
    }
}
