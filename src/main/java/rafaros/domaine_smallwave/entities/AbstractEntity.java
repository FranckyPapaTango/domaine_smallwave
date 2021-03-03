/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rafaros.domaine_smallwave.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import rafaros.domaine_smallwave.tools.ModuleTools;
import rafaros.domaine_smallwave.tools.Validateur;

/**
 *
 * @author smallwave
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //	@Version // l'attribut updatedVersionDate remplace la version !
    //  private int version;    
    @Basic(optional = true)
    @Column(name = "UPDATED_VERSION_DATE")//  
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedVersionDate;
    //	@Version 
    
    @Basic(optional = true)
    @Column(name = "DATE_PERSISTENCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePersistence;

    @Basic(optional = false)
    @Column(name = "CSS_RAW_COLOR_CODE")
    private String cssRawColorCode;

    /**
     * méthode de rappel initialisant l'attribut datePersistence et l'attribut
     * CssRawColorCode
     */
    @PrePersist
    protected void initDatas() {
        //setUpdatedVersionDate(ModuleTools.asDateHMS(LocalDateTime.now()));//indice d'update et de version
        setDatePersistence(ModuleTools.asDateHMS(LocalDateTime.now()));//indice de creation        
        //datePersistence = ModuleTools.asDateHMS(LocalDateTime.now());
        setCssRawColorCode(Validateur.bootstrapRowColorValue(Validateur.generateRandomInt()));
    }

    @PreUpdate
    private void onUpdate() {
        setUpdatedVersionDate(ModuleTools.asDateHMS(LocalDateTime.now()));//indice d'update et de version
    }

	public Date getUpdatedVersionDate() {
		return updatedVersionDate;
	}

	public void setUpdatedVersionDate(Date updatedVersionDate) {
		this.updatedVersionDate = updatedVersionDate;
	}

	public Date getDatePersistence() {
		return datePersistence;
	}

	public void setDatePersistence(Date datePersistence) {
		this.datePersistence = datePersistence;
	}

	public String getCssRawColorCode() {
		return cssRawColorCode;
	}

	public void setCssRawColorCode(String cssRawColorCode) {
		this.cssRawColorCode = cssRawColorCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cssRawColorCode == null) ? 0 : cssRawColorCode.hashCode());
		result = prime * result + ((datePersistence == null) ? 0 : datePersistence.hashCode());
		result = prime * result + ((updatedVersionDate == null) ? 0 : updatedVersionDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (cssRawColorCode == null) {
			if (other.cssRawColorCode != null)
				return false;
		} else if (!cssRawColorCode.equals(other.cssRawColorCode))
			return false;
		if (datePersistence == null) {
			if (other.datePersistence != null)
				return false;
		} else if (!datePersistence.equals(other.datePersistence))
			return false;
		if (updatedVersionDate == null) {
			if (other.updatedVersionDate != null)
				return false;
		} else if (!updatedVersionDate.equals(other.updatedVersionDate))
			return false;
		return true;
	}
    
    
}

