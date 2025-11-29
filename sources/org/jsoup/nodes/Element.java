package org.jsoup.nodes;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.Selector;

/* loaded from: classes4.dex */
public class Element extends Node {
    private Attributes attributes;
    List<Node> childNodes;
    private WeakReference<List<Element>> shadowChildrenRef;
    private Tag tag;
    private static final List<Node> EMPTY_NODES = Collections.emptyList();
    private static final Pattern classSplit = Pattern.compile("\\s+");
    private static final String baseUriKey = Attributes.internalKey("baseUri");

    public Element(Tag tag, String str, Attributes attributes) {
        Validate.notNull(tag);
        this.childNodes = EMPTY_NODES;
        this.attributes = attributes;
        this.tag = tag;
        if (str != null) {
            setBaseUri(str);
        }
    }

    public Element(Tag tag, String str) {
        this(tag, str, null);
    }

    @Override // org.jsoup.nodes.Node
    protected List<Node> ensureChildNodes() {
        if (this.childNodes == EMPTY_NODES) {
            this.childNodes = new NodeList(this, 4);
        }
        return this.childNodes;
    }

    @Override // org.jsoup.nodes.Node
    protected boolean hasAttributes() {
        return this.attributes != null;
    }

    @Override // org.jsoup.nodes.Node
    public Attributes attributes() {
        if (!hasAttributes()) {
            this.attributes = new Attributes();
        }
        return this.attributes;
    }

    @Override // org.jsoup.nodes.Node
    public String baseUri() {
        return searchUpForAttribute(this, baseUriKey);
    }

    private static String searchUpForAttribute(Element element, String str) {
        while (element != null) {
            if (element.hasAttributes() && element.attributes.hasKey(str)) {
                return element.attributes.get(str);
            }
            element = element.parent();
        }
        return "";
    }

    @Override // org.jsoup.nodes.Node
    protected void doSetBaseUri(String str) {
        attributes().put(baseUriKey, str);
    }

    @Override // org.jsoup.nodes.Node
    public int childNodeSize() {
        return this.childNodes.size();
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return this.tag.getName();
    }

    public String tagName() {
        return this.tag.getName();
    }

    public String normalName() {
        return this.tag.normalName();
    }

    public Tag tag() {
        return this.tag;
    }

    public boolean isBlock() {
        return this.tag.isBlock();
    }

    public String id() {
        return hasAttributes() ? this.attributes.getIgnoreCase("id") : "";
    }

