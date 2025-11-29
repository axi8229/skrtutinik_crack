package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Phonemetadata$PhoneNumberDesc implements Externalizable {
    private boolean hasExampleNumber;
    private boolean hasNationalNumberPattern;
    private String nationalNumberPattern_ = "";
    private List<Integer> possibleLength_ = new ArrayList();
    private List<Integer> possibleLengthLocalOnly_ = new ArrayList();
    private String exampleNumber_ = "";

    public String getNationalNumberPattern() {
        return this.nationalNumberPattern_;
    }

    public Phonemetadata$PhoneNumberDesc setNationalNumberPattern(String str) {
        this.hasNationalNumberPattern = true;
        this.nationalNumberPattern_ = str;
        return this;
    }

    public List<Integer> getPossibleLengthList() {
        return this.possibleLength_;
    }

    public int getPossibleLengthCount() {
        return this.possibleLength_.size();
    }

    public int getPossibleLength(int i) {
        return this.possibleLength_.get(i).intValue();
    }

    public List<Integer> getPossibleLengthLocalOnlyList() {
        return this.possibleLengthLocalOnly_;
    }

    public int getPossibleLengthLocalOnlyCount() {
        return this.possibleLengthLocalOnly_.size();
    }

    public Phonemetadata$PhoneNumberDesc setExampleNumber(String str) {
        this.hasExampleNumber = true;
        this.exampleNumber_ = str;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.hasNationalNumberPattern);
        if (this.hasNationalNumberPattern) {
            objectOutput.writeUTF(this.nationalNumberPattern_);
        }
        int possibleLengthCount = getPossibleLengthCount();
        objectOutput.writeInt(possibleLengthCount);
        for (int i = 0; i < possibleLengthCount; i++) {
            objectOutput.writeInt(this.possibleLength_.get(i).intValue());
        }
        int possibleLengthLocalOnlyCount = getPossibleLengthLocalOnlyCount();
        objectOutput.writeInt(possibleLengthLocalOnlyCount);
        for (int i2 = 0; i2 < possibleLengthLocalOnlyCount; i2++) {
            objectOutput.writeInt(this.possibleLengthLocalOnly_.get(i2).intValue());
        }
        objectOutput.writeBoolean(this.hasExampleNumber);
        if (this.hasExampleNumber) {
            objectOutput.writeUTF(this.exampleNumber_);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            setNationalNumberPattern(objectInput.readUTF());
        }
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.possibleLength_.add(Integer.valueOf(objectInput.readInt()));
        }
        int i3 = objectInput.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.possibleLengthLocalOnly_.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            setExampleNumber(objectInput.readUTF());
        }
    }
}
