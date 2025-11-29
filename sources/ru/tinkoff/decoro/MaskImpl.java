package ru.tinkoff.decoro;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import ru.tinkoff.decoro.slots.Slot;

/* loaded from: classes4.dex */
public class MaskImpl implements Mask {
    public static final Parcelable.Creator<MaskImpl> CREATOR = new Parcelable.Creator<MaskImpl>() { // from class: ru.tinkoff.decoro.MaskImpl.1
        @Override // android.os.Parcelable.Creator
        public MaskImpl createFromParcel(Parcel parcel) {
            return new MaskImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MaskImpl[] newArray(int i) {
            return new MaskImpl[i];
        }
    };
    private boolean forbidInputWhenFilled;
    private boolean hideHardcodedHead;
    private Character placeholder;
    private boolean showHardcodedTail;
    private boolean showingEmptySlots;
    private SlotsList slots;
    private boolean terminated;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static MaskImpl createTerminated(Slot[] slotArr) {
        return new MaskImpl(slotArr, true);
    }

    public MaskImpl(Slot[] slotArr, boolean z) {
        this.showHardcodedTail = true;
        this.terminated = z;
        SlotsList slotsListOfArray = SlotsList.ofArray(slotArr);
        this.slots = slotsListOfArray;
        if (slotsListOfArray.size() != 1 || z) {
            return;
        }
        extendTail(1);
    }

    public MaskImpl(MaskImpl maskImpl) {
        this(maskImpl, maskImpl.terminated);
    }

    public MaskImpl(MaskImpl maskImpl, boolean z) {
        this.showHardcodedTail = true;
        this.terminated = z;
        this.placeholder = maskImpl.placeholder;
        this.showingEmptySlots = maskImpl.showingEmptySlots;
        this.forbidInputWhenFilled = maskImpl.forbidInputWhenFilled;
        this.hideHardcodedHead = maskImpl.hideHardcodedHead;
        this.showHardcodedTail = maskImpl.showHardcodedTail;
        this.slots = new SlotsList(maskImpl.slots);
    }

    public String toString() {
        return toString(true);
    }

    private String toString(boolean z) {
        return !this.slots.isEmpty() ? toStringFrom(this.slots.getFirstSlot(), z) : "";
    }

    @Override // java.lang.Iterable
    public Iterator<Slot> iterator() {
        return this.slots.iterator();
    }

    private String toStringFrom(Slot slot, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (slot != null) {
            Character value = slot.getValue();
            if (z || !slot.hasTag(14779)) {
                boolean zAnyInputToTheRight = slot.anyInputToTheRight();
                if (!zAnyInputToTheRight && !this.showingEmptySlots && (!this.showHardcodedTail || !this.slots.checkIsIndex((slot.hardcodedSequenceEndIndex() - 1) + i))) {
                    break;
                }
                if (value != null || (!this.showingEmptySlots && !zAnyInputToTheRight)) {
                    if (value == null) {
                        break;
                    }
                } else {
                    value = getPlaceholder();
                }
                sb.append(value);
            }
            slot = slot.getNextSlot();
            i++;
        }
        return sb.toString();
    }

    @Override // ru.tinkoff.decoro.Mask
    public int getInitialInputPosition() {
        int i = 0;
        for (Slot slot = this.slots.getSlot(0); slot != null && slot.getValue() != null; slot = slot.getNextSlot()) {
            i++;
        }
        return i;
    }

    private boolean filledFrom(Slot slot) {
        if (slot == null) {
            throw new IllegalArgumentException("first slot is null");
        }
        do {
            if (!slot.hasTag(-149635) && !slot.hardcoded() && slot.getValue() == null) {
                return false;
            }
            slot = slot.getNextSlot();
        } while (slot != null);
        return true;
    }

    public int insertAt(int i, CharSequence charSequence, boolean z) {
        if (!this.slots.isEmpty() && this.slots.checkIsIndex(i) && charSequence != null && charSequence.length() != 0) {
            boolean z2 = true;
            this.showHardcodedTail = true;
            Slot slot = this.slots.getSlot(i);
            if (this.forbidInputWhenFilled && filledFrom(slot)) {
                return i;
            }
            Deque<Character> dequeDequeFrom = dequeFrom(charSequence);
            while (true) {
                if (dequeDequeFrom.isEmpty()) {
                    break;
                }
                Character chPop = dequeDequeFrom.pop();
                SlotIndexOffset slotIndexOffsetValidSlotIndexOffset = validSlotIndexOffset(slot, chPop.charValue());
                if (this.showingEmptySlots || !slotIndexOffsetValidSlotIndexOffset.nonHarcodedSlotSkipped) {
                    i += slotIndexOffsetValidSlotIndexOffset.indexOffset;
                    Slot slot2 = this.slots.getSlot(i);
                    if (slot2 != null) {
                        i += slot2.setValue(chPop, slotIndexOffsetValidSlotIndexOffset.indexOffset > 0);
                        slot = this.slots.getSlot(i);
                        if (!this.terminated && emptySlotsOnTail() < 1) {
                            extendTail(1);
                        }
                    }
                }
            }
            if (z) {
                int iHardcodedSequenceEndIndex = slot != null ? slot.hardcodedSequenceEndIndex() : 0;
                if (iHardcodedSequenceEndIndex > 0) {
                    i += iHardcodedSequenceEndIndex;
                }
            }
            Slot slot3 = this.slots.getSlot(i);
            if (slot3 != null && slot3.anyInputToTheRight()) {
                z2 = false;
            }
            this.showHardcodedTail = z2;
        }
        return i;
    }

    private int emptySlotsOnTail() {
        int i = 0;
        for (Slot lastSlot = this.slots.getLastSlot(); lastSlot != null && lastSlot.getValue() == null; lastSlot = lastSlot.getPrevSlot()) {
            i++;
        }
        return i;
    }

    @Override // ru.tinkoff.decoro.Mask
    public int insertAt(int i, CharSequence charSequence) {
        return insertAt(i, charSequence, true);
    }

    @Override // ru.tinkoff.decoro.Mask
    public int insertFront(CharSequence charSequence) {
        return insertAt(0, charSequence, true);
    }

    @Override // ru.tinkoff.decoro.Mask
    public int removeBackwards(int i, int i2) {
        return removeBackwardsInner(i, i2, true);
    }

    @Override // ru.tinkoff.decoro.Mask
    public int removeBackwardsWithoutHardcoded(int i, int i2) {
        return removeBackwardsInner(i, i2, false);
    }

    public Character getPlaceholder() {
        Character ch = this.placeholder;
        return Character.valueOf(ch != null ? ch.charValue() : '_');
    }

    private SlotIndexOffset validSlotIndexOffset(Slot slot, char c) {
        SlotIndexOffset slotIndexOffset = new SlotIndexOffset();
        while (slot != null && !slot.canInsertHere(c)) {
            if (!slotIndexOffset.nonHarcodedSlotSkipped && !slot.hardcoded()) {
                slotIndexOffset.nonHarcodedSlotSkipped = true;
            }
            slot = slot.getNextSlot();
            slotIndexOffset.indexOffset++;
        }
        return slotIndexOffset;
    }

    private void extendTail(int i) {
        if (this.terminated || i < 1) {
            return;
        }
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            SlotsList slotsList = this.slots;
            Slot slotInsertSlotAt = slotsList.insertSlotAt(slotsList.size(), this.slots.getLastSlot());
            slotInsertSlotAt.setValue(null);
            slotInsertSlotAt.withTags(-149635);
        }
    }

