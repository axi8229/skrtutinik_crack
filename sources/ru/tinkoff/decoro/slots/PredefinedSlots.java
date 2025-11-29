package ru.tinkoff.decoro.slots;

import java.util.Arrays;
import ru.tinkoff.decoro.slots.Slot;

/* loaded from: classes4.dex */
public final class PredefinedSlots {
    public static final Slot[] SINGLE_SLOT = {any()};
    public static final Slot[] RUS_PHONE_NUMBER = {hardcodedSlot('+'), hardcodedSlot('7'), hardcodedSlot(' ').withTags(14779), hardcodedSlot('(').withTags(14779), digit(), digit(), digit(), hardcodedSlot(')').withTags(14779), hardcodedSlot(' ').withTags(14779), digit(), digit(), digit(), hardcodedSlot('-').withTags(14779), digit(), digit(), hardcodedSlot('-').withTags(14779), digit(), digit()};
    public static final Slot[] RUS_PASSPORT = {digit(), digit(), digit(), digit(), hardcodedSlot(' '), digit(), digit(), digit(), digit(), digit(), digit()};
    public static final Slot[] CARD_NUMBER_STANDARD = {digit(), digit(), digit(), digit(), hardcodedSlot(' ').withTags(14779), digit(), digit(), digit(), digit(), hardcodedSlot(' ').withTags(14779), digit(), digit(), digit(), digit(), hardcodedSlot(' ').withTags(14779), digit(), digit(), digit(), digit()};
    public static final Slot[] CARD_NUMBER_MAESTRO = {digit(), digit(), digit(), digit(), digit(), digit(), digit(), digit(), hardcodedSlot(' ').withTags(14779), digit(), digit(), digit(), digit()};
    public static final Slot[] CARD_NUMBER_STANDARD_MASKABLE = {digit(), maskableDigit(), maskableDigit(), maskableDigit(), hardcodedSlot(' ').withTags(14779), maskableDigit(), maskableDigit(), maskableDigit(), maskableDigit(), hardcodedSlot(' ').withTags(14779), maskableDigit(), maskableDigit(), maskableDigit(), maskableDigit(), hardcodedSlot(' ').withTags(14779), maskableDigit(), maskableDigit(), maskableDigit(), maskableDigit()};
    public static final Slot[] CARD_NUMBER_MAESTRO_MASKABLE = {digit(), maskableDigit(), maskableDigit(), maskableDigit(), maskableDigit(), maskableDigit(), maskableDigit(), maskableDigit(), hardcodedSlot(' ').withTags(14779), maskableDigit(), maskableDigit(), maskableDigit(), maskableDigit()};

    public static Slot hardcodedSlot(char c) {
        return new Slot(3, Character.valueOf(c), null);
    }

    public static Slot digit() {
        return new Slot(null, new SlotValidators$DigitValidator());
    }

    public static Slot any() {
        return new Slot(null, new Slot.SlotValidator() { // from class: ru.tinkoff.decoro.slots.SlotValidators$GenerousValidator
            public int hashCode() {
                return -56328;
            }

            @Override // ru.tinkoff.decoro.slots.Slot.SlotValidator
            public boolean validate(char c) {
                return true;
            }

            public boolean equals(Object obj) {
                return obj != null && (obj instanceof SlotValidators$GenerousValidator);
            }
        });
    }

    public static Slot maskableDigit() {
        return new Slot(null, new SlotValidators$DigitValidator() { // from class: ru.tinkoff.decoro.slots.SlotValidators$MaskedDigitValidator
            private static final char[] DEFAULT_DIGIT_MASK_CHARS = {'X', 'x', '*'};
            private char[] maskChars = DEFAULT_DIGIT_MASK_CHARS;

            @Override // ru.tinkoff.decoro.slots.SlotValidators$DigitValidator, ru.tinkoff.decoro.slots.Slot.SlotValidator
            public boolean validate(char c) {
                if (super.validate(c)) {
                    return true;
                }
                for (char c2 : this.maskChars) {
                    if (c2 == c) {
                        return true;
                    }
                }
                return false;
            }

            @Override // ru.tinkoff.decoro.slots.SlotValidators$DigitValidator
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return Arrays.equals(this.maskChars, ((SlotValidators$MaskedDigitValidator) obj).maskChars);
            }

            @Override // ru.tinkoff.decoro.slots.SlotValidators$DigitValidator
            public int hashCode() {
                return Arrays.hashCode(this.maskChars);
            }
        });
    }
}
