//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.21 at 09:59:49 PM BST 
//


package mismo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AUS_ProjectDesignTypeEnumerated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AUS_ProjectDesignTypeEnumerated">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Attached"/>
 *     &lt;enumeration value="Detached"/>
 *     &lt;enumeration value="GardenProject"/>
 *     &lt;enumeration value="HighriseProject"/>
 *     &lt;enumeration value="MidriseProject"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="TownhouseRowhouse"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AUS_ProjectDesignTypeEnumerated")
@XmlEnum
public enum AUSProjectDesignTypeEnumerated {

    @XmlEnumValue("Attached")
    ATTACHED("Attached"),
    @XmlEnumValue("Detached")
    DETACHED("Detached"),
    @XmlEnumValue("GardenProject")
    GARDEN_PROJECT("GardenProject"),
    @XmlEnumValue("HighriseProject")
    HIGHRISE_PROJECT("HighriseProject"),
    @XmlEnumValue("MidriseProject")
    MIDRISE_PROJECT("MidriseProject"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("TownhouseRowhouse")
    TOWNHOUSE_ROWHOUSE("TownhouseRowhouse");
    private final String value;

    AUSProjectDesignTypeEnumerated(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AUSProjectDesignTypeEnumerated fromValue(String v) {
        for (AUSProjectDesignTypeEnumerated c: AUSProjectDesignTypeEnumerated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}