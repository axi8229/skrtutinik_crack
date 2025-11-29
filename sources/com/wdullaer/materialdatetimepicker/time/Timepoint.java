package com.wdullaer.materialdatetimepicker.time;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class Timepoint implements Parcelable, Comparable<Timepoint> {
    public static final Parcelable.Creator<Timepoint> CREATOR = new Parcelable.Creator<Timepoint>() { // from class: com.wdullaer.materialdatetimepicker.time.Timepoint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timepoint createFromParcel(Parcel parcel) {
            return new Timepoint(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timepoint[] newArray(int i) {
            return new Timepoint[i];
        }
    };
    private int hour;
    private int minute;
    private int second;

    public enum TYPE {
        HOUR,
        MINUTE,
        SECOND
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Timepoint(Timepoint timepoint) {
        this(timepoint.hour, timepoint.minute, timepoint.second);
    }

    public Timepoint(int i, int i2, int i3) {
        this.hour = i % 24;
        this.minute = i2 % 60;
        this.second = i3 % 60;
    }

    public Timepoint(int i, int i2) {
        this(i, i2, 0);
    }

    public Timepoint(int i) {
        this(i, 0);
    }

    public Timepoint(Parcel parcel) {
        this.hour = parcel.readInt();
        this.minute = parcel.readInt();
        this.second = parcel.readInt();
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public boolean isAM() {
        return this.hour < 12;
    }

    public boolean isPM() {
        return !isAM();
    }

    public void setAM() {
        int i = this.hour;
        if (i >= 12) {
            this.hour = i % 12;
        }
    }

    public void setPM() {
        int i = this.hour;
        if (i < 12) {
            this.hour = (i + 12) % 24;
        }
    }

    public void add(TYPE type, int i) {
        if (type == TYPE.MINUTE) {
            i *= 60;
        }
        if (type == TYPE.HOUR) {
            i *= 3600;
        }
        int seconds = i + toSeconds();
        int i2 = AnonymousClass2.$SwitchMap$com$wdullaer$materialdatetimepicker$time$Timepoint$TYPE[type.ordinal()];
        if (i2 == 1) {
            this.second = (seconds % 3600) % 60;
        } else {
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
            }
            this.hour = (seconds / 3600) % 24;
        }
        this.minute = (seconds % 3600) / 60;
        this.hour = (seconds / 3600) % 24;
    }

    /* renamed from: com.wdullaer.materialdatetimepicker.time.Timepoint$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$wdullaer$materialdatetimepicker$time$Timepoint$TYPE;

        static {
            int[] iArr = new int[TYPE.values().length];
            $SwitchMap$com$wdullaer$materialdatetimepicker$time$Timepoint$TYPE = iArr;
            try {
                iArr[TYPE.SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$wdullaer$materialdatetimepicker$time$Timepoint$TYPE[TYPE.MINUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$wdullaer$materialdatetimepicker$time$Timepoint$TYPE[TYPE.HOUR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public int get(TYPE type) {
        int i = AnonymousClass2.$SwitchMap$com$wdullaer$materialdatetimepicker$time$Timepoint$TYPE[type.ordinal()];
        if (i == 1) {
            return getSecond();
        }
        if (i == 2) {
            return getMinute();
        }
        return getHour();
    }

    public int toSeconds() {
        return (this.hour * 3600) + (this.minute * 60) + this.second;
    }

    public int hashCode() {
        return toSeconds();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && hashCode() == ((Timepoint) obj).hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(com.wdullaer.materialdatetimepicker.time.Timepoint r4, com.wdullaer.materialdatetimepicker.time.Timepoint.TYPE r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int[] r1 = com.wdullaer.materialdatetimepicker.time.Timepoint.AnonymousClass2.$SwitchMap$com$wdullaer$materialdatetimepicker$time$Timepoint$TYPE
            int r5 = r5.ordinal()
            r5 = r1[r5]
            r1 = 1
            if (r5 == r1) goto L16
            r2 = 2
            if (r5 == r2) goto L20
            r2 = 3
            if (r5 == r2) goto L2a
            goto L36
        L16:
            int r5 = r4.getSecond()
            int r2 = r3.getSecond()
            if (r5 != r2) goto L35
        L20:
            int r5 = r4.getMinute()
            int r2 = r3.getMinute()
            if (r5 != r2) goto L35
        L2a:
            int r4 = r4.getHour()
            int r5 = r3.getHour()
            if (r4 != r5) goto L35
            r0 = r1
        L35:
            r1 = r0
        L36:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.Timepoint.equals(com.wdullaer.materialdatetimepicker.time.Timepoint, com.wdullaer.materialdatetimepicker.time.Timepoint$TYPE):boolean");
    }

    @Override // java.lang.Comparable
    public int compareTo(Timepoint timepoint) {
        return hashCode() - timepoint.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
        parcel.writeInt(this.second);
    }

    public String toString() {
        return "" + this.hour + "h " + this.minute + "m " + this.second + "s";
    }
}
