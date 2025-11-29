package io.michaelrocks.libphonenumber.android;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Phonemetadata$PhoneMetadata implements Externalizable {
    private boolean hasCarrierSpecific;
    private boolean hasCountryCode;
    private boolean hasEmergency;
    private boolean hasFixedLine;
    private boolean hasGeneralDesc;
    private boolean hasId;
    private boolean hasInternationalPrefix;
    private boolean hasLeadingDigits;
    private boolean hasLeadingZeroPossible;
    private boolean hasMainCountryForCode;
    private boolean hasMobile;
    private boolean hasMobileNumberPortableRegion;
    private boolean hasNationalPrefix;
    private boolean hasNationalPrefixForParsing;
    private boolean hasNationalPrefixTransformRule;
    private boolean hasNoInternationalDialling;
    private boolean hasPager;
    private boolean hasPersonalNumber;
    private boolean hasPreferredExtnPrefix;
    private boolean hasPreferredInternationalPrefix;
    private boolean hasPremiumRate;
    private boolean hasSameMobileAndFixedLinePattern;
    private boolean hasSharedCost;
    private boolean hasShortCode;
    private boolean hasSmsServices;
    private boolean hasStandardRate;
    private boolean hasTollFree;
    private boolean hasUan;
    private boolean hasVoicemail;
    private boolean hasVoip;
    private Phonemetadata$PhoneNumberDesc generalDesc_ = null;
    private Phonemetadata$PhoneNumberDesc fixedLine_ = null;
    private Phonemetadata$PhoneNumberDesc mobile_ = null;
    private Phonemetadata$PhoneNumberDesc tollFree_ = null;
    private Phonemetadata$PhoneNumberDesc premiumRate_ = null;
    private Phonemetadata$PhoneNumberDesc sharedCost_ = null;
    private Phonemetadata$PhoneNumberDesc personalNumber_ = null;
    private Phonemetadata$PhoneNumberDesc voip_ = null;
    private Phonemetadata$PhoneNumberDesc pager_ = null;
    private Phonemetadata$PhoneNumberDesc uan_ = null;
    private Phonemetadata$PhoneNumberDesc emergency_ = null;
    private Phonemetadata$PhoneNumberDesc voicemail_ = null;
    private Phonemetadata$PhoneNumberDesc shortCode_ = null;
    private Phonemetadata$PhoneNumberDesc standardRate_ = null;
    private Phonemetadata$PhoneNumberDesc carrierSpecific_ = null;
    private Phonemetadata$PhoneNumberDesc smsServices_ = null;
    private Phonemetadata$PhoneNumberDesc noInternationalDialling_ = null;
    private String id_ = "";
    private int countryCode_ = 0;
    private String internationalPrefix_ = "";
    private String preferredInternationalPrefix_ = "";
    private String nationalPrefix_ = "";
    private String preferredExtnPrefix_ = "";
    private String nationalPrefixForParsing_ = "";
    private String nationalPrefixTransformRule_ = "";
    private boolean sameMobileAndFixedLinePattern_ = false;
    private List<Phonemetadata$NumberFormat> numberFormat_ = new ArrayList();
    private List<Phonemetadata$NumberFormat> intlNumberFormat_ = new ArrayList();
    private boolean mainCountryForCode_ = false;
    private String leadingDigits_ = "";
    private boolean leadingZeroPossible_ = false;
    private boolean mobileNumberPortableRegion_ = false;

    public Phonemetadata$PhoneNumberDesc getGeneralDesc() {
        return this.generalDesc_;
    }

    public Phonemetadata$PhoneMetadata setGeneralDesc(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasGeneralDesc = true;
        this.generalDesc_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getFixedLine() {
        return this.fixedLine_;
    }

    public Phonemetadata$PhoneMetadata setFixedLine(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasFixedLine = true;
        this.fixedLine_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getMobile() {
        return this.mobile_;
    }

    public Phonemetadata$PhoneMetadata setMobile(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasMobile = true;
        this.mobile_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getTollFree() {
        return this.tollFree_;
    }

    public Phonemetadata$PhoneMetadata setTollFree(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasTollFree = true;
        this.tollFree_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getPremiumRate() {
        return this.premiumRate_;
    }

    public Phonemetadata$PhoneMetadata setPremiumRate(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasPremiumRate = true;
        this.premiumRate_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getSharedCost() {
        return this.sharedCost_;
    }

    public Phonemetadata$PhoneMetadata setSharedCost(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasSharedCost = true;
        this.sharedCost_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getPersonalNumber() {
        return this.personalNumber_;
    }

    public Phonemetadata$PhoneMetadata setPersonalNumber(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasPersonalNumber = true;
        this.personalNumber_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getVoip() {
        return this.voip_;
    }

    public Phonemetadata$PhoneMetadata setVoip(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasVoip = true;
        this.voip_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getPager() {
        return this.pager_;
    }

    public Phonemetadata$PhoneMetadata setPager(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasPager = true;
        this.pager_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getUan() {
        return this.uan_;
    }

    public Phonemetadata$PhoneMetadata setUan(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasUan = true;
        this.uan_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setEmergency(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasEmergency = true;
        this.emergency_ = value;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc getVoicemail() {
        return this.voicemail_;
    }

    public Phonemetadata$PhoneMetadata setVoicemail(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasVoicemail = true;
        this.voicemail_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setShortCode(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasShortCode = true;
        this.shortCode_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setStandardRate(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasStandardRate = true;
        this.standardRate_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setCarrierSpecific(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasCarrierSpecific = true;
        this.carrierSpecific_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setSmsServices(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasSmsServices = true;
        this.smsServices_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setNoInternationalDialling(Phonemetadata$PhoneNumberDesc value) {
        value.getClass();
        this.hasNoInternationalDialling = true;
        this.noInternationalDialling_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setId(String value) {
        this.hasId = true;
        this.id_ = value;
        return this;
    }

    public int getCountryCode() {
        return this.countryCode_;
    }

    public Phonemetadata$PhoneMetadata setCountryCode(int value) {
        this.hasCountryCode = true;
        this.countryCode_ = value;
        return this;
    }

    public String getInternationalPrefix() {
        return this.internationalPrefix_;
    }

    public Phonemetadata$PhoneMetadata setInternationalPrefix(String value) {
        this.hasInternationalPrefix = true;
        this.internationalPrefix_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setPreferredInternationalPrefix(String value) {
        this.hasPreferredInternationalPrefix = true;
        this.preferredInternationalPrefix_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setNationalPrefix(String value) {
        this.hasNationalPrefix = true;
        this.nationalPrefix_ = value;
        return this;
    }

    public boolean hasPreferredExtnPrefix() {
        return this.hasPreferredExtnPrefix;
    }

    public String getPreferredExtnPrefix() {
        return this.preferredExtnPrefix_;
    }

    public Phonemetadata$PhoneMetadata setPreferredExtnPrefix(String value) {
        this.hasPreferredExtnPrefix = true;
        this.preferredExtnPrefix_ = value;
        return this;
    }

    public String getNationalPrefixForParsing() {
        return this.nationalPrefixForParsing_;
    }

    public Phonemetadata$PhoneMetadata setNationalPrefixForParsing(String value) {
        this.hasNationalPrefixForParsing = true;
        this.nationalPrefixForParsing_ = value;
        return this;
    }

    public String getNationalPrefixTransformRule() {
        return this.nationalPrefixTransformRule_;
    }

    public Phonemetadata$PhoneMetadata setNationalPrefixTransformRule(String value) {
        this.hasNationalPrefixTransformRule = true;
        this.nationalPrefixTransformRule_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setSameMobileAndFixedLinePattern(boolean value) {
        this.hasSameMobileAndFixedLinePattern = true;
        this.sameMobileAndFixedLinePattern_ = value;
        return this;
    }

    public List<Phonemetadata$NumberFormat> numberFormats() {
        return this.numberFormat_;
    }

    public int numberFormatSize() {
        return this.numberFormat_.size();
    }

    public List<Phonemetadata$NumberFormat> intlNumberFormats() {
        return this.intlNumberFormat_;
    }

    public int intlNumberFormatSize() {
        return this.intlNumberFormat_.size();
    }

    public Phonemetadata$PhoneMetadata setMainCountryForCode(boolean value) {
        this.hasMainCountryForCode = true;
        this.mainCountryForCode_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setLeadingDigits(String value) {
        this.hasLeadingDigits = true;
        this.leadingDigits_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setLeadingZeroPossible(boolean value) {
        this.hasLeadingZeroPossible = true;
        this.leadingZeroPossible_ = value;
        return this;
    }

    public Phonemetadata$PhoneMetadata setMobileNumberPortableRegion(boolean value) {
        this.hasMobileNumberPortableRegion = true;
        this.mobileNumberPortableRegion_ = value;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.hasGeneralDesc);
        if (this.hasGeneralDesc) {
            this.generalDesc_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasFixedLine);
        if (this.hasFixedLine) {
            this.fixedLine_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasMobile);
        if (this.hasMobile) {
            this.mobile_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasTollFree);
        if (this.hasTollFree) {
            this.tollFree_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPremiumRate);
        if (this.hasPremiumRate) {
            this.premiumRate_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasSharedCost);
        if (this.hasSharedCost) {
            this.sharedCost_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPersonalNumber);
        if (this.hasPersonalNumber) {
            this.personalNumber_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasVoip);
        if (this.hasVoip) {
            this.voip_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPager);
        if (this.hasPager) {
            this.pager_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasUan);
        if (this.hasUan) {
            this.uan_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasEmergency);
        if (this.hasEmergency) {
            this.emergency_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasVoicemail);
        if (this.hasVoicemail) {
            this.voicemail_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasShortCode);
        if (this.hasShortCode) {
            this.shortCode_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasStandardRate);
        if (this.hasStandardRate) {
            this.standardRate_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasCarrierSpecific);
        if (this.hasCarrierSpecific) {
            this.carrierSpecific_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasSmsServices);
        if (this.hasSmsServices) {
            this.smsServices_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasNoInternationalDialling);
        if (this.hasNoInternationalDialling) {
            this.noInternationalDialling_.writeExternal(objectOutput);
        }
        objectOutput.writeUTF(this.id_);
        objectOutput.writeInt(this.countryCode_);
        objectOutput.writeUTF(this.internationalPrefix_);
        objectOutput.writeBoolean(this.hasPreferredInternationalPrefix);
        if (this.hasPreferredInternationalPrefix) {
            objectOutput.writeUTF(this.preferredInternationalPrefix_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefix);
        if (this.hasNationalPrefix) {
            objectOutput.writeUTF(this.nationalPrefix_);
        }
        objectOutput.writeBoolean(this.hasPreferredExtnPrefix);
        if (this.hasPreferredExtnPrefix) {
            objectOutput.writeUTF(this.preferredExtnPrefix_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefixForParsing);
        if (this.hasNationalPrefixForParsing) {
            objectOutput.writeUTF(this.nationalPrefixForParsing_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefixTransformRule);
        if (this.hasNationalPrefixTransformRule) {
            objectOutput.writeUTF(this.nationalPrefixTransformRule_);
        }
        objectOutput.writeBoolean(this.sameMobileAndFixedLinePattern_);
        int iNumberFormatSize = numberFormatSize();
        objectOutput.writeInt(iNumberFormatSize);
        for (int i = 0; i < iNumberFormatSize; i++) {
            this.numberFormat_.get(i).writeExternal(objectOutput);
        }
        int iIntlNumberFormatSize = intlNumberFormatSize();
        objectOutput.writeInt(iIntlNumberFormatSize);
        for (int i2 = 0; i2 < iIntlNumberFormatSize; i2++) {
            this.intlNumberFormat_.get(i2).writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.mainCountryForCode_);
        objectOutput.writeBoolean(this.hasLeadingDigits);
        if (this.hasLeadingDigits) {
            objectOutput.writeUTF(this.leadingDigits_);
        }
        objectOutput.writeBoolean(this.leadingZeroPossible_);
        objectOutput.writeBoolean(this.mobileNumberPortableRegion_);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            setGeneralDesc(phonemetadata$PhoneNumberDesc);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc2 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc2.readExternal(objectInput);
            setFixedLine(phonemetadata$PhoneNumberDesc2);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc3 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc3.readExternal(objectInput);
            setMobile(phonemetadata$PhoneNumberDesc3);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc4 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc4.readExternal(objectInput);
            setTollFree(phonemetadata$PhoneNumberDesc4);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc5 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc5.readExternal(objectInput);
            setPremiumRate(phonemetadata$PhoneNumberDesc5);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc6 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc6.readExternal(objectInput);
            setSharedCost(phonemetadata$PhoneNumberDesc6);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc7 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc7.readExternal(objectInput);
            setPersonalNumber(phonemetadata$PhoneNumberDesc7);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc8 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc8.readExternal(objectInput);
            setVoip(phonemetadata$PhoneNumberDesc8);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc9 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc9.readExternal(objectInput);
            setPager(phonemetadata$PhoneNumberDesc9);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc10 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc10.readExternal(objectInput);
            setUan(phonemetadata$PhoneNumberDesc10);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc11 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc11.readExternal(objectInput);
            setEmergency(phonemetadata$PhoneNumberDesc11);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc12 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc12.readExternal(objectInput);
            setVoicemail(phonemetadata$PhoneNumberDesc12);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc13 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc13.readExternal(objectInput);
            setShortCode(phonemetadata$PhoneNumberDesc13);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc14 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc14.readExternal(objectInput);
            setStandardRate(phonemetadata$PhoneNumberDesc14);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc15 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc15.readExternal(objectInput);
            setCarrierSpecific(phonemetadata$PhoneNumberDesc15);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc16 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc16.readExternal(objectInput);
            setSmsServices(phonemetadata$PhoneNumberDesc16);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc17 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc17.readExternal(objectInput);
            setNoInternationalDialling(phonemetadata$PhoneNumberDesc17);
        }
        setId(objectInput.readUTF());
        setCountryCode(objectInput.readInt());
        setInternationalPrefix(objectInput.readUTF());
        if (objectInput.readBoolean()) {
            setPreferredInternationalPrefix(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setNationalPrefix(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setPreferredExtnPrefix(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setNationalPrefixForParsing(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setNationalPrefixTransformRule(objectInput.readUTF());
        }
        setSameMobileAndFixedLinePattern(objectInput.readBoolean());
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            Phonemetadata$NumberFormat phonemetadata$NumberFormat = new Phonemetadata$NumberFormat();
            phonemetadata$NumberFormat.readExternal(objectInput);
            this.numberFormat_.add(phonemetadata$NumberFormat);
        }
        int i3 = objectInput.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            Phonemetadata$NumberFormat phonemetadata$NumberFormat2 = new Phonemetadata$NumberFormat();
            phonemetadata$NumberFormat2.readExternal(objectInput);
            this.intlNumberFormat_.add(phonemetadata$NumberFormat2);
        }
        setMainCountryForCode(objectInput.readBoolean());
        if (objectInput.readBoolean()) {
            setLeadingDigits(objectInput.readUTF());
        }
        setLeadingZeroPossible(objectInput.readBoolean());
        setMobileNumberPortableRegion(objectInput.readBoolean());
    }
}
