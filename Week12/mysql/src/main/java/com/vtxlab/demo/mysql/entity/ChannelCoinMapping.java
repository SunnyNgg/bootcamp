package com.vtxlab.demo.mysql.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nonnull;
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
@Table(name = "CHANNEL_COIN_MAPPINGS")
public class ChannelCoinMapping implements Serializable{

  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long id;

  @Nonnull
  @Column(name = "COIN_CODE")
  private String coinCode;

  @Nonnull
  @Column(name = "COIN_ID")
  private String coinId;

  @Nonnull
  @Column(name = "LAST_UPD_DATE")
  private LocalDate lastUpdate;

    //question
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "CHANNEL_ID", referencedColumnName = "ID")
  @JsonIgnoreProperties("channelCoinMappings")
  private Channel channel;
}
