package org.jsoup.nodes;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;

/* loaded from: classes4.dex */
public class DocumentType extends LeafNode {
    @Override // org.jsoup.nodes.Node
    void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node attr(String str, String str2) {
        return super.attr(str, str2);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node empty() {
        return super.empty();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public DocumentType(String str, String str2, String str3) {
        Validate.notNull(str);
        Validate.notNull(str2);
        Validate.notNull(str3);
        attr(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
        attr("publicId", str2);
        attr("systemId", str3);
        updatePubSyskey();
    }

    public void setPubSysKey(String str) {
        if (str != null) {
            attr("pubSysKey", str);
        }
    }

    private void updatePubSyskey() {
        if (has("publicId")) {
            attr("pubSysKey", "PUBLIC");
        } else if (has("systemId")) {
            attr("pubSysKey", "SYSTEM");
        }
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#doctype";
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.syntax() == Document.OutputSettings.Syntax.html && !has("publicId") && !has("systemId")) {
            appendable.append("<!doctype");
        } else {
            appendable.append("<!DOCTYPE");
        }
        if (has(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
            appendable.append(" ").append(attr(AppMeasurementSdk.ConditionalUserProperty.NAME));
        }
        if (has("pubSysKey")) {
            appendable.append(" ").append(attr("pubSysKey"));
        }
        if (has("publicId")) {
            appendable.append(" \"").append(attr("publicId")).append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        if (has("systemId")) {
            appendable.append(" \"").append(attr("systemId")).append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        appendable.append('>');
    }

    private boolean has(String str) {
        return !StringUtil.isBlank(attr(str));
    }
}
