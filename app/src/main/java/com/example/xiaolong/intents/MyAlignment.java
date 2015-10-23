package com.example.xiaolong.intents;

/**
 * Created by xiaolong on 16.10.15.
 */
public enum MyAlignment {
    LEFT("left"),
    CENTER("center"),
    RIGHT("right");

    private final String text;

    /**
     * @param text
     */
    MyAlignment(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
