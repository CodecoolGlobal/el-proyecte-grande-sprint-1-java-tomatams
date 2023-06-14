package com.codecool.elproyectegrandesprint.javatomatams.model;

public enum CookingTime {
    SHORT(0, 29),
    MEDIUM(30, 59),
    LONG(60, 89),
    EXTRA_LONG (90, 10000);

    private int min;
    private int max;
    CookingTime(int min, int max){
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
