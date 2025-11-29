package ru.tinkoff.decoro.slots;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public final class Slot implements Serializable, Parcelable {
    public static final Parcelable.Creator<Slot> CREATOR = new Parcelable.Creator<Slot>() { // from class: ru.tinkoff.decoro.slots.Slot.1
        @Override // android.os.Parcelable.Creator
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private transient Slot nextSlot;
    private transient Slot prevSlot;
    private int rulesFlags;
    private final Set<Integer> tags;
    private SlotValidatorSet validators;
    private Character value;
    private ValueInterpreter valueInterpreter;

    public interface SlotValidator extends Serializable {
        boolean validate(char c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Slot(int i, Character ch, SlotValidatorSet slotValidatorSet) {
        this.rulesFlags = 0;
        this.tags = new HashSet();
        this.rulesFlags = i;
        this.value = ch;
        this.validators = slotValidatorSet == null ? new SlotValidatorSet() : slotValidatorSet;
    }

    public Slot(Character ch, SlotValidator... slotValidatorArr) {
        this(0, ch, SlotValidatorSet.setOf(slotValidatorArr));
    }

    public Slot() {
        this(0, null, null);
    }

    public Slot(Slot slot) {
        this(slot.rulesFlags, slot.value, slot.getValidators());
        this.valueInterpreter = slot.valueInterpreter;
        this.tags.addAll(slot.tags);
    }

    public boolean anyInputToTheRight() {
        if (this.value != null && !hardcoded()) {
            return true;
        }
        Slot slot = this.nextSlot;
        if (slot != null) {
            return slot.anyInputToTheRight();
        }
        return false;
    }

    public int setValue(Character ch) {
        return setValue(ch, false);
    }

    public int setValue(Character ch, boolean z) {
        return setValueInner(0, ch, z);
    }

    private int setValueInner(int i, Character ch, boolean z) {
        ValueInterpreter valueInterpreter = this.valueInterpreter;
        if (valueInterpreter != null) {
            ch = valueInterpreter.interpret(ch);
        }
        if (ch == null) {
            removeCurrentValue();
            return checkRule(4) ? 1 : 0;
        }
        return setNewValue(i, ch, z);
    }

    public Character getValue() {
        return this.value;
    }

    public boolean canInsertHere(char c) {
        ValueInterpreter valueInterpreter = this.valueInterpreter;
        if (valueInterpreter != null) {
            c = valueInterpreter.interpret(Character.valueOf(c)).charValue();
        }
        if (hardcoded()) {
            return this.value.equals(Character.valueOf(c));
        }
        return validate(c);
    }

    private boolean validate(char c) {
        SlotValidatorSet slotValidatorSet = this.validators;
        return slotValidatorSet == null || slotValidatorSet.validate(c);
    }

    public boolean hardcoded() {
        return this.value != null && checkRule(2);
    }

    public int hardcodedSequenceEndIndex() {
        return hardcodedSequenceEndIndex(0);
    }

    public int hardcodedSequenceEndIndex(int i) {
        Slot slot;
        if (hardcoded() && ((slot = this.nextSlot) == null || !slot.hardcoded())) {
            return i + 1;
        }
        if (hardcoded() && this.nextSlot.hardcoded()) {
            return this.nextSlot.hardcodedSequenceEndIndex(i + 1);
        }
        return -1;
    }

    private int setNewValue(int i, Character ch, boolean z) {
        int iPushValueToSlot;
        boolean z2 = true;
        boolean z3 = z && checkRule(2) && !checkRule(1);
        if (hardcoded() && !z3 && this.value.equals(ch)) {
            return checkRule(8) ? i : i + 1;
        }
        if (checkRule(2) || z3) {
            iPushValueToSlot = pushValueToSlot(i + 1, ch, this.nextSlot);
            z2 = false;
        } else {
            iPushValueToSlot = 0;
        }
        Character ch2 = this.value;
        if (ch2 != null && (this.rulesFlags & 3) == 0) {
            pushValueToSlot(0, ch2, this.nextSlot);
        }
        if (!z2) {
            return iPushValueToSlot;
        }
        this.value = ch;
        if (!checkRule(8)) {
            i++;
        }
        return i;
    }

    private boolean checkRule(int i) {
        return (this.rulesFlags & i) == i;
    }

    private void removeCurrentValue() {
        if (!hardcoded()) {
            this.value = pullValueFromSlot(this.nextSlot);
            return;
        }
        Slot slot = this.prevSlot;
        if (slot != null) {
            slot.removeCurrentValue();
        }
    }

    private int pushValueToSlot(int i, Character ch, Slot slot) {
        if (slot == null) {
            return 0;
        }
        return this.nextSlot.setValueInner(i, ch, true);
    }

    private Character pullValueFromSlot(Slot slot) {
        if (slot == null) {
            return null;
        }
        if (!slot.hardcoded()) {
            Character value = slot.getValue();
            if (value != null && !validate(value.charValue())) {
                return null;
            }
            slot.removeCurrentValue();
            return value;
        }
        if (slot.getNextSlot() != null) {
            return pullValueFromSlot(slot.getNextSlot());
        }
        return null;
    }

    public Slot getNextSlot() {
        return this.nextSlot;
    }

    public void setNextSlot(Slot slot) {
        this.nextSlot = slot;
    }

    public Slot getPrevSlot() {
        return this.prevSlot;
    }

    public void setPrevSlot(Slot slot) {
        this.prevSlot = slot;
    }

    public SlotValidatorSet getValidators() {
        return this.validators;
    }

    public Slot withTags(Integer... numArr) {
        if (numArr == null) {
            return this;
        }
        for (Integer num : numArr) {
            if (num != null) {
                this.tags.add(num);
            }
        }
        return this;
    }

    public boolean hasTag(Integer num) {
        if (num == null) {
            return false;
        }
        return this.tags.contains(num);
    }

    public String toString() {
        return "Slot{value=" + this.value + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.rulesFlags);
        parcel.writeSerializable(this.value);
        parcel.writeSerializable(this.validators);
        parcel.writeSerializable(this.valueInterpreter);
        parcel.writeInt(this.tags.size());
        Iterator<Integer> it = this.tags.iterator();
        while (it.hasNext()) {
            parcel.writeInt(it.next().intValue());
        }
    }

    protected Slot(Parcel parcel) {
        this.rulesFlags = 0;
        this.tags = new HashSet();
        this.rulesFlags = parcel.readInt();
        this.value = (Character) parcel.readSerializable();
        this.validators = (SlotValidatorSet) parcel.readSerializable();
        this.valueInterpreter = (ValueInterpreter) parcel.readSerializable();
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.tags.add(Integer.valueOf(parcel.readInt()));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Slot.class != obj.getClass()) {
            return false;
        }
        Slot slot = (Slot) obj;
        if (this.rulesFlags != slot.rulesFlags) {
            return false;
        }
        Character ch = this.value;
        if (ch == null ? slot.value != null : !ch.equals(slot.value)) {
            return false;
        }
        Set<Integer> set = this.tags;
        if (set == null ? slot.tags != null : !set.equals(slot.tags)) {
            return false;
        }
        SlotValidatorSet slotValidatorSet = this.validators;
        SlotValidatorSet slotValidatorSet2 = slot.validators;
        return slotValidatorSet != null ? slotValidatorSet.equals(slotValidatorSet2) : slotValidatorSet2 == null;
    }

    public int hashCode() {
        int i = this.rulesFlags * 31;
        Character ch = this.value;
        int iHashCode = (i + (ch != null ? ch.hashCode() : 0)) * 31;
        Set<Integer> set = this.tags;
        int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
        SlotValidatorSet slotValidatorSet = this.validators;
        return iHashCode2 + (slotValidatorSet != null ? slotValidatorSet.hashCode() : 0);
    }
}
