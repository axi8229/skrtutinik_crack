package org.jsoup.select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Element;

/* loaded from: classes4.dex */
public class Elements extends ArrayList<Element> {
    public Elements() {
    }

    public Elements(int i) {
        super(i);
    }

    public Elements(List<Element> list) {
        super(list);
    }

    @Override // java.util.ArrayList
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            elements.add(it.next().mo3013clone());
        }
        return elements;
    }

    public String outerHtml() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (sbBorrowBuilder.length() != 0) {
                sbBorrowBuilder.append("\n");
            }
            sbBorrowBuilder.append(next.outerHtml());
        }
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return outerHtml();
    }

    public Element first() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }
}
