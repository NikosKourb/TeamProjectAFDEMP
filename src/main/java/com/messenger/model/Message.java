package com.messenger.model;
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

//revised at 15:24 11/12/2018

@Entity
@Table(name = "messages")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false, nullable=false)
    private Long id;

    @Column(nullable = false)
    private Long sender_id;
    
    @Column(nullable = false)
    private Long receiver_id;
    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date sent_at;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;
    
    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT '0'")
    private boolean read_status;
    
    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT '0'")
    private boolean sender_view;
    
    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT '0'")
    private boolean receiver_view;
    
    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
    private String subject="";

    @Column(nullable = false, columnDefinition = "VARCHAR(250)")
    private String text_content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSender_id() {
		return sender_id;
	}

	public void setSender_id(Long sender_id) {
		this.sender_id = sender_id;
	}

	public Long getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(Long receiver_id) {
		this.receiver_id = receiver_id;
	}

	public Date getSent_at() {
		return sent_at;
	}

	public void setSent_at(Date sent_at) {
		this.sent_at = sent_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public boolean getRead_status() {
		return read_status;
	}

	public void setRead_status(boolean read_status) {
		this.read_status = read_status;
	}

	public boolean getSender_view() {
		return sender_view;
	}

	public void setSender_view(boolean sender_view) {
		this.sender_view = sender_view;
	}

	public boolean getReceiver_view() {
		return receiver_view;
	}

	public void setReceiver_view(boolean receiver_view) {
		this.receiver_view = receiver_view;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText_content() {
		return text_content;
	}

	public void setText_content(String text_content) {
		this.text_content = text_content;
	}

    
	@Override
	public String toString() {
		return "Message [ id=" + id + ", sender_id=" + sender_id + ", receiver_id=" + receiver_id + ", sent_at=" + sent_at
		     + ", updated_at=" + updated_at + ", read_status=" + read_status +", sender_view=" + sender_view
		     + ", receiver_view=" + receiver_view + ", subject=" + subject + ", text_content=" + text_content + " ]";
	}
    
    
 
    
    
}