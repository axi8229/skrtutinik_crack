package org.jsoup.parser;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Token;

/* loaded from: classes4.dex */
enum HtmlTreeBuilderState {
    Initial { // from class: org.jsoup.parser.HtmlTreeBuilderState.1
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                Token.Doctype doctypeAsDoctype = token.asDoctype();
                DocumentType documentType = new DocumentType(htmlTreeBuilder.settings.normalizeTag(doctypeAsDoctype.getName()), doctypeAsDoctype.getPublicIdentifier(), doctypeAsDoctype.getSystemIdentifier());
                documentType.setPubSysKey(doctypeAsDoctype.getPubSysKey());
                htmlTreeBuilder.getDocument().appendChild(documentType);
                if (doctypeAsDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
            } else {
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
                return htmlTreeBuilder.process(token);
            }
            return true;
        }
    },
    BeforeHtml { // from class: org.jsoup.parser.HtmlTreeBuilderState.2
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (!token.isComment()) {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    htmlTreeBuilder.insert(token.asCharacter());
                    return true;
                }
                if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                    htmlTreeBuilder.insert(token.asStartTag());
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
                    return true;
                }
                if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            htmlTreeBuilder.insert(token.asComment());
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag("html");
            htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
            return htmlTreeBuilder.process(token);
        }
    },
    BeforeHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.3
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("head")) {
                htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
                return true;
            }
            if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                htmlTreeBuilder.processStartTag("head");
                return htmlTreeBuilder.process(token);
            }
            if (token.isEndTag()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.processStartTag("head");
            return htmlTreeBuilder.process(token);
        }
    },
    InHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.4
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (i == 2) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (i == 3) {
                    Token.StartTag startTagAsStartTag = token.asStartTag();
                    String strNormalName = startTagAsStartTag.normalName();
                    if (strNormalName.equals("html")) {
                        return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(strNormalName, Constants.InHeadEmpty)) {
                        Element elementInsertEmpty = htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                        if (strNormalName.equals("base") && elementInsertEmpty.hasAttr("href")) {
                            htmlTreeBuilder.maybeSetBaseUri(elementInsertEmpty);
                        }
                    } else if (strNormalName.equals("meta")) {
                        htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                    } else if (strNormalName.equals(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)) {
                        HtmlTreeBuilderState.handleRcData(startTagAsStartTag, htmlTreeBuilder);
                    } else if (StringUtil.inSorted(strNormalName, Constants.InHeadRaw)) {
                        HtmlTreeBuilderState.handleRawtext(startTagAsStartTag, htmlTreeBuilder);
                    } else if (strNormalName.equals("noscript")) {
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InHeadNoscript);
                    } else if (strNormalName.equals("script")) {
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.Text);
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else {
                        if (strNormalName.equals("head")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        return anythingElse(token, htmlTreeBuilder);
                    }
                } else if (i == 4) {
                    String strNormalName2 = token.asEndTag().normalName();
                    if (strNormalName2.equals("head")) {
                        htmlTreeBuilder.pop();
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterHead);
                    } else {
                        if (StringUtil.inSorted(strNormalName2, Constants.InHeadEnd)) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            }
            return true;
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag("head");
            return treeBuilder.process(token);
        }
    },
    InHeadNoscript { // from class: org.jsoup.parser.HtmlTreeBuilderState.5
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (!token.isEndTag() || !token.asEndTag().normalName().equals("noscript")) {
                if (HtmlTreeBuilderState.isWhitespace(token) || token.isComment() || (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoScriptHead))) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                }
                if (token.isEndTag() && token.asEndTag().normalName().equals("br")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoscriptIgnore)) || token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            htmlTreeBuilder.pop();
            htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }
    },
    AfterHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.6
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            }
            if (token.isStartTag()) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strNormalName = startTagAsStartTag.normalName();
                if (strNormalName.equals("html")) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                }
                if (strNormalName.equals("body")) {
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
                    return true;
                }
                if (strNormalName.equals("frameset")) {
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InFrameset);
                    return true;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InBodyStartToHead)) {
                    htmlTreeBuilder.error(this);
                    Element headElement = htmlTreeBuilder.getHeadElement();
                    htmlTreeBuilder.push(headElement);
                    htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                    htmlTreeBuilder.removeFromStack(headElement);
                    return true;
                }
                if (strNormalName.equals("head")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                anythingElse(token, htmlTreeBuilder);
                return true;
            }
            if (token.isEndTag()) {
                if (StringUtil.inSorted(token.asEndTag().normalName(), Constants.AfterHeadBody)) {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                }
                htmlTreeBuilder.error(this);
                return false;
            }
            anythingElse(token, htmlTreeBuilder);
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag("body");
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }
    },
    InBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.7
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (i == 2) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (i == 3) {
                    return inBodyStartTag(token, htmlTreeBuilder);
                }
                if (i == 4) {
                    return inBodyEndTag(token, htmlTreeBuilder);
                }
                if (i == 5) {
                    Token.Character characterAsCharacter = token.asCharacter();
                    if (characterAsCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (htmlTreeBuilder.framesetOk() && HtmlTreeBuilderState.isWhitespace(characterAsCharacter)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(characterAsCharacter);
                    } else {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(characterAsCharacter);
                        htmlTreeBuilder.framesetOk(false);
                    }
                }
            }
            return true;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean inBodyStartTag(org.jsoup.parser.Token r19, org.jsoup.parser.HtmlTreeBuilder r20) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 1956
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass7.inBodyStartTag(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }

        private boolean inBodyEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token.EndTag endTagAsEndTag;
            String strNormalName;
            endTagAsEndTag = token.asEndTag();
            strNormalName = endTagAsEndTag.normalName();
            strNormalName.hashCode();
            switch (strNormalName) {
                case "p":
                    if (!htmlTreeBuilder.inButtonScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processStartTag(strNormalName);
                        return htmlTreeBuilder.process(endTagAsEndTag);
                    }
                    htmlTreeBuilder.generateImpliedEndTags(strNormalName);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strNormalName);
                    return true;
                case "br":
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag("br");
                    return false;
                case "dd":
                case "dt":
                    if (!htmlTreeBuilder.inScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(strNormalName);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strNormalName);
                    return true;
                case "h1":
                case "h2":
                case "h3":
                case "h4":
                case "h5":
                case "h6":
                    String[] strArr = Constants.Headings;
                    if (!htmlTreeBuilder.inScope(strArr)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(strNormalName);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strArr);
                    return true;
                case "li":
                    if (!htmlTreeBuilder.inListItemScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(strNormalName);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strNormalName);
                    return true;
                case "body":
                    if (!htmlTreeBuilder.inScope("body")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterBody);
                    return true;
                case "form":
                    FormElement formElement = htmlTreeBuilder.getFormElement();
                    htmlTreeBuilder.setFormElement(null);
                    if (formElement == null || !htmlTreeBuilder.inScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().normalName().equals(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.removeFromStack(formElement);
                    return true;
                case "html":
                    if (htmlTreeBuilder.processEndTag("body")) {
                        return htmlTreeBuilder.process(endTagAsEndTag);
                    }
                    return true;
                case "span":
                case "sarcasm":
                    return anyOtherEndTag(token, htmlTreeBuilder);
                default:
                    if (StringUtil.inSorted(strNormalName, Constants.InBodyEndAdoptionFormatters)) {
                        return inBodyEndTagAdoption(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(strNormalName, Constants.InBodyEndClosers)) {
                        if (!htmlTreeBuilder.inScope(strNormalName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().normalName().equals(strNormalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(strNormalName);
                    } else if (StringUtil.inSorted(strNormalName, Constants.InBodyStartApplets)) {
                        if (!htmlTreeBuilder.inScope(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                            if (!htmlTreeBuilder.inScope(strNormalName)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            htmlTreeBuilder.generateImpliedEndTags();
                            if (!htmlTreeBuilder.currentElement().normalName().equals(strNormalName)) {
                                htmlTreeBuilder.error(this);
                            }
                            htmlTreeBuilder.popStackToClose(strNormalName);
                            htmlTreeBuilder.clearFormattingElementsToLastMarker();
                        }
                    } else {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    }
                    return true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean anyOtherEndTag(org.jsoup.parser.Token r6, org.jsoup.parser.HtmlTreeBuilder r7) {
            /*
                r5 = this;
                org.jsoup.parser.Token$EndTag r6 = r6.asEndTag()
                java.lang.String r6 = r6.normalName
                java.util.ArrayList r0 = r7.getStack()
                int r1 = r0.size()
                r2 = 1
                int r1 = r1 - r2
            L10:
                if (r1 < 0) goto L48
                java.lang.Object r3 = r0.get(r1)
                org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
                java.lang.String r4 = r3.normalName()
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L3a
                r7.generateImpliedEndTags(r6)
                org.jsoup.nodes.Element r0 = r7.currentElement()
                java.lang.String r0 = r0.normalName()
                boolean r0 = r6.equals(r0)
                if (r0 != 0) goto L36
                r7.error(r5)
            L36:
                r7.popStackToClose(r6)
                goto L48
            L3a:
                boolean r3 = r7.isSpecial(r3)
                if (r3 == 0) goto L45
                r7.error(r5)
                r6 = 0
                return r6
            L45:
                int r1 = r1 + (-1)
                goto L10
            L48:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass7.anyOtherEndTag(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }

        private boolean inBodyEndTagAdoption(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String strNormalName = token.asEndTag().normalName();
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            for (int i = 0; i < 8; i++) {
                Element activeFormattingElement = htmlTreeBuilder.getActiveFormattingElement(strNormalName);
                if (activeFormattingElement == null) {
                    return anyOtherEndTag(token, htmlTreeBuilder);
                }
                if (!htmlTreeBuilder.onStack(activeFormattingElement)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    return true;
                }
                if (!htmlTreeBuilder.inScope(activeFormattingElement.normalName())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                    htmlTreeBuilder.error(this);
                }
                int size = stack.size();
                Element element = null;
                int i2 = 0;
                boolean z = false;
                Element element2 = null;
                while (true) {
                    if (i2 >= size || i2 >= 64) {
                        break;
                    }
                    Element element3 = stack.get(i2);
                    if (element3 == activeFormattingElement) {
                        element2 = stack.get(i2 - 1);
                        z = true;
                    } else if (z && htmlTreeBuilder.isSpecial(element3)) {
                        element = element3;
                        break;
                    }
                    i2++;
                }
                if (element == null) {
                    htmlTreeBuilder.popStackToClose(activeFormattingElement.normalName());
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    return true;
                }
                Element elementAboveOnStack = element;
                Element element4 = elementAboveOnStack;
                for (int i3 = 0; i3 < 3; i3++) {
                    if (htmlTreeBuilder.onStack(elementAboveOnStack)) {
                        elementAboveOnStack = htmlTreeBuilder.aboveOnStack(elementAboveOnStack);
                    }
                    if (!htmlTreeBuilder.isInActiveFormattingElements(elementAboveOnStack)) {
                        htmlTreeBuilder.removeFromStack(elementAboveOnStack);
                    } else {
                        if (elementAboveOnStack == activeFormattingElement) {
                            break;
                        }
                        Element element5 = new Element(Tag.valueOf(elementAboveOnStack.nodeName(), ParseSettings.preserveCase), htmlTreeBuilder.getBaseUri());
                        htmlTreeBuilder.replaceActiveFormattingElement(elementAboveOnStack, element5);
                        htmlTreeBuilder.replaceOnStack(elementAboveOnStack, element5);
                        if (element4.parent() != null) {
                            element4.remove();
                        }
                        element5.appendChild(element4);
                        elementAboveOnStack = element5;
                        element4 = elementAboveOnStack;
                    }
                }
                if (StringUtil.inSorted(element2.normalName(), Constants.InBodyEndTableFosters)) {
                    if (element4.parent() != null) {
                        element4.remove();
                    }
                    htmlTreeBuilder.insertInFosterParent(element4);
                } else {
                    if (element4.parent() != null) {
                        element4.remove();
                    }
                    element2.appendChild(element4);
                }
                Element element6 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                element6.attributes().addAll(activeFormattingElement.attributes());
                for (Node node : (Node[]) element.childNodes().toArray(new Node[0])) {
                    element6.appendChild(node);
                }
                element.appendChild(element6);
                htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                htmlTreeBuilder.removeFromStack(activeFormattingElement);
                htmlTreeBuilder.insertOnStackAfter(element, element6);
            }
            return true;
        }
    },
    Text { // from class: org.jsoup.parser.HtmlTreeBuilderState.8
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            }
            if (!token.isEndTag()) {
                return true;
            }
            htmlTreeBuilder.pop();
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return true;
        }
    },
    InTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.9
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableText);
                return htmlTreeBuilder.process(token);
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag()) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strNormalName = startTagAsStartTag.normalName();
                if (strNormalName.equals("caption")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InCaption);
                } else if (strNormalName.equals("colgroup")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InColumnGroup);
                } else {
                    if (strNormalName.equals("col")) {
                        htmlTreeBuilder.processStartTag("colgroup");
                        return htmlTreeBuilder.process(token);
                    }
                    if (StringUtil.inSorted(strNormalName, Constants.InTableToBody)) {
                        htmlTreeBuilder.clearStackToTableContext();
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableBody);
                    } else {
                        if (StringUtil.inSorted(strNormalName, Constants.InTableAddBody)) {
                            htmlTreeBuilder.processStartTag("tbody");
                            return htmlTreeBuilder.process(token);
                        }
                        if (strNormalName.equals("table")) {
                            htmlTreeBuilder.error(this);
                            if (htmlTreeBuilder.processEndTag("table")) {
                                return htmlTreeBuilder.process(token);
                            }
                        } else {
                            if (StringUtil.inSorted(strNormalName, Constants.InTableToHead)) {
                                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                            }
                            if (strNormalName.equals("input")) {
                                if (!startTagAsStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                                    return anythingElse(token, htmlTreeBuilder);
                                }
                                htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                            } else if (strNormalName.equals("form")) {
                                htmlTreeBuilder.error(this);
                                if (htmlTreeBuilder.getFormElement() != null) {
                                    return false;
                                }
                                htmlTreeBuilder.insertForm(startTagAsStartTag, false);
                            } else {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                        }
                    }
                }
                return true;
            }
            if (token.isEndTag()) {
                String strNormalName2 = token.asEndTag().normalName();
                if (strNormalName2.equals("table")) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.popStackToClose("table");
                    htmlTreeBuilder.resetInsertionMode();
                    return true;
                }
                if (StringUtil.inSorted(strNormalName2, Constants.InTableEndErr)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            if (token.isEOF()) {
                if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                    htmlTreeBuilder.error(this);
                }
                return true;
            }
            return anythingElse(token, htmlTreeBuilder);
        }

        boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                htmlTreeBuilder.setFosterInserts(true);
                boolean zProcess = htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                htmlTreeBuilder.setFosterInserts(false);
                return zProcess;
            }
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }
    },
    InTableText { // from class: org.jsoup.parser.HtmlTreeBuilderState.10
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.type == Token.TokenType.Character) {
                Token.Character characterAsCharacter = token.asCharacter();
                if (characterAsCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.getPendingTableCharacters().add(characterAsCharacter.getData());
                return true;
            }
            if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                for (String str : htmlTreeBuilder.getPendingTableCharacters()) {
                    if (!HtmlTreeBuilderState.isWhitespace(str)) {
                        htmlTreeBuilder.error(this);
                        if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                            htmlTreeBuilder.setFosterInserts(true);
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                            htmlTreeBuilder.setFosterInserts(false);
                        } else {
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                        }
                    } else {
                        htmlTreeBuilder.insert(new Token.Character().data(str));
                    }
                }
                htmlTreeBuilder.newPendingTableCharacters();
            }
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return htmlTreeBuilder.process(token);
        }
    },
    InCaption { // from class: org.jsoup.parser.HtmlTreeBuilderState.11
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag() && token.asEndTag().normalName().equals("caption")) {
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElement().normalName().equals("caption")) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose("caption");
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                return true;
            }
            if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) || (token.isEndTag() && token.asEndTag().normalName().equals("table"))) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.processEndTag("caption")) {
                    return htmlTreeBuilder.process(token);
                }
                return true;
            }
            if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.InCaptionIgnore)) {
                htmlTreeBuilder.error(this);
                return false;
            }
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }
    },
    InColumnGroup { // from class: org.jsoup.parser.HtmlTreeBuilderState.12
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
            } else if (i == 3) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strNormalName = startTagAsStartTag.normalName();
                strNormalName.hashCode();
                if (!strNormalName.equals("col")) {
                    if (strNormalName.equals("html")) {
                        return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.insertEmpty(startTagAsStartTag);
            } else {
                if (i != 4) {
                    if (i == 6) {
                        if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                            return true;
                        }
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (token.asEndTag().normalName.equals("colgroup")) {
                    if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            }
            return true;
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("colgroup")) {
                return treeBuilder.process(token);
            }
            return true;
        }
    },
    InTableBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.13
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i != 3) {
                if (i == 4) {
                    String strNormalName = token.asEndTag().normalName();
                    if (StringUtil.inSorted(strNormalName, Constants.InTableEndIgnore)) {
                        if (!htmlTreeBuilder.inTableScope(strNormalName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.clearStackToTableBodyContext();
                        htmlTreeBuilder.pop();
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                        return true;
                    }
                    if (strNormalName.equals("table")) {
                        return exitTableBody(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(strNormalName, Constants.InTableBodyEndIgnore)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            Token.StartTag startTagAsStartTag = token.asStartTag();
            String strNormalName2 = startTagAsStartTag.normalName();
            if (strNormalName2.equals("template")) {
                htmlTreeBuilder.insert(startTagAsStartTag);
                return true;
            }
            if (strNormalName2.equals("tr")) {
                htmlTreeBuilder.clearStackToTableBodyContext();
                htmlTreeBuilder.insert(startTagAsStartTag);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                return true;
            }
            if (StringUtil.inSorted(strNormalName2, Constants.InCellNames)) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processStartTag("tr");
                return htmlTreeBuilder.process(startTagAsStartTag);
            }
            if (StringUtil.inSorted(strNormalName2, Constants.InTableBodyExit)) {
                return exitTableBody(token, htmlTreeBuilder);
            }
            return anythingElse(token, htmlTreeBuilder);
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.inTableScope("tbody") && !htmlTreeBuilder.inTableScope("thead") && !htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.clearStackToTableBodyContext();
            htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().normalName());
            return htmlTreeBuilder.process(token);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }
    },
    InRow { // from class: org.jsoup.parser.HtmlTreeBuilderState.14
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strNormalName = startTagAsStartTag.normalName();
                if (strNormalName.equals("template")) {
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InCellNames)) {
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InCell);
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    return true;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InRowMissing)) {
                    return handleMissingTr(token, htmlTreeBuilder);
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            if (token.isEndTag()) {
                String strNormalName2 = token.asEndTag().normalName();
                if (strNormalName2.equals("tr")) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableBody);
                    return true;
                }
                if (strNormalName2.equals("table")) {
                    return handleMissingTr(token, htmlTreeBuilder);
                }
                if (StringUtil.inSorted(strNormalName2, Constants.InTableToBody)) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.processEndTag("tr");
                    return htmlTreeBuilder.process(token);
                }
                if (StringUtil.inSorted(strNormalName2, Constants.InRowIgnore)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            return anythingElse(token, htmlTreeBuilder);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("tr")) {
                return treeBuilder.process(token);
            }
            return false;
        }
    },
    InCell { // from class: org.jsoup.parser.HtmlTreeBuilderState.15
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String strNormalName = token.asEndTag().normalName();
                if (StringUtil.inSorted(strNormalName, Constants.InCellNames)) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().normalName().equals(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strNormalName);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                    return true;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InCellBody)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InCellTable)) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) {
                if (!htmlTreeBuilder.inTableScope("td") && !htmlTreeBuilder.inTableScope("th")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                closeCell(htmlTreeBuilder);
                return htmlTreeBuilder.process(token);
            }
            return anythingElse(token, htmlTreeBuilder);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("td")) {
                htmlTreeBuilder.processEndTag("td");
            } else {
                htmlTreeBuilder.processEndTag("th");
            }
        }
    },
    InSelect { // from class: org.jsoup.parser.HtmlTreeBuilderState.16
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String strNormalName;
            switch (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    return true;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    Token.StartTag startTagAsStartTag = token.asStartTag();
                    String strNormalName2 = startTagAsStartTag.normalName();
                    if (strNormalName2.equals("html")) {
                        return htmlTreeBuilder.process(startTagAsStartTag, HtmlTreeBuilderState.InBody);
                    }
                    if (strNormalName2.equals("option")) {
                        if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else if (strNormalName2.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        if (htmlTreeBuilder.currentElement().normalName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("optgroup");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else {
                        if (strNormalName2.equals("select")) {
                            htmlTreeBuilder.error(this);
                            return htmlTreeBuilder.processEndTag("select");
                        }
                        if (StringUtil.inSorted(strNormalName2, Constants.InSelectEnd)) {
                            htmlTreeBuilder.error(this);
                            if (!htmlTreeBuilder.inSelectScope("select")) {
                                return false;
                            }
                            htmlTreeBuilder.processEndTag("select");
                            return htmlTreeBuilder.process(startTagAsStartTag);
                        }
                        if (strNormalName2.equals("script")) {
                            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                        }
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    return true;
                case 4:
                    strNormalName = token.asEndTag().normalName();
                    strNormalName.hashCode();
                    switch (strNormalName) {
                        case "option":
                            if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                                htmlTreeBuilder.pop();
                            } else {
                                htmlTreeBuilder.error(this);
                            }
                            return true;
                        case "select":
                            if (!htmlTreeBuilder.inSelectScope(strNormalName)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            htmlTreeBuilder.popStackToClose(strNormalName);
                            htmlTreeBuilder.resetInsertionMode();
                            return true;
                        case "optgroup":
                            if (htmlTreeBuilder.currentElement().normalName().equals("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).normalName().equals("optgroup")) {
                                htmlTreeBuilder.processEndTag("option");
                            }
                            if (htmlTreeBuilder.currentElement().normalName().equals("optgroup")) {
                                htmlTreeBuilder.pop();
                            } else {
                                htmlTreeBuilder.error(this);
                            }
                            return true;
                        default:
                            return anythingElse(token, htmlTreeBuilder);
                    }
                case 5:
                    Token.Character characterAsCharacter = token.asCharacter();
                    if (characterAsCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.insert(characterAsCharacter);
                    return true;
                case 6:
                    if (!htmlTreeBuilder.currentElement().normalName().equals("html")) {
                        htmlTreeBuilder.error(this);
                    }
                    return true;
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    InSelectInTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.17
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InSelecTableEnd)) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            }
            if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.InSelecTableEnd)) {
                htmlTreeBuilder.error(this);
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    return false;
                }
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            }
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InSelect);
        }
    },
    AfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.18
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEndTag() && token.asEndTag().normalName().equals("html")) {
                if (htmlTreeBuilder.isFragmentParsing()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterBody);
                return true;
            }
            if (token.isEOF()) {
                return true;
            }
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
            return htmlTreeBuilder.process(token);
        }
    },
    InFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.19
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token.StartTag startTagAsStartTag;
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (token.isDoctype()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (token.isStartTag()) {
                    startTagAsStartTag = token.asStartTag();
                    String strNormalName = startTagAsStartTag.normalName();
                    strNormalName.hashCode();
                    switch (strNormalName) {
                        case "frameset":
                            htmlTreeBuilder.insert(startTagAsStartTag);
                            break;
                        case "html":
                            return htmlTreeBuilder.process(startTagAsStartTag, HtmlTreeBuilderState.InBody);
                        case "frame":
                            htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                            break;
                        case "noframes":
                            return htmlTreeBuilder.process(startTagAsStartTag, HtmlTreeBuilderState.InHead);
                        default:
                            htmlTreeBuilder.error(this);
                            return false;
                    }
                } else if (token.isEndTag() && token.asEndTag().normalName().equals("frameset")) {
                    if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.pop();
                    if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElement().normalName().equals("frameset")) {
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterFrameset);
                    }
                } else if (token.isEOF()) {
                    if (!htmlTreeBuilder.currentElement().normalName().equals("html")) {
                        htmlTreeBuilder.error(this);
                    }
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            return true;
        }
    },
    AfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.20
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEndTag() && token.asEndTag().normalName().equals("html")) {
                htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterFrameset);
                return true;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
            }
            if (token.isEOF()) {
                return true;
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    AfterAfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.21
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (!token.isDoctype() && (!token.isStartTag() || !token.asStartTag().normalName().equals("html"))) {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    Element elementPopStackToClose = htmlTreeBuilder.popStackToClose("html");
                    htmlTreeBuilder.insert(token.asCharacter());
                    htmlTreeBuilder.stack.add(elementPopStackToClose);
                    htmlTreeBuilder.stack.add(elementPopStackToClose.selectFirst("body"));
                    return true;
                }
                if (token.isEOF()) {
                    return true;
                }
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
                return htmlTreeBuilder.process(token);
            }
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }
    },
    AfterAfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.22
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().normalName().equals("html"))) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEOF()) {
                return true;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    ForeignContent { // from class: org.jsoup.parser.HtmlTreeBuilderState.23
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };

    private static final String nullString = String.valueOf((char) 0);

    static final class Constants {
        static final String[] InHeadEmpty = {"base", "basefont", "bgsound", "command", "link"};
        static final String[] InHeadRaw = {"noframes", "style"};
        static final String[] InHeadEnd = {"body", "br", "html"};
        static final String[] AfterHeadBody = {"body", "html"};
        static final String[] BeforeHtmlToHead = {"body", "br", "head", "html"};
        static final String[] InHeadNoScriptHead = {"basefont", "bgsound", "link", "meta", "noframes", "style"};
        static final String[] InBodyStartToHead = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE};
        static final String[] InBodyStartPClosers = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
        static final String[] Headings = {"h1", "h2", "h3", "h4", "h5", "h6"};
        static final String[] InBodyStartLiBreakers = {"address", "div", "p"};
        static final String[] DdDt = {"dd", "dt"};
        static final String[] Formatters = {"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
        static final String[] InBodyStartApplets = {"applet", "marquee", "object"};
        static final String[] InBodyStartEmptyFormatters = {"area", "br", "embed", "img", "keygen", "wbr"};
        static final String[] InBodyStartMedia = {RemoteMessageConst.MessageBody.PARAM, "source", FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK};
        static final String[] InBodyStartInputAttribs = {"action", AppMeasurementSdk.ConditionalUserProperty.NAME, "prompt"};
        static final String[] InBodyStartDrop = {"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InBodyEndClosers = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
        static final String[] InBodyEndAdoptionFormatters = {"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
        static final String[] InBodyEndTableFosters = {"table", "tbody", "tfoot", "thead", "tr"};
        static final String[] InTableToBody = {"tbody", "tfoot", "thead"};
        static final String[] InTableAddBody = {"td", "th", "tr"};
        static final String[] InTableToHead = {"script", "style"};
        static final String[] InCellNames = {"td", "th"};
        static final String[] InCellBody = {"body", "caption", "col", "colgroup", "html"};
        static final String[] InCellTable = {"table", "tbody", "tfoot", "thead", "tr"};
        static final String[] InCellCol = {"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTableEndErr = {"body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTableFoster = {"table", "tbody", "tfoot", "thead", "tr"};
        static final String[] InTableBodyExit = {"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
        static final String[] InTableBodyEndIgnore = {"body", "caption", "col", "colgroup", "html", "td", "th", "tr"};
        static final String[] InRowMissing = {"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
        static final String[] InRowIgnore = {"body", "caption", "col", "colgroup", "html", "td", "th"};
        static final String[] InSelectEnd = {"input", "keygen", "textarea"};
        static final String[] InSelecTableEnd = {"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTableEndIgnore = {"tbody", "tfoot", "thead"};
        static final String[] InHeadNoscriptIgnore = {"head", "noscript"};
        static final String[] InCaptionIgnore = {"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
    }

    abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$24, reason: invalid class name */
    static /* synthetic */ class AnonymousClass24 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$org$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return StringUtil.isBlank(token.asCharacter().getData());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        return StringUtil.isBlank(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }
}
