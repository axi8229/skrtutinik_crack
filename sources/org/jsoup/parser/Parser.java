package org.jsoup.parser;

import java.io.StringReader;
import org.jsoup.nodes.Document;

/* loaded from: classes4.dex */
public class Parser {
    private ParseErrorList errors = ParseErrorList.noTracking();
    private ParseSettings settings;
    private TreeBuilder treeBuilder;

    public Parser(TreeBuilder treeBuilder) {
        this.treeBuilder = treeBuilder;
        this.settings = treeBuilder.defaultSettings();
    }

    public ParseErrorList getErrors() {
        return this.errors;
    }

    public ParseSettings settings() {
        return this.settings;
    }

    public static Document parse(String str, String str2) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.parse(new StringReader(str), str2, new Parser(htmlTreeBuilder));
    }
}
