package io.michaelrocks.libphonenumber.android;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Phonemetadata$NumberFormat implements Externalizable {
    private boolean hasDomesticCarrierCodeFormattingRule;
    private boolean hasFormat;
    private boolean hasNationalPrefixFormattingRule;
    private boolean hasNationalPrefixOptionalWhenFormatting;
    private boolean hasPattern;
    private String pattern_ = "";
    private String format_ = "";
    private List<String> leadingDigitsPattern_ = new ArrayList();
    private String nationalPrefixFormattingRule_ = "";
    private boolean nationalPrefixOptionalWhenFormatting_ = false;
    private String domesticCarrierCodeFormattingRule_ = "";

    public String getPattern() {
        return this.pattern_;
    }

    public Phonemetadata$NumberFormat setPattern(String value) {
        this.hasPattern = true;
        this.pattern_ = value;
        return this;
    }

    public String getFormat() {
        return this.format_;
    }

    public Phonemetadata$NumberFormat setFormat(String value) {
        this.hasFormat = true;
        this.format_ = value;
        return this;
    }

    public int leadingDigitsPatternSize() {
        return this.leadingDigitsPattern_.size();
    }

    public String getLeadingDigitsPattern(int index) {
        return this.leadingDigitsPattern_.get(index);
    }

    public String getNationalPrefixFormattingRule() {
        return this.nationalPrefixFormattingRule_;
    }

    public Phonemetadata$NumberFormat setNationalPrefixFormattingRule(String value) {
        this.hasNationalPrefixFormattingRule = true;
        this.nationalPrefixFormattingRule_ = value;
        return this;
    }

    public Phonemetadata$NumberFormat setNationalPrefixOptionalWhenFormatting(boolean value) {
        this.hasNationalPrefixOptionalWhenFormatting = true;
        this.nationalPrefixOptionalWhenFormatting_ = value;
        return this;
    }

    public String getDomesticCarrierCodeFormattingRule() {
        return this.domesticCarrierCodeFormattingRule_;
    }

    public Phonemetadata$NumberFormat setDomesticCarrierCodeFormattingRule(String value) {
        this.hasDomesticCarrierCodeFormattingRule = true;
        this.domesticCarrierCodeFormattingRule_ = value;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.pattern_);
        objectOutput.writeUTF(this.format_);
        int iLeadingDigitsPatternSize = leadingDigitsPatternSize();
        objectOutput.writeInt(iLeadingDigitsPatternSize);
        for (int i = 0; i < iLeadingDigitsPatternSize; i++) {
            objectOutput.writeUTF(this.leadingDigitsPattern_.get(i));
        }
        objectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
        if (this.hasNationalPrefixFormattingRule) {
            objectOutput.writeUTF(this.nationalPrefixFormattingRule_);
        }
        objectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
        if (this.hasDomesticCarrierCodeFormattingRule) {
            objectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
        }
        objectOutput.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        setPattern(objectInput.readUTF());
        setFormat(objectInput.readUTF());
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.leadingDigitsPattern_.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setNationalPrefixFormattingRule(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
        }
        setNationalPrefixOptionalWhenFormatting(objectInput.readBoolean());
    }
}
