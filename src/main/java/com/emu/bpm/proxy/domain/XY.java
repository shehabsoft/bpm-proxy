package com.emu.bpm.proxy.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * A xy.
 */
@Entity
@Table(name = "xy")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "xy")
public class XY extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drools_files_seq")
    @SequenceGenerator(name = "drools_files_seq", allocationSize = 1)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "simple_class_name")
    private String simpleClassName;

    @Column(name = "full_class_name")
    private String fullClassName;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public XY id(Long id) {
        this.id = id;
        return this;
    }

    public String getFileName() {
        return this.fileName;
    }

    public XY fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public String getSimpleClassName() {
        return this.simpleClassName;
    }

    public XY simpleClassName(String simpleClassName) {
        this.simpleClassName = simpleClassName;
        return this;
    }

    public void setSimpleClassName(String simpleClassName) {
        this.simpleClassName = simpleClassName;
    }

    public String getFullClassName() {
        return this.fullClassName;
    }

    public XY fullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
        return this;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof XY)) {
            return false;
        }
        return id != null && id.equals(((XY) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DroolsFiles{" +
            "id=" + getId() +
            ", fileName='" + getFileName() + "'" +
            ", simpleClassName='" + getSimpleClassName() + "'" +
            ", fullClassName='" + getFullClassName() + "'" +
            "}";
    }
}
