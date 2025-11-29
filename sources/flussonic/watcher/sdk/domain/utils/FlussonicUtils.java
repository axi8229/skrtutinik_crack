package flussonic.watcher.sdk.domain.utils;

import flussonic.watcher.sdk.domain.pojo.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class FlussonicUtils {
    public static long utcTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static void reduceRangesRight(List<Range> ranges, long max) {
        int size = ranges.size() - 1;
        while (size >= 0 && ranges.get(size).from() >= max) {
            ranges.remove(size);
            size--;
        }
        if (size >= 0) {
            Range range = ranges.get(size);
            if (range.to() > max) {
                ranges.set(size, Range.createFromTo(range.from(), max));
            }
        }
    }

    public static List<Range> splitRange(Range range, List<Range> ranges) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < ranges.size() && ranges.get(i).to() <= range.from()) {
            i++;
        }
        if (i == ranges.size()) {
            arrayList.add(range);
            return arrayList;
        }
        Range range2 = ranges.get(i);
        if (range2.from() > range.from()) {
            arrayList.add(Range.createFromTo(range.from(), Math.min(range.to(), range2.from())));
        }
        long j = range2.to();
        while (true) {
            i++;
            if (i >= ranges.size() || ranges.get(i).from() > range.to()) {
                break;
            }
            Range range3 = ranges.get(i);
            arrayList.add(Range.createFromTo(j, range3.from()));
            j = range3.to();
        }
        if (j < range.to()) {
            arrayList.add(Range.createFromTo(j, range.to()));
        }
        return arrayList;
    }

    public static List<Range> splitRanges(List<Range> ranges, long maxLength) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ranges.size(); i++) {
            Range range = ranges.get(i);
            long jDuration = range.duration();
            if (jDuration <= maxLength) {
                arrayList.add(range);
            } else {
                long jFrom = range.from();
                while (jDuration > 0) {
                    arrayList.add(Range.createFromDuration(jFrom, jDuration > maxLength ? maxLength : jDuration));
                    jFrom += maxLength;
                    jDuration -= maxLength;
                }
            }
        }
        return arrayList;
    }

    public static void mergeRanges0(List<Range> accumulator, List<Range> ranges) {
        mergeRanges(accumulator, ranges, 0);
    }

    public static void mergeRanges1(List<Range> accumulator, List<Range> ranges) {
        mergeRanges(accumulator, ranges, 1);
    }

    private static void mergeRanges(List<Range> accumulator, List<Range> ranges, int delta) {
        accumulator.addAll(ranges);
        Collections.sort(accumulator, new Comparator() { // from class: flussonic.watcher.sdk.domain.utils.FlussonicUtils$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return FlussonicUtils.lambda$mergeRanges$0((Range) obj, (Range) obj2);
            }
        });
        ArrayList arrayList = new ArrayList();
        for (Range range : accumulator) {
            int size = arrayList.size() - 1;
            Range range2 = arrayList.isEmpty() ? null : (Range) arrayList.get(size);
            if (range2 != null) {
                long j = delta;
                if (range2.to() >= range.from() - j) {
                    if (range.from() - j <= range2.to() && range2.to() < range.to()) {
                        arrayList.set(size, Range.createFromTo(range2.from(), range.to()));
                    }
                }
            }
            arrayList.add(range);
        }
        accumulator.clear();
        accumulator.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$mergeRanges$0(Range r1, Range r2) {
        return Long.compare(r1.from(), r2.from());
    }

    public static long calculateTimelinePosition(List<Range> ranges, long from, long playerPosition) {
        long jFrom;
        long j = from + playerPosition;
        if (ranges.isEmpty()) {
            return j;
        }
        int i = 0;
        while (i < ranges.size() && ranges.get(i).to() < from) {
            i++;
        }
        if (i >= ranges.size()) {
            return j;
        }
        Range range = ranges.get(i);
        if (range.from() <= from && range.to() >= from) {
            if (j <= range.to()) {
                return j;
            }
            playerPosition -= range.to() - from;
            i++;
        }
        while (true) {
            if (i < ranges.size()) {
                range = ranges.get(i);
                if (playerPosition <= range.duration()) {
                    jFrom = range.from();
                    break;
                }
                playerPosition -= range.duration();
                i++;
            } else {
                jFrom = range.to();
                break;
            }
        }
        return jFrom + playerPosition;
    }

    public static boolean contains(List<Range> ranges, long position) {
        for (Range range : ranges) {
            if (range.from() <= position && position <= range.to()) {
                return true;
            }
        }
        return false;
    }

    public static void increaseLastRangeToNowIfNeeded(List<Range> ranges) {
        int size = ranges.size() - 1;
        if (size >= 0) {
            Range range = ranges.get(size);
            long jUtcTimeSeconds = utcTimeSeconds() - range.to();
            if (0 > jUtcTimeSeconds || jUtcTimeSeconds > 60) {
                return;
            }
            ranges.set(size, Range.createFromTo(range.from(), utcTimeSeconds()));
        }
    }

    public static void subtract(List<Range> from, List<Range> what) {
        subtractLinear(from, what);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void subtractLinear(java.util.List<flussonic.watcher.sdk.domain.pojo.Range> r9, java.util.List<flussonic.watcher.sdk.domain.pojo.Range> r10) {
        /*
            boolean r0 = r9.isEmpty()
            if (r0 != 0) goto Lf8
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto Le
            goto Lf8
        Le:
            java.util.ListIterator r10 = r10.listIterator()
            java.util.ListIterator r9 = r9.listIterator()
            java.lang.Object r0 = r10.next()
            flussonic.watcher.sdk.domain.pojo.Range r0 = (flussonic.watcher.sdk.domain.pojo.Range) r0
            java.lang.Object r1 = r9.next()
            flussonic.watcher.sdk.domain.pojo.Range r1 = (flussonic.watcher.sdk.domain.pojo.Range) r1
            r2 = 0
        L23:
            long r3 = r1.from()
            long r5 = r0.to()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r4 = 1
            if (r3 >= 0) goto Le8
            long r5 = r0.duration()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L3c
            goto Le8
        L3c:
            long r5 = r0.from()
            long r7 = r1.to()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L59
            boolean r3 = r9.hasNext()
            if (r3 != 0) goto L51
        L4e:
            r2 = r4
            goto Lf6
        L51:
            java.lang.Object r1 = r9.next()
            flussonic.watcher.sdk.domain.pojo.Range r1 = (flussonic.watcher.sdk.domain.pojo.Range) r1
            goto Lf6
        L59:
            long r5 = r1.from()
            long r7 = r0.from()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L82
            long r5 = r1.to()
            long r7 = r0.to()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 > 0) goto L82
            r9.remove()
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L4e
            java.lang.Object r1 = r9.next()
            flussonic.watcher.sdk.domain.pojo.Range r1 = (flussonic.watcher.sdk.domain.pojo.Range) r1
            goto Lf6
        L82:
            long r3 = r1.from()
            long r5 = r0.from()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto Lbf
            long r3 = r1.to()
            long r5 = r0.to()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto Lbf
            long r3 = r1.from()
            long r5 = r0.from()
            flussonic.watcher.sdk.domain.pojo.Range r3 = flussonic.watcher.sdk.domain.pojo.Range.createFromTo(r3, r5)
            long r4 = r0.to()
            long r6 = r1.to()
            flussonic.watcher.sdk.domain.pojo.Range r1 = flussonic.watcher.sdk.domain.pojo.Range.createFromTo(r4, r6)
            r9.set(r3)
            r9.add(r1)
            java.lang.Object r1 = r9.previous()
            flussonic.watcher.sdk.domain.pojo.Range r1 = (flussonic.watcher.sdk.domain.pojo.Range) r1
            goto Lf6
        Lbf:
            long r3 = r1.from()
            long r5 = r0.from()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto Ld8
            long r3 = r1.from()
            long r5 = r0.from()
            flussonic.watcher.sdk.domain.pojo.Range r1 = flussonic.watcher.sdk.domain.pojo.Range.createFromTo(r3, r5)
            goto Le4
        Ld8:
            long r3 = r0.to()
            long r5 = r1.to()
            flussonic.watcher.sdk.domain.pojo.Range r1 = flussonic.watcher.sdk.domain.pojo.Range.createFromTo(r3, r5)
        Le4:
            r9.set(r1)
            goto Lf6
        Le8:
            boolean r3 = r10.hasNext()
            if (r3 != 0) goto Lf0
            goto L4e
        Lf0:
            java.lang.Object r0 = r10.next()
            flussonic.watcher.sdk.domain.pojo.Range r0 = (flussonic.watcher.sdk.domain.pojo.Range) r0
        Lf6:
            if (r2 == 0) goto L23
        Lf8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flussonic.watcher.sdk.domain.utils.FlussonicUtils.subtractLinear(java.util.List, java.util.List):void");
    }
}
