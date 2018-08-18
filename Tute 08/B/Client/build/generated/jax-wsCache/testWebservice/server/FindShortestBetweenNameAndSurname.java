
package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findShortestBetweenNameAndSurname complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findShortestBetweenNameAndSurname">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://server/}person" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findShortestBetweenNameAndSurname", propOrder = {
    "name"
})
public class FindShortestBetweenNameAndSurname {

    protected Person name;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setName(Person value) {
        this.name = value;
    }

}
