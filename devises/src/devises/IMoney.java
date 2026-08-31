package devises;

public interface IMoney {
    IMoney add(IMoney aMoney);

    IMoney addMoney(Money aMoney);

    IMoney addMoneyBag(MoneyBag aMoneyBag);
}
