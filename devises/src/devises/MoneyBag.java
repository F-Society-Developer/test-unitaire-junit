package devises;

import java.util.Vector;

public class MoneyBag implements IMoney {
    private Vector<Money> fMonies = new Vector<Money>();

    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }

    public MoneyBag(Money bag[]) {
        for (int i = 0; i < bag.length; i++)
            appendMoney(bag[i]);
    }

    protected MoneyBag() {
    }

    private void appendMoney(Money m) {
        if (m.amount() == 0)
            return;
        int i = 0;
        while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency()))))
            i++;
        if (i >= fMonies.size()) {
            fMonies.add(m);
        } else {
            int newAmount = fMonies.get(i).amount() + m.amount();
            if (newAmount == 0) {
                fMonies.remove(i);
            } else {
                fMonies.set(i, new Money(newAmount, m.currency()));
            }
        }
    }

    public Vector<Money> getMonies() {
        return fMonies;
    }

    @Override
    public IMoney add(IMoney m) {
        return m.addMoneyBag(this);
    }

    @Override
    public IMoney addMoney(Money m) {
        MoneyBag result = new MoneyBag();
        for (Money mono : fMonies)
            result.appendMoney(mono);
        result.appendMoney(m);
        return result.simplify();
    }

    @Override
    public IMoney addMoneyBag(MoneyBag s) {
        MoneyBag result = new MoneyBag();
        for (Money mono : fMonies)
            result.appendMoney(mono);
        for (Money mono : s.getMonies())
            result.appendMoney(mono);
        return result.simplify();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof MoneyBag) {
            MoneyBag bag = (MoneyBag) obj;
            if (bag.getMonies().size() != this.fMonies.size())
                return false;
            for (Money m : this.fMonies) {
                if (!bag.getMonies().contains(m))
                    return false;
            }
            return true;
        }
        return false;
    }

    private IMoney simplify() {
        if (fMonies.size() == 0) {
            return new Money(0, "USD");
        }
        if (fMonies.size() == 1) {
            return fMonies.get(0);
        }
        return this;
    }
}
