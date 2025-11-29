package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.SpanUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Map;

/* loaded from: classes2.dex */
final class TtmlRenderUtil {
    public static TtmlStyle resolveStyle(TtmlStyle style, String[] styleIds, Map<String, TtmlStyle> globalStyles) {
        int i = 0;
        if (style == null) {
            if (styleIds == null) {
                return null;
            }
            if (styleIds.length == 1) {
                return globalStyles.get(styleIds[0]);
            }
            if (styleIds.length > 1) {
                TtmlStyle ttmlStyle = new TtmlStyle();
                int length = styleIds.length;
                while (i < length) {
                    ttmlStyle.chain(globalStyles.get(styleIds[i]));
                    i++;
                }
                return ttmlStyle;
            }
        } else {
            if (styleIds != null && styleIds.length == 1) {
                return style.chain(globalStyles.get(styleIds[0]));
            }
            if (styleIds != null && styleIds.length > 1) {
                int length2 = styleIds.length;
                while (i < length2) {
                    style.chain(globalStyles.get(styleIds[i]));
                    i++;
                }
            }
        }
        return style;
    }

    public static void applyStylesToSpan(Spannable builder, int start, int end, TtmlStyle style, TtmlNode parent) {
        TtmlNode ttmlNodeFindRubyTextNode;
        if (style.getStyle() != -1) {
            builder.setSpan(new StyleSpan(style.getStyle()), start, end, 33);
        }
        if (style.isLinethrough()) {
            builder.setSpan(new StrikethroughSpan(), start, end, 33);
        }
        if (style.isUnderline()) {
            builder.setSpan(new UnderlineSpan(), start, end, 33);
        }
        if (style.hasFontColor()) {
            SpanUtil.addOrReplaceSpan(builder, new ForegroundColorSpan(style.getFontColor()), start, end, 33);
        }
        if (style.hasBackgroundColor()) {
            SpanUtil.addOrReplaceSpan(builder, new BackgroundColorSpan(style.getBackgroundColor()), start, end, 33);
        }
        if (style.getFontFamily() != null) {
            SpanUtil.addOrReplaceSpan(builder, new TypefaceSpan(style.getFontFamily()), start, end, 33);
        }
        int rubyType = style.getRubyType();
        if (rubyType == 2) {
            TtmlNode ttmlNodeFindRubyContainerNode = findRubyContainerNode(parent);
            if (ttmlNodeFindRubyContainerNode != null && (ttmlNodeFindRubyTextNode = findRubyTextNode(ttmlNodeFindRubyContainerNode)) != null) {
                if (ttmlNodeFindRubyTextNode.getChildCount() == 1 && ttmlNodeFindRubyTextNode.getChild(0).text != null) {
                    String str = (String) Util.castNonNull(ttmlNodeFindRubyTextNode.getChild(0).text);
                    TtmlStyle ttmlStyle = ttmlNodeFindRubyContainerNode.style;
                    builder.setSpan(new RubySpan(str, ttmlStyle != null ? ttmlStyle.getRubyPosition() : -1), start, end, 33);
                } else {
                    Log.i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                }
            }
        } else if (rubyType == 3 || rubyType == 4) {
            builder.setSpan(new DeleteTextSpan(), start, end, 33);
        }
        Layout.Alignment textAlign = style.getTextAlign();
        if (textAlign != null) {
            SpanUtil.addOrReplaceSpan(builder, new AlignmentSpan.Standard(textAlign), start, end, 33);
        }
        if (style.getTextCombine()) {
            SpanUtil.addOrReplaceSpan(builder, new HorizontalTextInVerticalContextSpan(), start, end, 33);
        }
        int fontSizeUnit = style.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            SpanUtil.addOrReplaceSpan(builder, new AbsoluteSizeSpan((int) style.getFontSize(), true), start, end, 33);
        } else if (fontSizeUnit == 2) {
            SpanUtil.addOrReplaceSpan(builder, new RelativeSizeSpan(style.getFontSize()), start, end, 33);
        } else {
            if (fontSizeUnit != 3) {
                return;
            }
            SpanUtil.addOrReplaceSpan(builder, new RelativeSizeSpan(style.getFontSize() / 100.0f), start, end, 33);
        }
    }

    private static TtmlNode findRubyTextNode(TtmlNode rubyContainerNode) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(rubyContainerNode);
        while (!arrayDeque.isEmpty()) {
            TtmlNode ttmlNode = (TtmlNode) arrayDeque.pop();
            TtmlStyle ttmlStyle = ttmlNode.style;
            if (ttmlStyle != null && ttmlStyle.getRubyType() == 3) {
                return ttmlNode;
            }
            for (int childCount = ttmlNode.getChildCount() - 1; childCount >= 0; childCount--) {
                arrayDeque.push(ttmlNode.getChild(childCount));
            }
        }
        return null;
    }

    private static TtmlNode findRubyContainerNode(TtmlNode node) {
        while (node != null) {
            TtmlStyle ttmlStyle = node.style;
            if (ttmlStyle != null && ttmlStyle.getRubyType() == 1) {
                return node;
            }
            node = node.parent;
        }
        return null;
    }

    static void endParagraph(SpannableStringBuilder builder) {
        int length = builder.length() - 1;
        while (length >= 0 && builder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || builder.charAt(length) == '\n') {
            return;
        }
        builder.append('\n');
    }

    static String applyTextElementSpacePolicy(String in) {
        return in.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }
}
