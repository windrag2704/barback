package com.example.barBack.repository;

import com.example.barBack.entity.BarTable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TableRepository implements JpaRepository<BarTable, Long> {

    @Override
    public List<BarTable> findAll() {
        return null;
    }

    @Override
    public List<BarTable> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<BarTable> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<BarTable> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(BarTable entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends BarTable> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends BarTable> S save(S entity) {
        return null;
    }

    @Override
    public <S extends BarTable> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<BarTable> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends BarTable> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends BarTable> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<BarTable> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public BarTable getOne(Long aLong) {
        return null;
    }

    @Override
    public BarTable getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends BarTable> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends BarTable> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends BarTable> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends BarTable> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends BarTable> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends BarTable> boolean exists(Example<S> example) {
        return false;
    }
}
