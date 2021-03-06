//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.21 at 09:59:49 PM BST 
//


package mismo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AUS_BUYDOWN_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AUS_BUYDOWN_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="_ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="_BaseDateType" type="{}AUS_BuydownBaseDateTypeEnumerated" />
 *       &lt;attribute name="_ChangeFrequencyMonths" type="{}AUS_MISMONumeric" />
 *       &lt;attribute name="_ContributorType" type="{}AUS_BuydownContributorTypeEnumerated" />
 *       &lt;attribute name="_DurationMonths" type="{}AUS_MISMONumeric" />
 *       &lt;attribute name="_IncreaseRatePercent" type="{}AUS_MISMONumeric" />
 *       &lt;attribute name="_LenderFundingIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="_PermanentIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="_ContributorTypeOtherDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_BaseDateTypeOtherDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUS_BUYDOWN_Type")
public class AUSBUYDOWNType {

    @XmlAttribute(name = "_ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "_BaseDateType")
    protected AUSBuydownBaseDateTypeEnumerated baseDateType;
    @XmlAttribute(name = "_ChangeFrequencyMonths")
    protected String changeFrequencyMonths;
    @XmlAttribute(name = "_ContributorType")
    protected AUSBuydownContributorTypeEnumerated contributorType;
    @XmlAttribute(name = "_DurationMonths")
    protected String durationMonths;
    @XmlAttribute(name = "_IncreaseRatePercent")
    protected String increaseRatePercent;
    @XmlAttribute(name = "_LenderFundingIndicator")
    protected String lenderFundingIndicator;
    @XmlAttribute(name = "_PermanentIndicator")
    protected String permanentIndicator;
    @XmlAttribute(name = "_ContributorTypeOtherDescription")
    protected String contributorTypeOtherDescription;
    @XmlAttribute(name = "_BaseDateTypeOtherDescription")
    protected String baseDateTypeOtherDescription;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the baseDateType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSBuydownBaseDateTypeEnumerated }
     *     
     */
    public AUSBuydownBaseDateTypeEnumerated getBaseDateType() {
        return baseDateType;
    }

    /**
     * Sets the value of the baseDateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSBuydownBaseDateTypeEnumerated }
     *     
     */
    public void setBaseDateType(AUSBuydownBaseDateTypeEnumerated value) {
        this.baseDateType = value;
    }

    /**
     * Gets the value of the changeFrequencyMonths property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeFrequencyMonths() {
        return changeFrequencyMonths;
    }

    /**
     * Sets the value of the changeFrequencyMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeFrequencyMonths(String value) {
        this.changeFrequencyMonths = value;
    }

    /**
     * Gets the value of the contributorType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSBuydownContributorTypeEnumerated }
     *     
     */
    public AUSBuydownContributorTypeEnumerated getContributorType() {
        return contributorType;
    }

    /**
     * Sets the value of the contributorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSBuydownContributorTypeEnumerated }
     *     
     */
    public void setContributorType(AUSBuydownContributorTypeEnumerated value) {
        this.contributorType = value;
    }

    /**
     * Gets the value of the durationMonths property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDurationMonths() {
        return durationMonths;
    }

    /**
     * Sets the value of the durationMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDurationMonths(String value) {
        this.durationMonths = value;
    }

    /**
     * Gets the value of the increaseRatePercent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncreaseRatePercent() {
        return increaseRatePercent;
    }

    /**
     * Sets the value of the increaseRatePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncreaseRatePercent(String value) {
        this.increaseRatePercent = value;
    }

    /**
     * Gets the value of the lenderFundingIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLenderFundingIndicator() {
        return lenderFundingIndicator;
    }

    /**
     * Sets the value of the lenderFundingIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLenderFundingIndicator(String value) {
        this.lenderFundingIndicator = value;
    }

    /**
     * Gets the value of the permanentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermanentIndicator() {
        return permanentIndicator;
    }

    /**
     * Sets the value of the permanentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermanentIndicator(String value) {
        this.permanentIndicator = value;
    }

    /**
     * Gets the value of the contributorTypeOtherDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContributorTypeOtherDescription() {
        return contributorTypeOtherDescription;
    }

    /**
     * Sets the value of the contributorTypeOtherDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContributorTypeOtherDescription(String value) {
        this.contributorTypeOtherDescription = value;
    }

    /**
     * Gets the value of the baseDateTypeOtherDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseDateTypeOtherDescription() {
        return baseDateTypeOtherDescription;
    }

    /**
     * Sets the value of the baseDateTypeOtherDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseDateTypeOtherDescription(String value) {
        this.baseDateTypeOtherDescription = value;
    }

}
