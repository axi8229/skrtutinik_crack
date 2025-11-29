package org.jsoup.select;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

/* loaded from: classes4.dex */
public class Selector {
    public static Element selectFirst(String str, Element element) {
        Validate.notEmpty(str);
        return Collector.findFirst(QueryParser.parse(str), element);
    }

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }
}
