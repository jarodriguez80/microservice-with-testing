package com.rappi.examination.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tickets")
public class Ticket implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public Ticket() {
	}

	public Ticket(@NotNull Date departureDate, @NotNull Date arrivalDate, @NotBlank String originCity,
			@NotBlank String destinyCity, @NotBlank String passengerName, @NotNull Integer passengerAge,
			@NotNull Boolean hasLuggageStorage, @NotNull BigDecimal price, @NotBlank String departureTime,
			@NotBlank String arrivalTime) {
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.originCity = originCity;
		this.destinyCity = destinyCity;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.hasLuggageStorage = hasLuggageStorage;
		this.price = price;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long itineraryID;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "departure_date")
	private Date departureDate;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "arrival_date")
	private Date arrivalDate;

	@NotBlank
	@Column(name = "origin_city")
	private String originCity;

	@NotBlank
	@Column(name = "destiny_city")
	private String destinyCity;

	@NotBlank
	@Column(name = "passenger_name")
	private String passengerName;

	@NotNull
	@Column(name = "passenger_age")
	private Integer passengerAge;

	@NotNull
	@Column(name = "has_luggage_storage")
	private Boolean hasLuggageStorage;

	@NotNull
	private BigDecimal price;

	@NotBlank
	@Column(name = "departure_time")
	private String departureTime;

	@NotBlank
	@Column(name = "arrival_time")
	private String arrivalTime;

	public Long getItineraryID() {
		return itineraryID;
	}

	public void setItineraryID(Long id) {
		this.itineraryID = id;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinyCity() {
		return destinyCity;
	}

	public void setDestinyCity(String destinyCity) {
		this.destinyCity = destinyCity;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public Boolean getHasLuggageStorage() {
		return hasLuggageStorage;
	}

	public void setHasLuggageStorage(Boolean hasLuggageStorage) {
		this.hasLuggageStorage = hasLuggageStorage;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
