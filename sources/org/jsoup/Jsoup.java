package org.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/* loaded from: classes4.dex */
public class Jsoup {
    public static Document parse(String str) {
        return Parser.parse(str, "");
    }
}
