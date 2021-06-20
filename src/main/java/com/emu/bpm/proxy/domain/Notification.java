package com.emu.bpm.proxy.domain;

import com.emu.bpm.proxy.domain.enumeration.NotificationType;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 * Entities for notification microservice
 */
@ApiModel(description = "Entities for notification microservice")
@Entity
@Table(name = "notification")
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "details")
    private String details;

    @NotNull
    @Column(name = "sent_date", nullable = false)
    private Instant sentDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "format", nullable = false)
    private NotificationType format;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotNull
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notification id(Long id) {
        this.id = id;
        return this;
    }

    public Instant getDate() {
        return this.date;
    }

    public Notification date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDetails() {
        return this.details;
    }

    public Notification details(String details) {
        this.details = details;
        return this;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Instant getSentDate() {
        return this.sentDate;
    }

    public Notification sentDate(Instant sentDate) {
        this.sentDate = sentDate;
        return this;
    }

    public void setSentDate(Instant sentDate) {
        this.sentDate = sentDate;
    }

    public NotificationType getFormat() {
        return this.format;
    }

    public Notification format(NotificationType format) {
        this.format = format;
        return this;
    }

    public void setFormat(NotificationType format) {
        this.format = format;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Notification userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public Notification memberId(Long memberId) {
        this.memberId = memberId;
        return this;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Notification)) {
            return false;
        }
        return id != null && id.equals(((Notification) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Notification{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", details='" + getDetails() + "'" +
            ", sentDate='" + getSentDate() + "'" +
            ", format='" + getFormat() + "'" +
            ", userId=" + getUserId() +
            ", memberId=" + getMemberId() +
            "}";
    }
}
