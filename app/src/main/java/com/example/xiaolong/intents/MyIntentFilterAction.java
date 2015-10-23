package com.example.xiaolong.intents;

/**
 * Created by xiaolong on 23.10.15.
 */
public enum MyIntentFilterAction {
    SHOW_DATE("android.intent.action.show_date"),
    SHOW_DATE_EXTENDED("android.intent.action.show_date_extended"),
    SHOW_TIME("android.intent.action.show_time"),
    ;

    private final String text;

    /**
     * @param text
     */
    MyIntentFilterAction(final String text) {
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