    private void trimTail() {
        if (this.terminated || this.slots.isEmpty()) {
            return;
        }
        Slot lastSlot = this.slots.getLastSlot();
        Slot prevSlot = lastSlot.getPrevSlot();
        while (isAllowedToRemoveSlot(lastSlot, prevSlot)) {
            this.slots.removeSlotAt(r0.size() - 1);
            Slot slot = prevSlot;
            prevSlot = prevSlot.getPrevSlot();
            lastSlot = slot;
        }
    }

    private boolean isAllowedToRemoveSlot(Slot slot, Slot slot2) {
        return slot.hasTag(-149635) && slot2.hasTag(-149635) && slot.getValue() == null && slot2.getValue() == null;
    }

    private Deque<Character> dequeFrom(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        ArrayDeque arrayDeque = new ArrayDeque(charSequence.length());
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            arrayDeque.push(Character.valueOf(charSequence.charAt(length)));
        }
        return arrayDeque;
    }

    private int removeBackwardsInner(int i, int i2, boolean z) {
        int i3;
        Slot slot;
        int value = i;
        for (int i4 = 0; i4 < i2; i4++) {
            if (this.slots.checkIsIndex(value) && (slot = this.slots.getSlot(value)) != null && (!slot.hardcoded() || (z && i2 == 1))) {
                value += slot.setValue(null);
            }
            value--;
        }
        int i5 = value + 1;
        trimTail();
        int i6 = i5;
        while (true) {
            i3 = i6 - 1;
            Slot slot2 = this.slots.getSlot(i3);
            if (slot2 == null || !slot2.hardcoded() || i3 <= 0) {
                break;
            }
            i6 = i3;
        }
        this.showHardcodedTail = i3 <= 0 && !this.hideHardcodedHead;
        if (i3 > 0) {
            i5 = (this.slots.checkIsIndex(i) && this.slots.getSlot(i).hardcoded() && i2 == 1) ? i3 : i6;
        }
        if (i5 < 0 || i5 > this.slots.size()) {
            return 0;
        }
        return i5;
    }

    private static class SlotIndexOffset {
        int indexOffset;
        boolean nonHarcodedSlotSkipped;

        private SlotIndexOffset() {
            this.indexOffset = 0;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.terminated ? (byte) 1 : (byte) 0);
        parcel.writeSerializable(this.placeholder);
        parcel.writeByte(this.showingEmptySlots ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.forbidInputWhenFilled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hideHardcodedHead ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showHardcodedTail ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.slots, i);
    }

    protected MaskImpl(Parcel parcel) {
        this.terminated = true;
        this.showHardcodedTail = true;
        this.terminated = parcel.readByte() != 0;
        this.placeholder = (Character) parcel.readSerializable();
        this.showingEmptySlots = parcel.readByte() != 0;
        this.forbidInputWhenFilled = parcel.readByte() != 0;
        this.hideHardcodedHead = parcel.readByte() != 0;
        this.showHardcodedTail = parcel.readByte() != 0;
        this.slots = (SlotsList) parcel.readParcelable(SlotsList.class.getClassLoader());
    }
}
