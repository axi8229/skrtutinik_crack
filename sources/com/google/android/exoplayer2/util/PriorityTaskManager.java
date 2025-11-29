package com.google.android.exoplayer2.util;

import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
public final class PriorityTaskManager {
    private final Object lock = new Object();
    private final PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
    private int highestPriority = Integer.MIN_VALUE;

    public void add(int priority) {
        synchronized (this.lock) {
            this.queue.add(Integer.valueOf(priority));
            this.highestPriority = Math.max(this.highestPriority, priority);
        }
    }

    public void remove(int priority) {
        synchronized (this.lock) {
            this.queue.remove(Integer.valueOf(priority));
            this.highestPriority = this.queue.isEmpty() ? Integer.MIN_VALUE : ((Integer) Util.castNonNull(this.queue.peek())).intValue();
            this.lock.notifyAll();
        }
    }
}
