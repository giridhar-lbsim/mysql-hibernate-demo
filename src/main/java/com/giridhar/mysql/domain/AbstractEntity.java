package com.giridhar.mysql.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.AttributeAccessor;

/**
 * Abstract base class for entities. Allows parameterization of id type, chooses auto-generation and
 * implements {@link #equals(Object)} and {@link #hashCode()} based on that id. Also adds the date
 * created and last modified fields for all entities.
 * 
 */

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

  private static final long serialVersionUID = -3028114538116703612L;

  @Id
  @GeneratedValue
  @AttributeAccessor("property")
  private Long id;

  @Column(nullable = false)
  private Date dateCreated;

  @Column(nullable = false)
  private Date lastModified;

  @Column(nullable = false)
  private Boolean active = Boolean.TRUE;

  @PrePersist
  public void onCreate() {
    this.dateCreated = this.lastModified = new Date();
  }

  @PreUpdate
  public void onUpdate() {
    this.lastModified = new Date();
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getLastModified() {
    return lastModified;
  }

  public void setLastModified(Date lastModified) {
    this.lastModified = lastModified;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void copyEntityFrom(AbstractEntity source) {
    this.id = source.id;
    this.active = source.active;
    this.lastModified = source.lastModified;
    this.dateCreated = source.dateCreated;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
