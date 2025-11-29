package com.google.android.exoplayer2.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes2.dex */
final class TtmlNode {
    private List<TtmlNode> children;
    public final long endTimeUs;
    public final String imageId;
    public final boolean isTextNode;
    private final HashMap<String, Integer> nodeEndsByRegion;
    private final HashMap<String, Integer> nodeStartsByRegion;
    public final TtmlNode parent;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    private final String[] styleIds;
    public final String tag;
    public final String text;

    public static TtmlNode buildTextNode(String text) {
        return new TtmlNode(null, TtmlRenderUtil.applyTextElementSpacePolicy(text), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static TtmlNode buildNode(String tag, long startTimeUs, long endTimeUs, TtmlStyle style, String[] styleIds, String regionId, String imageId, TtmlNode parent) {
        return new TtmlNode(tag, null, startTimeUs, endTimeUs, style, styleIds, regionId, imageId, parent);
    }

    private TtmlNode(String tag, String text, long startTimeUs, long endTimeUs, TtmlStyle style, String[] styleIds, String regionId, String imageId, TtmlNode parent) {
        this.tag = tag;
        this.text = text;
        this.imageId = imageId;
        this.style = style;
        this.styleIds = styleIds;
        this.isTextNode = text != null;
        this.startTimeUs = startTimeUs;
        this.endTimeUs = endTimeUs;
        this.regionId = (String) Assertions.checkNotNull(regionId);
        this.parent = parent;
        this.nodeStartsByRegion = new HashMap<>();
        this.nodeEndsByRegion = new HashMap<>();
    }

    public boolean isActive(long timeUs) {
        long j = this.startTimeUs;
        return (j == -9223372036854775807L && this.endTimeUs == -9223372036854775807L) || (j <= timeUs && this.endTimeUs == -9223372036854775807L) || ((j == -9223372036854775807L && timeUs < this.endTimeUs) || (j <= timeUs && timeUs < this.endTimeUs));
    }

    public void addChild(TtmlNode child) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(child);
    }

    public TtmlNode getChild(int index) {
        List<TtmlNode> list = this.children;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(index);
    }

    public int getChildCount() {
        List<TtmlNode> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long[] getEventTimesUs() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    private void getEventTimes(TreeSet<Long> out, boolean descendsPNode) {
        boolean zEquals = "p".equals(this.tag);
        boolean zEquals2 = "div".equals(this.tag);
        if (descendsPNode || zEquals || (zEquals2 && this.imageId != null)) {
            long j = this.startTimeUs;
            if (j != -9223372036854775807L) {
                out.add(Long.valueOf(j));
            }
            long j2 = this.endTimeUs;
            if (j2 != -9223372036854775807L) {
                out.add(Long.valueOf(j2));
            }
        }
        if (this.children == null) {
            return;
        }
        for (int i = 0; i < this.children.size(); i++) {
            this.children.get(i).getEventTimes(out, descendsPNode || zEquals);
        }
    }

    public List<Cue> getCues(long timeUs, Map<String, TtmlStyle> globalStyles, Map<String, TtmlRegion> regionMap, Map<String, String> imageMap) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        traverseForImage(timeUs, this.regionId, arrayList);
        TreeMap treeMap = new TreeMap();
        traverseForText(timeUs, false, this.regionId, treeMap);
        traverseForStyle(timeUs, globalStyles, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = imageMap.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                TtmlRegion ttmlRegion = (TtmlRegion) Assertions.checkNotNull(regionMap.get(pair.first));
                arrayList2.add(new Cue.Builder().setBitmap(bitmapDecodeByteArray).setPosition(ttmlRegion.position).setPositionAnchor(0).setLine(ttmlRegion.line, 0).setLineAnchor(ttmlRegion.lineAnchor).setSize(ttmlRegion.width).setBitmapHeight(ttmlRegion.height).build());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = (TtmlRegion) Assertions.checkNotNull(regionMap.get(entry.getKey()));
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            cleanUpText((SpannableStringBuilder) Assertions.checkNotNull(builder.getText()));
            builder.setLine(ttmlRegion2.line, ttmlRegion2.lineType);
            builder.setLineAnchor(ttmlRegion2.lineAnchor);
            builder.setPosition(ttmlRegion2.position);
            builder.setSize(ttmlRegion2.width);
            builder.setTextSize(ttmlRegion2.textSize, ttmlRegion2.textSizeType);
            arrayList2.add(builder.build());
        }
        return arrayList2;
    }

    private void traverseForImage(long timeUs, String inheritedRegion, List<Pair<String, String>> regionImageList) {
        if (!"".equals(this.regionId)) {
            inheritedRegion = this.regionId;
        }
        if (isActive(timeUs) && "div".equals(this.tag) && this.imageId != null) {
            regionImageList.add(new Pair<>(inheritedRegion, this.imageId));
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            getChild(i).traverseForImage(timeUs, inheritedRegion, regionImageList);
        }
    }

    private void traverseForText(long timeUs, boolean descendsPNode, String inheritedRegion, Map<String, Cue.Builder> regionOutputs) {
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        if ("metadata".equals(this.tag)) {
            return;
        }
        if (!"".equals(this.regionId)) {
            inheritedRegion = this.regionId;
        }
        if (this.isTextNode && descendsPNode) {
            getRegionOutputText(inheritedRegion, regionOutputs).append((CharSequence) Assertions.checkNotNull(this.text));
            return;
        }
        if ("br".equals(this.tag) && descendsPNode) {
            getRegionOutputText(inheritedRegion, regionOutputs).append('\n');
            return;
        }
        if (isActive(timeUs)) {
            for (Map.Entry<String, Cue.Builder> entry : regionOutputs.entrySet()) {
                this.nodeStartsByRegion.put(entry.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(entry.getValue().getText())).length()));
            }
            boolean zEquals = "p".equals(this.tag);
            for (int i = 0; i < getChildCount(); i++) {
                getChild(i).traverseForText(timeUs, descendsPNode || zEquals, inheritedRegion, regionOutputs);
            }
            if (zEquals) {
                TtmlRenderUtil.endParagraph(getRegionOutputText(inheritedRegion, regionOutputs));
            }
            for (Map.Entry<String, Cue.Builder> entry2 : regionOutputs.entrySet()) {
                this.nodeEndsByRegion.put(entry2.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(entry2.getValue().getText())).length()));
            }
        }
    }

    private static SpannableStringBuilder getRegionOutputText(String resolvedRegionId, Map<String, Cue.Builder> regionOutputs) {
        if (!regionOutputs.containsKey(resolvedRegionId)) {
            Cue.Builder builder = new Cue.Builder();
            builder.setText(new SpannableStringBuilder());
            regionOutputs.put(resolvedRegionId, builder);
        }
        return (SpannableStringBuilder) Assertions.checkNotNull(regionOutputs.get(resolvedRegionId).getText());
    }

    private void traverseForStyle(long timeUs, Map<String, TtmlStyle> globalStyles, Map<String, Cue.Builder> regionOutputs) {
        int iIntValue;
        if (isActive(timeUs)) {
            Iterator<Map.Entry<String, Integer>> it = this.nodeEndsByRegion.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                iIntValue = this.nodeStartsByRegion.containsKey(key) ? this.nodeStartsByRegion.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    applyStyleToOutput(globalStyles, (Cue.Builder) Assertions.checkNotNull(regionOutputs.get(key)), iIntValue, iIntValue2);
                }
            }
            while (iIntValue < getChildCount()) {
                getChild(iIntValue).traverseForStyle(timeUs, globalStyles, regionOutputs);
                iIntValue++;
            }
        }
    }

    private void applyStyleToOutput(Map<String, TtmlStyle> globalStyles, Cue.Builder regionOutput, int start, int end) {
        TtmlStyle ttmlStyleResolveStyle = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, globalStyles);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) regionOutput.getText();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            regionOutput.setText(spannableStringBuilder);
        }
        if (ttmlStyleResolveStyle != null) {
            TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder, start, end, ttmlStyleResolveStyle, this.parent);
            regionOutput.setVerticalType(ttmlStyleResolveStyle.getVerticalType());
        }
    }

    private static void cleanUpText(SpannableStringBuilder builder) {
        for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) builder.getSpans(0, builder.length(), DeleteTextSpan.class)) {
            builder.replace(builder.getSpanStart(deleteTextSpan), builder.getSpanEnd(deleteTextSpan), "");
        }
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == ' ') {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < builder.length() && builder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - i2;
                if (i4 > 0) {
                    builder.delete(i, i4 + i);
                }
            }
        }
        if (builder.length() > 0 && builder.charAt(0) == ' ') {
            builder.delete(0, 1);
        }
        for (int i5 = 0; i5 < builder.length() - 1; i5++) {
            if (builder.charAt(i5) == '\n') {
                int i6 = i5 + 1;
                if (builder.charAt(i6) == ' ') {
                    builder.delete(i6, i5 + 2);
                }
            }
        }
        if (builder.length() > 0 && builder.charAt(builder.length() - 1) == ' ') {
            builder.delete(builder.length() - 1, builder.length());
        }
        for (int i7 = 0; i7 < builder.length() - 1; i7++) {
            if (builder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                if (builder.charAt(i8) == '\n') {
                    builder.delete(i7, i8);
                }
            }
        }
        if (builder.length() <= 0 || builder.charAt(builder.length() - 1) != '\n') {
            return;
        }
        builder.delete(builder.length() - 1, builder.length());
    }
}
