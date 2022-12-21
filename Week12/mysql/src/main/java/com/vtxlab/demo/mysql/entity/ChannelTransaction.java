package com.vtxlab.demo.mysql.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "CHANNEL_TRANS")
public class ChannelTransaction implements Serializable {

  @Id

  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @Column(name = "DOMAIN_VERSION")
  private String domainVersion;

  @NonNull
  @Column(name = "DOMAIN_URL")
  private String domainUrl;

  @NonNull
  @Column(name = "SOURCE_APP")
  private String sourceApp;

  @NonNull
  @Column(name = "TRAN_TYPE")
  private String tranType;

  @NonNull
  @Column(name = "LAST_UPD_DATE")
  private LocalDateTime lastUpdate;

    //question
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "CHANNEL_ID", referencedColumnName = "ID")
  @JsonIgnoreProperties("channelTransactions")
  private Channel channel;

}
