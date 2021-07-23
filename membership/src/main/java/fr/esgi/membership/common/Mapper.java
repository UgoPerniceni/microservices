package fr.esgi.membership.common;

public interface Mapper<T, S> {
    
    T toDomain(S entity);
    S toEntity(T object);
}
