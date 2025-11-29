package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.SlidingPercentile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class SlidingPercentile {
    private static final Comparator<Sample> INDEX_COMPARATOR = new Comparator() { // from class: com.google.android.exoplayer2.util.SlidingPercentile$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return SlidingPercentile.lambda$static$0((SlidingPercentile.Sample) obj, (SlidingPercentile.Sample) obj2);
        }
    };
    private static final Comparator<Sample> VALUE_COMPARATOR = new Comparator() { // from class: com.google.android.exoplayer2.util.SlidingPercentile$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return SlidingPercentile.lambda$static$1((SlidingPercentile.Sample) obj, (SlidingPercentile.Sample) obj2);
        }
    };
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private int totalWeight;
    private final Sample[] recycledSamples = new Sample[5];
    private final ArrayList<Sample> samples = new ArrayList<>();
    private int currentSortOrder = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(Sample a, Sample b) {
        return a.index - b.index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$1(Sample a, Sample b) {
        return Float.compare(a.value, b.value);
    }

    public SlidingPercentile(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void reset() {
        this.samples.clear();
        this.currentSortOrder = -1;
        this.nextSampleIndex = 0;
        this.totalWeight = 0;
    }

    public void addSample(int weight, float value) {
        Sample sample;
        ensureSortedByIndex();
        int i = this.recycledSampleCount;
        if (i > 0) {
            Sample[] sampleArr = this.recycledSamples;
            int i2 = i - 1;
            this.recycledSampleCount = i2;
            sample = sampleArr[i2];
        } else {
            sample = new Sample();
        }
        int i3 = this.nextSampleIndex;
        this.nextSampleIndex = i3 + 1;
        sample.index = i3;
        sample.weight = weight;
        sample.value = value;
        this.samples.add(sample);
        this.totalWeight += weight;
        while (true) {
            int i4 = this.totalWeight;
            int i5 = this.maxWeight;
            if (i4 <= i5) {
                return;
            }
            int i6 = i4 - i5;
            Sample sample2 = this.samples.get(0);
            int i7 = sample2.weight;
            if (i7 <= i6) {
                this.totalWeight -= i7;
                this.samples.remove(0);
                int i8 = this.recycledSampleCount;
                if (i8 < 5) {
                    Sample[] sampleArr2 = this.recycledSamples;
                    this.recycledSampleCount = i8 + 1;
                    sampleArr2[i8] = sample2;
                }
            } else {
                sample2.weight = i7 - i6;
                this.totalWeight -= i6;
            }
        }
    }

    public float getPercentile(float percentile) {
        ensureSortedByValue();
        float f = percentile * this.totalWeight;
        int i = 0;
        for (int i2 = 0; i2 < this.samples.size(); i2++) {
            Sample sample = this.samples.get(i2);
            i += sample.weight;
            if (i >= f) {
                return sample.value;
            }
        }
        if (this.samples.isEmpty()) {
            return Float.NaN;
        }
        return this.samples.get(r5.size() - 1).value;
    }

    private void ensureSortedByIndex() {
        if (this.currentSortOrder != 1) {
            Collections.sort(this.samples, INDEX_COMPARATOR);
            this.currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue() {
        if (this.currentSortOrder != 0) {
            Collections.sort(this.samples, VALUE_COMPARATOR);
            this.currentSortOrder = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Sample {
        public int index;
        public float value;
        public int weight;

        private Sample() {
        }
    }
}
