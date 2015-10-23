package com.example.xiaolong.intents;

/**
 * Created by xiaolong on 16.10.15.
 */

public enum TextProperties {
    COLOR("color"),
    ALIGNMENT("alignment"),
    FONT("font");

    private final String text;

    /**
     * @param text
     */
    private TextProperties(final String text) {
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