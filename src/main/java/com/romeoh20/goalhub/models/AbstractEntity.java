package com.romeoh20.goalhub.models;

public abstract class AbstractEntity {

    private int id;
    public int getId() {
        return id;
    }
    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity entity = (AbstractEntity) o;
        return id == entity.id;
    }
}
