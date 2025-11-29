package ru.tinkoff.decoro.slots;

import java.util.HashSet;
import java.util.Iterator;
import ru.tinkoff.decoro.slots.Slot;

/* loaded from: classes4.dex */
public class SlotValidatorSet extends HashSet<Slot.SlotValidator> implements Slot.SlotValidator {
    public static SlotValidatorSet setOf(Slot.SlotValidator... slotValidatorArr) {
        if (slotValidatorArr == null) {
            return new SlotValidatorSet();
        }
        SlotValidatorSet slotValidatorSet = new SlotValidatorSet(slotValidatorArr.length);
        for (Slot.SlotValidator slotValidator : slotValidatorArr) {
            if (slotValidator instanceof SlotValidatorSet) {
                slotValidatorSet.addAll((SlotValidatorSet) slotValidator);
            } else {
                slotValidatorSet.add(slotValidator);
            }
        }
        return slotValidatorSet;
    }

    public SlotValidatorSet() {
    }

    public SlotValidatorSet(int i) {
        super(i);
    }

    @Override // ru.tinkoff.decoro.slots.Slot.SlotValidator
    public boolean validate(char c) {
        Iterator<Slot.SlotValidator> it = iterator();
        while (it.hasNext()) {
            if (it.next().validate(c)) {
                return true;
            }
        }
        return false;
    }
}
