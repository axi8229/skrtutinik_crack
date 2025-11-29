package org.jsoup.nodes;

import flussonic.media.FFmpegMediaMetadataRetriever;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;

/* loaded from: classes4.dex */
public class Document extends Element {
    private String location;
    private OutputSettings outputSettings;
    private Parser parser;
    private QuirksMode quirksMode;
    private boolean updateMetaCharset;

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.valueOf("#root", ParseSettings.htmlDefault), str);
        this.outputSettings = new OutputSettings();
        this.quirksMode = QuirksMode.noQuirks;
        this.updateMetaCharset = false;
        this.location = str;
    }

    public String title() {
        Element elementFirst = getElementsByTag(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE).first();
        return elementFirst != null ? StringUtil.normaliseWhitespace(elementFirst.text()).trim() : "";
    }

    @Override // org.jsoup.nodes.Node
    public String outerHtml() {
        return super.html();
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public String nodeName() {
        return "#document";
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Document mo3013clone() {
        Document document = (Document) super.mo3013clone();
        document.outputSettings = this.outputSettings.clone();
        return document;
    }

    public static class OutputSettings implements Cloneable {
        private Charset charset;
        Entities.CoreCharset coreCharset;
        private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
        private ThreadLocal<CharsetEncoder> encoderThreadLocal = new ThreadLocal<>();
        private boolean prettyPrint = true;
        private boolean outline = false;
        private int indentAmount = 1;
        private Syntax syntax = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            charset(Charset.forName("UTF8"));
        }

        public Entities.EscapeMode escapeMode() {
            return this.escapeMode;
        }

        public OutputSettings charset(Charset charset) {
            this.charset = charset;
            return this;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }

        CharsetEncoder prepareEncoder() {
            CharsetEncoder charsetEncoderNewEncoder = this.charset.newEncoder();
            this.encoderThreadLocal.set(charsetEncoderNewEncoder);
            this.coreCharset = Entities.CoreCharset.byName(charsetEncoderNewEncoder.charset().name());
            return charsetEncoderNewEncoder;
        }

        CharsetEncoder encoder() {
            CharsetEncoder charsetEncoder = this.encoderThreadLocal.get();
            return charsetEncoder != null ? charsetEncoder : prepareEncoder();
        }

        public Syntax syntax() {
            return this.syntax;
        }

        public boolean prettyPrint() {
            return this.prettyPrint;
        }

        public boolean outline() {
            return this.outline;
        }

        public int indentAmount() {
            return this.indentAmount;
        }

        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.charset.name());
                outputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
                return outputSettings;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public OutputSettings outputSettings() {
        return this.outputSettings;
    }

    public QuirksMode quirksMode() {
        return this.quirksMode;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.quirksMode = quirksMode;
        return this;
    }

    public Parser parser() {
        return this.parser;
    }

    public Document parser(Parser parser) {
        this.parser = parser;
        return this;
    }
}
