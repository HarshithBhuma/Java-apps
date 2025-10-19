package com.ex;

public class Appointment implements Hospital {

	Apollo apollo;

	public void setApollo(Apollo apollo) {
		this.apollo = apollo;
	}

	public void transaction() {

		apollo.bookedAppointment();

	}

}
