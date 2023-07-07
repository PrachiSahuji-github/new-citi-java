package com.citibank.domain;

public class Current extends Account {
	private double overdraftBalance;
	private double initialOverdraftBalance;

	public Current() {
		// TODO Auto-generated constructor stub
	}

	public Current(int accountNumber, String name, double balance, double overdraftBalance) {
		super(accountNumber, name, balance);
		this.overdraftBalance = overdraftBalance;
		this.initialOverdraftBalance = overdraftBalance;
	}

	public Current(double overdraftBalance) {
		super();
		this.overdraftBalance = overdraftBalance;
	}

	public double getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(double overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}

	@Override
	public boolean withdraw(double amount) {
		if (amount > 0) {
			if (amount <= getBalance()) {
				setBalance(getBalance() - amount);
				return true;
			}
			if (amount > getBalance() && amount <= getBalance() + overdraftBalance) {
				amount = amount - getBalance();
				setBalance(0);
				overdraftBalance = overdraftBalance - amount;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deposit(double amount) {
		if (amount > 0) {
			if (initialOverdraftBalance > overdraftBalance) {
				if (amount < (initialOverdraftBalance - overdraftBalance)) {
					overdraftBalance = overdraftBalance + amount;
					return true;
				} else {
					amount = amount - (initialOverdraftBalance - overdraftBalance);
					overdraftBalance = initialOverdraftBalance;
					setBalance(getBalance() + amount);
					return true;
				}
			} else {
				setBalance(getBalance() + amount);
				return true;
			}
		} else
			return false;
	}
}