    @Override // org.jsoup.nodes.Node
    public Element attr(String str, String str2) {
        super.attr(str, str2);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public final Element parent() {
        return (Element) this.parentNode;
    }

    public Element child(int i) {
        return childElementsList().get(i);
    }

    public Elements children() {
        return new Elements(childElementsList());
    }

    private List<Element> childElementsList() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.shadowChildrenRef;
        if (weakReference != null && (list = weakReference.get()) != null) {
            return list;
        }
        int size = this.childNodes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Node node = this.childNodes.get(i);
            if (node instanceof Element) {
                arrayList.add((Element) node);
            }
        }
        this.shadowChildrenRef = new WeakReference<>(arrayList);
        return arrayList;
    }

    @Override // org.jsoup.nodes.Node
    void nodelistChanged() {
        super.nodelistChanged();
        this.shadowChildrenRef = null;
    }

    public List<TextNode> textNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                arrayList.add((TextNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Element selectFirst(String str) {
        return Selector.selectFirst(str, this);
    }

    public Element appendChild(Node node) {
        Validate.notNull(node);
        reparentChild(node);
        ensureChildNodes();
        this.childNodes.add(node);
        node.setSiblingIndex(this.childNodes.size() - 1);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element before(Node node) {
        return (Element) super.before(node);
    }

    @Override // org.jsoup.nodes.Node
    public Element empty() {
        this.childNodes.clear();
        return this;
    }

    public Elements siblingElements() {
        if (this.parentNode == null) {
            return new Elements(0);
        }
        List<Element> listChildElementsList = parent().childElementsList();
        Elements elements = new Elements(listChildElementsList.size() - 1);
        for (Element element : listChildElementsList) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    public Element previousElementSibling() {
        List<Element> listChildElementsList;
        int iIndexInList;
        if (this.parentNode != null && (iIndexInList = indexInList(this, (listChildElementsList = parent().childElementsList()))) > 0) {
            return listChildElementsList.get(iIndexInList - 1);
        }
        return null;
    }

    public int elementSiblingIndex() {
        if (parent() == null) {
            return 0;
        }
        return indexInList(this, parent().childElementsList());
    }

    private static <E extends Element> int indexInList(Element element, List<E> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == element) {
                return i;
            }
        }
        return 0;
    }

    public Elements getElementsByTag(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Tag(Normalizer.normalize(str)), this);
    }

    public Elements getAllElements() {
        return Collector.collect(new Evaluator.AllElements(), this);
    }

    public String text() {
        final StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element.1
            @Override // org.jsoup.select.NodeVisitor
            public void head(Node node, int i) {
                if (node instanceof TextNode) {
                    Element.appendNormalisedText(sbBorrowBuilder, (TextNode) node);
                } else if (node instanceof Element) {
                    Element element = (Element) node;
                    if (sbBorrowBuilder.length() > 0) {
                        if ((element.isBlock() || element.tag.getName().equals("br")) && !TextNode.lastCharIsWhitespace(sbBorrowBuilder)) {
                            sbBorrowBuilder.append(' ');
                        }
                    }
                }
            }

            @Override // org.jsoup.select.NodeVisitor
            public void tail(Node node, int i) {
                if ((node instanceof Element) && ((Element) node).isBlock() && (node.nextSibling() instanceof TextNode) && !TextNode.lastCharIsWhitespace(sbBorrowBuilder)) {
                    sbBorrowBuilder.append(' ');
                }
            }
        }, this);
        return StringUtil.releaseBuilder(sbBorrowBuilder).trim();
    }

    public String ownText() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        ownText(sbBorrowBuilder);
        return StringUtil.releaseBuilder(sbBorrowBuilder).trim();
    }

    private void ownText(StringBuilder sb) {
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                appendNormalisedText(sb, (TextNode) node);
            } else if (node instanceof Element) {
                appendWhitespaceIfBr((Element) node, sb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendNormalisedText(StringBuilder sb, TextNode textNode) {
        String wholeText = textNode.getWholeText();
        if (preserveWhitespace(textNode.parentNode) || (textNode instanceof CDataNode)) {
            sb.append(wholeText);
        } else {
            StringUtil.appendNormalisedWhitespace(sb, wholeText, TextNode.lastCharIsWhitespace(sb));
        }
    }

    private static void appendWhitespaceIfBr(Element element, StringBuilder sb) {
        if (!element.tag.getName().equals("br") || TextNode.lastCharIsWhitespace(sb)) {
            return;
        }
        sb.append(" ");
    }

    static boolean preserveWhitespace(Node node) {
        if (node instanceof Element) {
            Element elementParent = (Element) node;
            int i = 0;
            while (!elementParent.tag.preserveWhitespace()) {
                elementParent = elementParent.parent();
                i++;
                if (i >= 6 || elementParent == null) {
                }
            }
            return true;
        }
        return false;
    }

    public String data() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                sbBorrowBuilder.append(((DataNode) node).getWholeData());
            } else if (node instanceof Comment) {
                sbBorrowBuilder.append(((Comment) node).getData());
            } else if (node instanceof Element) {
                sbBorrowBuilder.append(((Element) node).data());
            } else if (node instanceof CDataNode) {
                sbBorrowBuilder.append(((CDataNode) node).getWholeText());
            }
        }
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    public boolean hasClass(String str) {
        if (!hasAttributes()) {
            return false;
        }
        String ignoreCase = this.attributes.getIgnoreCase("class");
        int length = ignoreCase.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(ignoreCase);
            }
            boolean z = false;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isWhitespace(ignoreCase.charAt(i2))) {
                    if (!z) {
                        continue;
                    } else {
                        if (i2 - i == length2 && ignoreCase.regionMatches(true, i, str, 0, length2)) {
                            return true;
                        }
                        z = false;
                    }
                } else if (!z) {
                    i = i2;
                    z = true;
                }
            }
            if (z && length - i == length2) {
                return ignoreCase.regionMatches(true, i, str, 0, length2);
            }
        }
        return false;
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.prettyPrint() && isFormatAsBlock(outputSettings) && !isInlineable(outputSettings) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0)) {
            indent(appendable, i, outputSettings);
        }
        appendable.append('<').append(tagName());
        Attributes attributes = this.attributes;
        if (attributes != null) {
            attributes.html(appendable, outputSettings);
        }
        if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
            if (outputSettings.syntax() == Document.OutputSettings.Syntax.html && this.tag.isEmpty()) {
                appendable.append('>');
                return;
            } else {
                appendable.append(" />");
                return;
            }
        }
        appendable.append('>');
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
            return;
        }
        if (outputSettings.prettyPrint() && !this.childNodes.isEmpty() && (this.tag.formatAsBlock() || (outputSettings.outline() && (this.childNodes.size() > 1 || (this.childNodes.size() == 1 && !(this.childNodes.get(0) instanceof TextNode)))))) {
            indent(appendable, i, outputSettings);
        }
        appendable.append("</").append(tagName()).append('>');
    }

    public String html() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        html(sbBorrowBuilder);
        String strReleaseBuilder = StringUtil.releaseBuilder(sbBorrowBuilder);
        return NodeUtils.outputSettings(this).prettyPrint() ? strReleaseBuilder.trim() : strReleaseBuilder;
    }

    public <T extends Appendable> T html(T t) {
        int size = this.childNodes.size();
        for (int i = 0; i < size; i++) {
            this.childNodes.get(i).outerHtml(t);
        }
        return t;
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: clone */
    public Element mo3013clone() {
        return (Element) super.mo3013clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.nodes.Node
    public Element doClone(Node node) {
        Element element = (Element) super.doClone(node);
        Attributes attributes = this.attributes;
        element.attributes = attributes != null ? attributes.clone() : null;
        NodeList nodeList = new NodeList(element, this.childNodes.size());
        element.childNodes = nodeList;
        nodeList.addAll(this.childNodes);
        element.setBaseUri(baseUri());
        return element;
    }

    @Override // org.jsoup.nodes.Node
    public Element root() {
        return (Element) super.root();
    }

    private static final class NodeList extends ChangeNotifyingArrayList<Node> {
        private final Element owner;

        NodeList(Element element, int i) {
            super(i);
            this.owner = element;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.nodelistChanged();
        }
    }

    private boolean isFormatAsBlock(Document.OutputSettings outputSettings) {
        return this.tag.formatAsBlock() || (parent() != null && parent().tag().formatAsBlock()) || outputSettings.outline();
    }

    private boolean isInlineable(Document.OutputSettings outputSettings) {
        return (!tag().isInline() || tag().isEmpty() || !parent().isBlock() || previousSibling() == null || outputSettings.outline()) ? false : true;
    }
}
