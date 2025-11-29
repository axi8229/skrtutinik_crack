package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
final class WebvttSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final List<Cue> cues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List<WebvttCueInfo> cueInfos) {
        this.cues = new ArrayList(cueInfos.size());
        this.cueTimesUs = new long[cueInfos.size() * 2];
        for (int i = 0; i < cueInfos.size(); i++) {
            WebvttCueInfo webvttCueInfo = cueInfos.get(i);
            this.cues.add(webvttCueInfo.cue);
            int i2 = i * 2;
            long[] jArr = this.cueTimesUs;
            jArr[i2] = webvttCueInfo.startTimeUs;
            jArr[i2 + 1] = webvttCueInfo.endTimeUs;
        }
        long[] jArr2 = this.cueTimesUs;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.sortedCueTimesUs = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long timeUs) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.sortedCueTimesUs, timeUs, false, false);
        if (iBinarySearchCeil < this.sortedCueTimesUs.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int index) {
        Assertions.checkArgument(index >= 0);
        Assertions.checkArgument(index < this.sortedCueTimesUs.length);
        return this.sortedCueTimesUs[index];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long timeUs) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = null;
        Cue cue = null;
        for (int i = 0; i < this.cues.size(); i++) {
            long[] jArr = this.cueTimesUs;
            int i2 = i * 2;
            if (jArr[i2] <= timeUs && timeUs < jArr[i2 + 1]) {
                Cue cue2 = this.cues.get(i);
                if (!isNormal(cue2)) {
                    arrayList.add(cue2);
                } else if (cue == null) {
                    cue = cue2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) Assertions.checkNotNull(cue.text)).append((CharSequence) "\n").append((CharSequence) Assertions.checkNotNull(cue2.text));
                } else {
                    spannableStringBuilder.append((CharSequence) "\n").append((CharSequence) Assertions.checkNotNull(cue2.text));
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(WebvttCueParser.newCueForText(spannableStringBuilder));
        } else if (cue != null) {
            arrayList.add(cue);
        }
        return arrayList;
    }

    private static boolean isNormal(Cue cue) {
        return cue.line == -3.4028235E38f && cue.position == 0.5f;
    }
}
