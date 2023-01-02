package me.jaromir.mcclicker.Cookie;

public class Sakila {

    public Sakila(String uuid, long cookies, long count) {
        this.uuid = uuid;
        this.cookies = cookies;
        this.count = count;
    }

    private String uuid;
    private long cookies;
    private long count;

    public String getUuid() {
        return uuid;
    }

    public long getCookies() {
        return cookies;
    }

    public long getCount() {
        return count;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setCookies(long cookies) {
        this.cookies = cookies;
    }

    public void setCount(long count) {
        this.count = count;
    }
}

