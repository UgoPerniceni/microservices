package fr.esgi.market.common;

public interface Mapper<T, S> {
    
    T toDomain(S entity);
    S toEntity(T object);
}
