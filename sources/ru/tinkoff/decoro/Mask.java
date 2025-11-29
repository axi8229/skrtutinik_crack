package ru.tinkoff.decoro;

import android.os.Parcelable;
import ru.tinkoff.decoro.slots.Slot;

/* loaded from: classes4.dex */
public interface Mask extends Iterable<Slot>, Parcelable {
    int getInitialInputPosition();

    int insertAt(int i, CharSequence charSequence);

    int insertFront(CharSequence charSequence);

    int removeBackwards(int i, int i2);

    int removeBackwardsWithoutHardcoded(int i, int i2);
}
