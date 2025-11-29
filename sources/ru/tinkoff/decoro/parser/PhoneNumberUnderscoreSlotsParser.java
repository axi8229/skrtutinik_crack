package ru.tinkoff.decoro.parser;

import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.slots.SlotValidatorSet;
import ru.tinkoff.decoro.slots.SlotValidators$DigitValidator;

/* loaded from: classes4.dex */
public class PhoneNumberUnderscoreSlotsParser extends UnderscoreDigitSlotsParser {
    private int rule;

    @Override // ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
    public Slot[] parseSlots(CharSequence charSequence) {
        this.rule = 3;
        return super.parseSlots(charSequence);
    }

    @Override // ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
    protected Slot slotFromNonUnderscoredChar(char c) {
        if (!Character.isDigit(c)) {
            this.rule = 3;
            Slot slotHardcodedSlot = PredefinedSlots.hardcodedSlot(c);
            return c == '+' ? slotHardcodedSlot : slotHardcodedSlot.withTags(14779);
        }
        Slot slot = new Slot(this.rule, Character.valueOf(c), SlotValidatorSet.setOf(new SlotValidators$DigitValidator()));
        this.rule = 2;
        return slot;
    }
}
