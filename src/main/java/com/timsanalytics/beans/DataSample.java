package com.timsanalytics.beans;

public class DataSample<K, V> {
    private String device;
    private K key;
    private V value;
    private long timestamp;

    public DataSample(String device, K key, V value, long timestamp) {
        this.device = device;
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

