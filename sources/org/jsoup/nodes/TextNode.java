package org.jsoup.nodes;

import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;

/* loaded from: classes4.dex */
public class TextNode extends LeafNode {
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

    public TextNode(String str) {
        this.value = str;
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#text";
    }

    public String getWholeText() {
        return coreValue();
    }

    public boolean isBlank() {
        return StringUtil.isBlank(coreValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    @Override // org.jsoup.nodes.Node
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void outerHtmlHead(java.lang.Appendable r10, int r11, org.jsoup.nodes.Document.OutputSettings r12) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r12.prettyPrint()
            if (r0 == 0) goto L3d
            int r1 = r9.siblingIndex()
            if (r1 != 0) goto L24
            org.jsoup.nodes.Node r1 = r9.parentNode
            boolean r2 = r1 instanceof org.jsoup.nodes.Element
            if (r2 == 0) goto L24
            org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1
            org.jsoup.parser.Tag r1 = r1.tag()
            boolean r1 = r1.formatAsBlock()
            if (r1 == 0) goto L24
            boolean r1 = r9.isBlank()
            if (r1 == 0) goto L3a
        L24:
            boolean r1 = r12.outline()
            if (r1 == 0) goto L3d
            java.util.List r1 = r9.siblingNodes()
            int r1 = r1.size()
            if (r1 <= 0) goto L3d
            boolean r1 = r9.isBlank()
            if (r1 != 0) goto L3d
        L3a:
            r9.indent(r10, r11, r12)
        L3d:
            r11 = 0
            r1 = 1
            if (r0 == 0) goto L4b
            org.jsoup.nodes.Node r2 = r9.parentNode
            boolean r2 = org.jsoup.nodes.Element.preserveWhitespace(r2)
            if (r2 != 0) goto L4b
            r7 = r1
            goto L4c
        L4b:
            r7 = r11
        L4c:
            if (r0 == 0) goto L56
            org.jsoup.nodes.Node r0 = r9.parentNode
            boolean r0 = r0 instanceof org.jsoup.nodes.Document
            if (r0 == 0) goto L56
            r8 = r1
            goto L57
        L56:
            r8 = r11
        L57:
            java.lang.String r4 = r9.coreValue()
            r6 = 0
            r3 = r10
            r5 = r12
            org.jsoup.nodes.Entities.escape(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.TextNode.outerHtmlHead(java.lang.Appendable, int, org.jsoup.nodes.Document$OutputSettings):void");
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: clone */
    public TextNode mo3013clone() {
        return (TextNode) super.mo3013clone();
    }

    static boolean lastCharIsWhitespace(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }
}
