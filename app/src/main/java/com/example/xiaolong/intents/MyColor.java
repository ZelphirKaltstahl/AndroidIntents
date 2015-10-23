package com.example.xiaolong.intents;

/**
 * Created by xiaolong on 16.10.15.
 */
public enum MyColor {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF");

    private final String text;

    /**
     * @param text
     */
    MyColor(final String text) {
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
