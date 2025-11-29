package ru.tinkoff.decoro.slots;

import ru.tinkoff.decoro.slots.Slot;

/* loaded from: classes4.dex */
public class SlotValidators$DigitValidator implements Slot.SlotValidator {
    public int hashCode() {
        return -56329;
    }

    @Override // ru.tinkoff.decoro.slots.Slot.SlotValidator
    public boolean validate(char c) {
        return Character.isDigit(c);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof SlotValidators$DigitValidator);
    }
}
