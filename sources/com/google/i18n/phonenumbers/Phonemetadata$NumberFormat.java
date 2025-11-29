package com.google.i18n.phonenumbers;

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

    public Phonemetadata$NumberFormat setPattern(String str) {
        this.hasPattern = true;
        this.pattern_ = str;
        return this;
    }

    public String getFormat() {
        return this.format_;
    }

    public Phonemetadata$NumberFormat setFormat(String str) {
        this.hasFormat = true;
        this.format_ = str;
        return this;
    }

    @Deprecated
    public int leadingDigitsPatternSize() {
        return getLeadingDigitsPatternCount();
    }

    public int getLeadingDigitsPatternCount() {
        return this.leadingDigitsPattern_.size();
    }

    public String getLeadingDigitsPattern(int i) {
        return this.leadingDigitsPattern_.get(i);
    }

    public String getNationalPrefixFormattingRule() {
        return this.nationalPrefixFormattingRule_;
    }

    public Phonemetadata$NumberFormat setNationalPrefixFormattingRule(String str) {
        this.hasNationalPrefixFormattingRule = true;
        this.nationalPrefixFormattingRule_ = str;
        return this;
    }

    public Phonemetadata$NumberFormat setNationalPrefixOptionalWhenFormatting(boolean z) {
        this.hasNationalPrefixOptionalWhenFormatting = true;
        this.nationalPrefixOptionalWhenFormatting_ = z;
        return this;
    }

    public String getDomesticCarrierCodeFormattingRule() {
        return this.domesticCarrierCodeFormattingRule_;
    }

    public Phonemetadata$NumberFormat setDomesticCarrierCodeFormattingRule(String str) {
        this.hasDomesticCarrierCodeFormattingRule = true;
        this.domesticCarrierCodeFormattingRule_ = str;
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
