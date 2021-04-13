package com.suthar.jay.testapp;

class mRectangle {
    int length, width, originX, originY;

    mRectangle() {
        length = 0;
        width = 0;
        originX = 0;
        originY = 0;
    }

    mRectangle(int l, int w, int originX, int originY) {
        length = l;
        width = w;
        this.originX = originX;
        this.originY = originY;
    }

    boolean contains(int x, int y) {
        if (x >= this.originX) {
            if (x <= (this.originX + this.width)) {
                if (y >= this.originY) {
                    return y <= (this.originY + this.length);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}