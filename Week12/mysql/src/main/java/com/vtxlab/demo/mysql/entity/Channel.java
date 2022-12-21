package com.vtxlab.demo.mysql.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CHANNELS")
public class Channel implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Nonnull
  @Column(name = "CHANNEL_CODE")
  private String channelCode;

  @Nonnull
  @Column(name = "CHANNEL_URL")
  private String channelUrl;

  @Nonnull
  @Column(name = "LAST_UPD_DATE")
  private LocalDateTime lastUpdDate;

  //question
  @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
  //@JsonIgnoreProperties(ignoreUnknown = true)，将这个注解写在类上之后，就会忽略类中不存在的字段。
  @JsonIgnoreProperties({ "channel" })
  private List<ChannelCoinMapping> channelCoinMappings = new ArrayList<>();

  @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
  @JsonIgnoreProperties({ "channel" })
  private List<ChannelTransaction> channelTransactions = new ArrayList<>();
  
}