package homework04;

import java.math.BigDecimal;

public interface Asset {
	BigDecimal showBalance();

	void withdrawAsset();

	void depositAsset();

}
