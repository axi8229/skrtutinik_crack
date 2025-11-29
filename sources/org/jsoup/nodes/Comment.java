package org.jsoup.nodes;

import org.jsoup.nodes.Document;

/* loaded from: classes4.dex */
public class Comment extends LeafNode {
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

    public Comment(String str) {
        this.value = str;
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#comment";
    }

    public String getData() {
        return coreValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    @Override // org.jsoup.nodes.Node
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void outerHtmlHead(java.lang.Appendable r3, int r4, org.jsoup.nodes.Document.OutputSettings r5) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r5.prettyPrint()
            if (r0 == 0) goto L27
            int r0 = r2.siblingIndex()
            if (r0 != 0) goto L1e
            org.jsoup.nodes.Node r0 = r2.parentNode
            boolean r1 = r0 instanceof org.jsoup.nodes.Element
            if (r1 == 0) goto L1e
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            org.jsoup.parser.Tag r0 = r0.tag()
            boolean r0 = r0.formatAsBlock()
            if (r0 != 0) goto L24
        L1e:
            boolean r0 = r5.outline()
            if (r0 == 0) goto L27
        L24:
            r2.indent(r3, r4, r5)
        L27:
            java.lang.String r4 = "<!--"
            java.lang.Appendable r3 = r3.append(r4)
            java.lang.String r4 = r2.getData()
            java.lang.Appendable r3 = r3.append(r4)
            java.lang.String r4 = "-->"
            r3.append(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Comment.outerHtmlHead(java.lang.Appendable, int, org.jsoup.nodes.Document$OutputSettings):void");
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: clone */
    public Comment mo3013clone() {
        return (Comment) super.mo3013clone();
    }
}
