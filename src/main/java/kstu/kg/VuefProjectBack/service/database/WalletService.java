package kstu.kg.VuefProjectBack.service.database;

import kstu.kg.VuefProjectBack.entity.Wallet;
import kstu.kg.VuefProjectBack.service.base.CrudService;

public interface WalletService extends CrudService<Wallet> {
    Wallet getByUser(Long userId);
}
