package ru.tinkoff.decoro.parser;

import ru.tinkoff.decoro.TextUtils;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.slots.Slot;

/* loaded from: classes4.dex */
public class UnderscoreDigitSlotsParser {
    public Slot[] parseSlots(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            throw new IllegalArgumentException("String representation of the mask's slots is empty");
        }
        Slot[] slotArr = new Slot[charSequence.length()];
        for (int i = 0; i < charSequence.length(); i++) {
            slotArr[i] = slotFromChar(charSequence.charAt(i));
        }
        return slotArr;
    }

    protected Slot slotFromChar(char c) {
        if (c == '_') {
            return slotFromUnderscoreCharacter();
        }
        return slotFromNonUnderscoredChar(c);
    }

    protected Slot slotFromUnderscoreCharacter() {
        return PredefinedSlots.digit();
    }

    protected Slot slotFromNonUnderscoredChar(char c) {
        return PredefinedSlots.hardcodedSlot(c);
    }
}
