package homework04;

import java.math.BigDecimal;

public abstract class AssetAbstClass implements Asset {
	BigDecimal balance;

	public AssetAbstClass(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public BigDecimal showBalance() {
		System.out.println("Balance is: " + balance);
		return balance;
	}

	@Override
	public void withdrawAsset() {
		System.out.println("Withdraw " + this.getClass().getSimpleName());
	}

	@Override
	public void depositAsset() {
		System.out.println("Deposit " + this.getClass().getSimpleName());
	}
}