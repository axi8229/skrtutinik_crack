package org.jsoup.select;

import org.jsoup.nodes.Node;
import org.jsoup.select.NodeFilter;

/* loaded from: classes4.dex */
public class NodeTraversor {
    public static void traverse(NodeVisitor nodeVisitor, Node node) {
        Node nodeChildNode = node;
        int i = 0;
        while (nodeChildNode != null) {
            nodeVisitor.head(nodeChildNode, i);
            if (nodeChildNode.childNodeSize() > 0) {
                nodeChildNode = nodeChildNode.childNode(0);
                i++;
            } else {
                while (nodeChildNode.nextSibling() == null && i > 0) {
                    nodeVisitor.tail(nodeChildNode, i);
                    nodeChildNode = nodeChildNode.parentNode();
                    i--;
                }
                nodeVisitor.tail(nodeChildNode, i);
                if (nodeChildNode == node) {
                    return;
                } else {
                    nodeChildNode = nodeChildNode.nextSibling();
                }
            }
        }
    }

    public static NodeFilter.FilterResult filter(NodeFilter nodeFilter, Node node) {
        Node nodeChildNode = node;
        int i = 0;
        while (nodeChildNode != null) {
            NodeFilter.FilterResult filterResultHead = nodeFilter.head(nodeChildNode, i);
            if (filterResultHead == NodeFilter.FilterResult.STOP) {
                return filterResultHead;
            }
            if (filterResultHead == NodeFilter.FilterResult.CONTINUE && nodeChildNode.childNodeSize() > 0) {
                nodeChildNode = nodeChildNode.childNode(0);
                i++;
            } else {
                while (nodeChildNode.nextSibling() == null && i > 0) {
                    NodeFilter.FilterResult filterResult = NodeFilter.FilterResult.CONTINUE;
                    if ((filterResultHead == filterResult || filterResultHead == NodeFilter.FilterResult.SKIP_CHILDREN) && (filterResultHead = nodeFilter.tail(nodeChildNode, i)) == NodeFilter.FilterResult.STOP) {
                        return filterResultHead;
                    }
                    Node nodeParentNode = nodeChildNode.parentNode();
                    i--;
                    if (filterResultHead == NodeFilter.FilterResult.REMOVE) {
                        nodeChildNode.remove();
                    }
                    filterResultHead = filterResult;
                    nodeChildNode = nodeParentNode;
                }
                if ((filterResultHead == NodeFilter.FilterResult.CONTINUE || filterResultHead == NodeFilter.FilterResult.SKIP_CHILDREN) && (filterResultHead = nodeFilter.tail(nodeChildNode, i)) == NodeFilter.FilterResult.STOP) {
                    return filterResultHead;
                }
                if (nodeChildNode == node) {
                    return filterResultHead;
                }
                Node nodeNextSibling = nodeChildNode.nextSibling();
                if (filterResultHead == NodeFilter.FilterResult.REMOVE) {
                    nodeChildNode.remove();
                }
                nodeChildNode = nodeNextSibling;
            }
        }
        return NodeFilter.FilterResult.CONTINUE;
    }
}
