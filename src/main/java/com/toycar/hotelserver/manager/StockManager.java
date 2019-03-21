package com.toycar.hotelserver.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class StockManager {
    private static Map<String, ReentrantLock> roomMap = new ConcurrentHashMap<>();

    private static ReentrantLock getLock(String stockName){
        ReentrantLock lock = null;
        if (roomMap.containsKey(stockName)){
            lock = roomMap.get(stockName);
        }
        if (lock == null){
            lock = new ReentrantLock(false);
            roomMap.put(stockName,lock);
        }
        return lock;
    }

    public static boolean lockRoom(String roomId){
        ReentrantLock lock = getLock(roomId);
        return lock.tryLock();
    }

    public static void releaseRoom(String roomId){
        ReentrantLock lock = getLock(roomId);
        if (lock.isHeldByCurrentThread() && lock.isLocked()){
            lock.unlock();
        }
    }
}
