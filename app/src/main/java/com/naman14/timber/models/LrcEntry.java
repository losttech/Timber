/*
 * Copyright (C) 2017 wangchenyan
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.naman14.timber.models;

import android.text.TextUtils;

/**
 * 一行歌词实体
 */
public class LrcEntry implements Comparable<LrcEntry> {
    private long time;
    private String text;
    private String secondText;
    /**
     * 歌词距离视图顶部的距离
     */
    private float offset = Float.MIN_VALUE;

    public LrcEntry(long time, String text) {
        this.time = time;
        this.text = text;
    }
    public LrcEntry(long time, String text, String secondText) {
        this.time = time;
        this.text = text;
        this.secondText = secondText;
    }
    /**
     * Start time, in milliseconds.
     */
    public long getTime() {
        return time;
    }

    public LrcEntry setTime(long timeMs) {
        this.time = timeMs;
        return this;
    }

    public float getOffset() {
        return offset;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }

    public String getText() {
        return text;
    }


    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }

    private String getShowText() {
        if (!TextUtils.isEmpty(secondText)) {
            return text + "\n" + secondText;
        } else {
            return text;
        }
    }

    @Override
    public int compareTo(LrcEntry entry) {
        if (entry == null) {
            return -1;
        }
        return (int) (time - entry.getTime());
    }
}
