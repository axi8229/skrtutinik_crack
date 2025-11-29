package ru.tinkoff.decoro;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Array;
import java.util.Iterator;
import ru.tinkoff.decoro.slots.Slot;

/* loaded from: classes4.dex */
class SlotsList implements Iterable<Slot>, Parcelable {
    public static final Parcelable.Creator<SlotsList> CREATOR = new Parcelable.Creator<SlotsList>() { // from class: ru.tinkoff.decoro.SlotsList.1
        @Override // android.os.Parcelable.Creator
        public SlotsList createFromParcel(Parcel parcel) {
            return new SlotsList(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SlotsList[] newArray(int i) {
            return new SlotsList[i];
        }
    };
    private Slot firstSlot;
    private Slot lastSlot;
    private int size;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static SlotsList ofArray(Slot[] slotArr) {
        SlotsList slotsList = new SlotsList();
        int length = slotArr.length;
        slotsList.size = length;
        if (length == 0) {
            return slotsList;
        }
        linkSlots(slotArr, slotsList);
        return slotsList;
    }

    private static void linkSlots(Slot[] slotArr, SlotsList slotsList) {
        Slot slot = new Slot(slotArr[0]);
        slotsList.firstSlot = slot;
        if (slotsList.size == 1) {
            slotsList.lastSlot = slot;
        }
        int i = 1;
        while (i < slotArr.length) {
            Slot slot2 = new Slot(slotArr[i]);
            slot.setNextSlot(slot2);
            slot2.setPrevSlot(slot);
            if (i == slotArr.length - 1) {
                slotsList.lastSlot = slot2;
            }
            i++;
            slot = slot2;
        }
    }

    public SlotsList() {
        this.size = 0;
    }

    public SlotsList(SlotsList slotsList) {
        this.size = 0;
        if (slotsList.isEmpty()) {
            return;
        }
        Iterator<Slot> it = slotsList.iterator();
        Slot slot = null;
        while (it.hasNext()) {
            Slot slot2 = new Slot(it.next());
            if (this.size == 0) {
                this.firstSlot = slot2;
            } else {
                slot.setNextSlot(slot2);
                slot2.setPrevSlot(slot);
            }
            this.size++;
            slot = slot2;
        }
        this.lastSlot = slot;
    }

    public boolean checkIsIndex(int i) {
        return i >= 0 && i < this.size;
    }

    public Slot getSlot(int i) {
        Slot nextSlot;
        if (!checkIsIndex(i)) {
            return null;
        }
        int i2 = this.size;
        if (i < (i2 >> 1)) {
            nextSlot = this.firstSlot;
            for (int i3 = 0; i3 < i; i3++) {
                nextSlot = nextSlot.getNextSlot();
            }
        } else {
            Slot prevSlot = this.lastSlot;
            for (int i4 = i2 - 1; i4 > i; i4--) {
                prevSlot = prevSlot.getPrevSlot();
            }
            nextSlot = prevSlot;
        }
        if (nextSlot != null) {
            return nextSlot;
        }
        throw new IllegalStateException("Slot inside the mask should not be null. But it is.");
    }

    public Slot insertSlotAt(int i, Slot slot) {
        Slot prevSlot;
        if (i < 0 || this.size < i) {
            throw new IndexOutOfBoundsException("New slot position should be inside the slots list. Or on the tail (position = size)");
        }
        Slot slot2 = new Slot(slot);
        Slot slot3 = getSlot(i);
        if (slot3 == null) {
            prevSlot = this.lastSlot;
            slot3 = null;
        } else {
            prevSlot = slot3.getPrevSlot();
        }
        slot2.setNextSlot(slot3);
        slot2.setPrevSlot(prevSlot);
        if (slot3 != null) {
            slot3.setPrevSlot(slot2);
        }
        if (prevSlot != null) {
            prevSlot.setNextSlot(slot2);
        }
        if (i == 0) {
            this.firstSlot = slot2;
        } else if (i == this.size) {
            this.lastSlot = slot2;
        }
        this.size++;
        return slot2;
    }

    public Slot removeSlotAt(int i) {
        if (!checkIsIndex(i)) {
            throw new IndexOutOfBoundsException("Slot position should be inside the slots list");
        }
        return removeSlot(getSlot(i));
    }

    public Slot removeSlot(Slot slot) {
        if (slot == null || !contains(slot)) {
            return null;
        }
        Slot prevSlot = slot.getPrevSlot();
        Slot nextSlot = slot.getNextSlot();
        if (prevSlot != null) {
            prevSlot.setNextSlot(nextSlot);
        } else {
            this.firstSlot = nextSlot;
        }
        if (nextSlot != null) {
            nextSlot.setPrevSlot(prevSlot);
        } else {
            this.lastSlot = prevSlot;
        }
        this.size--;
        return slot;
    }

    @Override // java.lang.Iterable
    public Iterator<Slot> iterator() {
        return new SlotsIterator(this.firstSlot);
    }

    public Slot[] toArray() {
        if (isEmpty()) {
            return new Slot[0];
        }
        return (Slot[]) toArray(new Slot[size()]);
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr == null || tArr.length < this.size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.size));
        }
        Iterator<Slot> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            tArr[i] = it.next();
            i++;
        }
        return tArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SlotsList slotsList = (SlotsList) obj;
        if (slotsList.size() != size()) {
            return false;
        }
        Iterator<Slot> it = iterator();
        Iterator<Slot> it2 = slotsList.iterator();
        while (it2.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public Slot getFirstSlot() {
        return this.firstSlot;
    }

    public Slot getLastSlot() {
        return this.lastSlot;
    }

    private boolean contains(Slot slot) {
        Iterator<Slot> it = iterator();
        while (it.hasNext()) {
            if (it.next() == slot) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.size);
        if (this.size > 0) {
            parcel.writeTypedArray(toArray(), i);
        }
    }

    protected SlotsList(Parcel parcel) {
        this.size = 0;
        int i = parcel.readInt();
        this.size = i;
        if (i > 0) {
            Slot[] slotArr = new Slot[i];
            parcel.readTypedArray(slotArr, Slot.CREATOR);
            linkSlots(slotArr, this);
        }
    }

    private static class SlotsIterator implements Iterator<Slot> {
        Slot nextSlot;

        public SlotsIterator(Slot slot) {
            if (slot == null) {
                throw new IllegalArgumentException("Initial slot for iterator cannot be null");
            }
            this.nextSlot = slot;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextSlot != null;
        }

        @Override // java.util.Iterator
        public Slot next() {
            Slot slot = this.nextSlot;
            this.nextSlot = slot.getNextSlot();
            return slot;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Mask cannot be modified from outside!");
        }
    }
}
