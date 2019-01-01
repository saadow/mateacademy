package homework04;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		BigDecimal bd1 = new BigDecimal(100.0);
		BigDecimal bd2 = new BigDecimal(200.0);
		BigDecimal bd3 = new BigDecimal(300.0);
		Gold gold = new Gold(bd1);
		Currency cur = new Currency(bd2);
		SecurityPaper sp = new SecurityPaper(bd3);

		Bank<Gold> bankGold = new Bank<Gold>(1, "First", "Ukraine");
		Bank<Currency> bankCur = new Bank<Currency>(2, "Second", "USA");
		Bank<SecurityPaper> bankSP = new Bank<SecurityPaper>(3, "Third", "Australia");
		bankGold.setAsset(gold);
		System.out.println(bankGold.toString());
		bankGold.getAsset().showBalance();
		bankGold.getAsset().depositAsset();
		bankGold.getAsset().withdrawAsset();
		bankCur.setAsset(cur);
		System.out.println(bankCur.toString());
		bankCur.getAsset().showBalance();
		bankCur.getAsset().depositAsset();
		bankCur.getAsset().withdrawAsset();
		bankSP.setAsset(sp);
		System.out.println(bankSP.toString());
		bankSP.getAsset().showBalance();
		bankSP.getAsset().depositAsset();
		bankSP.getAsset().withdrawAsset();

	}

}
