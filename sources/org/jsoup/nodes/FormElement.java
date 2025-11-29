package org.jsoup.nodes;

import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class FormElement extends Element {
    private final Elements elements;

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
        this.elements = new Elements();
    }

    public FormElement addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    protected void removeChild(Node node) {
        super.removeChild(node);
        this.elements.remove(node);
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    /* renamed from: clone */
    public FormElement mo3013clone() {
        return (FormElement) super.mo3013clone();
    }
}
