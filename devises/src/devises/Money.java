package devises;

public class Money implements IMoney {
    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount() {
        return fAmount;
    }

    public String currency() {
        return fCurrency;
    }

    @Override
    public IMoney add(IMoney m) {
        return m.addMoney(this);
    }

    @Override
    public IMoney addMoney(Money m) {
        if (m.currency().equals(currency())) {
            return new Money(amount() + m.amount(), currency());
        }
        return new MoneyBag(this, m);
    }

    @Override
    public IMoney addMoneyBag(MoneyBag s) {
        return s.addMoney(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof Money) {
            Money m = (Money) obj;
            return m.amount() == this.amount() && m.currency().equals(this.currency());
        }
        return false;
    }
}
