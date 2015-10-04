package org.oa.ajax_rest_demo.dao;

public class StorageSession {

    private final DaoFacade daoFacade = new DaoFacade();

    public DaoFacade getDaoFacade() {
        return daoFacade;
    }

    private StorageSession(){

    }

    private final static StorageSession instance = new StorageSession();

    public static StorageSession getInstance(){
        return instance;
    }
}
