package org.jsoup.parser;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ParseErrorList extends ArrayList<ParseError> {
    private final int maxSize;

    ParseErrorList(int i, int i2) {
        super(i);
        this.maxSize = i2;
    }

    boolean canAddError() {
        return size() < this.maxSize;
    }

    public static ParseErrorList noTracking() {
        return new ParseErrorList(0, 0);
    }
}
