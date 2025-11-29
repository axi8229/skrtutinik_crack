package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Phonemetadata$PhoneMetadataCollection implements Externalizable {
    private List<Phonemetadata$PhoneMetadata> metadata_ = new ArrayList();

    public List<Phonemetadata$PhoneMetadata> getMetadataList() {
        return this.metadata_;
    }

    public int getMetadataCount() {
        return this.metadata_.size();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        int metadataCount = getMetadataCount();
        objectOutput.writeInt(metadataCount);
        for (int i = 0; i < metadataCount; i++) {
            this.metadata_.get(i).writeExternal(objectOutput);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata = new Phonemetadata$PhoneMetadata();
            phonemetadata$PhoneMetadata.readExternal(objectInput);
            this.metadata_.add(phonemetadata$PhoneMetadata);
        }
    }
}
